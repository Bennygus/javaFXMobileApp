package com.example.javafxmobileapp.controllers;

import com.example.javafxmobileapp.*;
import com.example.javafxmobileapp.services.RetroFitServiceGenerator;
import com.example.javafxmobileapp.services.UserService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import retrofit2.Call;
import retrofit2.Response;


public class CreateAccountController extends SuperController {

    @FXML
    public Button buttonForCloseInCreateAccount;
    public Label labelAccountConfirmationExist;
    @FXML
    TextField createUserEmailTextField;

    @FXML
    PasswordField createUserPasswordTextField;

    @FXML
    TextField createDisplayNameTextField;


    //TODO fix restrictions do create all needed now is a username only to create!
    public void createButtonOnAction(ActionEvent actionEvent) {
        if (true){

        }

       User user = new User(createUserEmailTextField.getText(),createDisplayNameTextField.getText(),createUserPasswordTextField.getText());

        UserService service =  RetroFitServiceGenerator.createService(UserService.class);


      Call<User> callSync = service.createUsers(user);

        try {

            Response<User> response = callSync.execute();

           response.message();

            if (response.isSuccessful()){

                labelAccountConfirmationExist.setVisible(true);
                createDisplayNameTextField.setText("");
                createUserPasswordTextField.setText("");
                createUserEmailTextField.setText("");
            }




//
        }
        catch (Exception e){
            System.out.println(e.getMessage());

        }



    }

    public void goBackToLoginSceneOnAction(ActionEvent actionEvent) {


        changeScene("loginScene.fxml");


    }

    public void buttonCloseInCreateAccountOnAction(ActionEvent event) {
        getStage().close();
    }


}