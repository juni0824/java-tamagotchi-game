package com.example;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class Pause_Menu_SceneController{

    @FXML
    private Button Resume;

    @FXML
    private Button mainMenu;

    @FXML
    private Button saveGame;

    private String lastScene = CurrentState.getInstance().returnScene();
    private Inventory inventory = CurrentState.getInstance().getInventory();
    private Pet pet = CurrentState.getInstance().getPet();
    private int saveFile = CurrentState.getInstance().getSaveFile();

    @FXML
    void Resume() throws IOException{
        App.setRoot("Gameplay");
    }

    @FXML
    void SaveGame() throws IOException{
        Save.saveGame(pet, saveFile);
        //Put music here
    }

    @FXML
    void Tutorial() throws IOException{
        Save.saveGame(pet, saveFile);
        CurrentState.getInstance().lastScene("PauseMenu");
        App.setRoot("Tut_1");
    }

    @FXML 
    void Settings() throws IOException{
        Save.saveGame(pet, saveFile);
        CurrentState.getInstance().lastScene("PauseMenu");
        App.setRoot("Settings");
    }

    @FXML
    void MainMenu() throws IOException{
        Save.saveGame(pet, saveFile);
        App.setRoot("Main_Menu");
    }

}
