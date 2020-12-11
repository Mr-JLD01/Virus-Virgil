//John Luke Denny, Corin Canepa, Nicholas Levergne, Brian Tsai
package org.cs3380project.application;

import java.io.IOException;
import javafx.fxml.FXML;



public class VVRestrictController {


    //Brings you back to the home page
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

    //Brings you to state statistics
    @FXML
    private void switchToStateStats() throws IOException {
        Main.setRoot("VVStateStats");
    }
}
