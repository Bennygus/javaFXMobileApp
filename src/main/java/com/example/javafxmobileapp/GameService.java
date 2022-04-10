package com.example.javafxmobileapp;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface GameService {


    @GET("/game")
    Call<List<Game>> getAllMyGames(

    );

    @GET("/all")
    Call<Game> getCreatedGameFromInvite(

                                        );





    // för update
    @PUT("/game/{id}")
    Call<Game> updateMyGame(
            @Path("id") Long id,
            @Body Game game)
    ;






    @POST("/game")
    Call<Game> createGame(
            @Body Game game

    );



}
