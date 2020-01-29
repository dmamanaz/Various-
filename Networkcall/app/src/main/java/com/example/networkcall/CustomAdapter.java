package com.example.networkcall;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.networkcall.CustomViewHolder;
import com.example.networkcall.PojoResponse;
import com.squareup.picasso.Picasso;

public class CustomAdapter
        extends RecyclerView.Adapter<CustomViewHolder> {
    private PojoResponse dataSet;

    public CustomAdapter(PojoResponse dataSet) {
        this.dataSet = dataSet;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CustomViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.item_layout,
                        parent,
                        false
                )
        );
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        holder.tvItemBookTitle.setText(dataSet.bookList.get(position).volumeInfo.title);
        //todo Picasso implementation
        //todo dataSet.items.get(position).volumeInfo.imageLinks.thumbnail;
        Picasso.get().load(
                dataSet.bookList.get(position).volumeInfo.imageLinks.thumbnail
        ).into(
                holder.ivItemBookCover
        );
    }

    @Override
    public int getItemCount() {
        return dataSet != null ? dataSet.bookList.size() : 0;
    }
}

