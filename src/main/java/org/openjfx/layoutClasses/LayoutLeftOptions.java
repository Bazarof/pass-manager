package org.openfx.layoutclasses;

import javafx.util.Builder;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.layout.Pane;


class LayoutLeftOptionsBuilder implements Builder<Region>{

    public LayoutLeftOptionsBuilder() {

    }

    @Override
    public Region build() {

        VBox result = new VBox();
        result.setStyle("-fx-background-color: #265586");

        Pane buttonPane = new Pane();

        buttonPane.setPrefSize(40, 30);
        buttonPane.setStyle("-fx-background-color: #bc4d3c");

        result.getChildren().add(buttonPane);

        return result;
    }

}