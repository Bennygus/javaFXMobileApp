package com.example.javafxmobileapp.controllers;

import com.example.javafxmobileapp.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

import retrofit2.Call;
import retrofit2.Response;

import java.util.Objects;


public class GameController extends SuperController {


    private static final String ROCK ="Rock";
    private static final String PAPER ="Paper";
    private static final String SCISSOR ="Scissor";



    Game game = new Game();

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
    //TODO fix match result to switch button
    @FXML

    public ListView matchResult;
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

        if (game.getPlayerOne().equals(RetroFitServiceGenerator.userName) ){

            game.setMessageOne(TextAreaForMessage.getText());


        }
        else
            game.setMessageTwo(TextAreaForMessage.getText());

        TextAreaForReceiving.setText(game.getMessageOne());


    }

    public void match(){

        //TODO Transfer to GameRules and write better code!

        ImageViewForPlayerOneChoice.setVisible(true);
        ImageViewForPlayerTwoChoice.setVisible(true);

        LabelForWinner.setOpacity(1);

        if (game.getChoiceOne().equals(game.getChoiceTwo())){

            LabelForWinner.setText("Tie!");

            game.setResult( TextOnLeftPaneForScore.getText() + " - " + TextOnRightPaneForScore.getText());


            Image myImage = new Image(("/" + game.getChoiceOne() + ".jpg"));


            ImageViewForPlayerOneChoice.setImage(myImage);
            ImageViewForPlayerTwoChoice.setImage(myImage);

        }

        else if (game.getChoiceOne().equals(ROCK)){

            if (game.getChoiceTwo().equals(PAPER)) {

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
        else if (game.getChoiceOne().equals(PAPER)){

            if (game.getChoiceTwo().equals(SCISSOR)) {
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

        else if (game.getChoiceOne().equals(SCISSOR)){

            if (game.getChoiceTwo().equals(ROCK)) {
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


    /**
     *
     * @param game takes in a game object from invite and list.
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

           match();

       }

        // set users to player One and two depending on who started the invite
        if (game.getPlayerOne().equals(RetroFitServiceGenerator.userName)){


            game.setPlayerOne(RetroFitServiceGenerator.userName);

        }
        else game.setPlayerTwo(RetroFitServiceGenerator.userName);

    }



    public void ClickOnRockButton(ActionEvent event) {


        setYourChoice(ROCK);

        ButtonForPaper.setDisable(true);
        ButtonForScissor.setDisable(true);


    }

    public void ClickOnPaperButton(ActionEvent event) {
        setYourChoice(PAPER);

        ButtonForRock.setDisable(true);
        ButtonForScissor.setDisable(true);

    }

    public void ClickOnScissorButton(ActionEvent event) {
        setYourChoice(SCISSOR);

        ButtonForPaper.setDisable(true);
        ButtonForRock.setDisable(true);

    }

    /**
     *
     * @param choice method for choice and who make the choice depending on whose logged-in userName is equal to playerOne
     *               or two.
     *               also update the game and determine the outcome after both made a choice
     *
     */
    private void setYourChoice(String choice) {



            // Set choice to determine if it's the one inviting aka first player(left) or second(right)
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

//        if (!game.getResult().equals("")){
//            game.setState("Closed");
//
//
//        }

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
}
