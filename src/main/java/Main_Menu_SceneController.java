package com.example;

import java.io.IOException;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Alert.AlertType;
import javafx.event.ActionEvent;
import javafx.util.Duration;

public class Main_Menu_SceneController {

    @FXML
    private Button newGameButton;

    @FXML
    private Button loadGameButton;

    // Timeline for checking parental restrictions periodically.
    private Timeline restrictionsTimeline;

    @FXML
    public void initialize() {
        // Check every 30 seconds.
        restrictionsTimeline = new Timeline(new KeyFrame(Duration.seconds(30), event -> checkParentalRestrictions()));
        restrictionsTimeline.setCycleCount(Timeline.INDEFINITE);
        restrictionsTimeline.play();
    }

    /**
     * Stops the timeline (if needed) before switching scenes.
     */
    public void stopTimeline() {
        if (restrictionsTimeline != null) {
            restrictionsTimeline.stop();
        }
    }

    /**
     * Checks parental restrictions and disables the New Game and Load Game buttons if needed.
     */
    private void checkParentalRestrictions() {
        Restrictions r = App.getRestrictions();
        if (r.isGameStatus() && !r.isPlayAllowed()) {
            if(newGameButton != null) newGameButton.setDisable(true);
            if(loadGameButton != null) loadGameButton.setDisable(true);
            System.out.println("Parental restrictions active: New Game and Load Game disabled.");
        } else {
            if(newGameButton != null) newGameButton.setDisable(false);
            if(loadGameButton != null) loadGameButton.setDisable(false);
        }
    }

    @FXML
    public void NewGame(ActionEvent event) throws IOException {
        stopTimeline();
        Restrictions r = App.getRestrictions();
        if (r.isGameStatus() && !r.isPlayAllowed()) {
            showRestrictionAlert("New Game cannot be started due to parental restrictions.\nPlease remove restrictions to continue.");
        } else {
            App.setRoot("New_Game");
        }
    }

    @FXML
    public void LoadGame(ActionEvent event) throws IOException {
        stopTimeline();
        Restrictions r = App.getRestrictions();
        if (r.isGameStatus() && !r.isPlayAllowed()) {
            showRestrictionAlert("Load Game cannot be started due to parental restrictions.\nPlease remove restrictions to continue.");
        } else {
            App.setRoot("Load_Game");
        }
    }

    @FXML
    public void Tutorial(ActionEvent event) throws IOException {
        stopTimeline();
        CurrentState.getInstance().lastScene("Main_Menu");
        App.setRoot("Tut_1");
    }

    @FXML
    public void Settings(ActionEvent event) throws IOException {
        stopTimeline();
        CurrentState.getInstance().lastScene("Main_Menu");
        App.setRoot("Settings");
    }

    @FXML
    public void Exit(ActionEvent event) {
        stopTimeline();
        System.exit(0);
    }

    /**
     * Displays an alert indicating that parental restrictions are active.
     */
    private void showRestrictionAlert(String message) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Restricted Playtime");
        alert.setHeaderText("Access Denied");
        alert.setContentText(message);
        alert.showAndWait();
    }
}
