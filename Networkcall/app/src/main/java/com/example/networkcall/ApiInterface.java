package com.example.networkcall;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
    //  https://www.googleapis.com/books/v1/volumes?q=pride+prejudice&maxResults=5&printType=books

    @GET("books/v1/volumes")
    Call<PojoResponse> getBooks(@Query("printType")String type,
                                @Query("maxResults")String quantity,
                                @Query("q")String bookTitle);

}
