package com.example.javafxmobileapp.controllers;

import com.example.javafxmobileapp.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import retrofit2.Call;
import retrofit2.Response;

public class InviteController extends SuperController {


    @FXML
    public TextField TextFieldForPLayers;


    @FXML
    CheckBox CheckboxOneWithNumberOneAsChoice;
    @FXML
    CheckBox CheckBoxTwoWithNumberThreeAsChoice;
    @FXML
    CheckBox CheckBoxThreeWithNumberFiveAsChoice;

//FXCollections.observableArrayList(st)


    @FXML
    TextArea TextAreaForMessageToPlayer;
    @FXML
    public Button ButtonForSendInvite;



    public void ButtonForSendingInvite(ActionEvent event) {

      String getPlayerNameTwo=  TextFieldForPLayers.getText();
        Game startNewGame = new Game("hej",RetroFitServiceGenerator.userName,getPlayerNameTwo,"","","");



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


    public void ButtonBackToLobby(ActionEvent actionEvent) {

        changeScene("lobby.fxml");
    }




    @FXML
    private void handleOneBox(){
        if (CheckboxOneWithNumberOneAsChoice.isSelected()) {
            CheckBoxTwoWithNumberThreeAsChoice.setSelected(false);
            CheckBoxThreeWithNumberFiveAsChoice.setSelected(false);
        }
    }

    @FXML
    private void handleThreeBox(){
        if (CheckBoxTwoWithNumberThreeAsChoice.isSelected()) {
            CheckboxOneWithNumberOneAsChoice.setSelected(false);
            CheckBoxThreeWithNumberFiveAsChoice.setSelected(false);

                    }
    }

    @FXML
    private void handleFiveBox(){
        if ( CheckBoxThreeWithNumberFiveAsChoice.isSelected()) {
            CheckboxOneWithNumberOneAsChoice.setSelected(false);
            CheckBoxTwoWithNumberThreeAsChoice.setSelected(false);
        }
    }



}
