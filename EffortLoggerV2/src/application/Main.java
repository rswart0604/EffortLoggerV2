package application;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;

public class Main extends Application {
	public static void main(String[] args) {
        launch(args);
    }
    
    @Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/main_menu.fxml"));
			Scene scene = new Scene(root, 300, 500);
			primaryStage.setTitle("Main menu");
			primaryStage.setScene(scene);
			primaryStage.show();
			
			
//			BorderPane root = new BorderPane();
//			Scene scene = new Scene(root, 1000, 1000);
//			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
//			primaryStage.setScene(scene);
//			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
