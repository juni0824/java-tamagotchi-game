package com.example;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Gifts_SceneController {

    @FXML
    private Button backbtn;

    @FXML
    private ImageView itm1;

    @FXML
    private ImageView itm2;

    @FXML
    private ImageView itm3;

    @FXML
    private ImageView itm4;

    @FXML
    private ImageView itm5;

    @FXML
    private ImageView itm6;

    @FXML
    private ImageView itm7;

    @FXML
    private ImageView itm8;

    @FXML
    private ImageView itm9;

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

    @FXML
    private Button selectBtn;

    private Stage stage;
    private Scene scene;
    private Parent root;
    private Inventory inventory = CurrentState.getInstance().getInventory();
    private Item selectedItem;
    private Pet pet = CurrentState.getInstance().getPet();

    @FXML
    void initialize() {
        selectedItem = inventory.filterItem(Item.ItemType.GIFT)[0][0];
        itmName.setText(selectedItem.getName());
        itmType.setText(selectedItem.getType().toString());
        itmElement.setText(selectedItem.getElementType().toString());
        itmAmount.setText(Integer.toString(selectedItem.getInventoryAmount()));
        itmdscrpt.setText(selectedItem.getDescription());
        itmimgBig.setImage(new Image(getClass().getResource(selectedItem.getSprite()).toExternalForm()));
        moneyAmount.setText("MONEY: $" + inventory.getMoney());
    }

    @FXML
    void backbtn() throws IOException {
        App.setRoot(CurrentState.getInstance().returnScene());
    }

    @FXML
    void itm1Clicked() {
        selectedItem = inventory.filterItem(Item.ItemType.GIFT)[0][0];
        itmName.setText(selectedItem.getName());
        itmType.setText(selectedItem.getType().toString());
        itmElement.setText(selectedItem.getElementType().toString());
        itmAmount.setText(Integer.toString(selectedItem.getInventoryAmount()));
        itmdscrpt.setText(selectedItem.getDescription());
        itmimgBig.setImage(new Image(getClass().getResource(selectedItem.getSprite()).toExternalForm()));
    }

    @FXML
    void itm2Clicked() {
        selectedItem = inventory.filterItem(Item.ItemType.GIFT)[0][1];
        itmName.setText(selectedItem.getName());
        itmType.setText(selectedItem.getType().toString());
        itmElement.setText(selectedItem.getElementType().toString());
        itmAmount.setText(Integer.toString(selectedItem.getInventoryAmount()));
        itmdscrpt.setText(selectedItem.getDescription());
        itmimgBig.setImage(new Image(getClass().getResource(selectedItem.getSprite()).toExternalForm()));
    }

    @FXML
    void itm3Clicked() {
        selectedItem = inventory.filterItem(Item.ItemType.GIFT)[0][2];
        itmName.setText(selectedItem.getName());
        itmType.setText(selectedItem.getType().toString());
        itmElement.setText(selectedItem.getElementType().toString());
        itmAmount.setText(Integer.toString(selectedItem.getInventoryAmount()));
        itmdscrpt.setText(selectedItem.getDescription());
        itmimgBig.setImage(new Image(getClass().getResource(selectedItem.getSprite()).toExternalForm()));
    }

    @FXML
    void itm4Clicked() {
        selectedItem = inventory.filterItem(Item.ItemType.GIFT)[0][3];
        itmName.setText(selectedItem.getName());
        itmType.setText(selectedItem.getType().toString());
        itmElement.setText(selectedItem.getElementType().toString());
        itmAmount.setText(Integer.toString(selectedItem.getInventoryAmount()));
        itmdscrpt.setText(selectedItem.getDescription());
        itmimgBig.setImage(new Image(getClass().getResource(selectedItem.getSprite()).toExternalForm()));
    }

    @FXML
    void itm5Clicked() {
        selectedItem = inventory.filterItem(Item.ItemType.GIFT)[1][0];
        itmName.setText(selectedItem.getName());
        itmType.setText(selectedItem.getType().toString());
        itmElement.setText(selectedItem.getElementType().toString());
        itmAmount.setText(Integer.toString(selectedItem.getInventoryAmount()));
        itmdscrpt.setText(selectedItem.getDescription());
        itmimgBig.setImage(new Image(getClass().getResource(selectedItem.getSprite()).toExternalForm()));
    }

    @FXML
    void itm6Clicked() {
        selectedItem = inventory.filterItem(Item.ItemType.GIFT)[1][1];
        itmName.setText(selectedItem.getName());
        itmType.setText(selectedItem.getType().toString());
        itmElement.setText(selectedItem.getElementType().toString());
        itmAmount.setText(Integer.toString(selectedItem.getInventoryAmount()));
        itmdscrpt.setText(selectedItem.getDescription());
        itmimgBig.setImage(new Image(getClass().getResource(selectedItem.getSprite()).toExternalForm()));
    }

    @FXML
    void itm7Clicked() {
        selectedItem = inventory.filterItem(Item.ItemType.GIFT)[1][2];
        itmName.setText(selectedItem.getName());
        itmType.setText(selectedItem.getType().toString());
        itmElement.setText(selectedItem.getElementType().toString());
        itmAmount.setText(Integer.toString(selectedItem.getInventoryAmount()));
        itmdscrpt.setText(selectedItem.getDescription());
        itmimgBig.setImage(new Image(getClass().getResource(selectedItem.getSprite()).toExternalForm()));
    }

    @FXML
    void itm8Clicked() {
        selectedItem = inventory.filterItem(Item.ItemType.GIFT)[1][3];
        itmName.setText(selectedItem.getName());
        itmType.setText(selectedItem.getType().toString());
        itmElement.setText(selectedItem.getElementType().toString());
        itmAmount.setText(Integer.toString(selectedItem.getInventoryAmount()));
        itmdscrpt.setText(selectedItem.getDescription());
        itmimgBig.setImage(new Image(getClass().getResource(selectedItem.getSprite()).toExternalForm()));
    }

    @FXML
    void itm9Clicked() {
        selectedItem = inventory.filterItem(Item.ItemType.GIFT)[2][0];
        itmName.setText(selectedItem.getName());
        itmType.setText(selectedItem.getType().toString());
        itmElement.setText(selectedItem.getElementType().toString());
        itmAmount.setText(Integer.toString(selectedItem.getInventoryAmount()));
        itmdscrpt.setText(selectedItem.getDescription());
        itmimgBig.setImage(new Image(getClass().getResource(selectedItem.getSprite()).toExternalForm()));
    }

    @FXML
    void selectBtnClicked(ActionEvent event) throws IOException {
        if (selectedItem.getInventoryAmount() > 0) {
            pet.giveGift(inventory, selectedItem);
            App.setRoot(CurrentState.getInstance().returnScene());
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Insufficient Quantity");
            alert.setHeaderText("Item Not Available");
            alert.setContentText("There is not enough of the selected item in your inventory.");
            alert.showAndWait();
        }
    }
}
