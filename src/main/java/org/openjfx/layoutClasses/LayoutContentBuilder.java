package org.openfx.layoutclasses;

import java.lang.Runnable;
import javafx.util.Builder;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.geometry.Insets;

public class LayoutContentBuilder implements Builder<Region> {

    Runnable sceneSwapper;
    
    public LayoutContentBuilder(Runnable sceneSwapper) {

        this.sceneSwapper = sceneSwapper;

    }

    @Override
    public Region build() {

        Button button = new Button("Change to Scene 1");
        button.setOnAction(evt -> sceneSwapper.run());
        VBox results = new VBox(20, new Label("Welcome to Scene 2"), button);
        results.setPadding(new Insets(50));

        return results;
    }

}