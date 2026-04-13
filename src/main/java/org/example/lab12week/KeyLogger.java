package org.example.lab12week;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class KeyLogger extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        TextField textField = new TextField("Write here");
        TextArea textArea = new TextArea();
        textArea.setPrefRowCount(5);
        textArea.setEditable(false);


        textField.setOnKeyPressed(keyEvent -> {
            textArea.appendText(String.format("PRESSED | Code: %s | Shift: %b  | Ctrl: %b%n"
                    , keyEvent.getCode(), keyEvent.isShiftDown(), keyEvent.isControlDown()
            ));
        });

        textField.setOnKeyReleased(keyEvent -> {
            textArea.appendText(String.format(" \n RELEASED | Code: %s", keyEvent.getCode()));
        });

        textField.setOnKeyTyped(keyEvent -> {
            textArea.appendText(String.format(" \nTyped | %s", keyEvent.getCharacter()));
        });

        Button  button = new Button("Clear");
        button.setOnAction(actionEvent -> {
            textArea.clear();
        });

        VBox vBox = new VBox(textField, textArea, button);
        vBox.setSpacing(10);
        vBox.setPadding(new Insets(20));
        Scene scene = new Scene(vBox, 420, 320);
        stage.setScene(scene);
        stage.show();
    }
}
