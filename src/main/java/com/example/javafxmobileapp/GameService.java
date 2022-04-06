package com.example.javafxmobileapp;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

import java.util.List;

public interface GameService {


    @GET("/game")
    Call<List<Game>> getAllMyGames(

            );


    @POST("/game")
    Call<Game> createGame(
            @Body Game game);
}
