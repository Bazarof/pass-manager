package org.openjfx.layoutclasses;

import java.lang.Runnable;
import javafx.util.Builder;
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

class LayoutLeftOptionsBuilder implements Builder<Region>{

    private Runnable sceneSwapper;

    private BorderPane mainLayoutRef;

    // option layaouts
    private LinkedHashMap<String, Region> nav;

    // button properties
    private final LinkedHashMap<String, EventHandler<ActionEvent>> btnProperties = new LinkedHashMap<>(){{

        put("Home", evt -> mainLayoutRef.setCenter(nav.get("home")));
        put("Passwod generator", evt -> System.out.println("Adios mundo !!!"));

    }};

    private final Button btnLogOut;

    private ArrayList<Button> btns;

    public LayoutLeftOptionsBuilder(Runnable sceneSwapper, LinkedHashMap<String, Region> nav, BorderPane mainLayoutRef) {

        this.btnLogOut = new Button("Signout"){{
            setOnAction(evt -> sceneSwapper.run());
        }};

        this.nav = nav;
        this.mainLayoutRef = mainLayoutRef;
        initializeComponents();

    }

    @Override
    public Region build() {

        BorderPane bp = new BorderPane();

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

        bp.setCenter(sideBar);
        bp.setBottom(sideBarBottom);

        return bp;
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