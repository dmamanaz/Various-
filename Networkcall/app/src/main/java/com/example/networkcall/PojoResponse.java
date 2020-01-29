package com.example.networkcall;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PojoResponse {
    @SerializedName("items")
    List<ItemsPojo> bookList;
}
