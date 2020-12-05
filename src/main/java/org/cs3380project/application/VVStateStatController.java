package org.cs3380project.application;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

public class VVStateStatController {

    @FXML
    private ChoiceBox stateDropDown;

    @FXML
    private Label stateCases;

    @FXML
    private Label stateDeaths;

    @FXML
    private Label stateHosp;

    public String temp = null;


    //populates the drop down menu with states;
    public void getStates(){

        stateCases.setText("");
        stateDeaths.setText("");
        stateHosp.setText("");

        stateDropDown.getItems().clear();

        //can be used to populate the state drop down list below
        String states [] = new String [50];
        stateDropDown.getItems().addAll("Alabama", "Alaska",  "Arizona", "Arkansas", "Colorado" );


    }
    //once the user selects their state from the drop down, they will click refresh to reload the labels below with the state information
    //this will need to be populate uses the state object
    public void getStateInfo(){

        if ( stateDropDown.getValue() == "Alabama"){
            stateCases.setText("1000");
            stateDeaths.setText("1000");
            stateHosp.setText("1000");
        }

        if ( stateDropDown.getValue() == "Alaska"){
            stateCases.setText("2000");
            stateDeaths.setText("2000");
            stateHosp.setText("2000");
        }



    }

    @FXML
    private void switchToMainPage() throws IOException {
        Main.setRoot("VVMainPage");
    }

    //Brings you to about covid
    @FXML
    private void switchToAboutCovid() throws IOException {
        Main.setRoot("VVAboutCovid");
    }

    //Brings you to about us
    @FXML
    private void switchToAboutUs() throws IOException {
        Main.setRoot("VVAboutUs");
    }

    //brings you restrictions
    @FXML
    private void switchToRestrict() throws IOException {
        Main.setRoot("VVRestrictions");
    }


}

