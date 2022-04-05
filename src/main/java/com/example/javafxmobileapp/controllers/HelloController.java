package com.example.javafxmobileapp.controllers;

import com.example.javafxmobileapp.SuperController;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController extends SuperController {
    @FXML
    private Label welcomeText;



    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}