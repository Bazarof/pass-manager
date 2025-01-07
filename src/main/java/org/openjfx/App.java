package org.openjfx;

import org.openjfx.classes.utilities.Stages;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {

        if(isUserLogged()){

            Stages.setMainPaneStage(stage);

        }else{

            Stages.setLoginStage(stage);

        }

    }

    public static void main(String[] args) {

        launch();

    }

    private boolean isUserLogged() {

        // VERIFY USER AUTHENTICATION

        return false;
    }

}