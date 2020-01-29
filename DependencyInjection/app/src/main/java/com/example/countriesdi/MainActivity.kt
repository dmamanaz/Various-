package com.example.countriesdi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import butterknife.BindView
import butterknife.ButterKnife
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject


class MainActivity : AppCompatActivity() {
    //this program dispalys country name and flag from the API using recyclerview
    @BindView(R.id.recyclerview)
    lateinit var recyclerview: RecyclerView
    @Inject
    lateinit var apiInterface : ApiInterface

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ButterKnife.bind(this)
        (applicationContext as CustomApplication)
            .component.inject(this)
        recyclerview.layoutManager = GridLayoutManager(this, 3)
        val adapter = CustomAdapter()
        recyclerview.adapter = adapter
        apiInterface.getAllCountries().enqueue(
            object : Callback<List<CountryPoko>>{
                override fun onFailure(call: Call<List<CountryPoko>>, t: Throwable) {
                    Toast.makeText(this@MainActivity,
                    t.message,
                    Toast.LENGTH_SHORT).show()
                }
                override fun onResponse(
                    call: Call<List<CountryPoko>>,
                    response: Response<List<CountryPoko>>
                ) {
                    if(response.isSuccessful)
                        adapter.dataSet = response.body()!!
                }

            }

        )
    }
}
