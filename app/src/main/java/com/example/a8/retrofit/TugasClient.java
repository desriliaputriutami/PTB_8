package com.example.a8.retrofit;

import com.example.a8.LoginResponse;
import com.example.a8.datamodels.ListPermintaanTAResponse;
import com.example.a8.datamodels.PembimbingResponse;
import com.example.a8.models.MessageClass;
import com.example.a8.models.ThesesData;


import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface TugasClient {

    @FormUrlEncoded
    @POST("api/login")
    Call<LoginResponse> login(@Field("username") String email, @Field("password") String password);

    @POST("api/logout")
    Call<MessageClass> logout(@Header("Authorization") String token);

    @GET("api/admin/theses")
    Call<ThesesData> Getlist(@Header("Authorization") String token);

    @GET("api/admin/thesis-submissions")
    Call<ListPermintaanTAResponse> listPermintaan(@Header("Authorization") String token);

    @FormUrlEncoded
    @POST("api/admin/theses/369/supervisors")
    Call<PembimbingResponse> pembimbing(
            @Header("Authorization") String token,
            @Field("lecturer_id") String lecturer_id,
            @Field("position") String position);


}
