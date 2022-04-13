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
    public Pane PaneLeftForScore;

    public Text TextOnLeftPaneForScore;
    @FXML
    public Label LabelForPlayerOneAtScore;
    @FXML
    public Label LabelForPlayerTwoAtScore;
    @FXML
    public Text TextOnRightPaneForScore;

    @FXML
    public Button ButtonForRock;
    @FXML
    public Button ButtonForPaper;
    @FXML
    public Button ButtonForScissor;


    //Middle
    @FXML
    public Label LabelForPlayerOneChoice;

    @FXML
    public Label LabelForPlayerTwoChoice;

    @FXML
    public ImageView ImageViewForPlayerOneChoice;

    @FXML
    public ImageView ImageViewForPlayerTwoChoice;

    @FXML
    public Button ButtonForChanging;
    @FXML
    public Label LabelForWinner;

    //Bottom

    @FXML
    public TextArea textAreaForReceiving;
    @FXML
    public TextArea textAreaForMessage;
    @FXML
    public Button ButtonForSendingMessage;
    //TODO fix match result to switch button


    @FXML
    public Button ButtonForGameToGoBack;
    @FXML
    public Button ButtonForCloseGame;
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
       LabelForPlayerOneAtScore.setText(game.getPlayerOne());
       LabelForPlayerTwoAtScore.setText(game.getPlayerTwo());


       // getting result to closed games and disable the choice buttons
       if (!game.getResult().equals("")){

           ButtonForRock.setDisable(true);
           ButtonForPaper.setDisable(true);
           ButtonForScissor.setDisable(true);
           ButtonForSendingMessage.setDisable(true);

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
    public void sendMessageToPlayer(ActionEvent dddd) {

        textAreaForReceiving.setText(textAreaForMessage.getText());

        if (game.getPlayerOne().equals(RetroFitServiceGenerator.userName) ){

             game.setMessageOne(textAreaForMessage.getText());

        }
        if (game.getPlayerTwo().equals(RetroFitServiceGenerator.userName)) {

             game.setMessageTwo(textAreaForMessage.getText());

        }

    }


    public void ClickOnRockButton(ActionEvent event) {

        setYourChoice(GameRules.ROCK);

        ButtonForPaper.setDisable(true);
        ButtonForScissor.setDisable(true);

    }

    public void ClickOnPaperButton(ActionEvent event) {
        setYourChoice(GameRules.PAPER);

        ButtonForRock.setDisable(true);
        ButtonForScissor.setDisable(true);

    }

    public void ClickOnScissorButton(ActionEvent event) {
        setYourChoice(GameRules.SCISSOR);

        ButtonForPaper.setDisable(true);
        ButtonForRock.setDisable(true);
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
                LabelForPlayerOneChoice.setVisible(true);
                LabelForPlayerOneChoice.setText(game.getPlayerOne() + " played " + game.getChoiceOne());
                LabelForPlayerTwoChoice.setVisible(true);
                LabelForPlayerTwoChoice.setText(game.getPlayerTwo() + " played " + game.getChoiceTwo());

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


    public void ButtonForGameToGoBackToLobby(ActionEvent event) {

        changeScene("lobby.fxml");
    }

    public void ButtonForCloseGame(ActionEvent event) {
        getStage().close();
    }

    //TODO Transfer to GameRules and write better code!
    public void match(){



        ImageViewForPlayerOneChoice.setVisible(true);
        ImageViewForPlayerTwoChoice.setVisible(true);

        LabelForWinner.setOpacity(1);

        if (game.checkIfTie(game.getChoiceOne(), game.getChoiceTwo())){

            LabelForWinner.setText("Tie!");

            game.setResult( TextOnLeftPaneForScore.getText() + " - " + TextOnRightPaneForScore.getText());


            Image myImage = new Image(("/" + game.getChoiceOne() + ".jpg"));


            ImageViewForPlayerOneChoice.setImage(myImage);
            ImageViewForPlayerTwoChoice.setImage(myImage);

        }

        else if (game.getChoiceOne().equals(GameRules.ROCK)){

            if (game.getChoiceTwo().equals(GameRules.PAPER)) {

                LabelForWinner.setText(game.getPlayerTwo() +
                        " Wins!");
                TextOnRightPaneForScore.setText("1");

                game.setResult( TextOnLeftPaneForScore.getText() + " - " + TextOnRightPaneForScore.getText());

                Image myImage = new Image(("/" + game.getChoiceTwo() + ".jpg"));
                ImageViewForPlayerTwoChoice.setImage(myImage);

                Image myImage2 = new Image(("/" + game.getChoiceOne() + ".jpg"));
                ImageViewForPlayerOneChoice.setImage(myImage2);



            } else {
                LabelForWinner.setText(game.getPlayerOne() + " Wins!");
                TextOnLeftPaneForScore.setText("1");

                game.setResult( TextOnLeftPaneForScore.getText() + " - " + TextOnRightPaneForScore.getText());

                Image myImage2 = new Image(("/" + game.getChoiceOne() + ".jpg"));
                ImageViewForPlayerOneChoice.setImage(myImage2);


                Image myImage3 = new Image(("/" + game.getChoiceTwo()+ ".jpg"));
                ImageViewForPlayerTwoChoice.setImage(myImage3);

            }

        }
        else if (game.getChoiceOne().equals(GameRules.PAPER)){

            if (game.getChoiceTwo().equals(GameRules.SCISSOR)) {
                LabelForWinner.setText(game.getPlayerTwo() +
                        " Wins!");
                TextOnRightPaneForScore.setText("1");

                game.setResult( TextOnLeftPaneForScore.getText() + " - " + TextOnRightPaneForScore.getText());

                Image myImage = new Image(("/" + game.getChoiceTwo() + ".jpg"));
                ImageViewForPlayerTwoChoice.setImage(myImage);


                Image myImage2 = new Image(("/" + game.getChoiceOne() + ".jpg"));
                ImageViewForPlayerOneChoice.setImage(myImage2);

            } else {
                LabelForWinner.setText(game.getPlayerOne() + " Wins!");
                TextOnLeftPaneForScore.setText("1");

                game.setResult( TextOnLeftPaneForScore.getText() + " - " + TextOnRightPaneForScore.getText());

                Image myImage2 = new Image(("/" + game.getChoiceOne() + ".jpg"));
                ImageViewForPlayerOneChoice.setImage(myImage2);


                Image myImage3 = new Image(("/" + game.getChoiceTwo()+ ".jpg"));
                ImageViewForPlayerTwoChoice.setImage(myImage3);


            }

        }

        else if (game.getChoiceOne().equals(GameRules.SCISSOR)){

            if (game.getChoiceTwo().equals(GameRules.ROCK)) {
                LabelForWinner.setText(game.getPlayerTwo() +
                        " Wins!");
                TextOnRightPaneForScore.setText("1");

                game.setResult( TextOnLeftPaneForScore.getText() + " - " + TextOnRightPaneForScore.getText());

                Image myImage = new Image(("/" + game.getChoiceTwo() + ".jpg"));
                ImageViewForPlayerTwoChoice.setImage(myImage);


                Image myImage2 = new Image(("/" + game.getChoiceOne() + ".jpg"));
                ImageViewForPlayerOneChoice.setImage(myImage2);

            } else  {
                LabelForWinner.setText(game.getPlayerOne() + " Wins!");
                TextOnLeftPaneForScore.setText("1");

                game.setResult( TextOnLeftPaneForScore.getText() + " - " + TextOnRightPaneForScore.getText());

                Image myImage2 = new Image(("/" + game.getChoiceOne() + ".jpg"));
                ImageViewForPlayerOneChoice.setImage(myImage2);


                Image myImage3 = new Image(("/" + game.getChoiceTwo()+ ".jpg"));
                ImageViewForPlayerTwoChoice.setImage(myImage3);

            }

        }

    }
}
