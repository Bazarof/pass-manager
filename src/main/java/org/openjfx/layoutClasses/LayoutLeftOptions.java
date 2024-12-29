package org.openjfx.layoutclasses;

import org.openjfx.layoutclasses.sidebaroptions.LayoutHomeOption;

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
import java.util.HashMap;

class LayoutLeftOptionsBuilder implements Builder<Region>{

    private Runnable sceneSwapper;

    private BorderPane mainLayoutRef;

    // option layaouts
    private HashMap<String, Region> nav;

    private final String[] sideBarOptions = {
        "Home",
        "Password generator",
        "Exit"
        // more options...
    };

    // sidebar option actions
    private final ArrayList<EventHandler<ActionEvent>> actions = new ArrayList<>(Arrays.asList(
        evt -> mainLayoutRef.setCenter(nav.get("home")),
        evt -> System.out.println("Adios mundo !!!"),
        evt -> sceneSwapper.run()
    ));

    // sidebar buttons lenght rely on sideBarOptions lenght
    private ArrayList<Button> btns;

    public LayoutLeftOptionsBuilder(Runnable sceneSwapper, HashMap<String, Region> nav, BorderPane mainLayoutRef) {

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

        for(int i = 0; i < sideBarOptions.length; i++){
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
        for(int i = 0; i < sideBarOptions.length; i++) {

            btn = new Button(sideBarOptions[i]);
            btn.setPrefWidth(130);
            btn.setOnAction(actions.get(i));

            btns.add(btn);
        }
    }

}