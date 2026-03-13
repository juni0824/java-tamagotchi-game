package com.example;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import javafx.fxml.FXML;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class Gameplay_Menu_SceneController {

    @FXML
    private Circle HapCircle;

    @FXML
    private Circle HpCircle;

    @FXML
    private Circle FulCircle;

    @FXML
    private Circle SlpCircle;

    @FXML
    private Text EXP;

    @FXML
    private Label FUL;

    @FXML
    private Label HAP;

    @FXML
    private Text Level;

    @FXML
    private Text Name;

    @FXML
    private ImageView Pet_Current;

    @FXML
    private ImageView Pet_Image;

    @FXML
    private Label SLP;

    @FXML
    private Text Score;

    @FXML
    private Button feedAction;

    @FXML
    private Button pausebtn1;

    @FXML
    private Label healthLabel;

    @FXML
    private Button sleepAction;

    @FXML
    private Text Money;

    @FXML
    private Button vetBtn;

    @FXML
    private RadioButton menubtn;

    private Pet pet = CurrentState.getInstance().getPet();

    private Inventory inventory = CurrentState.getInstance().getInventory();

    private Timeline timeline;

    private static int playCooldown = 0;

    private static int exerciseCooldown = 0;

    private String soundPath = "src/main/resources/com/example/Click.mp3";

    @FXML
    void btn(ActionEvent event) {

    }

    @FXML
    void pause(ActionEvent event) throws IOException {
        timeline.stop();
        CurrentState.getInstance().lastScene("Gameplay_Menu");
        App.setRoot("PauseMenu");
    }

    public void decreaseStats() {
        Random rand = new Random();
        pet.updateStats(inventory);
        Score.setText("Score: " + pet.getScore());
        healthLabel.setText(pet.getHealth() + "");
        Level.setText(pet.getLevel() + "");
        FUL.setText(pet.getFullness() + "");
        HAP.setText(pet.getHappiness() + "");
        EXP.setText(pet.getEXP() + "");
        SLP.setText(pet.getSleep() + "");

        if (1 == rand.nextInt(2 - 1 + 1) + 1) {
            pet.updateSprite();
        } else {
            pet.updateSpriteA();
        }
        Image image = new Image(getClass().getResource(pet.getCurrentSprite()).toExternalForm());

        Pet_Current.setImage(image);

        if (pet.checkDead()) {
            Save.saveGame(pet, CurrentState.getInstance().getSaveFile());
        }

        if (playCooldown > 0) {
            playCooldown -= 2;
        }

        if (exerciseCooldown > 0) {
            exerciseCooldown -= 2;
        }

        if(pet.getHealth() < pet.getMaxHealth()/4){
            HpCircle.setFill(Color.RED);
        }

        if(pet.getSleep() < pet.getMaxSleep()/4){
            SlpCircle.setFill(Color.RED);
        }

        if(pet.getHappiness() < pet.getMaxHappiness()/4){
            HapCircle.setFill(Color.RED);
        }

        if(pet.getFullness() < pet.getMaxFullness()/4){
            FulCircle.setFill(Color.RED);
        }

        // Inventory

        Money.setText("Money: " + inventory.getMoney());

    }

    @FXML
    public void initialize() {

        // PauseTransition delay = new PauseTransition(Duration.seconds(3)); // Wait for
        // 3 seconds
        // delay.setOnFinished(event -> healthLabel.setText("50")); // Change text
        // delay.play(); // Start the timer

        Score.setText("Score: " + pet.getScore());
        healthLabel.setText(pet.getHealth() + "");
        Level.setText(pet.getLevel() + "");
        FUL.setText(pet.getFullness() + "");
        HAP.setText(pet.getHappiness() + "");
        EXP.setText(pet.getEXP() + "");
        SLP.setText(pet.getSleep() + "");
        Money.setText("Money: " + inventory.getMoney());
        Name.setText(pet.getName());
        vetBtn.setText("Vet $" + pet.getVetFee() + " (V)");

        Image image = new Image(getClass().getResource(pet.getCurrentSprite()).toExternalForm());

        Pet_Current.setImage(image);
        Pet_Image.setImage(image);

        timeline = new Timeline(new KeyFrame(Duration.seconds(2), event -> decreaseStats()));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();

    }

    @FXML
    void returnToGameplay(ActionEvent event) throws IOException {
        timeline.stop();
        App.setRoot("Gameplay");
    }

    @FXML
    void Inventory(ActionEvent event) throws IOException {
        timeline.stop();
        App.setRoot("Inventory");
    }

    @FXML
    void Pause(ActionEvent event) throws IOException {
        timeline.stop();

    }

    @FXML
    void openShop(ActionEvent event) throws IOException {
        timeline.stop();
        App.setRoot("Shop");
    }

    // Pet value changers
    @FXML
    public void petPet() {
        if (!pet.checkDead()) {
            pet.pet(inventory);
            Media sound = new Media(new File(soundPath).toURI().toString());
            MediaPlayer mediaPlayer = new MediaPlayer(sound);
            mediaPlayer.play();
        }
    }

    @FXML
    public void Feed() throws IOException {
        timeline.stop();
        if (pet.checkDead() || pet.checkAsleep() || pet.checkAngry()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Pet Refuses");
            alert.setHeaderText("Action Unavailable");
            alert.setContentText("You cannot feed the pet right now.");
            alert.showAndWait();
        } else {
            CurrentState.getInstance().lastScene("Gameplay_Menu");
            App.setRoot("Food");
        }
    }

    @FXML
    public void Sleep() {
        if (!pet.checkDead() && !pet.checkAsleep() && !pet.checkAngry()) {
            pet.goToBed();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Pet Refuses");
            alert.setHeaderText("Action Unavailable");
            alert.setContentText("The pet will not or cannot sleep.");
            alert.showAndWait();
        }
    }

    @FXML
    public void Exercise() {
        if (pet.checkDead() || pet.checkAsleep() || pet.checkAngry()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Pet Refuses");
            alert.setHeaderText("Action Unavailable");
            alert.setContentText("The pet will not exercise.");
            alert.showAndWait();
        } else if (exerciseCooldown <= 0) {
            pet.exercise(inventory);
            exerciseCooldown = 20;
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Cooldown Active");
            alert.setHeaderText("Action Unavailable");
            alert.setContentText("You must wait " + playCooldown + " seconds before playing again.");
            alert.showAndWait();
        }
    }
    @FXML
    public void Play() throws IOException {
        timeline.stop();
        if (pet.checkDead() || pet.checkAsleep()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Pet Refuses");
            alert.setHeaderText("Action Unavailable");
            alert.setContentText("The pet cannot play with you.");
            alert.showAndWait();
        } else if (playCooldown <= 0) {
            CurrentState.getInstance().lastScene("Gameplay_Menu");
            App.setRoot("Toys");
            playCooldown = 20;
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Cooldown Active");
            alert.setHeaderText("Action Unavailable");
            alert.setContentText("You must wait " + playCooldown + " seconds before playing again.");
            alert.showAndWait();
        }
    }


    @FXML
    public void Gift() throws IOException {
        timeline.stop();
        if (pet.checkDead() || pet.checkAsleep()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Pet Refuses");
            alert.setHeaderText("Action Unavailable");
            alert.setContentText("The pet cannot accept your gift.");
            alert.showAndWait();
        } else {
            CurrentState.getInstance().lastScene("Gameplay_Menu");
            App.setRoot("Gifts");
        }
    }

    @FXML
    public void takeToVet() {
        if (pet.checkDead() || pet.checkAsleep() || pet.checkAngry()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Pet Refuses");
            alert.setHeaderText("Action Unavailable");
            alert.setContentText("The pet refuses or cannot go.");
            alert.showAndWait();
        } else if (inventory.getMoney() >= pet.getVetFee()) {
            pet.takeToVet(inventory);
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Insufficient Money");
            alert.setHeaderText("Action Unavailable");
            alert.setContentText("You do not have enough money to afford the vet.");
            alert.showAndWait();
        }
    }

    @FXML
    private void handleKeyPress(KeyEvent event) throws IOException {
        if (event.getCode() == KeyCode.DIGIT1) {

        }
    }

}
