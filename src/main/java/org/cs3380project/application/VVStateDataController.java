package org.cs3380project.application;

import java.io.IOException;
import javafx.fxml.FXML;

public class VVStateDataController {

    @FXML
    private void switchToMainPage() throws IOException 
    {
        Main.setRoot("VVMainPage");
    }
    
    @FXML
    private void switchToAdvisoryPage() throws IOException 
    {
        Main.setRoot("VVAdvisoryPage");
    }
}
