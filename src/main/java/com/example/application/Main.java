package com.example.application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        FXMLLoader loader = new FXMLLoader();

        /**
        primaryStage.setTitle("My First JavaFX App");

        Label label = new Label("Main World from JavaFX!");
        label.setAlignment(Pos.CENTER);

        // This sets the size of the Scene to be 400px wide, 200px high
        Scene scene = new Scene(label, 400, 200);
        primaryStage.setScene(scene);

        primaryStage.show();
         **/
    }
}