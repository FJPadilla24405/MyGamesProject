package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import application.mainApp;

public class Login {
    private double xOffset = 500;
    private double yOffset = 0;
    
    @FXML
    private HBox header;

    @FXML
    private BorderPane bpFondo;

    @FXML
    private Button btnLogin;

    @FXML
    private Label btnRegister;

    @FXML
    void headerDrag(MouseEvent event) {
    	 header.setOnMouseDragged(event1 -> {
             mainApp.getPrimaryStage().setX(event1.getScreenX() - xOffset);
             mainApp.getPrimaryStage().setY(event1.getScreenY() - yOffset);
         });   		
    }
    
    @FXML
    void headerPressed(MouseEvent event) {
    	header.setOnMousePressed(event1 -> {
            xOffset = event1.getSceneX();
            yOffset = event1.getSceneY();
        });
    }
    
    @FXML
    void loginEntered(MouseEvent event) {
    	btnLogin.setCursor(Cursor.HAND);
    }

    @FXML
    void loginExited(MouseEvent event) {
    	btnLogin.setCursor(Cursor.DEFAULT);
    }

    @FXML
    void loginPressed(ActionEvent event) {
    	System.out.println("LOGIN");
    }

    
    
    @FXML
    void registerEntered(MouseEvent event) {
    	btnRegister.setCursor(Cursor.HAND);
    }

    @FXML
    void registerExited(MouseEvent event) {
    	btnRegister.setCursor(Cursor.DEFAULT);
    }

    @FXML
    void registerPressed(MouseEvent event) {
    	System.out.println("REGISTER");
    }
    

}
