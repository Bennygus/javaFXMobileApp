package com.example.javafxmobileapp.controllers;

import com.example.javafxmobileapp.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import retrofit2.Call;
import retrofit2.Response;


public class CreateAccountController extends SuperController {

    @FXML
    TextField createUserEmailTextField;

    @FXML
    PasswordField createUserPasswordTextField;

    @FXML
    TextField createDisplayNameTextField;



    public void logInButton(ActionEvent actionEvent) {

       User user = new User(createUserEmailTextField.getText(),createDisplayNameTextField.getText(),createUserPasswordTextField.getText());

        UserService service =  RetroFitServiceGenerator.createService(UserService.class);


      Call<User> callSync = service.createUsers(user);

        try {

            Response<User> response = callSync.execute();

//
        }
        catch (Exception e){
            System.out.println(e.getMessage());

        }


       // changeScene("lobby.fxml");

    }

    public void GoBackToLoginScene(ActionEvent actionEvent) {


        changeScene("loginScene.fxml");


    }
}