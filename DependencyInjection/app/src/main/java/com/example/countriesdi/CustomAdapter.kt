package com.example.countriesdi

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import butterknife.BindView
import butterknife.ButterKnife
import com.squareup.picasso.Picasso

class CustomAdapter: RecyclerView.Adapter<CustomAdapter.CustomViewHolder>(){
    var dataSet: List<CountryPoko> = emptyList()
    set(value){
        field = value
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        return CustomViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_layout,
                    parent,
                    false)
        )
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        //bind the data with the viewholder
        holder.countryName.text=dataSet[position].name
        Picasso.get().load(dataSet[position].flag).into(holder.vectorFlag)
        //we need to trigger another network call


    }

    inner class CustomViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) { 
        @BindView(R.id.iv_country_flag)
        lateinit var vectorFlag: ImageView
        @BindView(R.id.tv_country_name)
        lateinit var countryName: TextView
        init{
            ButterKnife.bind(this, itemView)
        }

    }
}