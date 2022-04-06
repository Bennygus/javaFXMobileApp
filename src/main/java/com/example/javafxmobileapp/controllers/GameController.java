package com.example.javafxmobileapp.controllers;

import com.example.javafxmobileapp.Game;
import com.example.javafxmobileapp.SuperController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

public class GameController extends SuperController {


    public static final String ROCK ="Rock";
    public static final String Paper ="Paper";
    public static final String SCISSOR ="Scissor";

    Game game = new Game();


    //Top

    public Pane PaneLeftForScore;
    public Text TextOnLeftPaneForScore;
    public Label LabelForPlayerOneAtScore;
    public Label LabelForPlayerTwoAtScore;
    public Text TextOnRightPaneForScore;

    @FXML
    public Button ButtonForRock;
    @FXML
    public Button ButtonForPaper;
    @FXML
    public Button ButtonForScissor;

    public void match(String choicePlayerOne,String choicePlayerTwo){


        if (game.getChoiceOne().equals(game.getChoiceTwo())){ System.out.println("TIE");
            LabelForWinner.setOpacity(1);
            LabelForWinner.setText("TIE!");}

        else if (game.getChoiceOne().equals(choicePlayerOne)){
            if (game.getChoiceTwo().equals(choicePlayerTwo)) {
                TextOnRightPaneForScore.setText("1");
            } else {
                TextOnLeftPaneForScore.setText("1");
            }

        }
//        else if (game.getChoiceOne().equals(Paper)){
//            if (game.getChoiceTwo().equals(SCISSOR)) {
//                TextOnRightPaneForScore.setText("1");
//            } else {
//                TextOnLeftPaneForScore.setText("1");
//            }
//
//        }
//        else if (game.getChoiceOne().equals(SCISSOR)){
//            if (game.getChoiceTwo().equals(ROCK)) {
//                TextOnRightPaneForScore.setText("1");
//            } else {
//                TextOnLeftPaneForScore.setText("1");
//            }
//
//        }

// computerMove.equals(Game.PAPER) ? "Computer Wins": "Player wins");


    }

    public void ClickOnRockButton(ActionEvent event) {
        if (game.getPlayerOne().equals("1")) game.setChoiceOne(ROCK); {
            try {
                match(game.getChoiceOne(),game.getChoiceTwo());
            }
            catch (Exception e){
                System.out.println(e.getMessage());
            }

        }
    }
    public void ClickOnPaperButton(ActionEvent event) {

        if (game.getPlayerOne().equals("1")) game.setChoiceOne(Paper); {
            try {
                match(game.getChoiceOne(),game.getChoiceTwo());
            }
            catch (Exception e){
                System.out.println(e.getMessage());
            }

        }

    }

    public void ClickOnScissorButton(ActionEvent event) {
        if (game.getPlayerOne().equals("1")) game.setChoiceOne(SCISSOR); {
            try {
                match(game.getChoiceOne(),game.getChoiceTwo());
            }
            catch (Exception e){
                System.out.println(e.getMessage());
            }

        }

    }



    //Middle
    public Label LabelForPlayerOneChoice;

    public Label LabelForPlayerTwoChoice;

    public ImageView ImageViewForPlayerOneChoice;

    public ImageView ImageViewForPlayerTwoChoice;

    @FXML
    public Button ButtonForChanging;
    @FXML
    public Label LabelForWinner;
    //Bottom

    @FXML
    public TextArea TextAreaForReceiving;
    @FXML
    public TextArea TextAreaForMessage;
    @FXML
    public Button ButtonForSendingMessage;



    //TODO better code
    // swap between message and score/result for each round by opacity
    public void changeOpacity(ActionEvent event) {

        if (TextAreaForMessage.getOpacity() == 1){
            TextAreaForMessage.setOpacity(0);
        }
        else TextAreaForMessage.setOpacity(1);

        if (ButtonForSendingMessage.getOpacity() == 1){
            ButtonForSendingMessage.setOpacity(0);
        }
        else ButtonForSendingMessage.setOpacity(1);

        if (TextAreaForReceiving.getOpacity() == 1){
            TextAreaForReceiving.setOpacity(0);
        }
        else TextAreaForReceiving.setOpacity(1);


    }

    //TODO fix sendMessage to work like a chat
    public void sendMessageToPlayer(ActionEvent event) {
        TextAreaForReceiving.setText(TextAreaForMessage.getText());
        TextAreaForMessage.setText("");


    }



}
