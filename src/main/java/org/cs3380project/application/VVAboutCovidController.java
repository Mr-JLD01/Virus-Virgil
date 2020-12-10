package org.cs3380project.application;

import java.io.IOException;
import javafx.fxml.FXML;



public class VVAboutCovidController {

    //Brings you back to the home page
    @FXML
    private void switchToMainPage() throws IOException {


        Main.setRoot("VVMainPage");
    }

    //bring you to about us
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

}
