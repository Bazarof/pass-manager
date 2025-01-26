package org.openjfx.layout.sidebaroptions;

import org.openjfx.classes.utilities.PasswordGenerator;

import javafx.util.Builder;
import javafx.scene.layout.Region;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.Priority;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.geometry.Pos;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

public class LayoutPasswordGeneratorBuilder implements Builder<Region> {

    // controls
    private TextField passwordField;
    private Button btnGenerator;
    private Button btnCopy;
    private Button btnSave;
    private Button btnClean;

    // password verification message layout
    private VBox messageBox;

    private GridPane passwordGeneratorForm;

    public LayoutPasswordGeneratorBuilder() {

        initializeComponents();

    }

    @Override
    public Region build(){

        passwordGeneratorForm = new GridPane(){{
            setAlignment(Pos.CENTER);
            setHgap(10);
            setVgap(10);
        }};

        passwordGeneratorForm.add(passwordField, 0, 0);
        passwordGeneratorForm.setColumnSpan(passwordField, 4);

        passwordGeneratorForm.add(btnGenerator, 4, 0);


        passwordGeneratorForm.add(btnSave, 0, 2);
        passwordGeneratorForm.add(btnClean, 1, 2);

        return passwordGeneratorForm;

    }

    public void initializeComponents() {

        passwordField = new TextField();
        passwordField.setPrefWidth(260);


	passwordField.textProperty().addListener(new ChangeListener<String>() {
	
	    @Override
	    public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {

		if(passwordGeneratorForm.getChildren().contains(messageBox)){
		    passwordGeneratorForm.getChildren().remove(messageBox);
		    messageBox.getChildren().clear();
		}
	    
		//Check password
		for(String message: PasswordGenerator.verifyPassword(newValue.toCharArray())) {
		    messageBox.getChildren().add(new Text("\u2022 " + message));
		}

		
		if(!messageBox.getChildren().isEmpty()) {
		
		    passwordGeneratorForm.add(messageBox, 0, 1);
        	    passwordGeneratorForm.setColumnSpan(messageBox, 4);
		
		}
	    }
	
	});

	messageBox = new VBox();
	messageBox.getStyleClass().add("password-message-box");

	// Same thing can be achived with
	//passwordField.textProperty().addListener((observable, oldValue, newValue) -> System.out.println(newValue) );

        btnGenerator = new Button("Generate password");
        btnGenerator.setOnAction(evt -> {

            passwordField.setText(new String(PasswordGenerator.generatePassword()));

        });

        

        btnSave = new Button("Save");
        btnSave.setPrefWidth(60);

        btnClean = new Button("Clean");
        btnClean.setPrefWidth(60);
        btnClean.setOnAction(evt -> {

            passwordField.setText("");

        });
    }

}
