package com.example.sqlitetest;

import android.provider.BaseColumns;

public class Utility {
    //this class helps to define DB name, version, columns
    public static final String DATABASE_NAME = "contacts";
    public static final int DATABASE_VERSION = 1;

    //create inner class that holds all the information for contacts table
    public class Contacts implements BaseColumns {
        public static final String CONTACTS_TABLE_NAME = "contacts"; //"contacts" is the column name
        public static final String CONTACTS_COLUMN_NAME = "name";
        public static final String CONTACTS_COLUMN__ADDRESS = "address";
        public static final String CONTACTS_COLUMN__GENDER = "gender";
        public static final String CONTACTS_COLUMN__PHONE = "phone";
        public static final String CONTACTS_COLUMN__EMAIL = "email";
    }
}
