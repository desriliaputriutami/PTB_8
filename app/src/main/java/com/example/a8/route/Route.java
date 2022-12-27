package com.example.a8.route;

import com.example.a8.LoginResponse;
import com.example.a8.models.AuthClass;
import com.example.a8.models.MessageClass;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface Route {

    @FormUrlEncoded
    @POST("login")
    Call<LoginResponse> login(@Field("email") String email, @Field("password") String password);

    @POST("logout")
    Call<MessageClass> logout(@Header("Authorization") String token);

}
