package com.example.javafxmobileapp;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class SuperController {

    private Stage stage;
    private Object object;

    public Object getMyObject() {
        return this.object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }


    /**
     *
     * @param viewName changeScene method take in String that change scene/stage by FXMLLoader in SuperController.
     *                 Ex: string = "theName.fxml"
     */
    public void changeScene(String viewName) {
        FXMLLoader fxmlLoader = new FXMLLoader(SuperController.class.getResource(viewName));
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load());
            SuperController controller = fxmlLoader.getController();
            controller.setStage(stage);
            stage.setScene(scene);

        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    /**
     *
     * @param viewName  takes in a String that change scene/stage by FXMLLoader in SuperController.
     *      *                 Ex: string = "theName.fxml"
     * @param dataObject takes an Object to be used for setGame method in GameController as either a new game or loaded game
     * @return controller with a scene and dataObject or null if try and catch ain't working.
     */
    public SuperController changeScene(String viewName,Object dataObject) {
        FXMLLoader fxmlLoader = new FXMLLoader(SuperController.class.getResource(viewName));
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load());
            SuperController controller = fxmlLoader.getController();
            controller.setStage(stage);
            controller.setObject(dataObject);
            stage.setScene(scene);

            return controller;

        } catch (IOException e) {
            e.printStackTrace();
        }


        return null;
    }
}