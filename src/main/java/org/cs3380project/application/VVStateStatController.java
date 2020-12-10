package org.cs3380project.application;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import org.cs3380project.application.backend.CovidUnitedStatesAPI;
import org.json.JSONObject;


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

    private String[] stateAbbv = {"AL","AK","AZ","AR","CA","CO",
            "CT","DE","FL","GA","HI","ID","IL","IN","IA","KS","KY",
            "LA","ME","MD","MA","MI","MN","MS","MO","MT","NE","NV",
            "NH","NJ","NM","NY","NC","ND","OH","OK","OR","PA","RI",
            "SC","SD","TN","TX","UT","VT","VA","WA","WV","WI","WY"};
    private ArrayList<String> states = new ArrayList<>(Arrays.asList(
            "Alabama","Alaska","Arizona","Arkansas","California","Colorado",
            "Connecticut","Delaware","Florida","Georgia","Hawaii","Idaho",
            "Illinois","Indiana","Iowa","Kansas","Kentucky","Louisiana",
            "Maine","Maryland","Massachusetts","Michigan","Minnesota",
            "Nebraska","Nevada","New Hampshire","New Jersey","New Mexico",
            "New York","North Carolina","North Dakota","Ohio","Oklahoma",
            "Oregon","Pennsylvania","Rhode Island","South Carolina","South Dakota",
            "Tennessee","Texas","Utah","Vermont","Virginia","Washington","West Virginia","Wisconsin","Wyoming"));

    //populates the drop down menu with states;
    public void getStates(){

        stateCases.setText("");
        stateDeaths.setText("");
        stateHosp.setText("");

        stateDropDown.getItems().clear();
        
        //can be used to populate the state drop down list below
        stateDropDown.getItems().addAll(states);
    }
    //once the user selects their state from the drop down, they will click refresh to reload the labels below with the state information
    //this will need to be populate uses the state object
    public void getStateInfo(){
        //try getIndex() not getValue()
        int state = states.indexOf(stateDropDown.getValue());
        JSONObject stateInfo = CovidUnitedStatesAPI.currentValuesSingleState(stateAbbv[state]);
        
        stateCases.setText("" + stateInfo.getInt("positive"));
        stateDeaths.setText("" + stateInfo.getInt("deathConfirmed"));
        stateHosp.setText("" + stateInfo.getInt("hospitalizedCurrently"));
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

