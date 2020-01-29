package com.example.rxjavatest.model

import com.example.rxjavatest.model.MoviesPojo
import io.reactivex.Observable
import retrofit2.http.GET

import kotlin.collections.ArrayList

interface ApiInterface {
//https://api.androidhive.info/json/movies.json
    @GET("movies.json")
    fun getMovies() : Observable<ArrayList<MoviesPojo>>

}