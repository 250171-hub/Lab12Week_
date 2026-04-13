package org.example.lab12week;

import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class MourseCoords extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Label label = new Label("Move mouse over the screen");
        StackPane stackPane = new StackPane();
        stackPane.setPrefSize(400, 300);
        stackPane.setStyle("-fx-background-color: light-blue");
        stackPane.setOnMouseClicked(mouseEvent -> {
            stackPane.setStyle(String.format("-fx-background-color: rgb(%d,%d,%d);",
                    (int)(Math.random()*256), (int)(Math.random()*256), (int)(Math.random()*256)));
        });
        stackPane.setOnMouseMoved(mouseEvent -> {
            label.setText(String.format("X: %.2f  Y: %.2f", mouseEvent.getX(), mouseEvent.getY()));
        });
        stackPane.setOnMouseExited(mouseEvent ->{
            label.setText("Move the mouse over the pane");
        });

        BorderPane pane =new BorderPane();
        pane.setBottom(label);
        pane.setCenter(stackPane);
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();

    }


}
