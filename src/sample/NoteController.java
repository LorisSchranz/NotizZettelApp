package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class NoteController implements Initializable {
    @FXML
    public TextField Title;
    @FXML
    public TextArea Content;
    @FXML
    public Button Save;
    @FXML
    public Label ErrorLabel;

    private ObservableList<Note> myModel = FXCollections.observableArrayList();
    private ListView<Note> myListview;
    private int Position = -1;


    void setModel(ObservableList<Note> list) {
        myModel = list;
    }

    void setEdit(int position) {
        Position = position;
        Title.setText(myModel.get(position).getTitle());
        Content.setText(myModel.get(position).getContent());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    public void Save() {
        boolean canSave = true;
        boolean canEdit = true;
        ErrorLabel.setText("");
        String content = Content.getText();
        String title = Title.getText();
        ErrorLabel.setText("Errors: ");
        if (myModel.size() != 0) {
            for (int i = 0; i < myModel.size(); i++) {
                if (title.equals(myModel.get(i).toString()) && i != Position) {
                    canSave = false;
                    ErrorLabel.setText(ErrorLabel.getText() + "Already Taken Title ");
                }
            }
        }
        if (title.equals("")) {
            canSave = false;
            ErrorLabel.setText(ErrorLabel.getText() + "No Title ");
        }
        if (Position == -1) {
            canEdit = false;
        }
        if (content.equals("")) {
            canSave = false;
            ErrorLabel.setText(ErrorLabel.getText() + "No Content ");
        }
        if (canSave && !canEdit) {
            myModel.add(new Note(title, content));
            Stage stage = (Stage) Save.getScene().getWindow();
            stage.close();
        } else if (canSave) {
            myModel.add(new Note(title, content));
            myModel.remove(Position);
            Stage stage = (Stage) Save.getScene().getWindow();
            stage.close();
        }
    }
}
