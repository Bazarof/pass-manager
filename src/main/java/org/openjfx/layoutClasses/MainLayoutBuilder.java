package org.openjfx.layoutclasses;

import org.openjfx.layoutclasses.sidebaroptions.LayoutHomeOptionBuilder;

import javafx.util.Builder;
import javafx.scene.layout.Region;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;

public class MainLayoutBuilder implements Builder<Region> {

    private Region loginComponent;
    private Region sideBarComponent;

    private final LinkedHashMap<String, Region> nav = new LinkedHashMap<>(){{
        put("home", new LayoutHomeOptionBuilder().build());
    }};

    @Override
    public Region build() {

        BorderPane mainLayout = new BorderPane();

        // Sublayouts 
        loginComponent = new LayoutLoginBuilder(() -> {
            mainLayout.setCenter(nav.get("home"));
            mainLayout.setLeft(sideBarComponent);
        }, nav).build();

        sideBarComponent = new LayoutLeftOptionsBuilder(() -> {
            mainLayout.setCenter(loginComponent);
            mainLayout.setLeft(null);
        }, nav, mainLayout).build();
        
        mainLayout.setCenter(loginComponent);
        
        return mainLayout;
    }

}