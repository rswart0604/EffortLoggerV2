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
	
	
	ArrayList<LocalDateTime> startTimes = new ArrayList<>();
	ArrayList<LocalDateTime> endTimes = new ArrayList<>();
	ArrayList<String> projects = new ArrayList<>();
	ArrayList<String> lifeCycles = new ArrayList<>();
	ArrayList<String> effortCategories = new ArrayList<>();
	ArrayList<String> items = new ArrayList<>();
	
	ArrayList<Integer> currentIndices = new ArrayList<>();
	ArrayList<Integer> showIndices = new ArrayList<>();
	
	
	
	
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
    private void backClicked(ActionEvent event) {
    	try {
	    	Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
	    	Parent root = FXMLLoader.load(getClass().getResource("/main_menu.fxml"));
			Scene scene = new Scene(root, 300, 500);
			stage.setTitle("Main menu");
			stage.setScene(scene);
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    }

    @FXML
    private void initialize() {
        // method stub, just initialize everything here
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
    	
//    	EffortLoggingData effortData = EffortLoggingData.getInstance();
//    	System.out.println(effortData.getEffortCategories());
    	
    }
	
}
