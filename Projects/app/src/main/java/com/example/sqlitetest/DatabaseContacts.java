package com.example.sqlitetest;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

// this class is a child of SQLiteOpenHelper
public class DatabaseContacts extends SQLiteOpenHelper {
    public DatabaseContacts(@Nullable Context context) {
        super(context, Utility.DATABASE_NAME,
                null,
                Utility.DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        // we create columns inside of our database using the sql query
        sqLiteDatabase.execSQL(
                "CREATE TABLE " +
                        Utility.Contacts.CONTACTS_TABLE_NAME +
                        " ("+
                        Utility.Contacts._ID +
                        " INTEGER PRIMARY KEY, " +
                        Utility.Contacts.CONTACTS_COLUMN_NAME +
                        " VARCHAR(255), " +
                        Utility.Contacts.CONTACTS_COLUMN__EMAIL +
                        " VARCHAR(255), " +
                        Utility.Contacts.CONTACTS_COLUMN__ADDRESS +
                        " VARCHAR(255), " +
                        Utility.Contacts.CONTACTS_COLUMN__GENDER +
                        " VARCHAR(255), " +
                        Utility.Contacts.CONTACTS_COLUMN__PHONE +
                        " VARCHAR(255))"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

}
