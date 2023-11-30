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

// Author: Ryan Swart

public class PlanningPokerFirstRoundController {
	
	// screen elements
	@FXML
	private Button createEstimateButton;
	@FXML
	private Text storyPointsText;
	@FXML
	private Button nextButton;
	@FXML
	private ScrollPane scrollPane;
	@FXML
	private TextField newProjectField;
	@FXML
	private TextArea userStoryTextArea;
	@FXML
	private TextArea keyWordsTextArea;
	@FXML
	private Button editButton;
	
	// data for our planning poker (singleton)
	PlanningPokerData data = PlanningPokerData.getInstance();
	
	// store which boxes are checked
	private ArrayList<Integer> selectedList = data.selectedList;
	
	// edit the current user story
	@FXML
	private void editClicked() {
		data.currentStory = userStoryTextArea.getText();
		data.currentProject = newProjectField.getText();
		data.currentKeys = keyWordsTextArea.getText().split(",");
	}
	
	// calculate the average of the checked boxes and display it
	@FXML
	private void estimateClicked() {
		int sum = 0;
		int count = 0;
		for (Integer i : selectedList) {
			sum += data.effortPoints.get(i);
			count++;
		}
		if (count != 0) {
			sum = (int) sum/count;
		}
		storyPointsText.setText(Integer.toString(sum));
	}
	
	// take us to the next screen (subsequent rounds)
	@FXML
	private void nextClicked(ActionEvent event) {
		try {
	    	Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
	    	Parent root = FXMLLoader.load(getClass().getResource("/planning_poker_subsequent_round.fxml"));
			Scene scene = new Scene(root, 1000, 1000);
			stage.setTitle("Main menu");
			stage.setScene(scene);
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
	}
	
	// make a gridpane and initialize data
	@FXML
	private void initialize() {
		if (data.effortPoints.size() <= 0) { // make some dummy data. PROTOTYPE
			for (int i=0; i<10; i++) {
				data.effortPoints.add(i);
				data.userStories.add("THIS IS AN EXAMPLE USER STORY");
				data.keyWords.add(new String[] {"here", "are", "keys"});
			}
			data.effortPoints.add(100); // this shows us that we can find a unique story
			data.userStories.add("This is a user story with matching keywords!");
			data.keyWords.add(new String[] {"one", "two", "three"});
		}
		
		GridPane gridPane = new GridPane();  
		
		// add cols
		ColumnConstraints col1 = new ColumnConstraints();
		col1.setPrefWidth(50);
		ColumnConstraints col2 = new ColumnConstraints();
		col2.setPrefWidth(400);
		ColumnConstraints col3 = new ColumnConstraints();
		col3.setPrefWidth(70);
		gridPane.getColumnConstraints().addAll(col1, col2, col3);

		// add the data into the columns
		for (int i=0; i<data.userStories.size(); i++) {
			
			// this logic selects the stories based on the keys of the current story
			String[] currentWords = data.keyWords.get(i);
			boolean wordsMatch = false;
			for (String word : currentWords) {
				for (String otherWord : data.currentKeys) {
					if (otherWord.equals(word)) {
						wordsMatch = true;
						selectedList.add(i);
					}
				}
			}
			
			// actually make the box
			CheckBox cbox = new CheckBox();
			cbox.setSelected(wordsMatch);
			
			final int j = i;
			
			// if box selected, add story to list
			cbox.setOnAction(e -> {
				if (cbox.isSelected()) {
					selectedList.add(j);
					for (int k=0; k<selectedList.size(); k++) {
						System.out.println(selectedList.get(k));
					}
					System.out.println();
				} else {
					selectedList.remove(selectedList.indexOf(j));
				}
			});
			
			// add cols to pane
			gridPane.add(cbox, 0, i);
			Label l = new Label(data.userStories.get(i));
			l.setWrapText(true);
			gridPane.add(l, 1, i);
			Label l2 = new Label(data.effortPoints.get(i).toString());
			gridPane.add(l2, 2, i);
		}
		
		gridPane.setGridLinesVisible(true);

		// add gridpane to scrollpane
		scrollPane.setContent(gridPane);
		
		// get our current stuff
		newProjectField.setText(data.currentProject);
		userStoryTextArea.setText(data.currentStory);
		keyWordsTextArea.setText(String.join(",", data.currentKeys));

	}
}
