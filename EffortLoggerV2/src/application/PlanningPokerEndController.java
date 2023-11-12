package application;
import javafx.scene.control.ScrollPane;
import java.util.ArrayList;
import java.util.Arrays;

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

public class PlanningPokerEndController {
	
	@FXML
	private TextArea userStoryTextArea;
	@FXML
	private TextArea keyWordsTextArea;
	@FXML
	private TextArea notesTextArea;
	@FXML
	private TextField storyPointsField;
	@FXML
	private Button submitButton;
	@FXML
	private Button backButton;
	
	PlanningPokerData data = PlanningPokerData.getInstance();
	
	@FXML
	private void submitClicked() {
		data.effortPoints.add(Integer.parseInt(storyPointsField.getText()));
		data.userStories.add(userStoryTextArea.getText());
		data.notes.add(notesTextArea.getText());
		data.keyWords.add(keyWordsTextArea.getText().split(","));

		System.out.println(Arrays.toString(data.effortPoints.toArray()));
		System.out.println(Arrays.toString(data.userStories.toArray()));
		System.out.println(Arrays.toString(data.notes.toArray()));
		System.out.println(Arrays.toString(data.keyWords.toArray()));
	}
	
	@FXML
	private void backClicked(ActionEvent event) {
		try {
	    	Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
	    	Parent root = FXMLLoader.load(getClass().getResource("/PostLoginScreen.fxml"));
			Scene scene = new Scene(root, 1000, 1000);
			stage.setTitle("Main menu");
			stage.setScene(scene);
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
	}
	
	@FXML
	private void initialize() {
		storyPointsField.setText(Integer.toString(data.currentPoints));
		userStoryTextArea.setText(data.currentStory);
		keyWordsTextArea.setText(String.join(",", data.currentKeys));
	}
	
	
	
	
	
}
