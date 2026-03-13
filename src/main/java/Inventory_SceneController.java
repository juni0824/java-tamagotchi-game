
package com.example;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.image.Image;

public class Inventory_SceneController {

    @FXML
    private Text itmAmount;

    @FXML
    private Text itmElement;

    @FXML
    private Text itmName;

    @FXML
    private Text itmType;

    @FXML
    private Text itmdscrpt;

    @FXML
    private ImageView itmimgBig;

    @FXML
    private Text moneyAmount;

    private Stage stage;
    private Scene scene;
    private Parent root;
    private Inventory inventory = CurrentState.getInstance().getInventory();

    @FXML
    void initialize() {
        moneyAmount.setText("MONEY: $" + inventory.getMoney());
        Item item = inventory.getItem(0, 0);
        itmName.setText(item.getName());
        itmType.setText(item.getType().toString());
        itmElement.setText(item.getElementType().toString());
        itmAmount.setText(Integer.toString(item.getInventoryAmount()));
        itmdscrpt.setText(item.getDescription());
        itmimgBig.setImage(new Image(getClass().getResource(item.getSprite()).toExternalForm()));
    }

    @FXML
    void itm10Clicked() {
        Item item = inventory.getItem(2, 1);
        itmName.setText(item.getName());
        itmType.setText(item.getType().toString());
        itmElement.setText(item.getElementType().toString());
        itmAmount.setText(Integer.toString(item.getInventoryAmount()));
        itmdscrpt.setText(item.getDescription());
        itmimgBig.setImage(new Image(getClass().getResource(item.getSprite()).toExternalForm()));
    }

    @FXML
    void itm11Clicked() {
        Item item = inventory.getItem(2, 2);
        itmName.setText(item.getName());
        itmType.setText(item.getType().toString());
        itmElement.setText(item.getElementType().toString());
        itmAmount.setText(Integer.toString(item.getInventoryAmount()));
        itmdscrpt.setText(item.getDescription());
        itmimgBig.setImage(new Image(getClass().getResource(item.getSprite()).toExternalForm()));
    }

    @FXML
    void itm12Clicked() {
        Item item = inventory.getItem(2, 3);
        itmName.setText(item.getName());
        itmType.setText(item.getType().toString());
        itmElement.setText(item.getElementType().toString());
        itmAmount.setText(Integer.toString(item.getInventoryAmount()));
        itmdscrpt.setText(item.getDescription());
        itmimgBig.setImage(new Image(getClass().getResource(item.getSprite()).toExternalForm()));
    }

    @FXML
    void itm13Clicked() {
        Item item = inventory.getItem(3, 0);
        itmName.setText(item.getName());
        itmType.setText(item.getType().toString());
        itmElement.setText(item.getElementType().toString());
        itmAmount.setText(Integer.toString(item.getInventoryAmount()));
        itmdscrpt.setText(item.getDescription());
        itmimgBig.setImage(new Image(getClass().getResource(item.getSprite()).toExternalForm()));
    }

    @FXML
    void itm14Clicked() {
        Item item = inventory.getItem(3, 1);
        itmName.setText(item.getName());
        itmType.setText(item.getType().toString());
        itmElement.setText(item.getElementType().toString());
        itmAmount.setText(Integer.toString(item.getInventoryAmount()));
        itmdscrpt.setText(item.getDescription());
        itmimgBig.setImage(new Image(getClass().getResource(item.getSprite()).toExternalForm()));
    }

    @FXML
    void itm15Clicked() {
        Item item = inventory.getItem(3, 2);
        itmName.setText(item.getName());
        itmType.setText(item.getType().toString());
        itmElement.setText(item.getElementType().toString());
        itmAmount.setText(Integer.toString(item.getInventoryAmount()));
        itmdscrpt.setText(item.getDescription());
        itmimgBig.setImage(new Image(getClass().getResource(item.getSprite()).toExternalForm()));
    }

    @FXML
    void itm16Clicked() {
        Item item = inventory.getItem(3, 3);
        itmName.setText(item.getName());
        itmType.setText(item.getType().toString());
        itmElement.setText(item.getElementType().toString());
        itmAmount.setText(Integer.toString(item.getInventoryAmount()));
        itmdscrpt.setText(item.getDescription());
        itmimgBig.setImage(new Image(getClass().getResource(item.getSprite()).toExternalForm()));
    }

    @FXML
    void itm17Clicked() {
        Item item = inventory.getItem(4, 0);
        itmName.setText(item.getName());
        itmType.setText(item.getType().toString());
        itmElement.setText(item.getElementType().toString());
        itmAmount.setText(Integer.toString(item.getInventoryAmount()));
        itmdscrpt.setText(item.getDescription());
        itmimgBig.setImage(new Image(getClass().getResource(item.getSprite()).toExternalForm()));
    }

    @FXML
    void itm18Clicked() {
        Item item = inventory.getItem(4, 1);
        itmName.setText(item.getName());
        itmType.setText(item.getType().toString());
        itmElement.setText(item.getElementType().toString());
        itmAmount.setText(Integer.toString(item.getInventoryAmount()));
        itmdscrpt.setText(item.getDescription());
        itmimgBig.setImage(new Image(getClass().getResource(item.getSprite()).toExternalForm()));
    }

    @FXML
    void itm19Clicked() {
        Item item = inventory.getItem(4, 2);
        itmName.setText(item.getName());
        itmType.setText(item.getType().toString());
        itmElement.setText(item.getElementType().toString());
        itmAmount.setText(Integer.toString(item.getInventoryAmount()));
        itmdscrpt.setText(item.getDescription());
        itmimgBig.setImage(new Image(getClass().getResource(item.getSprite()).toExternalForm()));
    }

    @FXML
    void itm1Clicked() {
        Item item = inventory.getItem(0, 0);
        itmName.setText(item.getName());
        itmType.setText(item.getType().toString());
        itmElement.setText(item.getElementType().toString());
        itmAmount.setText(Integer.toString(item.getInventoryAmount()));
        itmdscrpt.setText(item.getDescription());
        itmimgBig.setImage(new Image(getClass().getResource(item.getSprite()).toExternalForm()));
    }

    @FXML
    void itm20Clicked() {
        Item item = inventory.getItem(4, 3);
        itmName.setText(item.getName());
        itmType.setText(item.getType().toString());
        itmElement.setText(item.getElementType().toString());
        itmAmount.setText(Integer.toString(item.getInventoryAmount()));
        itmdscrpt.setText(item.getDescription());
        itmimgBig.setImage(new Image(getClass().getResource(item.getSprite()).toExternalForm()));
    }

    @FXML
    void itm21Clicked() {
        Item item = inventory.getItem(5, 0);
        itmName.setText(item.getName());
        itmType.setText(item.getType().toString());
        itmElement.setText(item.getElementType().toString());
        itmAmount.setText(Integer.toString(item.getInventoryAmount()));
        itmdscrpt.setText(item.getDescription());
        itmimgBig.setImage(new Image(getClass().getResource(item.getSprite()).toExternalForm()));
    }

    @FXML
    void itm22Clicked() {
        Item item = inventory.getItem(5, 1);
        itmName.setText(item.getName());
        itmType.setText(item.getType().toString());
        itmElement.setText(item.getElementType().toString());
        itmAmount.setText(Integer.toString(item.getInventoryAmount()));
        itmdscrpt.setText(item.getDescription());
        itmimgBig.setImage(new Image(getClass().getResource(item.getSprite()).toExternalForm()));
    }

    @FXML
    void itm23Clicked() {
        Item item = inventory.getItem(5, 2);
        itmName.setText(item.getName());
        itmType.setText(item.getType().toString());
        itmElement.setText(item.getElementType().toString());
        itmAmount.setText(Integer.toString(item.getInventoryAmount()));
        itmdscrpt.setText(item.getDescription());
        itmimgBig.setImage(new Image(getClass().getResource(item.getSprite()).toExternalForm()));
    }

    @FXML
    void itm24Clicked() {
        Item item = inventory.getItem(5, 3);
        itmName.setText(item.getName());
        itmType.setText(item.getType().toString());
        itmElement.setText(item.getElementType().toString());
        itmAmount.setText(Integer.toString(item.getInventoryAmount()));
        itmdscrpt.setText(item.getDescription());
        itmimgBig.setImage(new Image(getClass().getResource(item.getSprite()).toExternalForm()));
    }

    @FXML
    void itm25Clicked() {
        Item item = inventory.getItem(6, 0);
        itmName.setText(item.getName());
        itmType.setText(item.getType().toString());
        itmElement.setText(item.getElementType().toString());
        itmAmount.setText(Integer.toString(item.getInventoryAmount()));
        itmdscrpt.setText(item.getDescription());
        itmimgBig.setImage(new Image(getClass().getResource(item.getSprite()).toExternalForm()));
    }

    @FXML
    void itm26Clicked() {
        Item item = inventory.getItem(6, 1);
        itmName.setText(item.getName());
        itmType.setText(item.getType().toString());
        itmElement.setText(item.getElementType().toString());
        itmAmount.setText(Integer.toString(item.getInventoryAmount()));
        itmdscrpt.setText(item.getDescription());
        itmimgBig.setImage(new Image(getClass().getResource(item.getSprite()).toExternalForm()));
    }

    @FXML
    void itm27Clicked() {
        Item item = inventory.getItem(6, 2);
        itmName.setText(item.getName());
        itmType.setText(item.getType().toString());
        itmElement.setText(item.getElementType().toString());
        itmAmount.setText(Integer.toString(item.getInventoryAmount()));
        itmdscrpt.setText(item.getDescription());
        itmimgBig.setImage(new Image(getClass().getResource(item.getSprite()).toExternalForm()));
    }

    @FXML
    void itm28Clicked() {
        Item item = inventory.getItem(6, 3);
        itmName.setText(item.getName());
        itmType.setText(item.getType().toString());
        itmElement.setText(item.getElementType().toString());
        itmAmount.setText(Integer.toString(item.getInventoryAmount()));
        itmdscrpt.setText(item.getDescription());
        itmimgBig.setImage(new Image(getClass().getResource(item.getSprite()).toExternalForm()));
    }

    @FXML
    void itm2Clicked() {
        Item item = inventory.getItem(0, 1);
        itmName.setText(item.getName());
        itmType.setText(item.getType().toString());
        itmElement.setText(item.getElementType().toString());
        itmAmount.setText(Integer.toString(item.getInventoryAmount()));
        itmdscrpt.setText(item.getDescription());
        itmimgBig.setImage(new Image(getClass().getResource(item.getSprite()).toExternalForm()));
    }

    @FXML
    void itm3Clicked() {
        Item item = inventory.getItem(0, 2);
        itmName.setText(item.getName());
        itmType.setText(item.getType().toString());
        itmElement.setText(item.getElementType().toString());
        itmAmount.setText(Integer.toString(item.getInventoryAmount()));
        itmdscrpt.setText(item.getDescription());
        itmimgBig.setImage(new Image(getClass().getResource(item.getSprite()).toExternalForm()));
    }

    @FXML
    void itm4Clicked() {
        Item item = inventory.getItem(0, 3);
        itmName.setText(item.getName());
        itmType.setText(item.getType().toString());
        itmElement.setText(item.getElementType().toString());
        itmAmount.setText(Integer.toString(item.getInventoryAmount()));
        itmdscrpt.setText(item.getDescription());
        itmimgBig.setImage(new Image(getClass().getResource(item.getSprite()).toExternalForm()));
    }

    @FXML
    void itm5Clicked() {
        Item item = inventory.getItem(1, 0);
        itmName.setText(item.getName());
        itmType.setText(item.getType().toString());
        itmElement.setText(item.getElementType().toString());
        itmAmount.setText(Integer.toString(item.getInventoryAmount()));
        itmdscrpt.setText(item.getDescription());
        itmimgBig.setImage(new Image(getClass().getResource(item.getSprite()).toExternalForm()));
    }

    @FXML
    void itm6Clicked() {
        Item item = inventory.getItem(1, 1);
        itmName.setText(item.getName());
        itmType.setText(item.getType().toString());
        itmElement.setText(item.getElementType().toString());
        itmAmount.setText(Integer.toString(item.getInventoryAmount()));
        itmdscrpt.setText(item.getDescription());
        itmimgBig.setImage(new Image(getClass().getResource(item.getSprite()).toExternalForm()));
    }

    @FXML
    void itm7Clicked() {
        Item item = inventory.getItem(1, 2);
        itmName.setText(item.getName());
        itmType.setText(item.getType().toString());
        itmElement.setText(item.getElementType().toString());
        itmAmount.setText(Integer.toString(item.getInventoryAmount()));
        itmdscrpt.setText(item.getDescription());
        itmimgBig.setImage(new Image(getClass().getResource(item.getSprite()).toExternalForm()));
    }

    @FXML
    void itm8Clicked() {
        Item item = inventory.getItem(1, 3);
        itmName.setText(item.getName());
        itmType.setText(item.getType().toString());
        itmElement.setText(item.getElementType().toString());
        itmAmount.setText(Integer.toString(item.getInventoryAmount()));
        itmdscrpt.setText(item.getDescription());
        itmimgBig.setImage(new Image(getClass().getResource(item.getSprite()).toExternalForm()));
    }

    @FXML
    void itm9Clicked() {
        Item item = inventory.getItem(2, 0);
        itmName.setText(item.getName());
        itmType.setText(item.getType().toString());
        itmElement.setText(item.getElementType().toString());
        itmAmount.setText(Integer.toString(item.getInventoryAmount()));
        itmdscrpt.setText(item.getDescription());
        itmimgBig.setImage(new Image(getClass().getResource(item.getSprite()).toExternalForm()));
    }

    @FXML
    void backbtn() throws IOException {
        App.setRoot("Gameplay_Menu");
    }
}
