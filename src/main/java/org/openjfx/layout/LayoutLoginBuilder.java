package org.openjfx.layout;

import org.openjfx.classes.utilities.Stages;

import java.lang.Runnable;
import javafx.util.Builder;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Region;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.text.*;
import java.util.LinkedHashMap;

public class LayoutLoginBuilder implements Builder<Region>{

    private Text sceneTitle;

    // controls
    private Label emailLabel;
    private Label passwordLabel;
    private TextField emailField;
    private PasswordField passwordField;
    private Button btnLogin;

    public LayoutLoginBuilder(Stage currentStage){
        buttonLogin(currentStage);
        initializeComponents();
    }

    // Adds the controls to the GridPane
    @Override
    public Region build() {

        GridPane loginForm = new GridPane(){{
            setAlignment(Pos.CENTER);
            setHgap(10);
            setVgap(10);
            //setPadding(new Insets(25, 25, 25, 25));
        }};

        loginForm.add(sceneTitle, 0, 0, 2, 1);

        loginForm.add(emailLabel, 0, 1);
        loginForm.add(emailField, 0, 2, 3, 1);

        loginForm.add(passwordLabel, 0, 3);
        loginForm.add(passwordField, 0, 4, 3, 1);

        loginForm.add(btnLogin, 2, 5);

        //loginForm.setGridLinesVisible(true);

        return loginForm;
    }

    private void initializeComponents() {
        title();
        labels();
        fields();
    }

    private void title() {

        sceneTitle = new Text("Welcome");
        sceneTitle.setFont(Font.font("Tahoma", FontWeight.BOLD, 40));

    }

    private void labels() {

        Font labelFont = Font.font("Tahoma", FontWeight.NORMAL, 20);

        emailLabel = new Label("E-mail");
        emailLabel.setFont(labelFont);

        passwordLabel = new Label("Password");
        passwordLabel.setFont(labelFont);

    }

    private void fields() {

        Font fieldFont = Font.font("Tahoma", FontWeight.NORMAL, 16);

        emailField = new TextField();
        emailField.setFont(fieldFont);

        passwordField = new PasswordField();
        passwordField.setFont(fieldFont);

    }

    private void buttonLogin(Stage currentStage) {

        Font btnFont = Font.font("Tahoma", FontWeight.NORMAL, 16);

        btnLogin = new Button("Login");
        btnLogin.setFont(btnFont);
        btnLogin.setOnAction(evt -> {

            // AUTHENTICATE USER

            Stages.closeCurrentStage(currentStage);
            Stages.openMainPaneStage();
        });

    }
}