package com.example.rxjavatest.model

data class MoviesPojo(
    var title: String,
    var image: String,
    var rating: Float,
    var releaseYear: Int,
    var genre: ArrayList<String>
) //Kotlin uses default values for empty attributes