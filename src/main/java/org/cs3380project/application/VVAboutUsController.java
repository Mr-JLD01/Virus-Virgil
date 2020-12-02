package org.cs3380project.application;

import java.io.IOException;
import javafx.fxml.FXML;

public class VVAboutUsController {

    @FXML
    private void switchToMainPage() throws IOException 
    {
        Main.setRoot("VVMainPage");
    }
}
