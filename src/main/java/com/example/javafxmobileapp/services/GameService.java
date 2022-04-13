package com.example.javafxmobileapp.services;

import com.example.javafxmobileapp.Game;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

/**
 *  Service to call for getting,posting/creating or update a game object.
 */
public interface GameService {


    @GET("/game")
    Call<List<Game>> getAllMyGames(

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
