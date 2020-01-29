package com.example.countriesdi

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {
   @Provides
   @Singleton
   fun getApiInterface(): ApiInterface{
       return  Retrofit.Builder()
           .baseUrl("https://restcountries.eu/")
           .addConverterFactory(GsonConverterFactory.create())
           .build()
           .create(ApiInterface::class.java)
   }
}