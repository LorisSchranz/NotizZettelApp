package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    private ObservableList<Note> notesModel = FXCollections.observableArrayList();
    @FXML
    public ListView<Note> lv1;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if (notesModel != null) {
            lv1.setItems(notesModel);
        }
    }

    public void newNote() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Note.fxml"));
            Parent newNote = fxmlLoader.load();
            NoteController noteController = fxmlLoader.getController();
            noteController.setModel(notesModel);
            Scene scene1 = new Scene(newNote, 500, 500);
            Stage stage1 = new Stage();
            stage1.setTitle("New Note");
            stage1.setResizable(false);
            stage1.setScene(scene1);
            stage1.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void end() {
        System.exit(0);
    }

    public void edit() {
        int position = lv1.getSelectionModel().getSelectedIndex();
        if (lv1.getSelectionModel().getSelectedItems() != null && notesModel != null && position != -1) {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Note.fxml"));
                Parent newNote = fxmlLoader.load();
                NoteController noteController = fxmlLoader.getController();
                noteController.setModel(notesModel);
                noteController.setEdit(position);
                Scene sceneEdit = new Scene(newNote, 500, 500);
                Stage stageEdit = new Stage();
                stageEdit.setTitle("New Note");
                stageEdit.setResizable(false);
                stageEdit.setScene(sceneEdit);
                stageEdit.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void delete() {
        int position = lv1.getSelectionModel().getSelectedIndex();
        if (lv1.getSelectionModel().getSelectedItems() != null && notesModel != null && position != -1) {
            notesModel.remove(position);
        }
    }

    public void about() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("About.fxml"));
            Parent newAbout = fxmlLoader.load();
            Scene sceneAbout = new Scene(newAbout, 500, 500);
            Stage stageAbout = new Stage();
            stageAbout.setTitle("New Note");
            stageAbout.setResizable(false);
            stageAbout.setScene(sceneAbout);
            stageAbout.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void help() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Help.fxml"));
            Parent newHelp = fxmlLoader.load();
            Scene sceneHelp = new Scene(newHelp, 500, 500);
            Stage stageHelp = new Stage();
            stageHelp.setTitle("New Note");
            stageHelp.setResizable(false);
            stageHelp.setScene(sceneHelp);
            stageHelp.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
