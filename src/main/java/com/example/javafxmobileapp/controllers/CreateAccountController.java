package com.example.javafxmobileapp.controllers;

import com.example.javafxmobileapp.*;
import com.example.javafxmobileapp.services.RetroFitServiceGenerator;
import com.example.javafxmobileapp.services.UserService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import retrofit2.Call;
import retrofit2.Response;


public class CreateAccountController extends SuperController {

    @FXML
    public Button buttonForCloseInCreateAccount;
    @FXML
    TextField createUserEmailTextField;

    @FXML
    PasswordField createUserPasswordTextField;

    @FXML
    TextField createDisplayNameTextField;



    public void logInButtonOnAction(ActionEvent actionEvent) {

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

    public void goBackToLoginSceneOnAction(ActionEvent actionEvent) {


        changeScene("loginScene.fxml");


    }

    public void buttonCloseInCreateAccountOnAction(ActionEvent event) {
        getStage().close();
    }
}