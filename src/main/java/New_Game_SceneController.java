package com.example;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;
import java.util.List;
import java.nio.file.Paths;
import java.nio.file.Path;

public class New_Game_SceneController {

    @FXML
    private Text ful1;

    @FXML
    private Text ful2;

    @FXML
    private Text ful3;

    @FXML
    private Text hap1;

    @FXML
    private Text hap2;

    @FXML
    private Text hap3;

    @FXML
    private Text hp1;

    @FXML
    private Text hp2;

    @FXML
    private Text hp3;

    @FXML
    private Text money1;

    @FXML
    private Text money2;

    @FXML
    private Text money3;

    @FXML
    private Text name1;

    @FXML
    private Text name2;

    @FXML
    private Text name3;

    @FXML
    private Text score1;

    @FXML
    private Text score2;

    @FXML
    private Text score3;

    @FXML
    private Text slp1;

    @FXML
    private Text slp2;

    @FXML
    private Text slp3;

    @FXML
    private ImageView image1;

    @FXML
    private ImageView image2;

    @FXML
    private ImageView image3;

    private boolean fileLoaded1 = false;
    private boolean fileLoaded2 = false;
    private boolean fileLoaded3 = false;

    @FXML
    public void initialize() {

        Path path = Paths.get("src/main/java/com/example/save.json");

        List<Pet> pets = Load.loadGame(path.toAbsolutePath().toString());

        if (pets.get(0) != null) {
            fileLoaded1 = true;
        }
        if (pets.get(1) != null) {
            fileLoaded2 = true;
        }
        if (pets.get(2) != null) {
            fileLoaded3 = true;
        }

        /* Code for pet 1 */

        if (fileLoaded1 == true) {
            Pet pet = pets.get(0);

            Image image = new Image(getClass().getResource(pet.getCurrentSprite()).toExternalForm());

            image1.setImage(image);

            ful1.setText("FUL: " + pet.getFullness());

            hap1.setText("HAP: " + pet.getHappiness());

            hp1.setText("HP: " + pet.getHealth());

            money1.setText("MONEY: " + 0);

            slp1.setText("SLP: " + pet.getSleep());

            name1.setText(pet.getName());

            score1.setText("SCORE: " + pet.getScore());
        } else {

            ful1.setText("FUL: 0");

            hap1.setText("HAP: 0");

            hp1.setText("HP: 0:");

            money1.setText("MONEY: 0");

            slp1.setText("SLP: 0");

            score1.setText("SCORE: 0");

            name1.setText("New Game");
        }

        /* Pet2 */

        if (fileLoaded2 == true) {
            Pet pet = pets.get(1);

            Image image = new Image(getClass().getResource(pet.getCurrentSprite()).toExternalForm());

            image2.setImage(image);

            ful2.setText("FUL: " + pet.getFullness());

            hap2.setText("HAP: " + pet.getHappiness());

            hp2.setText("HP: " + pet.getHealth());

            money2.setText("MONEY: " + 0);

            slp2.setText("SLP: " + pet.getSleep());

            name2.setText(pet.getName());

            score2.setText("SCORE: " + pet.getScore());
        } else {

            ful2.setText("FUL: 0");

            hap2.setText("HAP: 0");

            hp2.setText("HP: 0:");

            money2.setText("MONEY: 0");

            slp2.setText("SLP: 0");

            score2.setText("SCORE: 0");

            name2.setText("New Game");
        }

        /* Pet 3 */

        if (fileLoaded3 == true) {
            Pet pet = pets.get(2);

            Image image = new Image(getClass().getResource(pet.getCurrentSprite()).toExternalForm());

            image3.setImage(image);

            ful3.setText("FUL: " + pet.getFullness());

            hap3.setText("HAP: " + pet.getHappiness());

            hp3.setText("HP: " + pet.getHealth());

            money3.setText("MONEY: " + 0);

            slp3.setText("SLP: " + pet.getSleep());

            name3.setText(pet.getName());

            score3.setText("SCORE: " + pet.getScore());
        } else {

            ful3.setText("FUL: 0");

            hap3.setText("HAP: 0");

            hp3.setText("HP: 0:");

            money3.setText("MONEY: 0");

            slp3.setText("SLP: 0");

            score3.setText("SCORE: 0");

            name3.setText("New Game");
        }

    }

    @FXML
    void ReturnToMenu(ActionEvent event) throws IOException {
        App.setRoot("Main_Menu");
    }

    @FXML
    void ChooseSaveFile1(ActionEvent event) throws IOException {
        CurrentState.getInstance().setSaveFile(0);

        Path path = Paths.get("src/main/java/com/example/items.json");

        Inventory inventory = new Inventory("", new Item[7][4], path.toAbsolutePath().toString());
        CurrentState.getInstance().setInventory(inventory);
        CurrentState.getInstance().setStore(new Store("Shop", new Item[7][4]));
        if (fileLoaded1 == true) {

            App.setRoot("Overwrite_PopUp");
        } else {
            App.setRoot("Choose_Pet");
        }

    }

    @FXML
    void ChooseSaveFile2(ActionEvent event) throws IOException {
        CurrentState.getInstance().setSaveFile(1);

        Path path = Paths.get("src/main/java/com/example/items.json");

        Inventory inventory = new Inventory("", new Item[7][4], path.toAbsolutePath().toString());
        CurrentState.getInstance().setInventory(inventory);
        CurrentState.getInstance().setStore(new Store("Shop", new Item[7][4]));
        if (fileLoaded2 == true) {

            App.setRoot("Overwrite_PopUp");
        } else {
            App.setRoot("Choose_Pet");
        }

    }

    @FXML
    void ChooseSaveFile3(ActionEvent event) throws IOException {
        CurrentState.getInstance().setSaveFile(2);

        Path path = Paths.get("src/main/java/com/example/items.json");

        Inventory inventory = new Inventory("", new Item[7][4], path.toAbsolutePath().toString());
        CurrentState.getInstance().setInventory(inventory);
        CurrentState.getInstance().setStore(new Store("Shop", new Item[7][4]));
        if (fileLoaded3 == true) {

            App.setRoot("Overwrite_PopUp");
        } else {

            App.setRoot("Choose_Pet");
        }

    }

    @FXML
    private void handleKeyPress(KeyEvent event) throws IOException {
        if (event.getCode() == KeyCode.DIGIT1) {
            ChooseSaveFile1(null);
        }

        if (event.getCode() == KeyCode.DIGIT2) {
            ChooseSaveFile2(null);
        }

        if (event.getCode() == KeyCode.DIGIT3) {
            ChooseSaveFile3(null);
        }
    }

}
