package com.example.javafxmobileapp.controllers;

import com.example.javafxmobileapp.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.Random;


public class InviteController extends SuperController {

    @FXML
    public TextField TextFieldForPLayers;
    @FXML
    public RadioButton randomButton;

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

        //--------------------Test Random Radio Button-----------------------------------------
        if (randomButton.isSelected()){

            UserService userServiceToGetAllUsers = RetroFitServiceGenerator.createAuthService(UserService.class);
            Call<List<String>> callMyUsers = userServiceToGetAllUsers.getAllUsers();


                try {
                    Response<List<String>> response = callMyUsers.execute();


                    //TODO BAD RANDOM FIX! BAD SECURITY
                    Random random = new Random();

                    assert response.body() != null;

                    int randomUser = random.nextInt(response.body().size()+1) ;
//                   System.out.println(randomUser);
//                   System.out.println(response.body().size());
                    if (randomUser>6) {


                        assert response.body() != null;
                        getPlayerNameTwo = response.body().get(randomUser-1);
                    }

                    if (randomUser<6) {
                        assert response.body() != null;

                    //    System.out.println(randomUser);

                        getPlayerNameTwo = response.body().get(randomUser);
                    }


                } catch (IOException e) {

                    e.printStackTrace();

                }

        }
// ---------------------------Test Random end---------


        Game startNewGame = new Game(TextAreaForMessageToPlayer.getText(),"",RetroFitServiceGenerator.userName,getPlayerNameTwo,"","","","Active");

        GameService service = RetroFitServiceGenerator.createAuthService(GameService.class);

        Call<Game> callSync = service.createGame(startNewGame);

        try {


          //  changeScene("game.fxml");
            Response<Game> response = callSync.execute();

            startNewGame = response.body();

            assert startNewGame != null;
            GameController  gameController = (GameController) changeScene("game.fxml",startNewGame);
            gameController.setGame(startNewGame);

        }
        catch (Exception e){
            System.out.println(e.getMessage());

        }

    }

    /**
     *
     * @param event randomInviteButton sets disable for username textField true/false when clicked.
     */
    public void randomInviteButton(ActionEvent event) {

        if (randomButton.isSelected())
            TextFieldForPLayers.setDisable(true);
        if (!randomButton.isSelected()){
            TextFieldForPLayers.setDisable(false);
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
