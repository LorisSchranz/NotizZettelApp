package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;

import java.net.URL;
import java.util.ResourceBundle;

public class HelpController implements Initializable {
    @FXML
    public TextArea TextHelp;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        TextHelp.setText("Here you can look up everyting what you can do with this programm.");
        TextHelp.appendText("\n1. You can create new Notes and add a Title to them and add some content");
        TextHelp.appendText("\n2. You can edit your Notes that you created and delete them.");
    }
}
