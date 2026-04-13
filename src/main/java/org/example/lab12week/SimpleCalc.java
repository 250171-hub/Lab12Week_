package org.example.lab12week;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class SimpleCalc extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        TextField textField1 = new TextField("");
        TextField textField2 = new TextField("");
        Text result = new Text("");
        Text text3 = new Text("Number 1:");
        Text text4 = new Text("Number 2");


        Button button1 = new Button("Calculate");
        Button buttonClear = new Button("Clear");
        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(20));
        gridPane.setAlignment(Pos.CENTER);
        gridPane.add(textField1, 1, 0);
        gridPane.add(textField2, 1, 1);
        gridPane.add(text3, 0, 0);
        gridPane.add(text4, 0, 1);
        gridPane.add(result, 0, 2);
        gridPane.add(button1, 2, 0);
        gridPane.add(buttonClear, 2, 1);


        button1.setOnAction(actionEvent -> {
            try {
                Double number1 = Double.parseDouble(textField1.getText());
                Double number2 = Double.parseDouble(textField2.getText());
                double x = number1 + number2;
                result.setText(String.format("Sum is: %.2f", x));

            } catch (NumberFormatException e) {
                result.setText("Invalid input");
            }
        });
        buttonClear.setOnAction(actionEvent -> {
            textField1.clear();
            textField2.clear();
            result.setText("");
        });
        Scene scene = new Scene(gridPane);
        stage.setScene(scene);
        stage.show();

    }
}
