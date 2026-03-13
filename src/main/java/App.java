package com.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class App extends Application {

    private static Scene scene;
    private static Restrictions restrictions = new Restrictions();

    @Override
    public void start(Stage stage) throws IOException {
        // Force creation of the Stats instance so its timers start.
        Stats.getInstance();
        scene = new Scene(loadFXML("Main_Menu"), 900, 750);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void stop() throws Exception {
        // Finalize the current session so that the current session's time is added.
        Stats stats = Stats.getInstance();
        stats.endSessionAndRestart();  // This adds sessionSeconds to totalSeconds and increments sessionsCount.
        stats.persistStats();          // Save the updated stats.
        stats.shutdownSchedulers();    // Shut down the scheduled tasks.
    }


    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("/com/example/" + fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static Restrictions getRestrictions() {
        return restrictions;
    }

    public static void main(String[] args) {
        launch();
    }
}