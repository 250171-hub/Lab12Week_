package org.example.lab12week;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class DraggableCircle extends Application {
    static double offsetX;
    static double offsetY;
    @Override
    public void start(Stage stage) throws Exception {
        Pane pane = new Pane();
        pane.setPrefSize(500,400);
        Circle circle = new Circle(250, 250, 40);
        circle.setFill(Color.CORAL);
        pane.getChildren().add(circle);

        circle.setOnMousePressed(mouseEvent -> {
            offsetX = mouseEvent.getX() - circle.getCenterX();
            offsetY = mouseEvent.getY() - circle.getCenterY();
        });

        circle.setOnMouseDragged(mouseEvent -> {
            circle.setCenterX(mouseEvent.getSceneX() - offsetX);
            circle.setCenterY(mouseEvent.getSceneY() - offsetY);
            circle.setFill(Color.TOMATO);

        });
        circle.setOnMouseReleased(mouseEvent -> {
            circle.setFill(Color.CORAL);
        });


        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }
}
