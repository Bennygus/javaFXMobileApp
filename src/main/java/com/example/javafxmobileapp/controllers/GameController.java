package com.example.javafxmobileapp.controllers;

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


    public Pane PaneLeftForScore;
    public Text TextOnLeftPaneForScore;
    public Label LabelForPlayerOneAtScore;
    public Label LabelForPlayerTwoAtScore;
    public Text TextOnRightPaneForScore;
    public Button ButtonForRock;
    public Button ButtonForPaper;
    public Button ButtonForScissor;
    public Label LabelForPlayerOneChoice;
    public Label LabelForPlayerTwoChoice;
    public Label LabelForWinner;
    public ImageView ImageViewForPlayerOneChoice;
    public ImageView ImageViewForPlayerTwoChoice;


    // outputText.setText(inputText.getText());
    @FXML
    public Button ButtonForChanging;

    @FXML
    public TextArea TextAreaForMessage;
    @FXML
    public Button ButtonForSendingMessage;
    @FXML
    public TextArea TextAreaForReceiving;


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

    public void sendMessageToPlayer(ActionEvent event) {
        TextAreaForReceiving.setText(TextAreaForMessage.getText());
        TextAreaForMessage.setText("");
        System.out.println();

    }
}
