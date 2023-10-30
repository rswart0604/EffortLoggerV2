package application;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.MenuButton;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Author: Om Sunit Chaudhari
 * Datetime: Oct 29 9:59pm
 * Description: This class, EffortLoggingDisplayController, manages the display and searching of effort logs.
 * The user interface consists of fields for input (project, lifecycle, effort category) and a TextArea to show the matching logs.
 * Multiple ArrayLists internally capture and filter data based on user search criteria.
 * The back button provides navigation functionality, guiding users to the previous screen.
 * 
 */

public class EffortLoggingDisplayController {

	@FXML
	private TextField projectField;
	@FXML
	private Button searchButton;
	@FXML
	private TextArea effortLogDisplayArea;
	@FXML
	private Button backButton;
	@FXML
	private TextField lifeCycleField; 
	@FXML
	private TextField effortCategoryField;
	
	// Lists for storing various effort logging data
	ArrayList<LocalDateTime> startTimes = new ArrayList<>();
	ArrayList<LocalDateTime> endTimes = new ArrayList<>();
	ArrayList<String> projects = new ArrayList<>();
	ArrayList<String> lifeCycles = new ArrayList<>();
	ArrayList<String> effortCategories = new ArrayList<>();
	ArrayList<String> items = new ArrayList<>();
	
	// Lists for tracking indices relevant to the current view and search results
	ArrayList<Integer> currentIndices = new ArrayList<>();
	ArrayList<Integer> showIndices = new ArrayList<>();
	
	
	
	
	// Filter displayed logs based on effort category input
    @FXML
	private void effortCategoryTyped() {
		showIndices.clear();
		String effortCat = effortCategoryField.getText();
		if (effortCat.equals("")) {
			showIndices.addAll(currentIndices);
		}
		for (int i=0; i<currentIndices.size(); i++) {
			if (effortCategories.get(i).equals(effortCat)) {
				showIndices.add(i);
			}
		}
		setTextArea();
	}
	
	@FXML
	// Filter displayed logs based on life cycle input
	private void lifeCycleTyped() {
		showIndices.clear();
		String lifeCycle = lifeCycleField.getText();
		if (lifeCycle.equals("")) {
			showIndices.addAll(currentIndices);
		}
		for (int i=0; i<currentIndices.size(); i++) {
			if (lifeCycles.get(i).equals(lifeCycle)) {
				showIndices.add(i);
			}
		}
		setTextArea();
	}
	
	@FXML
	// Search and display logs based on project name
	private void searchClicked() {
		currentIndices.clear();
		showIndices.clear();
		String project = projectField.getText();
		for (int i=0; i<projects.size(); i++) {
			if (projects.get(i).equals(project)) {
				currentIndices.add(i);
				showIndices.add(i);
			}
		}
		setTextArea();
	}
	
	// Display the relevant effort logs in the TextArea component
	private void setTextArea() {
		String toSet = "";
		for (Integer i : showIndices) {
			toSet += "Effort " + i.toString() + "\n";
			toSet += "Start: " + startTimes.get(i).toString() + "\n";
			toSet += "End: " + endTimes.get(i).toString() + "\n";
			toSet += "Project: " + projects.get(i).toString() + "\n";
			toSet += "Life cycle: " + lifeCycles.get(i).toString() + "\n";
			toSet += "Effort category: " + effortCategories.get(i).toString() + "\n";
			toSet += "Item: " + items.get(i).toString() + "\n\n\n";
		}
		effortLogDisplayArea.setText(toSet);
	}
	
	
	
    @FXML
    // Navigate back to the main menu or post login screen
    private void backClicked(ActionEvent event) {
    	if (EffortLoggerData.getInstance().isSinglePrototype()) {
	    	try {
		    	Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		    	Parent root = FXMLLoader.load(getClass().getResource("/main_menu.fxml"));
				Scene scene = new Scene(root, 300, 500);
				stage.setTitle("Main menu");
				stage.setScene(scene);
	    	} catch (Exception e) {
	    		e.printStackTrace();
	    	}
		} else {
			try {
		    	Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		    	Parent root = FXMLLoader.load(getClass().getResource("/PostLoginScreen.fxml"));
				Scene scene = new Scene(root, 1000, 560);
				stage.setTitle("Main menu");
				stage.setScene(scene);
	    	} catch (Exception e) {
	    		e.printStackTrace();
	    	}
		}
    }

    @FXML
    // Initialize the controller, loading mock data or real data as appropriate
    private void initialize() {
        // method stub, just initialize everything here
    	EffortLoggerData data = EffortLoggerData.getInstance();
    	if (data.isSinglePrototype()) {
	    	startTimes.add(LocalDateTime.now());
	    	startTimes.add(LocalDateTime.now());
	    	startTimes.add(LocalDateTime.now());
	    	endTimes.add(LocalDateTime.now());
	    	endTimes.add(LocalDateTime.now());
	    	endTimes.add(LocalDateTime.now());
	    	projects.add("Business project");
	    	projects.add("Business project");
	    	projects.add("Development project");
	    	lifeCycles.add("Verifying");
	    	lifeCycles.add("Outlining");
	    	lifeCycles.add("Drafting");
	    	effortCategories.add("Plans");
	    	effortCategories.add("Deliverables");
	    	effortCategories.add("Deliverables");
	    	items.add("Test Cases");
	    	items.add("Conceptual Design");
	    	items.add("Risk Management Plan");
    	} else {
    		startTimes = data.getStartTimes();
    		endTimes = data.getEndTimes();
    		projects = data.getProjects();
    		lifeCycles = data.getLifeCycles();
    		effortCategories = data.getEffortCategories();
    		items = data.getItems();
    	}
    }
	
}
