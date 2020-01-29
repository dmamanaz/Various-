package com.example.calllogs

import android.content.ContentResolver
import android.content.ContentValues
import android.content.pm.PackageManager
import android.database.Cursor
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.CallLog
import android.provider.ContactsContract
import android.util.Log
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        insertCallLog(
            contentResolver,
            "Sofia Vergara", "999999"
        )
        val contactsData = getAllCallLogs(
            contentResolver
        )
        while (contactsData?.moveToNext() == true) {
            Log.d(
                "MainActivity",
                contactsData.getString(
                    contactsData.getColumnIndexOrThrow(
                        android.provider.CallLog.Calls.NUMBER)
                )
            )

        }
    }

    fun getAllCallLogs(
        contentResolver:
        ContentResolver
    ): Cursor? {
        val orderString = android.provider.CallLog.Calls.DATE + " DESC"
        val uriCall = Uri.parse("content://call_log/calls")
        val cursorLogs = contentResolver.query(
            uriCall,
            null,
            null,
            null,
            orderString

        )
        Log.d("MainActivity", cursorLogs?.count.toString())
        return cursorLogs
    }

    fun insertCallLog(
        contentResolver: ContentResolver,
        callingName: String,
        callingNumber: String
    ) {
        val contentValues = ContentValues()

        contentValues.put(
            android.provider.CallLog.Calls.CACHED_NAME,
            callingName
        )
        contentValues.put(
            android.provider.CallLog.Calls.NUMBER,
            callingNumber
        )
        contentValues.put(android.provider.CallLog.Calls.DATE, System.currentTimeMillis())
        contentValues.put(CallLog.Calls.DURATION, 0)
        contentValues.put(CallLog.Calls.TYPE, CallLog.Calls.OUTGOING_TYPE)
        contentValues.put(CallLog.Calls.NEW, 1)
        contentValues.put(CallLog.Calls.CACHED_NUMBER_TYPE, 0)
        contentValues.put(CallLog.Calls.CACHED_NUMBER_LABEL, "")

        if (ContextCompat.checkSelfPermission(
                this,
                android.Manifest.permission.WRITE_CALL_LOG
            )
            == PackageManager.PERMISSION_GRANTED) {
            Log.d("MainActivity", "Permission granted!")
            contentResolver.insert(
                android.provider.CallLog.Calls.CONTENT_URI,
                contentValues
            )
        }
    }
}
