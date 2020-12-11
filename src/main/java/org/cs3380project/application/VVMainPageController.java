//John Luke Denny, Corin Canepa, Nicholas Levergne, Brian Tsai
package org.cs3380project.application;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Label;





public class VVMainPageController{



    @FXML
    private Label USTotalCases;

    @FXML
    private Label USTotalDeaths;




    //brings you back to the home page
    @FXML
    private void switchToAboutCovid() throws IOException {
        Main.setRoot("VVAboutCovid");
    }

    //brings to to about us
    @FXML
    private void switchToAboutUs() throws IOException {
        Main.setRoot("VVAboutUs");
    }

    //Brings you to COVID restrictions

    @FXML
    private void switchToRestrict() throws IOException {
        Main.setRoot("VVRestrictions");
    }

    //Brings you to state statistics
    @FXML
    private void switchToStateStats() throws IOException {
         Main.setRoot("VVStateStats");
    }

    //gets the information to display the total US positive cases and total deaths on the homepage
    public void getUSTotalCases(){
        USTotalCases.setText("14,041,436");
        USTotalDeaths.setText("275,387");

    }




}

