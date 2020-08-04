package com.example.mvvm.Network;

import com.example.mvvm.Model.Posts;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.PUT;

public interface JsonPlaceHolder {

    @GET("posts")
    Call<List<Posts>> getPosts();

    @PUT("posts/1")
    Call<Posts> updatePost(@Body Posts post);
}
