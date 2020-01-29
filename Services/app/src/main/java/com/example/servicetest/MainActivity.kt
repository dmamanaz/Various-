package com.example.servicetest

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_play.setOnClickListener {
            val intentPlay = Intent()
            intentPlay.setClass(
                this,
                PlayMusic::class.java
            )
            intentPlay.setAction("PLAY")
            startService(intentPlay)
        }//modify the activity layout: 2 buttons.

        btn_stop.setOnClickListener {
            val intentPlay = Intent()
            intentPlay.setClass(
                this,
                PlayMusic::class.java
            )
            intentPlay.setAction("STOP")
            startService(intentPlay)
        }

        var intentFilter = IntentFilter()
        intentFilter.addAction("com.example.servicetest.SEND_STATUS")

        val customReciever = CustomReciever()

        registerReceiver(customReciever, intentFilter)
    }

    inner class CustomReciever : BroadcastReceiver() {
        override fun onReceive(p0: Context?, p1: Intent?) {
            var status = ""
            if (p1?.action == "com.example.servicetest.SEND_STATUS")
                status = p1.getStringExtra("STATUS") ?: "Not Available"
            tv_status.text = status

        }

    }

}
