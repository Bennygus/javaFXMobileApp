package com.example.javafxmobileapp.controllers;

import com.example.javafxmobileapp.*;

import com.example.javafxmobileapp.services.GameService;
import com.example.javafxmobileapp.services.RetroFitServiceGenerator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

import retrofit2.Call;
import retrofit2.Response;

import java.util.Objects;


public class GameController extends SuperController {


    Game game = new Game();

    //Top
    @FXML
    public Pane paneLeftForScore;
    @FXML
    public Text textOnLeftPaneForScore;
    @FXML
    public Label labelForPlayerOneAtScore;
    @FXML
    public Label labelForPlayerTwoAtScore;
    @FXML
    public Text textOnRightPaneForScore;

    @FXML
    public Button buttonForRock;
    @FXML
    public Button buttonForPaper;
    @FXML
    public Button buttonForScissor;


    //Middle
    @FXML
    public Label labelForPlayerOneChoice;

    @FXML
    public Label labelForPlayerTwoChoice;

    @FXML
    public ImageView imageViewForPlayerOneChoice;

    @FXML
    public ImageView imageViewForPlayerTwoChoice;

    @FXML
    public Button buttonForChanging;
    @FXML
    public Label labelForWinner;

    //Bottom

    @FXML
    public TextArea textAreaForReceiving;
    @FXML
    public TextArea textAreaForMessage;
    @FXML
    public Button buttonForSendingMessage;
    //TODO fix match result to switch button

    @FXML
    public Button buttonForGameToGoBack;
    @FXML
    public Button buttonForCloseGame;
    //för över vald game
    public void initialize(){

    }

    //TODO better code
    // swap between message and score/result for each round by opacity maybe disable instead
    public void changeOpacity(ActionEvent event) {

//        if (textAreaForMessage.getOpacity() == 1){
//            textAreaForMessage.setOpacity(0);
//        }
//        else textAreaForMessage.setOpacity(1);
//
//        if (ButtonForSendingMessage.getOpacity() == 1){
//            ButtonForSendingMessage.setOpacity(0);
//        }
//        else ButtonForSendingMessage.setOpacity(1);
//
//        if (textAreaForReceiving.getOpacity() == 1){
//            textAreaForReceiving.setOpacity(0);
//        }
//        else textAreaForReceiving.setOpacity(1);

    }



    /**
     *
     * @param game takes in a game object from invite and list Controller.
     */

    public void setGame(Game game) {

        this.game = game;

        // Set name for the players next to the score one :Left two:right
       labelForPlayerOneAtScore.setText(game.getPlayerOne());
       labelForPlayerTwoAtScore.setText(game.getPlayerTwo());


       // getting result to closed games and disable the choice buttons
       if (!game.getResult().equals("")){

           buttonForRock.setDisable(true);
           buttonForPaper.setDisable(true);
           buttonForScissor.setDisable(true);
           buttonForSendingMessage.setDisable(true);

           match();
       }

        // set users to player One and two depending on who started the invite
        if (game.getPlayerOne().equals(RetroFitServiceGenerator.userName)){

            game.setPlayerOne(RetroFitServiceGenerator.userName);

           textAreaForReceiving.setText(game.getMessageTwo()+ "\n"+ game.getMessageOne());

        }
        else game.setPlayerTwo(RetroFitServiceGenerator.userName);

            textAreaForReceiving.setText(game.getMessageOne()+ "\n"+ game.getMessageTwo());

    }


    //TODO fix sendMessage to work like a chat
    public void sendMessageToPlayerOnAction(ActionEvent dddd) {

        textAreaForReceiving.setText(textAreaForMessage.getText());

        if (game.getPlayerOne().equals(RetroFitServiceGenerator.userName) ){

             game.setMessageOne(textAreaForMessage.getText());

        }
        if (game.getPlayerTwo().equals(RetroFitServiceGenerator.userName)) {

             game.setMessageTwo(textAreaForMessage.getText());

        }

    }


    public void clickOnRockButtonOnAction(ActionEvent event) {

        setYourChoice(GameRules.ROCK);

        buttonForPaper.setDisable(true);
        buttonForScissor.setDisable(true);

    }

    public void clickOnPaperButtonOnAction(ActionEvent event) {
        setYourChoice(GameRules.PAPER);

        buttonForRock.setDisable(true);
        buttonForScissor.setDisable(true);

    }

    public void clickOnScissorButtonOnAction(ActionEvent event) {
        setYourChoice(GameRules.SCISSOR);

        buttonForPaper.setDisable(true);
        buttonForRock.setDisable(true);
    }

    /**
     *
     * @param choice method for choice and who make the choice, depending on whose logged-in userName is equal to playerOne
     *               or two.
     *               also update the game and determine the outcome after both made a choice.
     *
     */
    private void setYourChoice(String choice) {

            // Set choice by set playerName from setGame method
            if (RetroFitServiceGenerator.userName.equals(game.getPlayerOne()))
                game.setChoiceOne(choice);

            else
                game.setChoiceTwo(choice);

            //when both have done a choice
            if (!Objects.equals(game.getChoiceOne(), "") && !Objects.equals(game.getChoiceTwo(), "")){


                //set players choice visible
                labelForPlayerOneChoice.setVisible(true);
                labelForPlayerOneChoice.setText(game.getPlayerOne() + " played " + game.getChoiceOne());
                labelForPlayerTwoChoice.setVisible(true);
                labelForPlayerTwoChoice.setText(game.getPlayerTwo() + " played " + game.getChoiceTwo());

                // rules and determine winner and show all choices and winner
                match();

                game.setState("Closed");
            }

            GameService service = RetroFitServiceGenerator.createAuthService(GameService.class);

            Call<Game> callSync = service.updateMyGame(game.getGameId(),game);

            try {

                Response<Game> response = callSync.execute();
//
            }
            catch (Exception e){
                System.out.println(e.getMessage());

            }
    }


    public void buttonForGameToGoBackToLobbyOnAction(ActionEvent event) {

        changeScene("lobby.fxml");
    }

    public void buttonForCloseGameOnAction(ActionEvent event) {
        getStage().close();
    }

    //TODO Transfer to GameRules and write better code and change wins! text to a constant!
    public void match(){



        imageViewForPlayerOneChoice.setVisible(true);
        imageViewForPlayerTwoChoice.setVisible(true);

        labelForWinner.setOpacity(1);

        if (game.checkIfTie(game.getChoiceOne(), game.getChoiceTwo())){

            labelForWinner.setText("Tie!");

            game.setResult( textOnLeftPaneForScore.getText() + " - " + textOnRightPaneForScore.getText());


            Image myImage = new Image(("/" + game.getChoiceOne() + ".jpg"));


            imageViewForPlayerOneChoice.setImage(myImage);
            imageViewForPlayerTwoChoice.setImage(myImage);

        }

        else if (game.getChoiceOne().equals(GameRules.ROCK)){

            if (game.getChoiceTwo().equals(GameRules.PAPER)) {

                labelForWinner.setText(game.getPlayerTwo() +
                        " Wins!");
                textOnRightPaneForScore.setText("1");

                game.setResult( textOnLeftPaneForScore.getText() + " - " + textOnRightPaneForScore.getText());

                Image myImage = new Image(("/" + game.getChoiceTwo() + ".jpg"));
                imageViewForPlayerTwoChoice.setImage(myImage);

                Image myImage2 = new Image(("/" + game.getChoiceOne() + ".jpg"));
                imageViewForPlayerOneChoice.setImage(myImage2);



            } else {
                labelForWinner.setText(game.getPlayerOne() + " Wins!");
                textOnLeftPaneForScore.setText("1");

                game.setResult( textOnLeftPaneForScore.getText() + " - " + textOnRightPaneForScore.getText());

                Image myImage2 = new Image(("/" + game.getChoiceOne() + ".jpg"));
                imageViewForPlayerOneChoice.setImage(myImage2);


                Image myImage3 = new Image(("/" + game.getChoiceTwo()+ ".jpg"));
                imageViewForPlayerTwoChoice.setImage(myImage3);

            }

        }
        else if (game.getChoiceOne().equals(GameRules.PAPER)){

            if (game.getChoiceTwo().equals(GameRules.SCISSOR)) {
                labelForWinner.setText(game.getPlayerTwo() +
                        " Wins!");
                textOnRightPaneForScore.setText("1");

                game.setResult( textOnLeftPaneForScore.getText() + " - " + textOnRightPaneForScore.getText());

                Image myImage = new Image(("/" + game.getChoiceTwo() + ".jpg"));
                imageViewForPlayerTwoChoice.setImage(myImage);


                Image myImage2 = new Image(("/" + game.getChoiceOne() + ".jpg"));
                imageViewForPlayerOneChoice.setImage(myImage2);

            } else {
                labelForWinner.setText(game.getPlayerOne() + " Wins!");
                textOnLeftPaneForScore.setText("1");

                game.setResult( textOnLeftPaneForScore.getText() + " - " + textOnRightPaneForScore.getText());

                Image myImage2 = new Image(("/" + game.getChoiceOne() + ".jpg"));
                imageViewForPlayerOneChoice.setImage(myImage2);


                Image myImage3 = new Image(("/" + game.getChoiceTwo()+ ".jpg"));
                imageViewForPlayerTwoChoice.setImage(myImage3);


            }

        }

        else if (game.getChoiceOne().equals(GameRules.SCISSOR)){

            if (game.getChoiceTwo().equals(GameRules.ROCK)) {
                labelForWinner.setText(game.getPlayerTwo() +
                        " Wins!");
                textOnRightPaneForScore.setText("1");

                game.setResult( textOnLeftPaneForScore.getText() + " - " + textOnRightPaneForScore.getText());

                Image myImage = new Image(("/" + game.getChoiceTwo() + ".jpg"));
                imageViewForPlayerTwoChoice.setImage(myImage);


                Image myImage2 = new Image(("/" + game.getChoiceOne() + ".jpg"));
                imageViewForPlayerOneChoice.setImage(myImage2);

            } else  {
                labelForWinner.setText(game.getPlayerOne() + " Wins!");
                textOnLeftPaneForScore.setText("1");

                game.setResult( textOnLeftPaneForScore.getText() + " - " + textOnRightPaneForScore.getText());

                Image myImage2 = new Image(("/" + game.getChoiceOne() + ".jpg"));
                imageViewForPlayerOneChoice.setImage(myImage2);


                Image myImage3 = new Image(("/" + game.getChoiceTwo()+ ".jpg"));
                imageViewForPlayerTwoChoice.setImage(myImage3);

            }

        }

    }
}
