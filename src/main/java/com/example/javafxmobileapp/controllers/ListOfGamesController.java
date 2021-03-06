package com.example.javafxmobileapp.controllers;

import com.example.javafxmobileapp.Game;
import com.example.javafxmobileapp.services.GameService;
import com.example.javafxmobileapp.services.RetroFitServiceGenerator;
import com.example.javafxmobileapp.SuperController;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import retrofit2.Call;
import retrofit2.Response;

import java.util.List;

public class ListOfGamesController extends SuperController {




    @FXML
    public ListView listView;
    @FXML
    public Button ButtonForListOfGamesToGoBack;
    @FXML
    public Button ButtonForCloseTheGameInList;

    public void initialize(){

        GameService service = RetroFitServiceGenerator.createAuthService(GameService.class);


        Call <List<Game>> callSync = service.getAllMyGames();


        try {

         Response <List<Game>> response =  callSync.execute();

         listView.setItems(FXCollections.observableList(response.body()));


        }
        catch (Exception e){
            System.out.println(e);
        }

       listView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Game>() {

            @Override
            public void changed(ObservableValue<? extends Game> observable, Game oldValue, Game newValue) {


                if (!newValue.getResult().equals("")){
                    newValue.setState("Closed");

                }

                // ändrar controller från super till gameController med type cast
                GameController  gameController = (GameController) changeScene("game.fxml",newValue);
                // upd game
                gameController.setGame(newValue);


            }
        });


    }

    public void buttonForListOfGamesToGoBackOnAction(ActionEvent event) {
        changeScene("lobby.fxml");
    }

    public void buttonForCloseTheGameInListOnAction(ActionEvent event) {
        getStage().close();
    }
}
