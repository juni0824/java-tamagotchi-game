package com.example;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.event.ActionEvent;
import javafx.util.Duration;

public class Parental_Settings_SceneController {

    // UI elements for displaying statistics.
    @FXML
    private Label totalPlayTimeLabel;             // Current session time
    @FXML
    private Label totalPlayTimeMinsSecsLabel;       // Cumulative total play time
    @FXML
    private Label averageSessionTimeLabel;          // Average session time

    // UI elements for parental limitations.
    @FXML
    private TextField startTimeField;
    @FXML
    private TextField endTimeField;
    @FXML
    private ToggleButton parentalToggle;

    // NEW: ComboBox for selecting save slot.
    @FXML
    private ComboBox<String> slotComboBox;

    // Use the singleton Stats instance.
    private Stats stats = Stats.getInstance();
    // Use the shared Restrictions instance from App.
    private Restrictions restrictions = App.getRestrictions();

    // Timeline for updating the statistics labels live.
    private Timeline statsTimeline;

    @FXML
    public void initialize() {
        // Update statistics every 1 second.
        statsTimeline = new Timeline(new KeyFrame(Duration.seconds(1), event -> updateStatisticsLabels()));
        statsTimeline.setCycleCount(Timeline.INDEFINITE);
        statsTimeline.play();

        // Prepopulate the parental settings UI with current restrictions.
        parentalToggle.setSelected(restrictions.isGameStatus());
        parentalToggle.setText(restrictions.isGameStatus() ? "ON" : "OFF");
        startTimeField.setText(String.format("%02d:00", restrictions.getStartTimeLimit()));
        endTimeField.setText(String.format("%02d:00", restrictions.getEndTimeLimit()));

        // Populate the ComboBox with save slot options.
        slotComboBox.getItems().clear();
        slotComboBox.getItems().addAll("Slot 1", "Slot 2", "Slot 3");
        slotComboBox.getSelectionModel().select(0);
    }

    @FXML
    private void resetStatistics(ActionEvent event) {
        stats.resetPlaytime();
        updateStatisticsLabels();
        System.out.println("Statistics reset: current session and totals cleared.");
    }


    private void updateStatisticsLabels() {
        // Current session time.
        int currentSec = stats.getCurrentSessionSeconds();
        int currentMinutes = currentSec / 60;
        int currentRemainingSec = currentSec % 60;
        totalPlayTimeLabel.setText(String.format("Current Session (min:sec): %02d:%02d", currentMinutes, currentRemainingSec));

        // Cumulative total play time.
        int totalSec = stats.getPlaytime();
        int totalMinutes = totalSec / 60;
        int totalRemainingSec = totalSec % 60;
        totalPlayTimeMinsSecsLabel.setText(String.format("Total Play Time (min:sec): %02d:%02d", totalMinutes, totalRemainingSec));

        // Average session time.
        int avgSec = stats.getAveragePlaytime();
        int avgMinutes = avgSec / 60;
        int avgRemainingSec = avgSec % 60;
        averageSessionTimeLabel.setText(String.format("Average Session (min:sec): %02d:%02d", avgMinutes, avgRemainingSec));
    }

    /**
     * Revives the pet from the selected save slot.
     * Loads the save file, gets the pet in the chosen slot, checks if it is dead,
     * and if so, calls revive() and saves the updated pet.
     * If no pet exists in the slot or the pet is not dead, an alert is shown.
     */
    @FXML
    private void revivePet(ActionEvent event) {
        System.out.println("Attempting to revive pet...");
        String filePath = "src/main/java/com/example/save.json";
        List<Pet> pets = Load.loadGame(filePath);

        int selectedIndex = slotComboBox.getSelectionModel().getSelectedIndex();  // 0 for Slot 1, etc.
        if (selectedIndex < 0 || selectedIndex >= 3) {
            showAlert("No Slot Selected", "Please select a valid save slot.");
            return;
        }

        if (selectedIndex >= pets.size() || pets.get(selectedIndex) == null) {
            showAlert("Empty Slot", "The selected save slot is empty. Nothing to revive.");
            return;
        }

        Pet petToRevive = pets.get(selectedIndex);
        // Check if the pet is dead; assuming a dead pet's state contains State.DEAD.
        if (!petToRevive.checkDead()) {
            showAlert("Pet is Alive", "The pet in the selected slot is not dead. Revive is not required.");
            return;
        }

        petToRevive.revive();
        Save.saveGame(petToRevive, selectedIndex);
        CurrentState.getInstance().setPet(petToRevive);
        showAlert("Revived", "The pet in slot " + (selectedIndex + 1) + " has been revived successfully.");

    }

    /**
     * Saves the parental settings.
     * Reads the toggle state and time fields, then updates the shared Restrictions instance.
     */
    @FXML
    private void saveParentalSettings(ActionEvent event) {
        if (parentalToggle.isSelected()) {
            parentalToggle.setText("ON");
        } else {
            parentalToggle.setText("OFF");
        }
        boolean restrictionsActive = parentalToggle.isSelected();
        App.getRestrictions().setGameStatus(restrictionsActive);

        try {
            String startText = startTimeField.getText();
            String endText = endTimeField.getText();
            int startHour = Integer.parseInt(startText.split(":")[0].trim());
            int endHour = Integer.parseInt(endText.split(":")[0].trim());
            App.getRestrictions().setStartTimeLimit(startHour);
            App.getRestrictions().setEndTimeLimit(endHour);
            System.out.println("Parental settings saved: Restrictions active: " + restrictionsActive +
                    ", From: " + startHour + ", To: " + endHour);
        } catch (Exception e) {
            System.err.println("Error saving parental settings: " + e.getMessage());
        }
    }

    /**
     * Called when the parental restrictions toggle is pressed.
     * Updates the toggle button's text to reflect its current state.
     */
    @FXML
    private void toggleParentalRestrictions(ActionEvent event) {
        if (parentalToggle.isSelected()) {
            parentalToggle.setText("ON");
        } else {
            parentalToggle.setText("OFF");
        }
    }

    /**
     * Returns to the Settings screen.
     */
    @FXML
    private void backToSettings(ActionEvent event) throws IOException {
        App.setRoot("Settings");
    }

    /**
     * Utility method to show an alert dialog.
     */
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}