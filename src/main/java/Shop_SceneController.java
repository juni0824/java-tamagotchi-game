package com.example;

import java.io.IOException;

import com.example.Item.ItemType;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.ImagePattern;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Shop_SceneController {

    @FXML
    private Button backbtn;

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
    private Text itmPrice;

    private Item selectedItem;

    private Stage stage;
    private Scene scene;
    private Parent root;
    private Store shop = CurrentState.getInstance().getStore();
    private Inventory inventory = CurrentState.getInstance().getInventory();
    private Pet pet = CurrentState.getInstance().getPet();
    
    private int currentItemx = 0;
    private int currentItemy = 0;

    @FXML
    public void initialize() {
        moneyAmount.setText("MONEY: $" + inventory.getMoney());
        selectedItem = shop.getItem(0, 0);
        itmName.setText(selectedItem.getName());
        itmType.setText(selectedItem.getType().toString());
        itmElement.setText(selectedItem.getElementType().toString());
        itmAmount.setText(Integer.toString(selectedItem.getStoreAmount()));
        itmdscrpt.setText(selectedItem.getDescription());
        itmimgBig.setImage(new
        Image(getClass().getResource(selectedItem.getSprite()).toExternalForm()));
        itmPrice.setText("$: " + selectedItem.getPrice());
    }

    private void purchaseItem() {
        if (selectedItem == null) {
            return;
        }

        int price = selectedItem.getPrice();


        if(selectedItem.getType() == ItemType.TOY && pet.getLevel() < selectedItem.getPrice()/15){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Insufficient Level");
            alert.setHeaderText("Level too low.");
            alert.setContentText("You must be at least level " + selectedItem.getPrice()/15 + " to buy this item.");
            alert.showAndWait();
        }
        else if (inventory.getMoney() >= price && selectedItem.getStoreAmount() != 0) {

            inventory.setMoney(inventory.getMoney() - price);
            inventory.addItem(selectedItem);

            selectedItem.setStoreAmount(selectedItem.getStoreAmount() - 1);

            itmAmount.setText(selectedItem.getStoreAmount() + "");
            moneyAmount.setText("MONEY: $" + inventory.getMoney());
            Item item = inventory.getItem(currentItemx, currentItemy);
            item.setInventoryAmount(item.getInventoryAmount() + 1);

            System.out.println("Purchased " + selectedItem.getName());
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Insufficient");
            alert.setHeaderText("Item Not Available");
            alert.setContentText("Cannot buy item: insufficient stock or not enough money.");
            alert.showAndWait();
        }

        itmName.setText(selectedItem.getName());
        itmType.setText(selectedItem.getType().toString());
        itmElement.setText(selectedItem.getElementType().toString());
        itmAmount.setText(Integer.toString(selectedItem.getStoreAmount()));
        itmdscrpt.setText(selectedItem.getDescription());
    }

    @FXML
    void buyBtnClicked() {
        if (selectedItem != null) {
            purchaseItem();
        }

    }

    @FXML
    void itm10Clicked() {
        currentItemx = 2;
        currentItemy = 1;
        selectedItem = shop.getItem(2, 1);
        itmName.setText(selectedItem.getName());
        itmType.setText(selectedItem.getType().toString());
        itmElement.setText(selectedItem.getElementType().toString());
        itmAmount.setText(Integer.toString(selectedItem.getStoreAmount()));
        itmdscrpt.setText(selectedItem.getDescription());
        itmimgBig.setImage(new
        Image(getClass().getResource(selectedItem.getSprite()).toExternalForm()));
        itmPrice.setText("$: " + selectedItem.getPrice());
    }

    @FXML
    void itm11Clicked() {
        currentItemx = 2;
        currentItemy = 2;
        selectedItem = shop.getItem(2, 2);
        itmName.setText(selectedItem.getName());
        itmType.setText(selectedItem.getType().toString());
        itmElement.setText(selectedItem.getElementType().toString());
        itmAmount.setText(Integer.toString(selectedItem.getStoreAmount()));
        itmdscrpt.setText(selectedItem.getDescription());
        itmimgBig.setImage(new
        Image(getClass().getResource(selectedItem.getSprite()).toExternalForm()));
        itmPrice.setText("$: " + selectedItem.getPrice());
    }

    @FXML
    void itm12Clicked() {
        currentItemx = 2;
        currentItemy = 3;
        selectedItem = shop.getItem(2, 3);
        itmName.setText(selectedItem.getName());
        itmType.setText(selectedItem.getType().toString());
        itmElement.setText(selectedItem.getElementType().toString());
        itmAmount.setText(Integer.toString(selectedItem.getStoreAmount()));
        itmdscrpt.setText(selectedItem.getDescription());
        itmimgBig.setImage(new
        Image(getClass().getResource(selectedItem.getSprite()).toExternalForm()));
        itmPrice.setText("$: " + selectedItem.getPrice());
    }

    @FXML
    void itm13Clicked() {
        currentItemx = 3;
        currentItemy = 0;
        selectedItem = shop.getItem(3, 0);
        itmName.setText(selectedItem.getName());
        itmType.setText(selectedItem.getType().toString());
        itmElement.setText(selectedItem.getElementType().toString());
        itmAmount.setText(Integer.toString(selectedItem.getStoreAmount()));
        itmdscrpt.setText(selectedItem.getDescription());
        itmimgBig.setImage(new
        Image(getClass().getResource(selectedItem.getSprite()).toExternalForm()));
        itmPrice.setText("$: " + selectedItem.getPrice());
    }

    @FXML
    void itm14Clicked() {
        currentItemx = 3;
        currentItemy = 1;
        selectedItem = shop.getItem(3, 1);
        itmName.setText(selectedItem.getName());
        itmType.setText(selectedItem.getType().toString());
        itmElement.setText(selectedItem.getElementType().toString());
        itmAmount.setText(Integer.toString(selectedItem.getStoreAmount()));
        itmdscrpt.setText(selectedItem.getDescription());
        itmimgBig.setImage(new
        Image(getClass().getResource(selectedItem.getSprite()).toExternalForm()));
        itmPrice.setText("$: " + selectedItem.getPrice());
    }

    @FXML
    void itm15Clicked() {
        currentItemx = 3;
        currentItemy = 2;
        selectedItem = shop.getItem(3, 2);
        itmName.setText(selectedItem.getName());
        itmType.setText(selectedItem.getType().toString());
        itmElement.setText(selectedItem.getElementType().toString());
        itmAmount.setText(Integer.toString(selectedItem.getStoreAmount()));
        itmdscrpt.setText(selectedItem.getDescription());
        itmimgBig.setImage(new
        Image(getClass().getResource(selectedItem.getSprite()).toExternalForm()));
        itmPrice.setText("$: " + selectedItem.getPrice());
    }

    @FXML
    void itm16Clicked() {
        currentItemx = 3;
        currentItemy = 3;
        selectedItem = shop.getItem(3, 3);
        itmName.setText(selectedItem.getName());
        itmType.setText(selectedItem.getType().toString());
        itmElement.setText(selectedItem.getElementType().toString());
        itmAmount.setText(Integer.toString(selectedItem.getStoreAmount()));
        itmdscrpt.setText(selectedItem.getDescription());
        itmimgBig.setImage(new
        Image(getClass().getResource(selectedItem.getSprite()).toExternalForm()));
        itmPrice.setText("$: " + selectedItem.getPrice());
    }

    @FXML
    void itm17Clicked() {
        currentItemx = 4;
        currentItemy = 0;
        selectedItem = shop.getItem(4, 0);
        itmName.setText(selectedItem.getName());
        itmType.setText(selectedItem.getType().toString());
        itmElement.setText(selectedItem.getElementType().toString());
        itmAmount.setText(Integer.toString(selectedItem.getStoreAmount()));
        itmdscrpt.setText(selectedItem.getDescription());
        itmimgBig.setImage(new
        Image(getClass().getResource(selectedItem.getSprite()).toExternalForm()));
        itmPrice.setText("$: " + selectedItem.getPrice());
    }

    @FXML
    void itm18Clicked() {
        currentItemx = 4;
        currentItemy = 1;
        selectedItem = shop.getItem(4, 1);
        itmName.setText(selectedItem.getName());
        itmType.setText(selectedItem.getType().toString());
        itmElement.setText(selectedItem.getElementType().toString());
        itmAmount.setText(Integer.toString(selectedItem.getStoreAmount()));
        itmdscrpt.setText(selectedItem.getDescription());
        itmimgBig.setImage(new
        Image(getClass().getResource(selectedItem.getSprite()).toExternalForm()));
        itmPrice.setText("$: " + selectedItem.getPrice());
    }

    @FXML
    void itm19Clicked() {
        currentItemx = 4;
        currentItemy = 2;
        selectedItem = shop.getItem(4, 2);
        itmName.setText(selectedItem.getName());
        itmType.setText(selectedItem.getType().toString());
        itmElement.setText(selectedItem.getElementType().toString());
        itmAmount.setText(Integer.toString(selectedItem.getStoreAmount()));
        itmdscrpt.setText(selectedItem.getDescription());
        itmimgBig.setImage(new
        Image(getClass().getResource(selectedItem.getSprite()).toExternalForm()));
        itmPrice.setText("$: " + selectedItem.getPrice());
    }

    @FXML
    void itm1Clicked() {
        currentItemx = 0;
        currentItemy = 0;
        selectedItem = shop.getItem(0, 0);
        itmName.setText(selectedItem.getName());
        itmType.setText(selectedItem.getType().toString());
        itmElement.setText(selectedItem.getElementType().toString());
        itmAmount.setText(Integer.toString(selectedItem.getStoreAmount()));
        itmdscrpt.setText(selectedItem.getDescription());
        itmimgBig.setImage(new
        Image(getClass().getResource(selectedItem.getSprite()).toExternalForm()));
        itmPrice.setText("$: " + selectedItem.getPrice());
    }

    @FXML
    void itm20Clicked() {
        currentItemx = 4;
        currentItemy = 3;
        selectedItem = shop.getItem(4, 3);
        itmName.setText(selectedItem.getName());
        itmType.setText(selectedItem.getType().toString());
        itmElement.setText(selectedItem.getElementType().toString());
        itmAmount.setText(Integer.toString(selectedItem.getStoreAmount()));
        itmdscrpt.setText(selectedItem.getDescription());
        itmimgBig.setImage(new
        Image(getClass().getResource(selectedItem.getSprite()).toExternalForm()));
        itmPrice.setText("$: " + selectedItem.getPrice());
    }

    @FXML
    void itm21Clicked() {
        currentItemx = 5;
        currentItemy = 0;
        selectedItem = shop.getItem(5, 0);
        itmName.setText(selectedItem.getName());
        itmType.setText(selectedItem.getType().toString());
        itmElement.setText(selectedItem.getElementType().toString());
        itmAmount.setText(Integer.toString(selectedItem.getStoreAmount()));
        itmdscrpt.setText(selectedItem.getDescription());
        itmimgBig.setImage(new
        Image(getClass().getResource(selectedItem.getSprite()).toExternalForm()));
        itmPrice.setText("$: " + selectedItem.getPrice());
    }

    @FXML
    void itm22Clicked() {
        currentItemx = 5;
        currentItemy = 1;
        selectedItem = shop.getItem(5, 1);
        itmName.setText(selectedItem.getName());
        itmType.setText(selectedItem.getType().toString());
        itmElement.setText(selectedItem.getElementType().toString());
        itmAmount.setText(Integer.toString(selectedItem.getStoreAmount()));
        itmdscrpt.setText(selectedItem.getDescription());
        itmimgBig.setImage(new
        Image(getClass().getResource(selectedItem.getSprite()).toExternalForm()));
        itmPrice.setText("$: " + selectedItem.getPrice());
    }

    @FXML
    void itm23Clicked() {
        currentItemx = 5;
        currentItemy = 2;
        selectedItem = shop.getItem(5, 2);
        itmName.setText(selectedItem.getName());
        itmType.setText(selectedItem.getType().toString());
        itmElement.setText(selectedItem.getElementType().toString());
        itmAmount.setText(Integer.toString(selectedItem.getStoreAmount()));
        itmdscrpt.setText(selectedItem.getDescription());
        itmimgBig.setImage(new
        Image(getClass().getResource(selectedItem.getSprite()).toExternalForm()));
        itmPrice.setText("$: " + selectedItem.getPrice());
    }

    @FXML
    void itm24Clicked() {
        currentItemx = 5;
        currentItemy = 3;
        selectedItem = shop.getItem(5, 3);
        itmName.setText(selectedItem.getName());
        itmType.setText(selectedItem.getType().toString());
        itmElement.setText(selectedItem.getElementType().toString());
        itmAmount.setText(Integer.toString(selectedItem.getStoreAmount()));
        itmdscrpt.setText(selectedItem.getDescription());
        itmimgBig.setImage(new
        Image(getClass().getResource(selectedItem.getSprite()).toExternalForm()));
        itmPrice.setText("$: " + selectedItem.getPrice());
    }

    @FXML
    void itm25Clicked() {
        currentItemx = 6;
        currentItemy = 0;
        selectedItem = shop.getItem(6, 0);
        itmName.setText(selectedItem.getName());
        itmType.setText(selectedItem.getType().toString());
        itmElement.setText(selectedItem.getElementType().toString());
        itmAmount.setText(Integer.toString(selectedItem.getStoreAmount()));
        itmdscrpt.setText(selectedItem.getDescription());
        itmimgBig.setImage(new
        Image(getClass().getResource(selectedItem.getSprite()).toExternalForm()));
        itmPrice.setText("$: " + selectedItem.getPrice());
    }

    @FXML
    void itm26Clicked() {
        currentItemx = 6;
        currentItemy = 1;
        selectedItem = shop.getItem(6, 1);
        itmName.setText(selectedItem.getName());
        itmType.setText(selectedItem.getType().toString());
        itmElement.setText(selectedItem.getElementType().toString());
        itmAmount.setText(Integer.toString(selectedItem.getStoreAmount()));
        itmdscrpt.setText(selectedItem.getDescription());
        itmimgBig.setImage(new
        Image(getClass().getResource(selectedItem.getSprite()).toExternalForm()));
        itmPrice.setText("$: " + selectedItem.getPrice());
    }

    @FXML
    void itm27Clicked() {
        currentItemx = 6;
        currentItemy = 2;
        selectedItem = shop.getItem(6, 2);
        itmName.setText(selectedItem.getName());
        itmType.setText(selectedItem.getType().toString());
        itmElement.setText(selectedItem.getElementType().toString());
        itmAmount.setText(Integer.toString(selectedItem.getStoreAmount()));
        itmdscrpt.setText(selectedItem.getDescription());
        itmimgBig.setImage(new
        Image(getClass().getResource(selectedItem.getSprite()).toExternalForm()));
        itmPrice.setText("$: " + selectedItem.getPrice());
    }

    @FXML
    void itm28Clicked() {
        currentItemx = 6;
        currentItemy = 3;
        selectedItem = shop.getItem(6, 3);
        itmName.setText(selectedItem.getName());
        itmType.setText(selectedItem.getType().toString());
        itmElement.setText(selectedItem.getElementType().toString());
        itmAmount.setText(Integer.toString(selectedItem.getStoreAmount()));
        itmdscrpt.setText(selectedItem.getDescription());
        itmimgBig.setImage(new
        Image(getClass().getResource(selectedItem.getSprite()).toExternalForm()));
        itmPrice.setText("$: " + selectedItem.getPrice());
    }

    @FXML
    void itm2Clicked() {
        currentItemx = 0;
        currentItemy = 1;
        selectedItem = shop.getItem(0, 1);
        itmName.setText(selectedItem.getName());
        itmType.setText(selectedItem.getType().toString());
        itmElement.setText(selectedItem.getElementType().toString());
        itmAmount.setText(Integer.toString(selectedItem.getStoreAmount()));
        itmdscrpt.setText(selectedItem.getDescription());
        itmimgBig.setImage(new
        Image(getClass().getResource(selectedItem.getSprite()).toExternalForm()));
        itmPrice.setText("$: " + selectedItem.getPrice());
    }

    @FXML
    void itm3Clicked() {
        currentItemx = 0;
        currentItemy = 2;
        selectedItem = shop.getItem(0, 2);
        itmName.setText(selectedItem.getName());
        itmType.setText(selectedItem.getType().toString());
        itmElement.setText(selectedItem.getElementType().toString());
        itmAmount.setText(Integer.toString(selectedItem.getStoreAmount()));
        itmdscrpt.setText(selectedItem.getDescription());
        itmimgBig.setImage(new
        Image(getClass().getResource(selectedItem.getSprite()).toExternalForm()));
        itmPrice.setText("$: " + selectedItem.getPrice());
    }

    @FXML
    void itm4Clicked() {
        currentItemx = 0;
        currentItemy = 3;
        selectedItem = shop.getItem(0, 3);
        itmName.setText(selectedItem.getName());
        itmType.setText(selectedItem.getType().toString());
        itmElement.setText(selectedItem.getElementType().toString());
        itmAmount.setText(Integer.toString(selectedItem.getStoreAmount()));
        itmdscrpt.setText(selectedItem.getDescription());
        itmimgBig.setImage(new
        Image(getClass().getResource(selectedItem.getSprite()).toExternalForm()));
        itmPrice.setText("$: " + selectedItem.getPrice());
    }

    @FXML
    void itm5Clicked() {
        currentItemx = 1;
        currentItemy = 0;
        selectedItem = shop.getItem(1, 0);
        itmName.setText(selectedItem.getName());
        itmType.setText(selectedItem.getType().toString());
        itmElement.setText(selectedItem.getElementType().toString());
        itmAmount.setText(Integer.toString(selectedItem.getStoreAmount()));
        itmdscrpt.setText(selectedItem.getDescription());
        itmimgBig.setImage(new
        Image(getClass().getResource(selectedItem.getSprite()).toExternalForm()));
        itmPrice.setText("$: " + selectedItem.getPrice());
    }

    @FXML
    void itm6Clicked() {
        currentItemx = 1;
        currentItemy = 1;
        selectedItem = shop.getItem(1, 1);
        itmName.setText(selectedItem.getName());
        itmType.setText(selectedItem.getType().toString());
        itmElement.setText(selectedItem.getElementType().toString());
        itmAmount.setText(Integer.toString(selectedItem.getStoreAmount()));
        itmdscrpt.setText(selectedItem.getDescription());
        itmimgBig.setImage(new
        Image(getClass().getResource(selectedItem.getSprite()).toExternalForm()));
        itmPrice.setText("$: " + selectedItem.getPrice());
    }

    @FXML
    void itm7Clicked() {
        currentItemx = 1;
        currentItemy = 2;
        selectedItem = shop.getItem(1, 2);
        itmName.setText(selectedItem.getName());
        itmType.setText(selectedItem.getType().toString());
        itmElement.setText(selectedItem.getElementType().toString());
        itmAmount.setText(Integer.toString(selectedItem.getStoreAmount()));
        itmdscrpt.setText(selectedItem.getDescription());
        itmimgBig.setImage(new
        Image(getClass().getResource(selectedItem.getSprite()).toExternalForm()));
        itmPrice.setText("$: " + selectedItem.getPrice());
    }

    @FXML
    void itm8Clicked() {
        currentItemx = 1;
        currentItemy = 3;
        selectedItem = shop.getItem(1, 3);
        itmName.setText(selectedItem.getName());
        itmType.setText(selectedItem.getType().toString());
        itmElement.setText(selectedItem.getElementType().toString());
        itmAmount.setText(Integer.toString(selectedItem.getStoreAmount()));
        itmdscrpt.setText(selectedItem.getDescription());
        itmimgBig.setImage(new
        Image(getClass().getResource(selectedItem.getSprite()).toExternalForm()));
        itmPrice.setText("$: " + selectedItem.getPrice());
    }

    @FXML
    void itm9Clicked() {
        currentItemx = 2;
        currentItemy = 0;
        selectedItem = shop.getItem(2, 0);
        itmName.setText(selectedItem.getName());
        itmType.setText(selectedItem.getType().toString());
        itmElement.setText(selectedItem.getElementType().toString());
        itmAmount.setText(Integer.toString(selectedItem.getStoreAmount()));
        itmdscrpt.setText(selectedItem.getDescription());
        itmimgBig.setImage(new
        Image(getClass().getResource(selectedItem.getSprite()).toExternalForm()));
        itmPrice.setText("$: " + selectedItem.getPrice());
    }

    @FXML
    void backbtn() throws IOException {
        App.setRoot("Gameplay_Menu");
    }
}
