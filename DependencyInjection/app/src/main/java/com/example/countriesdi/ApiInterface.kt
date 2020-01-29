package com.example.countriesdi

import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    //https://restcountries.eu/rest/v2/all
    @GET("rest/v2/all")
    fun getAllCountries(): Call<List<CountryPoko>>


}