package com.example.javafxmobileapp.controllers;

import com.example.javafxmobileapp.Game;
import com.example.javafxmobileapp.GameChoice;
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

    public Button buttonCloseLobby;

    public static String getComputerMove()
    {
        String compMove;
        Random random = new Random();
        int input = random.nextInt(3)+1;
        if (input == 1)
            compMove = GameChoice.ROCK.toString();
        else if(input == 2)
            compMove = GameChoice.PAPER.toString();
        else
            compMove = GameChoice.SCISSOR.toString();


        return compMove;
    }

    public void gameAgainstCompOnAction(ActionEvent event){




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



    public void backToLogInScreenOnAction(ActionEvent actionEvent) {

        changeScene("loginScene.fxml");
    }

    public void inviteToGameOnAction(ActionEvent actionEvent) {

        changeScene("invite.fxml");
    }

    public void listOnAction(ActionEvent event) {
        changeScene("listOfGames.fxml");
    }

    public void buttonToCloseLobbyOnAction(ActionEvent actionEvent) {
        getStage().close();
    }
}
