package com.example.javafxmobileapp.controllers;

import com.example.javafxmobileapp.SuperController;
import javafx.event.ActionEvent;

public class LobbyController extends SuperController {

    public void gameAgainstComp(ActionEvent event){


        changeScene("game.fxml");

    }



    public void BackToLogInScreen(ActionEvent actionEvent) {

        changeScene("loginScene.fxml");
    }

    public void InviteToGame(ActionEvent actionEvent) {

        changeScene("invite.fxml");
    }
}
