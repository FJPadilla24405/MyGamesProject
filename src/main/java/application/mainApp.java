package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class mainApp extends Application {
  private Stage primaryStage;
  private AnchorPane rootLayout;

  @Override
  public void start(Stage primaryStage) {
      this.primaryStage = primaryStage;
      this.primaryStage.setTitle("Login");
      this.primaryStage.initStyle(StageStyle.UNDECORATED);

      try {
          FXMLLoader loader = new FXMLLoader();
          loader.setLocation(mainApp.class.getResource("/views/Login.fxml"));
          rootLayout = (AnchorPane) loader.load();
          
          Scene scene = new Scene(rootLayout);
          scene.getStylesheets().add(getClass().getResource("mainStyle.css").toExternalForm());
          
          primaryStage.setScene(scene);
          primaryStage.show();
      } catch (IOException e) {
          e.printStackTrace();
      }
  }
  
  /**
   * Returns the main stage.
   * @return
   */
  public Stage getPrimaryStage() {
	  return primaryStage;
  }

  public static void main(String[] args) {
      launch(args);
  }}
