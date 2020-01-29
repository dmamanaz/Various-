package com.example.rxjavatest.view

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.rxjavatest.R


class CustomViewHolder(itemView: View) :
    RecyclerView.ViewHolder(itemView) {
    var posterMovie : ImageView
    var movieTitle : TextView
    var movieGenre : TextView
    init {
        posterMovie = itemView.findViewById(R.id.iv_item_movies)
        movieTitle = itemView.findViewById(R.id.tv_title)
        movieGenre= itemView.findViewById(R.id.tv_genre)
    }
}