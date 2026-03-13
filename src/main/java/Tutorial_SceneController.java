package com.example;

import javafx.scene.text.Text;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.image.*;

public class Tutorial_SceneController {

     @FXML
    private Button Continue;

    @FXML
    private ImageView Pet_Current;

    @FXML
    private ImageView Pet_Image;

    @FXML
    private Label healthLabel;

    @FXML
    private RadioButton menubtn;

    @FXML
    private Text petHealth;

    static int counter = 1;

    @FXML
    void NextTutorial(ActionEvent event) throws Exception{
        
        if(counter != 7){
            counter++;
            App.setRoot("Tut_" + counter);
        }
        else{
            counter = 1;
            App.setRoot(CurrentState.getInstance().returnScene());
        }

    }

}
