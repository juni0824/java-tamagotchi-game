module com.example {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    requires json.simple;
    requires com.google.gson;
    requires javafx.graphics; // For Gson

    opens com.example to javafx.fxml;
    exports com.example;
}
