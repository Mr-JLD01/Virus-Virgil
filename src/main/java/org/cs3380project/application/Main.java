//John Luke Denny, Corin Canepa, Nicholas Levergne, Brian Tsai
package org.cs3380project.application;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


/**
 * JavaFX App
 */
public class Main extends Application {

    private static Scene scene;

    @Override
    public void start(Stage primaryStage) throws IOException {
        scene = new Scene(loadFXML("VVMainPage"), 900, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException{
        String name = fxml + ".fxml";



        // FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(fxml + ".fxml"));
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(Main.class.getResource(name));

        //loads controllers for the main page
        if (fxml.equals("VVMainPage")){
            Parent root = fxmlLoader.load();
            VVMainPageController mainPageController = fxmlLoader.getController();
            mainPageController.getUSTotalCases();
            return root;
        }

        //if user click on the State Stat page/scene this will load all the appropriate controllers
        else if (fxml.equals("VVStateStats")){
            Parent root = fxmlLoader.load();
            VVStateStatController  stateStatController = fxmlLoader.getController();
            stateStatController.getStates();

            return root;
        }

        else
            return fxmlLoader.load();
    }



    public static void main(String[] args) {

        launch();

    }

}
