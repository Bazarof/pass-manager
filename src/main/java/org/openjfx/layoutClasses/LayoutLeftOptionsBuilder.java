package org.openjfx.layoutclasses;

import java.lang.Runnable;
import javafx.util.Builder;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.layout.BorderPane;
import javafx.geometry.Insets;
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
        put("Exit", evt -> sceneSwapper.run());

    }};

    private ArrayList<Button> btns;

    public LayoutLeftOptionsBuilder(Runnable sceneSwapper, LinkedHashMap<String, Region> nav, BorderPane mainLayoutRef) {

        this.sceneSwapper = sceneSwapper;
        this.nav = nav;
        this.mainLayoutRef = mainLayoutRef;
        initializeComponents();

    }

    @Override
    public Region build() {

        VBox sideBar = new VBox(10);
        sideBar.setPadding(new Insets(10, 10, 10 ,10));
        sideBar.setStyle("-fx-background-color: #265586");

        for(int i = 0; i < btnProperties.size(); i++){
            sideBar.getChildren().add(btns.get(i));
        }

        return sideBar;
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

            btns.add(btn);
        }
    }

}