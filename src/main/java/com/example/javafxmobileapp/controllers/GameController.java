package com.example.javafxmobileapp.controllers;

import com.example.javafxmobileapp.*;

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

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Objects;


public class GameController extends SuperController {


    public static final String ROCK ="Rock";
    public static final String PAPER ="Paper";
    public static final String SCISSOR ="Scissor";


    Game game = new Game();
    GameRules gameRules;





    //Top

    public Pane PaneLeftForScore;

    public Text TextOnLeftPaneForScore;
    @FXML
    public Label LabelForPlayerOneAtScore;
    @FXML
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
    public TextArea TextAreaForReceiving;
    @FXML
    public TextArea TextAreaForMessage;
    @FXML
    public Button ButtonForSendingMessage;

    //för över vald game
    public void initialize(){

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



    public void match(){


        LabelForWinner.setOpacity(1);

        if (game.getChoiceOne().equals(game.getChoiceTwo())){ System.out.println("TIE");

            LabelForWinner.setText("Tie!");}


        else if (game.getChoiceOne().equals(ROCK)){
            if (game.getChoiceTwo().equals(PAPER)) {

                LabelForWinner.setText(game.getPlayerTwo() +
                        " Wins!");
                TextOnRightPaneForScore.setText("1");



            } else {
                LabelForWinner.setText(game.getPlayerOne() + " Wins!");
                TextOnLeftPaneForScore.setText("1");
            }

        }
        else if (game.getChoiceOne().equals(PAPER)){
            if (game.getChoiceTwo().equals(SCISSOR)) {
                LabelForWinner.setText(game.getPlayerTwo() +
                        " Wins!");
                TextOnRightPaneForScore.setText("1");

            } else {
                LabelForWinner.setText(game.getPlayerOne() + " Wins!");
                TextOnLeftPaneForScore.setText("1");
            }

        }

        else if (game.getChoiceOne().equals(SCISSOR)){
            if (game.getChoiceTwo().equals(ROCK)) {
                LabelForWinner.setText(game.getPlayerTwo() +
                        " Wins!");
                TextOnRightPaneForScore.setText("1");

            } else {
                LabelForWinner.setText(game.getPlayerOne() + " Wins!");
                TextOnLeftPaneForScore.setText("1");
            }

        }





    }


    public void setGame(Game game) {



        this.game = game;

        // Set name for the players next to the score one :Left two:right
       LabelForPlayerOneAtScore.setText(game.getPlayerOne());
       LabelForPlayerTwoAtScore.setText(game.getPlayerTwo());


        if (game.getPlayerOne().equals(RetroFitServiceGenerator.userName)){


            game.setPlayerOne(RetroFitServiceGenerator.userName);


        }
        else game.setPlayerTwo(RetroFitServiceGenerator.userName);

       // LabelForPlayerOneAtScore.setText(game.getPlayerOne());

    }

//------------
    //game = (Game) this.getMyObject();

    public void ClickOnRockButton(ActionEvent event) {


        setYourChoice(ROCK);


    }

    public void ClickOnPaperButton(ActionEvent event) {
        setYourChoice(PAPER);

    }

    public void ClickOnScissorButton(ActionEvent event) {
        setYourChoice(SCISSOR);


    }

    private void setYourChoice(String choice) {


//            if (game.getGameId()==null){
//                GameService service = RetroFitServiceGenerator.createAuthService(GameService.class);
//
//
//
//            }



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

                if (game.getChoiceOne().equals(game.getChoiceTwo()))

                    try {

                        Image myImage= new Image(("/Rock.jpg"));

                        ImageViewForPlayerOneChoice.setVisible(true);
                        ImageViewForPlayerTwoChoice.setVisible(true);



                        ImageViewForPlayerOneChoice.setImage(myImage);
                        ImageViewForPlayerTwoChoice.setImage(myImage);

                    } catch (Exception e) {
                        e.printStackTrace();
                    }




                match();}



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


}
