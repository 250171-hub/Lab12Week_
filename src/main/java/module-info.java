module org.example.lab12week {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.lab12week to javafx.fxml;
    exports org.example.lab12week;
}