package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;

import java.net.URL;
import java.util.ResourceBundle;

public class AboutController implements Initializable {
    @FXML
    public TextArea TextAbout;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        TextAbout.setText("Notizzettel 1.0 by Loris Schranz");
        TextAbout.appendText("\nReleased at 01.02.2019");
        TextAbout.appendText("\nHope you enjoy.");

    }

}
