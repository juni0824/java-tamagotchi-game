package com.example;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;


public class Pick_Name_SceneController {

    @FXML
    private ImageView PetImage;

    @FXML
    private TextField userInput;

    @FXML
    private Text petName;

    private Pet pet = CurrentState.getInstance().getPet();

    @FXML
    public void initialize(){
        petName.setText(pet.getName());

        Image image = new Image(getClass().getResource(pet.getCurrentSprite()).toExternalForm());
        PetImage.setImage(image);
    }

    @FXML
    void Confirm(ActionEvent event) throws IOException{
        pet.setName(userInput.getText());
        CurrentState.getInstance().setPet(pet);
        Save.saveGame(pet, CurrentState.getInstance().getSaveFile());
        App.setRoot("Gameplay");
    }

    @FXML
    void Exit(ActionEvent event) throws IOException{
        App.setRoot("Choose_Pet");
    }

        @FXML
    private void handleKeyPress(KeyEvent event) throws IOException{
        if (event.getCode() == KeyCode.ENTER) {
            Confirm(null);
        }

        if(event.getCode() == KeyCode.ESCAPE){
            Exit(null);
        }

    }

}