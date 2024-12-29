package org.openjfx.layoutclasses;

import java.lang.Runnable;
import javafx.util.Builder;
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
import java.util.HashMap;

public class LayoutLoginBuilder implements Builder<Region>{

    private Runnable sceneSwapper;

    private BorderPane mainLayoutRef;

    private HashMap<String, Region> nav;

    private Text sceneTitle;

    // controls
    private Label emailLabel;
    private Label passwordLabel;
    private TextField emailField;
    private PasswordField passwordField;
    private Button btnLogin;

    public LayoutLoginBuilder(Runnable sceneSwapper, HashMap<String, Region> nav, BorderPane mainLayoutRef) {

        this.sceneSwapper = sceneSwapper;
        this.nav = nav;
        this.mainLayoutRef = mainLayoutRef;
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
        buttonLogin();
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

    private void buttonLogin() {

        Font btnFont = Font.font("Tahoma", FontWeight.NORMAL, 16);

        btnLogin = new Button("Login");
        btnLogin.setFont(btnFont);
        btnLogin.setOnAction(evt -> sceneSwapper.run());

    }
}