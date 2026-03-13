package com.example;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.control.PasswordField;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class Password_Settings_SceneController {

    @FXML
    private PasswordField passwordField;

    /**
     * Navigates back to the Settings screen using App.setRoot.
     */
    @FXML
    void Settings(ActionEvent event) throws IOException {
        App.setRoot("Settings");
    }

    /**
     * Checks the password and navigates to the Parental Settings screen if correct.
     * If the password is wrong, it plays womp.mp3 and clears the password field.
     */
    @FXML
    void verifyPassword(ActionEvent event) throws IOException {
        String input = passwordField.getText();

        if ("goofy".equals(input)) {
            // Password correct: load Parental Settings screen using App.setRoot.
            App.setRoot("Parental_Settings");
        } else {
            passwordField.clear();
            System.out.println("Incorrect password.");

            // Play womp.mp3 from the classpath.
            // Ensure that womp.mp3 is placed in src/main/resources/com/example/
            java.net.URL soundURL = getClass().getResource("/com/example/womp.mp3");
            if (soundURL != null) {
                Media sound = new Media(soundURL.toString());
                MediaPlayer mediaPlayer = new MediaPlayer(sound);
                mediaPlayer.play();
            } else {
                System.err.println("Sound file not found: womp.mp3");
            }
        }
    }
}
