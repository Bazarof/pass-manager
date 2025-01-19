package org.openjfx.layout.sidebaroptions;

import org.openjfx.classes.utilities.PasswordGenerator;

import javafx.util.Builder;
import javafx.scene.layout.Region;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.geometry.Pos;

public class LayoutPasswordGeneratorBuilder implements Builder<Region> {

    private PasswordGenerator passwordGenerator;

    // controls
    private TextField passwordField;
    private Button btnGenerator;
    private Button btnSave;
    private Button btnClean;

    public LayoutPasswordGeneratorBuilder() {

        initializeComponents();

    }

    @Override
    public Region build(){

        GridPane passwordGeneratorForm = new GridPane(){{
            setAlignment(Pos.CENTER);
            setHgap(10);
            setVgap(10);
        }};

        passwordGeneratorForm.add(passwordField, 0, 0);
        passwordGeneratorForm.setColumnSpan(passwordField, 4);

        passwordGeneratorForm.add(btnGenerator, 4, 0);

        passwordGeneratorForm.add(btnSave, 0, 1);

        passwordGeneratorForm.add(btnClean, 1, 1);

        return passwordGeneratorForm;

    }

    public void initializeComponents() {

        passwordField = new TextField();
        passwordField.setPrefWidth(260);

        btnGenerator = new Button("Generate password");

        btnGenerator.setOnAction(evt -> {
            passwordGenerator = new PasswordGenerator();
        });

        btnClean = new Button("Clean");
        btnClean.setPrefWidth(60);
        btnSave = new Button("Save");
        btnSave.setPrefWidth(60);
    }

}