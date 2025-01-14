package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class mainApp extends Application {
  private static Stage primaryStage;
  private AnchorPane rootLayout;

  @Override
  public void start(Stage primaryStage) {
	  mainApp.primaryStage = primaryStage;
      mainApp.primaryStage.setTitle("Login");
      mainApp.primaryStage.initStyle(StageStyle.UNDECORATED);

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
  public static Stage getPrimaryStage() {
	  return primaryStage;
  }

  public static void main(String[] args) {
      launch(args);
  }}
