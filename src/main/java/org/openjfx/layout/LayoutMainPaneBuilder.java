package org.openjfx.layout;

import org.openjfx.layout.sidebaroptions.LayoutHomeOptionBuilder;
import org.openjfx.layout.sidebaroptions.LayoutPasswordGeneratorBuilder;
import org.openjfx.classes.utilities.Stages;

import java.lang.Runnable;
import javafx.util.Builder;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap; // can get items in the order were put
import java.util.Map;

public class LayoutMainPaneBuilder implements Builder<Region>{

    private BorderPane mainPane;

    // route layaouts
    private final LinkedHashMap<String, Region> nav = new LinkedHashMap<>(){{
        put("home", new LayoutHomeOptionBuilder().build());
        put("password-generator", new LayoutPasswordGeneratorBuilder().build());
    }};

    // button properties
    private final LinkedHashMap<String, EventHandler<ActionEvent>> btnProperties = new LinkedHashMap<>(){{

        put("Home", evt -> mainPane.setCenter(nav.get("home")));
        put("Passwod generator", evt -> mainPane.setCenter(nav.get("password-generator")));

    }};

    private final Button btnLogOut;

    private ArrayList<Button> btns;

    public LayoutMainPaneBuilder(Stage currentStage) {

        this.mainPane = new BorderPane();

        this.btnLogOut = new Button("Signout"){{

            getStyleClass().add("button-signout");

            setOnAction(evt -> {

                Stages.closeCurrentStage(currentStage);
                Stages.openLoginStage();

            });
        }};

        initializeComponents();

    }

    @Override
    public Region build() {

        BorderPane sideBarBP = new BorderPane();

        VBox sideBar = new VBox(10){{
            setPadding(new Insets(10, 10, 10 ,10));
            setStyle("-fx-background-color: #29446f");
        }};

        HBox sideBarBottom = new HBox(5){{
            setPadding(new Insets(5, 5, 5, 5));
            setAlignment(Pos.CENTER_RIGHT);
            getStyleClass().add("sidebar-bottom");
            getChildren().add(btnLogOut);
        }};

        for(int i = 0; i < btnProperties.size(); i++){
            sideBar.getChildren().add(btns.get(i));
        }

        sideBarBP.setCenter(sideBar);
        sideBarBP.setBottom(sideBarBottom);

        mainPane.setLeft(sideBarBP);
        mainPane.setCenter(nav.get("home"));

        return mainPane;
    }

    private void initializeComponents() {

        btnList();

    }

    // create option buttons assigning text and action events
    private void btnList() {

        btns = new ArrayList<>();
        
        Button btn;
        for(Map.Entry<String, EventHandler<ActionEvent>> entry: btnProperties.entrySet()) {

            btn = new Button(entry.getKey());
            btn.setPrefWidth(130);
            btn.setOnAction(entry.getValue());
            btn.getStyleClass().add("sidebar-btn");

            btns.add(btn);
        }
    }

}