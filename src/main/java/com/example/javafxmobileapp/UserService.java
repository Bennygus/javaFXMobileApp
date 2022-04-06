package com.example.javafxmobileapp;



import retrofit2.Call;
import retrofit2.http.*;



public interface UserService {

    @GET("/greeting")
    Call<Text> getGreeting();




    @POST("/users")
    Call<User> createUsers(
            @Body User user);



//    @GET("/users/{username}")
//    public Call<User> getUser(@Path("username") String username);



}
