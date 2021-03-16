package sample;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import sample.SerialPortService;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;

public class Main extends Application {

    public static void main(String[] args) {

        launch(args);
    }
    public void start(Stage primaryStage){
        var sp = SerialPortService.getSerialPort("COM3");
        var outputStream = sp.getOutputStream();

        var pane = new BorderPane();

        // Solution for the MOSFET part
        var label = new Label();
        var button = new Button();
        button.setText("MOSFET");


        var slider = new Slider();
        slider.setMin(0.0);
        slider.setMax(100.0);


        //TODO: Add a 'listener' to the {@code valueProperty} of the slider. The listener
        //  should write the {@code byteValue()} of the new slider value to the output stream.

        slider.valueProperty().addListener((observableValue, oldValue, newValue) -> {
            label.setText(String.valueOf(newValue));
        });

        // MOSFET part
        button.setOnMousePressed(value ->{
            try{
                outputStream.write(255);
            }
            catch (IOException e){
                e.printStackTrace();
                System.out.println("Mouse Press not detected");
            }
        });

        button.setOnMouseReleased(value -> {
            try{
                outputStream.write(0);
            }
            catch (IOException e)
            {
                e.printStackTrace();
                System.out.println("Mouse Released not detected");
            }
        });


        pane.setCenter(slider);
        pane.setPadding(new Insets(0,20,0,20));
        pane.setBottom(label);
        pane.setTop(button);

        //pane.setStyle("background color: blue");

        var scene = new Scene(pane,400,200);

        primaryStage.setScene(scene);
        primaryStage.show();


    }



}
