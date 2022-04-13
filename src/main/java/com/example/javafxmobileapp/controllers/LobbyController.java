package com.example.javafxmobileapp.controllers;

import com.example.javafxmobileapp.Game;
import com.example.javafxmobileapp.services.GameService;
import com.example.javafxmobileapp.services.RetroFitServiceGenerator;
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




     Game startNewGame = new Game("","",RetroFitServiceGenerator.userName,"computer","","",getComputerMove(),"");





        GameService service = RetroFitServiceGenerator.createAuthService(GameService.class);


        Call<Game> callSync = service.createGame(startNewGame);

        try {
            Response<Game> response = callSync.execute();

            startNewGame = response.body();

            assert startNewGame != null;
            GameController  gameController = (GameController) changeScene("game.fxml",startNewGame);
            gameController.setGame(startNewGame);



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
