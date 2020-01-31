package com.softwarica.airlinereservationsystem.API;

import com.softwarica.airlinereservationsystem.model.Contact;
import com.softwarica.airlinereservationsystem.model.User;
import com.softwarica.airlinereservationsystem.serverresponse.ImageResponse;
import com.softwarica.airlinereservationsystem.serverresponse.RegisterResponse;


import java.util.List;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface UsersAPI {
    @POST("users/register")
    Call<RegisterResponse> registerUser(@Body User users);

    @FormUrlEncoded
    @POST("/contact")
    Call<Void> contactUs(@Header("Authorization") String token, @Field("fullname") String fullname, @Field("email") String email, @Field("message") String message);

    @FormUrlEncoded
    @POST("users/login")
    Call<RegisterResponse> checkUser(@Field("email") String email, @Field("password") String password);

    @Multipart
    @POST("upload")
    Call<ImageResponse> uploadImage(@Part MultipartBody.Part img);

    @GET("users/me")
    Call<User> getUserDetails(@Header("Authorization") String token);

    @GET("users/user")
    Call<List<User>> getUser(@Header("Authorization") String token);

    @GET("contacts/contact")
    Call<List<Contact>> getContact(@Header("Authorization") String token);
}
