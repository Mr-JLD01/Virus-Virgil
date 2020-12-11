John Luke Denny, Corin Canepa, Nicholas Levergne, Brian Tsai
package org.cs3380project.application;


import java.io.IOException;
import javafx.fxml.FXML;



public class VVAboutUsController {

    //Brings you back to the homePage
    @FXML
    private void switchToMainPage() throws IOException {

        Main.setRoot("VVMainPage");
    }

    //Brings you to about Covid
    @FXML
    private void switchToAboutCovid() throws IOException {


        Main.setRoot("VVAboutCovid");
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
}
