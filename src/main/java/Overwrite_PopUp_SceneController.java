package com.example;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Overwrite_PopUp_SceneController {
    @FXML
    private Text FUL;

    @FXML
    private Text HAP;

    @FXML
    private Text HP;

    @FXML
    private Text MONEY;

    @FXML
    private Text NAME;

    @FXML
    private Text SCORE;

    @FXML
    private Text SLP;

    @FXML
    private ImageView petImage;

    @FXML
    public void initialize(){
        Path path = Paths.get("src/main/java/com/example/save.json");

        List<Pet> pets = Load.loadGame(path.toAbsolutePath().toString());
        Pet pet = pets.get(CurrentState.getInstance().getSaveFile());
        FUL.setText("FUL:" + pet.getFullness());
        HAP.setText("HAP:" + pet.getHappiness());
        HP.setText("HP:" + pet.getHealth());
        MONEY.setText("MONEY:" + 0);
        NAME.setText(pet.getName());
        SCORE.setText("SCORE:" + pet.getScore());
        SLP.setText("SLP:" + pet.getSleep());

        Image image = new Image(getClass().getResource(pet.getCurrentSprite()).toExternalForm());
        petImage.setImage(image);

    }

    @FXML
    void ConfirmNewGame(ActionEvent event) throws IOException{
        Save.reset(CurrentState.getInstance().getSaveFile());

        App.setRoot("Choose_Pet");
    }

    @FXML
    void DenyNewGame(ActionEvent event) throws IOException{
        App.setRoot("New_Game");
    }

    @FXML
    private void handleKeyPress(KeyEvent event) throws IOException{
        if (event.getCode() == KeyCode.Y) {
            ConfirmNewGame(null);
        }
        
        if (event.getCode() == KeyCode.N){
            DenyNewGame(null);
        }

    }

}