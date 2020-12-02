package org.cs3380project.application;

import java.io.IOException;
import javafx.fxml.FXML;

public class VVMainPageController {

    @FXML
    private void switchToStateData() throws IOException 
    {
        Main.setRoot("VVStateDataPage");
    }
    @FXML
    private void switchToAboutUs() throws IOException 
    {
        Main.setRoot("VVAboutUsPage");
    }
    @FXML
    private void switchToAdvisoryPage() throws IOException 
    {
        Main.setRoot("VVAdvisoryPage");
    }
    @FXML
    private void switchToAboutCovid() throws IOException 
    {
        Main.setRoot("VVAboutCovidPage");
    }
}
