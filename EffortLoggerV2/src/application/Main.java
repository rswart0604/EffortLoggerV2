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

/**
 * Author: Sankritya Thakur
 * Datetime: Oct 29 10:03pm
 * Description: The Main class is the entry point for the JavaFX application.
 * It initializes and starts the primary stage with the "main_menu.fxml" layout.
 * The window dimensions are set to 300x500 pixels and titled "Main menu".
 * In case of any exceptions during the layout loading or application startup, it prints the stack trace.
 * 
 */

public class Main extends Application {
	public static void main(String[] args) {
        launch(args);
    }
    
    @Override
	public void start(Stage primaryStage) {
		try {
			EffortLoggerData.getInstance().setSinglePrototype(false);
			Parent root = FXMLLoader.load(getClass().getResource("/login.fxml"));
			Scene scene = new Scene(root, 1000, 560);
			primaryStage.setTitle("Main menu");
			primaryStage.setScene(scene);
			primaryStage.show();			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
