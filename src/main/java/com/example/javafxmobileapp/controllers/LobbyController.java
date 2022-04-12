package com.example.javafxmobileapp.controllers;

import com.example.javafxmobileapp.Game;
import com.example.javafxmobileapp.GameService;
import com.example.javafxmobileapp.RetroFitServiceGenerator;
import com.example.javafxmobileapp.SuperController;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import retrofit2.Call;
import retrofit2.Response;

import java.util.Random;

public class LobbyController extends SuperController {

    public Button listaSpel;

    public static String getComputerMove()
    {
        String compMove;
        Random random = new Random();
        int input = random.nextInt(3)+1;
        if (input == 1)
            compMove = "Rock";
        else if(input == 2)
            compMove = "Paper";
        else
            compMove = "Scissor";


        return compMove;
    }

    public void gameAgainstComp(ActionEvent event){



        String comp = "computer";
     Game startNewGame = new Game("","",RetroFitServiceGenerator.userName,"r","","",getComputerMove(),"");





        GameService service = RetroFitServiceGenerator.createAuthService(GameService.class);


        Call<Game> callSync = service.createGame(startNewGame);

        try {
            changeScene("game.fxml");
            Response<Game> response = callSync.execute();



//
        }
        catch (Exception e){
            System.out.println(e.getMessage());

        }

    }



    public void BackToLogInScreen(ActionEvent actionEvent) {

        changeScene("loginScene.fxml");
    }

    public void InviteToGame(ActionEvent actionEvent) {

        changeScene("invite.fxml");
    }

    public void list(ActionEvent event) {
        changeScene("listOfGames.fxml");
    }
}
