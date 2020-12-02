package org.cs3380project.application;

import java.io.IOException;
import javafx.fxml.FXML;

public class VVAdvisoryController {

    @FXML
    private void switchToMainPage() throws IOException 
    {
        Main.setRoot("VVMainPage");
    }
    @FXML
    private void switchToStateDataPage() throws IOException 
    {
        Main.setRoot("VVStateDataPage");
    }
}
