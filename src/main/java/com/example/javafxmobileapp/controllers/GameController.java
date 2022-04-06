package com.example.javafxmobileapp.controllers;

import com.example.javafxmobileapp.Game;
import com.example.javafxmobileapp.RetroFitServiceGenerator;
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
    public static final String PAPER ="Paper";
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




//        else if (game.getChoiceOne().equals(choicePlayerOne)){
//            if (game.getChoiceTwo().equals(choicePlayerTwo)) {
//                TextOnRightPaneForScore.setText("1");
//            } else {
//                TextOnLeftPaneForScore.setText("1");
//            }
//
//        }



//    public void ClickOnRockButton(ActionEvent event) {
//        if (RetroFitServiceGenerator.userName.equals()) game.setChoiceOne(ROCK); {
//            try {
//                match();
//            }
//            catch (Exception e){
//                System.out.println(e.getMessage());
//            }
//
//        }
//    }




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

    //för över vald game
    public void initialize(){

        game = (Game) this.getObject();
    }


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

//------------
public void match(){

    LabelForWinner.setOpacity(1);

    if (game.getChoiceOne().equals(game.getChoiceTwo())){ System.out.println("TIE");

        LabelForWinner.setText("TIE!");}


    else if (game.getChoiceOne().equals(ROCK)){
        if (game.getChoiceTwo().equals(PAPER)) {

            LabelForWinner.setText(game.getPlayerTwo() +
                    " wins");
            TextOnRightPaneForScore.setText("1");

        } else {
            LabelForWinner.setText(game.getPlayerOne() + " wins");
            TextOnLeftPaneForScore.setText("1");
        }

    }
    else if (game.getChoiceOne().equals(PAPER)){
        if (game.getChoiceTwo().equals(SCISSOR)) {
            LabelForWinner.setText(game.getPlayerTwo() +
                    " wins");
            TextOnRightPaneForScore.setText("1");

        } else {
            LabelForWinner.setText(game.getPlayerOne() + " wins");
            TextOnLeftPaneForScore.setText("1");
        }

    }

    else if (game.getChoiceOne().equals(SCISSOR)){
        if (game.getChoiceTwo().equals(ROCK)) {
            LabelForWinner.setText(game.getPlayerTwo() +
                    " wins");
            TextOnRightPaneForScore.setText("1");

        } else {
            LabelForWinner.setText(game.getPlayerOne() + " wins");
            TextOnLeftPaneForScore.setText("1");
        }

    }





}

    public void ClickOnPaperButton(ActionEvent event) {

        if (game.getPlayerOne().equals("1")) game.setChoiceOne(PAPER); {
            try {

            }
            catch (Exception e){
                System.out.println(e.getMessage());
            }

        }

    }

    public void ClickOnScissorButton(ActionEvent event) {
        if (game.getPlayerOne().equals("1")) game.setChoiceOne(SCISSOR); {
            try {

            }
            catch (Exception e){
                System.out.println(e.getMessage());
            }

        }

    }



}
