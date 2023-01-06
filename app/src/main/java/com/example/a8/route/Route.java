package com.example.a8.route;

import com.example.a8.LoginResponse;
import com.example.a8.models.AuthClass;
import com.example.a8.models.MessageClass;
import com.example.a8.models.PSidangResponse;
import com.example.a8.models.ThesesData;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface Route {

    @FormUrlEncoded
    @POST("api/login")
    Call<LoginResponse> login(@Field("username") String email, @Field("password") String password);

    @POST("api/logout")
    Call<MessageClass> logout(@Header("Authorization") String token);

    @GET("api/admin/thesis/trial-submissions")
    Call<PSidangResponse> getPsidang (
            @Header("Authorization")String token
    );

    @GET("api/admin/theses")
    Call<ThesesData> Getlist(@Header("Authorization") String token);

}
