package com.example.javafxmobileapp.controllers;

import com.example.javafxmobileapp.*;

import com.example.javafxmobileapp.services.GameService;
import com.example.javafxmobileapp.services.RetroFitServiceGenerator;
import com.example.javafxmobileapp.services.UserService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;
import java.util.List;
import java.util.Random;


public class InviteController extends SuperController {

    @FXML
    public TextField textFieldForPLayers;
    @FXML
    public RadioButton randomButton;

    @FXML
    CheckBox checkboxOneWithNumberOneAsChoice;
    @FXML
    CheckBox checkBoxTwoWithNumberThreeAsChoice;
    @FXML
    CheckBox checkBoxThreeWithNumberFiveAsChoice;


    @FXML
    TextArea textAreaForMessageToPlayer;

    @FXML
    public Button buttonForSendInvite;




    public void buttonForSendingInviteOnAction(ActionEvent event) {


        String getPlayerNameTwo=  textFieldForPLayers.getText();

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


        Game startNewGame = new Game(textAreaForMessageToPlayer.getText(),"",RetroFitServiceGenerator.userName,getPlayerNameTwo,"","","","Active");

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

//    /**
//     *
//     * @param event randomInviteButton sets disable for username textField true/false when clicked.
//     */
    public void randomInviteButtonOnAction(ActionEvent event) {

        if (randomButton.isSelected())
            textFieldForPLayers.setDisable(true);
        if (!randomButton.isSelected()){
            textFieldForPLayers.setDisable(false);
        }


    }


    public void buttonBackToLobbyOnAction(ActionEvent actionEvent) {

        changeScene("lobby.fxml");
    }




    @FXML
    private void handleOneBox(){


        checkboxOneWithNumberOneAsChoice.setSelected(true);
        if (checkboxOneWithNumberOneAsChoice.isSelected()) {



            checkBoxTwoWithNumberThreeAsChoice.setSelected(false);
            checkBoxThreeWithNumberFiveAsChoice.setSelected(false);
        }
    }

    @FXML
    private void handleThreeBox(){
        if (checkBoxTwoWithNumberThreeAsChoice.isSelected()) {
            checkboxOneWithNumberOneAsChoice.setSelected(false);
            checkBoxThreeWithNumberFiveAsChoice.setSelected(false);

                    }
    }

    @FXML
    private void handleFiveBox(){
        if ( checkBoxThreeWithNumberFiveAsChoice.isSelected()) {
            checkboxOneWithNumberOneAsChoice.setSelected(false);
            checkBoxTwoWithNumberThreeAsChoice.setSelected(false);
        }
    }


    public void buttonForCloseInviteGameOnAction(ActionEvent event) {

        getStage().close();
    }
}
