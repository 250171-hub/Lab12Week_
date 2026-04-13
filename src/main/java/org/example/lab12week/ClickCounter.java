package org.example.lab12week;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import java.io.IOException;


public class ClickCounter extends Application {
    static int counter = 0;
    @Override
    public void start(Stage stage) throws IOException {

        Label label = new Label("Clicks: " + counter);
        Button button = new Button("Click me");
        label.setFont(Font.font("Bold", FontWeight.BOLD, 24));
        VBox vBox = new VBox(label, button);
        vBox.setPadding(new Insets(30));
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(20);
        button.setOnAction(actionEvent -> {
           counter++;
           vBox.getChildren().clear();
           Label label1 = new Label("Clicks: " + counter);
           label1.setFont(Font.font("Bold", FontWeight.BOLD, 24));
           vBox.getChildren().add(label1);
           vBox.getChildren().add(button);
        });

        Scene scene = new Scene(vBox, 300, 200);
        stage.setScene(scene);
        stage.setTitle("Click Counter");
        stage.show();
    }

    public static void main(String[] args){
        launch(args);
    }
}
