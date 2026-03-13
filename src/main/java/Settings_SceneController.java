package com.example;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class Settings_SceneController {

    @FXML
    private Button backBtn;

    @FXML
    private Button grassBtn;

    @FXML
    private Button hotBtn;

    @FXML
    private Button parentalSettingsBtn;

    @FXML
    private Button pet1Btn;

    @FXML
    private Button pet2Btn;

    @FXML
    private Button pet3Btn;

    @FXML
    private Button quiltBtn;

    @FXML
    private Button snowBtn;

    @FXML
    private Button spaceBtn;

    @FXML
    private GridPane spriteGrid;

    @FXML
    private GridPane spriteGrid1;

    @FXML
    private Button treatBtn;

    @FXML
    private Button waterBtn;

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    void Password_Settings(ActionEvent event) throws IOException {
        App.setRoot("Password_Settings");
    }

    @FXML
    void ReturnToMenu(ActionEvent event) throws IOException {
        App.setRoot(CurrentState.getInstance().returnScene());
    }
}
