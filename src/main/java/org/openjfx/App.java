package org.openjfx;

import org.openjfx.layoutclasses.MainLayoutBuilder;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
//import javafx.stage.StageStyle;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        stage.setScene(new Scene(new MainLayoutBuilder().build()));
        stage.setWidth(700);
        stage.setHeight(500);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}