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

        UserService service =  RetroFitServiceGenerator.createService2(UserService.class,createDisplayNameTextField.getText(), createUserPasswordTextField.getText(),createUserEmailTextField.getText());
      //  UserService service =  RetroFitServiceGenerator.createService2(UserService.class, user.getName(),  user.getPassword(),user.getEmail());



      Call<User> callSync = service.createUsers(user);

        try {

            Response<User> response = callSync.execute();

//            if (response.isSuccessful()) changeScene("lobby.fxml");

            //String text = response.body().getMessage();

//
//            RetroFitServiceGenerator.userEmail = createUserEmailTextField.getText();
//            RetroFitServiceGenerator.userName = createDisplayNameTextField.getText();
//            RetroFitServiceGenerator.password = createUserPasswordTextField.getText();

           // System.out.println(text);
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