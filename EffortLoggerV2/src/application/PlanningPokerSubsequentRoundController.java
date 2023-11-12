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

public class PlanningPokerSubsequentRoundController {

	@FXML
	private TextField newProjectField;
	@FXML
	private TextArea userStoryTextArea;
	@FXML
	private TextArea keyWordsTextArea;
	@FXML
	private Button editButton;
	@FXML
	private ScrollPane scrollPane;
	@FXML
	private Button estimateButton;
	@FXML
	private Button nextButton;
	@FXML
	private Text storyPointsText;
	@FXML
	private TextField biasTextField;
	
	
	
	PlanningPokerData data = PlanningPokerData.getInstance();
	private ArrayList<Integer> selectedList = data.selectedList;
	private ArrayList<TextField> weightFields = new ArrayList<>();
	
	@FXML
	private void nextClicked(ActionEvent event) {
		
		try {
	    	Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
	    	Parent root = FXMLLoader.load(getClass().getResource("/planning_poker_end.fxml"));
			Scene scene = new Scene(root, 1000, 1000);
			stage.setTitle("Main menu");
			stage.setScene(scene);
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
	}
	
	@FXML private void estimateClicked() {
		double sum = 0;
		for (int i=0; i<data.effortPoints.size(); i++) {
			if (selectedList.contains(i)) {
				TextField weightBox = weightFields.get(i);
				double weight = Double.parseDouble(weightBox.getText());
				sum += data.effortPoints.get(i) * weight;
			}
		}
		
		int bias = 0;
		if (!biasTextField.getText().equals("")) {
			bias = Integer.parseInt(biasTextField.getText());
		}
		sum += bias;
		data.currentPoints = (int) sum;
		storyPointsText.setText(Integer.toString((int) sum));
	}
	
	@FXML
	private void editClicked() {
		data.currentStory = userStoryTextArea.getText();
		data.currentProject = newProjectField.getText();
		data.currentKeys = keyWordsTextArea.getText().split(",");
	}
	
	@FXML
	private void initialize() {
		GridPane gridPane = new GridPane();  
		
		ColumnConstraints col1 = new ColumnConstraints();
		col1.setPrefWidth(50);
		ColumnConstraints col2 = new ColumnConstraints();
		col2.setPrefWidth(370);
		ColumnConstraints col3 = new ColumnConstraints();
		col3.setPrefWidth(50);
		ColumnConstraints col4 = new ColumnConstraints();
		col4.setPrefWidth(50);
		
		gridPane.getColumnConstraints().addAll(col1, col2, col3, col4);
		
		
		for (int i=0; i<data.userStories.size(); i++) {
			CheckBox cbox = new CheckBox();
			if (selectedList.indexOf(i) > -1) {
				cbox.setSelected(true);
			} else {
				cbox.setSelected(false);
			}
			final int j = i;
			
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
			
			TextField w = new TextField();
			w.setText("1.0");
			weightFields.add(w);
			
			gridPane.add(cbox, 0, i);
			Label l = new Label(data.userStories.get(i));
			l.setWrapText(true);
			gridPane.add(l, 1, i);
			Label l2 = new Label(data.effortPoints.get(i).toString());
			gridPane.add(l2, 2, i);
			gridPane.add(w, 3, i);
		}
		gridPane.setGridLinesVisible(true);
		scrollPane.setContent(gridPane);
		
		newProjectField.setText(data.currentProject);
		userStoryTextArea.setText(data.currentStory);
		keyWordsTextArea.setText(String.join(",", data.currentKeys));
		
		
	}
	
}
