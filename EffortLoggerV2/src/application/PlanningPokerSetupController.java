package application;
import javafx.scene.control.ScrollPane;
import java.util.ArrayList;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;



public class PlanningPokerSetupController {
	
	@FXML
	private TextField newProjectField;
	@FXML
	private TextArea userStoryTextArea;
	@FXML
	private TextArea keyWordsTextArea;
	@FXML
	private Button continueButton;

	PlanningPokerData data = PlanningPokerData.getInstance();
	
	
	@FXML
	private void continueClicked(ActionEvent event) {
		System.out.println("hello1");
		data.currentStory = userStoryTextArea.getText();
		data.currentProject = newProjectField.getText();
		data.currentKeys = keyWordsTextArea.getText().split(",");
		
		System.out.println("hello");
		
		try {
	    	Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
	    	Parent root = FXMLLoader.load(getClass().getResource("/planning_poker_first_round.fxml"));
			Scene scene = new Scene(root, 1000, 1000);
			stage.setTitle("Main menu");
			stage.setScene(scene);
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
	}
	
	@FXML
	private void initialize() {
		
	}
	
	
	
	
	
}
