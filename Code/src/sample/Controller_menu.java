package sample;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Controller_menu {
    public void go_Add() throws IOException {
        Parent scene_Add = FXMLLoader.<Parent>load(getClass().getResource("Add.fxml"));
        Stage stage_Add = new Stage();
        stage_Add.initModality(Modality.APPLICATION_MODAL);
        stage_Add.setTitle("Add");
        stage_Add.setScene(new Scene(scene_Add));
        stage_Add.getIcons().add(new Image("/icon/add.png"));
        stage_Add.showAndWait();
    }

    public void go_Search() throws IOException {
        Parent scene_Search = FXMLLoader.<Parent>load(getClass().getResource("Search.fxml"));
        Stage stage_Search = new Stage();
        stage_Search.initModality(Modality.APPLICATION_MODAL);
        stage_Search.setTitle("Search");
        stage_Search.setScene(new Scene(scene_Search));
        stage_Search.getIcons().add(new Image("/icon/search.png"));
        stage_Search.showAndWait();
    }

    public void go_Change() throws IOException {
        Parent scene_Change = FXMLLoader.<Parent>load(getClass().getResource("Set.fxml"));
        Stage stage_Change = new Stage();
        stage_Change.initModality(Modality.APPLICATION_MODAL);
        stage_Change.setTitle("Set");
        stage_Change.setScene(new Scene(scene_Change));
        stage_Change.getIcons().add(new Image("/icon/set.png"));
        stage_Change.showAndWait();
    }

    public void go_About() throws IOException {
        Parent scene_About = FXMLLoader.<Parent>load(getClass().getResource("About.fxml"));
        Stage stage_About = new Stage();
        stage_About.initModality(Modality.APPLICATION_MODAL);
        stage_About.setTitle("About");
        stage_About.setScene(new Scene(scene_About));
        stage_About.getIcons().add(new Image("/icon/About.png"));
        stage_About.showAndWait();
    }
}