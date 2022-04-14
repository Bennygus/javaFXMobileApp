package com.example.javafxmobileapp.controllers;

import com.example.javafxmobileapp.services.RetroFitServiceGenerator;
import com.example.javafxmobileapp.SuperController;

import com.example.javafxmobileapp.Text;
import com.example.javafxmobileapp.services.UserService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;


import retrofit2.Call;
import retrofit2.Response;



public class LogInController extends SuperController {





    @FXML
    TextField userLoginEmailTextField;
    @FXML
    PasswordField userLoginPasswordTextField;



    public void logInButton(ActionEvent actionEvent) {


        UserService service =  RetroFitServiceGenerator.createService(UserService.class,userLoginEmailTextField.getText() , userLoginPasswordTextField.getText());
        Call<Text>  callSync = service.getGreeting();

        try {

            Response<Text> response = callSync.execute();
            if (response.isSuccessful()) changeScene("lobby.fxml");

            String text = response.body().getMessage();


            RetroFitServiceGenerator.userName = userLoginEmailTextField.getText();
            RetroFitServiceGenerator.password = userLoginPasswordTextField.getText();

            System.out.println(text);
        }
        catch (Exception e){
            System.out.println(e.getMessage());

        }





    }


    public void newAccount(ActionEvent actionEvent) {

       changeScene("createAccountScene.fxml");

    }



    public void buttonForCloseGameInLogin(ActionEvent actionEvent) {

        getStage().close();

    }
}
