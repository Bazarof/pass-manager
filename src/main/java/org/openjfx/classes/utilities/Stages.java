package org.openjfx.classes.utilities;

import org.openjfx.layout.LayoutLoginBuilder;
import org.openjfx.layout.LayoutMainPaneBuilder;

import javafx.stage.Stage;
import javafx.scene.Scene;

public class Stages {

    public static void setLoginStage(Stage newStage) {

        newStage.setScene(new Scene(new LayoutLoginBuilder(newStage).build()){{
            getStylesheets().add("style/styles.css");
        }});

        newStage.setWidth(350);
        newStage.setHeight(600);

        newStage.show();
    }

    public static void openLoginStage() {
        
        Stage newStage = new Stage();

        newStage.setScene(new Scene(new LayoutLoginBuilder(newStage).build()){{
            getStylesheets().add("style/styles.css");
        }});

        newStage.setWidth(350);
        newStage.setHeight(600);

        newStage.show();
    }

    public static void openMainPaneStage() {

        Stage newStage = new Stage();

        newStage.setScene(new Scene(new LayoutMainPaneBuilder(newStage).build()){{
            getStylesheets().add("style/styles.css");
        }});

        newStage.setWidth(600);
        newStage.setHeight(400);
        
        newStage.show();
    }

    public static void setMainPaneStage(Stage newStage) {

        newStage.setScene(new Scene(new LayoutMainPaneBuilder(newStage).build()){{
            getStylesheets().add("style/styles.css");
        }});

        newStage.setWidth(600);
        newStage.setHeight(400);
        
        newStage.show();
    }

    public static void closeCurrentStage(Stage currentStage) {

        currentStage.close();

    }
}