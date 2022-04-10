package com.example.javafxmobileapp.controllers;

import com.example.javafxmobileapp.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import retrofit2.Call;
import retrofit2.Response;

import java.util.Objects;


public class InviteController extends SuperController {


    @FXML
    public TextField TextFieldForPLayers;


    @FXML
    CheckBox CheckboxOneWithNumberOneAsChoice;
    @FXML
    CheckBox CheckBoxTwoWithNumberThreeAsChoice;
    @FXML
    CheckBox CheckBoxThreeWithNumberFiveAsChoice;




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


          //  changeScene("game.fxml");
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


    public void ButtonBackToLobby(ActionEvent actionEvent) {

        changeScene("lobby.fxml");
    }




    @FXML
    private void handleOneBox(){


        CheckboxOneWithNumberOneAsChoice.setSelected(true);
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
