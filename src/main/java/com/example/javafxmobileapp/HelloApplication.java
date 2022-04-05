package com.example.javafxmobileapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {


    @Override
    public void start(Stage stage) throws IOException {



        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("loginScene.fxml"));
        Scene scene = new Scene(fxmlLoader.load());


       SuperController superController= fxmlLoader.getController();



        stage.setTitle("Sten,Sax och Påse");

     superController.setStage(stage);




        stage.setScene(scene);
        stage.show();


    }

    public static void main(String[] args) {
        launch();
    }
}