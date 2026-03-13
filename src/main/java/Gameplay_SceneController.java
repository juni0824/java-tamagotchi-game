package com.example;

import java.io.File;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import java.util.Random;


public class Gameplay_SceneController {

    @FXML
    private Circle HapCircle;

    @FXML
    private Circle HpCircle;

    @FXML
    private Circle FulCircle;

    @FXML
    private Circle SlpCircle;

    @FXML
    private Label FUL;

    @FXML
    private Label HAP;

    @FXML
    private Text Level;

    @FXML
    private Text Money;

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
    private Label healthLabel;

    @FXML
    private RadioButton menubtn;

    @FXML
    private Button pausebtn;

    @FXML
    private Text EXP;



    private Pet pet = CurrentState.getInstance().getPet();

    private Inventory inventory = CurrentState.getInstance().getInventory();

    private Timeline timeline;

    private String soundPath = "src/main/resources/com/example/Click.mp3";

    @FXML
    void GameplayMenu(ActionEvent event) throws IOException{
        timeline.stop();
        App.setRoot("Gameplay_Menu");
    }

    public void decreaseStats(){
        Random rand = new Random();
        pet.updateStats(inventory);
        Score.setText("Score: " + pet.getScore());
        healthLabel.setText(pet.getHealth() + "");
        Level.setText(pet.getLevel() + "");
        FUL.setText(pet.getFullness() + "");
        HAP.setText(pet.getHappiness() + "");
        EXP.setText(pet.getEXP() + "");
        SLP.setText(pet.getSleep() + "");
        if(1 == rand.nextInt(2 - 1 + 1) + 1){
            pet.updateSprite();
        } else {
            pet.updateSpriteA();
        }   
        Image image = new Image(getClass().getResource(pet.getCurrentSprite()).toExternalForm());

        Pet_Current.setImage(image);

        if(pet.checkDead()){
            Save.saveGame(pet,CurrentState.getInstance().getSaveFile());
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

        //Inventory

        Money.setText("Money: " + inventory.getMoney());

    }

    @FXML
    public void initialize(){

        Score.setText("Score: " + pet.getScore());
        healthLabel.setText(pet.getHealth() + "");
        Level.setText(pet.getLevel() + "");
        FUL.setText(pet.getFullness() + "");
        HAP.setText(pet.getHappiness() + "");
        EXP.setText(pet.getEXP() + "");
        SLP.setText(pet.getSleep() + "");
        Money.setText("Money: " + inventory.getMoney());
        Name.setText(pet.getName());
        Image image = new Image(getClass().getResource(pet.getCurrentSprite()).toExternalForm());

        Pet_Current.setImage(image);
        Pet_Image.setImage(image);

        //start reduction

        timeline = new Timeline(new KeyFrame(Duration.seconds(2), event -> decreaseStats()));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    @FXML
    void Pause(ActionEvent event) throws IOException{
        timeline.stop();
        CurrentState.getInstance().lastScene("Gameplay");
        App.setRoot("PauseMenu");
    }

    @FXML
    public void petPet(){
        if (!pet.checkDead()) {
            pet.pet(inventory);
            Media sound = new Media(new File(soundPath).toURI().toString());
            MediaPlayer mediaPlayer = new MediaPlayer(sound);
            mediaPlayer.play();
        }
    }

    @FXML
    private void handleKeyPress(KeyEvent event) throws IOException{
        if (event.getCode() == KeyCode.P) {
            
        }

        if (event.getCode() == KeyCode.M){

        }
    }
}
