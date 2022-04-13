package com.example.javafxmobileapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


/**
 * Set Header text for log-in and a stage for the log-in scene when running the application.
 */
public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {



        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("loginScene.fxml"));
        Scene scene = new Scene(fxmlLoader.load());


       SuperController superController= fxmlLoader.getController();



        stage.setTitle("Rock,Paper and Scissor");

     superController.setStage(stage);




        stage.setScene(scene);
        stage.show();


    }

    public static void main(String[] args) {
        launch();
    }
}