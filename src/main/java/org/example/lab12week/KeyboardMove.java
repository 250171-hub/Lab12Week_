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
        Rectangle rectangle = new Rectangle(220, 180, 60, 40);
        rectangle.setFill(Color.BLUE);

        TextField textField = new TextField(String.format("X: %.2f   Y: %.2f", rectangle.getX(), rectangle.getY()));
        Scene scene = new Scene(pane);
        textField.setEditable(false);

        scene.setOnKeyPressed(keyEvent -> {
            x = rectangle.getX();
            y = rectangle.getY();
            if(keyEvent.getCode()== KeyCode.UP){
                y -= 10;
            }
            else if(keyEvent.getCode() == KeyCode.DOWN){
                y += 10;
            }
            else if(keyEvent.getCode()== KeyCode.LEFT){
                x -= 10;
            }
            if(keyEvent.getCode()== KeyCode.RIGHT){
                x += 10;
            }
            x = Math.max(0, Math.min(x, pane.getWidth()-60));
            y = Math.max(0, Math.min(y, pane.getHeight()-60));

            rectangle.setX(x);
            rectangle.setY(y);
            textField.setText(String.format("X: %.2f   Y: %.2f ", rectangle.getX(), rectangle.getY()));
        });
        pane.getChildren().add(rectangle);
        pane.getChildren().add(textField);
        scene.getRoot().requestFocus();
        stage.setScene(scene);
        stage.show();
    }
}
