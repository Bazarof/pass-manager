package org.openjfx;

//import org.openjfx.layoutclasses.MainLayoutBuilder;
import org.openjfx.layoutclasses.LayoutLoginBuilder;

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
            // show main panel

        }else{

            setLoginStage(stage);

        }


        stage.show();

    }

    public static void main(String[] args) {

        launch();

    }

    private void setLoginStage(Stage stage){

            stage.setScene(new Scene(new LayoutLoginBuilder(stage).build()){{
                getStylesheets().add("style/styles.css");
            }});

            stage.setWidth(350);
            stage.setHeight(500);

    }

    private boolean isUserLogged() {

        // VERIFY USER AUTHENTICATION

        return false;
    }

}