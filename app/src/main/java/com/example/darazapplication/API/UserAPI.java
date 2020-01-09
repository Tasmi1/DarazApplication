package com.example.darazapplication.API;


import com.example.darazapplication.ServerResponse.SignUpResponse;
import com.example.darazapplication.modalClass.Products;
import com.example.darazapplication.modalClass.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;


public interface UserAPI {

    @POST("user/register")
    Call<SignUpResponse> registeruser (User user);

    @FormUrlEncoded
    @POST("user/login")
    Call<SignUpResponse>checkUser(@Field("username")String username, @Field("password")String password);

    // get product details
    @GET("product")
    Call<List<Products>>getAllProducts();









}
