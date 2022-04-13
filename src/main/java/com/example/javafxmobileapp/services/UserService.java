package com.example.javafxmobileapp.services;



import com.example.javafxmobileapp.Text;
import com.example.javafxmobileapp.User;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;


/**
 * Service to call for getting or posting/creating a user object.
 */
public interface UserService {

    @GET("/greeting")
    Call<Text> getGreeting();


    @GET("/users")
    Call <List<String>>  getAllUsers(

    );


    @POST("/users")
    Call<User> createUsers(
            @Body User user);





}
