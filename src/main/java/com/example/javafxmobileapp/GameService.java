package com.example.javafxmobileapp;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;

import java.util.List;

public interface GameService {


    @GET("/game")
    Call<List<Game>> getAllMyGames(

            );

    // för update
    @PUT("/game")


    @POST("/game")
    Call<Game> createGame(
            @Body Game game);
}
