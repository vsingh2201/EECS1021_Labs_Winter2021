package sample;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class Main extends Application {

    public static void main(String[] args) {

        launch(args);
    }

    private Node makeSliderRow(){
        var hbox = new HBox();
        hbox.setSpacing(10.0);

        var slider = new Slider();
        slider.setMin(0.0);
        slider.setMax(100.0);

        var label = new Label();

        /*
        TODO: Bind the text property of the label to the value of the slider, formatted as {@code "I am <age> years old"}
         */
        // Second Method (Binding)
        label.textProperty().bind(slider.valueProperty().asString("I am %.0f years old"));
        /* First Method (Data Listener)
        slider.valueProperty().addListener((observableValue, oldValue, newValue) ->{
            label.setText("I am " + String.valueOf(newValue.intValue()) + " years old.");
        } );*/

        hbox.getChildren().addAll(slider, label);
        return hbox;

    }

    private Node makeButtonRow(){
        var hbox = new HBox();
        hbox.setSpacing(10.0);

        var textField = new TextField();
        textField.setPromptText("First name");
        //textField.setStyle("-fx-background-color: grey");

        var button = new Button("A button");

        button.disableProperty().bind(textField.textProperty().isEmpty());

        /*
        TODO: Bind the text property of the button so that when the text field is empty, the button's text is
         {@code "Disabled"}. Otherwise, it should say {@code "Enabled"}
         */
        // Solution
        button.textProperty().bind(Bindings.when(textField.textProperty().isEmpty())
        .then("Disabled")
        .otherwise("Enabled")
        );

        hbox.getChildren().addAll(textField,button);
        return hbox;
    }

    @Override
    public void start(Stage primaryStage){
        var rowA = makeSliderRow();
        var rowB = makeButtonRow();

        var vbox = new VBox();
        vbox.setSpacing(10.0);
        vbox.setPadding(new Insets(10,10,10,10));
        vbox.getChildren().addAll(rowA,rowB);

        var scene = new Scene(vbox,400,200);

        //vbox.setStyle("-fx-background-color: #B8B5FF");// Violet Color
        vbox.setStyle("-fx-background-color: #ffd369");

        //vbox.setStyle("-fx-background-color: #a4ebf3");

        primaryStage.setScene(scene);
        primaryStage.setTitle("LabH Part A");
        primaryStage.show();
    }
}
