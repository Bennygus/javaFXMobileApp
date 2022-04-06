package com.example.javafxmobileapp.controllers;

import com.example.javafxmobileapp.Game;
import com.example.javafxmobileapp.SuperController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;

public class InviteController extends SuperController {



    ObservableList<ChoiceBox<String>> choiceBoxForPLayersList = FXCollections.observableArrayList();

    //String st[] = { "Arnab", "Andrew", "Ankit", "None" };








    @FXML
    CheckBox CheckboxOneWithNumberOneAsChoice;
    @FXML
    CheckBox CheckBoxTwoWithNumberThreeAsChoice;
    @FXML
    CheckBox CheckBoxThreeWithNumberFiveAsChoice;

//FXCollections.observableArrayList(st)
    @FXML
    ChoiceBox <String> ChoiceBoxForPLayers = new ChoiceBox<>();

    @FXML
    TextArea TextAreaForMessageToPlayer;
    @FXML
    public Button ButtonForSendInvite;


    public void ButtonForSendingInvite(ActionEvent event) {
        Game startNewGame = new Game();
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
