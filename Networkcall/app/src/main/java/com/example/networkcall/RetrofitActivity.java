package com.example.networkcall;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitActivity extends AppCompatActivity {
    EditText etTitle, etMaxResults;
    Spinner spType;
    RecyclerView recyclerView;
    Button btnSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);
        initUI();
    }

    public void initUI() {
        etTitle = findViewById(R.id.et_title);
        etMaxResults = findViewById(R.id.et_maxResults);
        spType = findViewById(R.id.sp_print_type);
        recyclerView = findViewById(R.id.recyclerview);
        btnSearch = findViewById(R.id.btn_search);
        spType.setAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                getResources().getStringArray(R.array.books_types))
        );

        recyclerView.setLayoutManager(
                new LinearLayoutManager(this)
        );
        btnSearch.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (etTitle.getText().toString().isEmpty()
                                || etMaxResults.getText().toString().isEmpty()) {
                            Toast.makeText(RetrofitActivity.this,
                                    "Not allow!",
                                    Toast.LENGTH_LONG)
                                    .show();

                        } else {
                            initRetrofit(etTitle.getText().toString(),
                                    etMaxResults.getText().toString(),
                                    spType.getSelectedItem().toString());
                        }
                    }
                }
        );
    }

    //todo dependencies (retrofit2, converter-gson)
    //todo TypeSafe Pojo Classes
    //todo Interface
    //todo Create Retrofit Object

    public void initRetrofit(String title, String maxResult, String bookType) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.googleapis.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiInterface apiInterface = retrofit.create(ApiInterface.class);
        apiInterface.getBooks(bookType, maxResult, title)
                .enqueue(new Callback<PojoResponse>() {
                    @Override
                    public void onResponse(Call<PojoResponse> call, Response<PojoResponse> response) {
                        if (response.isSuccessful()) {
                            //todo pass data to the adapter
                            initAdapter(response.body());
                        }
                    }

                    @Override
                    public void onFailure(Call<PojoResponse> call, Throwable t) {
                        Toast.makeText(RetrofitActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });
    }

    public void initAdapter(PojoResponse response) {
        CustomAdapter adapter = new CustomAdapter(response);
        recyclerView.setAdapter(adapter);
    }

}