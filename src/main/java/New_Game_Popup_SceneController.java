package com.example;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;


public class New_Game_Popup_SceneController {

    @FXML
    private ImageView petImage;

    @FXML
    private Text Dislikes;

    @FXML
    private Text FUL;

    @FXML
    private Text HAP;

    @FXML
    private Text HP;

    @FXML
    private Text Likes;

    @FXML
    private Text SLP;

    @FXML
    private Text petName;

    @FXML
    public void initialize(){

        Pet pet = CurrentState.getInstance().getPet();
        String stringLike = "";
        String stringDislike = "";

        HP.setText("• HP: " + pet.getHealth());
        HAP.setText("• FUL: " + pet.getHappiness());
        FUL.setText("• HAP: " + pet.getFullness());
        SLP.setText("• SLP: " + pet.getSleep());
        if(pet.getType() == Pet.ElementType.EARTH){
            stringLike = "Earth";
            stringDislike = "Fire";
        }
        else if (pet.getType() == Pet.ElementType.FIRE){
            stringLike = "Fire";
            stringDislike = "Water";
        }
        else if (pet.getType() == Pet.ElementType.WATER){
            stringLike = "Water";
            stringDislike = "Earth";
        }
        Likes.setText("• Likes: " + stringLike);
        Dislikes.setText("• Dislikes: " + stringDislike);
        petName.setText(pet.getName());

        Image image = new Image(getClass().getResource(pet.getCurrentSprite()).toExternalForm());
        petImage.setImage(image);
    }

    @FXML
    void ChoosePetConfirm(ActionEvent event) throws IOException{
    
        App.setRoot("Pick_Name");
    }

    @FXML
    void ChoosePetDeny(ActionEvent event) throws IOException{

        App.setRoot("Choose_Pet");
    }

    @FXML
    private void handleKeyPress(KeyEvent event) throws IOException{
        if (event.getCode() == KeyCode.Y) {
            ChoosePetConfirm(null);
        }
        
        if (event.getCode() == KeyCode.N){
            ChoosePetDeny(null);
        }

    }

}