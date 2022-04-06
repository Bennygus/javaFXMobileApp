package com.example.javafxmobileapp.controllers;

import com.example.javafxmobileapp.Game;
import com.example.javafxmobileapp.RetroFitServiceGenerator;
import com.example.javafxmobileapp.SuperController;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;

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

        String playName = RetroFitServiceGenerator.userName;

        String comp = "computer";
        Game compGame = new Game(playName,comp,getComputerMove());
        changeScene("game.fxml");

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
