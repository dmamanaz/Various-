package com.example.rxjavatest.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rxjavatest.R
import com.example.rxjavatest.model.MoviesPojo
import com.squareup.picasso.Picasso

class CustomAdapter :
    RecyclerView.Adapter<CustomViewHolder>() {

    var movies = emptyList<MoviesPojo>()
    set(value){
        notifyDataSetChanged()
        field = value
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        return CustomViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(
                    R.layout.item_layout,
                    parent,
                    false
                )
        )
    }

    override fun getItemCount() = movies.size

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.movieTitle.text = movies[position].title
        var temp = ""
        for(item in movies[position].genre)
            temp+="$item"

        holder.movieGenre.text = movies[position]
            .genre.joinToString {
            it
        }
        Picasso.get().load(movies[position].image).into(holder.posterMovie)

    }
}





