package org.openjfx.layoutclasses.sidebaroptions;

import javafx.util.Builder;
import javafx.scene.layout.Region;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Label;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

public class LayoutHomeOptionBuilder implements Builder<Region> {

    Label text;

    public LayoutHomeOptionBuilder() {

        initializeComponents();

    }

    @Override
    public Region build() {

        GridPane home = new GridPane(){{
            setAlignment(Pos.CENTER);
            setHgap(10);
            setVgap(10);
            setPadding(new Insets(25, 25, 25, 25));
        }};

        home.add(text, 0, 0);

        return home;
    }

    private void initializeComponents() {
        text = new Label("This is Home.");
    }
}