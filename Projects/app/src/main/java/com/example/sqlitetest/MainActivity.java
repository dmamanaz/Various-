package com.example.sqlitetest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        saveDataDB();
        readDataDB();

//        Thread thread = new Thread(new Runnable() {   //creates a  new thread and executes a new thread
//            @Override
//            public void run() {
//                try {
//                    Thread.sleep(3000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                readDataDB();
//            }
//        });
//        thread.start();
    }
    // get instance
    public void saveDataDB(){
        //initialize db contacts
        DatabaseContacts dbContacts = new
                DatabaseContacts(this);
        //write in the db
        SQLiteDatabase database =
                dbContacts.getWritableDatabase();
        ContentValues contentValues = new
                ContentValues();  //create an instance of content value
        contentValues.put(Utility.Contacts.CONTACTS_COLUMN_NAME,
                "Doni");
        contentValues.put(Utility.Contacts.CONTACTS_COLUMN__EMAIL,
                "doniyorad@gmail.com");
        contentValues.put(Utility.Contacts.CONTACTS_COLUMN__ADDRESS,
                "Atlanta");
        contentValues.put(Utility.Contacts.CONTACTS_COLUMN__GENDER,
                "Male");
        contentValues.put(Utility.Contacts.CONTACTS_COLUMN__PHONE,
                "tel: 4424234232 \n office: 68435902123");

        long result = database.insert(Utility.Contacts.CONTACTS_TABLE_NAME,
                null,
                contentValues); // insert() asks for 3 parameters(table name, null, content values), returns a LONG value

        if(result>-1){
            Toast.makeText(this, "Good, good", Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(this, "Something failed.", Toast.LENGTH_LONG).show();
        }

    }
    public void readDataDB(){
        TextView textView = findViewById(R.id.text_view);
        DatabaseContacts databaseContacts =
                new DatabaseContacts((this));
        SQLiteDatabase readDB =
                databaseContacts.getReadableDatabase();
        //Projection
        String[] columns = {
                Utility.Contacts.CONTACTS_COLUMN_NAME,
                Utility.Contacts.CONTACTS_COLUMN__ADDRESS,
                Utility.Contacts.CONTACTS_COLUMN__EMAIL
        };
        //Selection
        String selection = Utility.Contacts.CONTACTS_COLUMN_NAME +
                " = ?";
        String[] selectionArg = {"Doni"};

        String ordering = Utility.Contacts.CONTACTS_COLUMN_NAME +
                " ASC";

        Cursor cursor =   // this query returns name, address and email
                readDB.query(
            Utility.Contacts.CONTACTS_TABLE_NAME,
            columns,
            selection,
            selectionArg,
            null,
            null,
            ordering
                );
            Cursor cursor1 =  //returns all the rows from the table, we need to specify the columns
                   readDB.query(
                           Utility.Contacts.CONTACTS_TABLE_NAME,
                           columns,
                           null,
                           null,
                           null,
                           null,
                           null
                   );
            //iterate through the cursor
        String name = null;
        while(cursor.moveToNext()){
            try{

             name = cursor.getString(
                    cursor.getColumnIndexOrThrow( //getColumnIndexOrThrow throws try catch if it can't find CONTACTS_COLUMN_NAME
                            Utility.Contacts.CONTACTS_COLUMN_NAME
                    )
            );
            }catch (Exception err) {err.printStackTrace();}
            String address = cursor.getString(
                    cursor.getColumnIndexOrThrow(
                            Utility.Contacts.CONTACTS_COLUMN__ADDRESS
                    )
            );
            String email = cursor.getString(
                    cursor.getColumnIndexOrThrow(
                            Utility.Contacts.CONTACTS_COLUMN__EMAIL
                    )
            );
            //after we get name, address we can show them in a textView
        }
        textView.setText(name);
        }
    }

