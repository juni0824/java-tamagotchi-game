package com.example;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.shape.Rectangle;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class Choose_Pet_SceneController {

    @FXML
    private Label FULtext;

    @FXML
    private Label HAPtext;

    @FXML
    private Label HPtext;

    @FXML
    private ImageView PetPic;

    @FXML
    private ImageView PetPic1;

    @FXML
    private ImageView PetPic2;

    @FXML
    private ImageView PetPic3;

    @FXML
    private Label SLPtext;

    @FXML
    private Rectangle backgroundColor;

    @FXML
    private Button confirmPet;

    @FXML
    private Label dietText;

    @FXML
    private Label dislikesText;

    @FXML
    private Label likeText;

    @FXML
    private Label petDescription;

    @FXML
    private Label petName;

    private Pet newPet = new Blorbo();

    @FXML
    public void initialize() throws IOException{

        changePet1(null);
    }

    @FXML
    void ConfirmPet(ActionEvent event) throws IOException{
        CurrentState.getInstance().setPet(newPet);
        App.setRoot("New_Game_Popup");
    }

    @FXML
    void changePet1(ActionEvent event) throws IOException{
        Image image = new Image(getClass().getResource("Sprite_Neutral.png").toExternalForm());
        PetPic.setImage(image);

        // Blorbo (Dinosaur)
        newPet = new Blorbo();

        petDescription.setText("WUBALUBA DUB DUB");
        HPtext.setText("• HP: " + newPet.getHealth());
        HAPtext.setText("• FUL: " + newPet.getHappiness());
        FULtext.setText("• HAP: " + newPet.getFullness());
        SLPtext.setText("• SLP: " + newPet.getSleep());
        likeText.setText("• Likes: WATER");
        dietText.setText("• Can't Eat: EARTH");
        petName.setText(newPet.getName());


    }

    @FXML
    void changePet2(ActionEvent event) throws IOException{
        Image image = new Image(getClass().getResource("Flower_Girl_Neutral.png").toExternalForm());
        PetPic.setImage(image);

        //Blonk (Flower girl)
        newPet = new Blonk();

        petDescription.setText("This gals a pretty tulip");
        HPtext.setText("• HP: " + newPet.getHealth());
        HAPtext.setText("• FUL: " + newPet.getHappiness());
        FULtext.setText("• HAP: " + newPet.getFullness());
        SLPtext.setText("• SLP: " + newPet.getSleep());
        likeText.setText("• Likes: EARTH");
        dietText.setText("• Can't Eat: FIRE");
        petName.setText(newPet.getName());

    }

    @FXML
    void changePet3(ActionEvent event) throws IOException{
        Image image = new Image(getClass().getResource("Bee_Neutral.png").toExternalForm());
        PetPic.setImage(image);

        // Bouba (Bee)
        newPet = new Bouba();

        petDescription.setText("This guys a busy bee");
        HPtext.setText("• HP: " + newPet.getHealth());
        HAPtext.setText("• FUL: " + newPet.getHappiness());
        FULtext.setText("• HAP: " + newPet.getFullness());
        SLPtext.setText("• SLP: " + newPet.getSleep());
        likeText.setText("• Likes: FIRE");
        dietText.setText("• Can't Eat: WATER");
        petName.setText(newPet.getName());

    }

    @FXML
    private void handleKeyPress(KeyEvent event) throws IOException{
        if (event.getCode() == KeyCode.DIGIT1) {
            changePet1(null);
        }
        
        if (event.getCode() == KeyCode.DIGIT2){
            changePet2(null);
        }

        if (event.getCode() == KeyCode.DIGIT3){
            changePet3(null);
        }

        if (event.getCode() == KeyCode.Y){
            ConfirmPet(null);
        }
    }

}
