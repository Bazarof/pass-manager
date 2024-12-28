package org.openfx.layoutclasses;

import javafx.util.Builder;
import javafx.scene.layout.Region;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.scene.control.Button;

public class MainLayoutBuilder implements Builder<Region> {

    private Region loginComponent;
    private Region appContent; 

    @Override
    public Region build() {

        BorderPane mainLayout = new BorderPane();

        // Sublayouts 
        loginComponent = new LayoutLoginBuilder(() -> {
            mainLayout.setCenter(appContent);
            mainLayout.setLeft(new LayoutLeftOptionsBuilder().build());
            }).build();

        appContent = new LayoutContentBuilder(() -> {
            mainLayout.setCenter(loginComponent);
            mainLayout.setLeft(null);
            }).build();
        
        mainLayout.setCenter(loginComponent);
        
        return mainLayout;
    }

}