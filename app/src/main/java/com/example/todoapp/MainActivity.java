package com.example.todoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView listOfData; // global variables
    EditText editTextData; // all methods in the class
    Button buttonAddTask; //have access to them
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //initialize variables
        listOfData = findViewById(R.id.lv_task_todo);
        editTextData = findViewById(R.id.et_todo);
        buttonAddTask = findViewById(R.id.btn_add_task);
        adapter = new ArrayAdapter<String>(
                MainActivity.this,
                android.R.layout.simple_list_item_1
        );
    listOfData.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
        @Override
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
            adapter.remove(
                    adapter.getItem(i)
            );
            return true;
        }
    });
        // Estbalish listener event
        buttonAddTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String task = editTextData.getText().toString(); // get the text from editor
                if (task.isEmpty())
                    task = "Default";  // if the editor is empty print the default value
                // todo add task to the ListView

                adapter.add(task);
                listOfData.setAdapter(adapter);
                editTextData.setText(""); // removes the tasks
            }
        }); // 3 ways to do


    }

}
