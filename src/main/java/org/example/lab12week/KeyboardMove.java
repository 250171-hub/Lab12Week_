package org.example.lab12week;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class KeyboardMove extends Application {
    static double x;
    static double y;
    @Override
    public void start(Stage stage) throws Exception {
        Pane pane = new Pane();
        pane.setPrefSize(500, 400);
        Rectangle rectangle = new Rectangle(60, 40, 220, 180);

        TextField textField = new TextField(String.format("X: %.2f   Y: %.2f", rectangle.getX(), rectangle.getY()));
        Scene scene = new Scene(pane);

        scene.setOnKeyPressed(keyEvent -> {
            x = rectangle.getX();
            y = rectangle.getY();
            if(keyEvent.getCode()== KeyCode.UP){
                y += 10;
            }
            else if(keyEvent.getCode()== KeyCode.LEFT){
                x -= 10;
            }
            if(keyEvent.getCode()== KeyCode.RIGHT){
                x += 10;
            }
            rectangle.setX(x);
            rectangle.setX(y);
            textField.setText(String.format("X: %.2f   Y: %.2f ", rectangle.getX(), rectangle.getY()));
        });
        pane.getChildren().add(rectangle);
        pane.getChildren().add(textField);
        scene.getRoot().requestFocus();
        stage.setScene(scene);
        stage.show();
    }
}
