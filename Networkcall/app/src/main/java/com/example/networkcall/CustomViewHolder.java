package com.example.networkcall;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CustomViewHolder  extends RecyclerView.ViewHolder{
    ImageView ivItemBookCover;
    TextView tvItemBookTitle;


    public CustomViewHolder(@NonNull View itemView){
        super(itemView);

                ivItemBookCover = itemView.findViewById(R.id.iv_book_cover);
                tvItemBookTitle = itemView.findViewById(R.id.tv_book_title);
    }
}
