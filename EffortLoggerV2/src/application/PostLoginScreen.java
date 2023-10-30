package application;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PostLoginScreen extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create the VBox layout
        VBox root = new VBox(20);
        root.setAlignment(Pos.CENTER);
        root.setPrefSize(400, 300);

        // Create the greeting label
        Label greetingLabel = new Label("Hello, User!");
        greetingLabel.setStyle("-fx-font-size: 24px;");

        // Create the buttons
        Button effortLoggerInputButton = createButton("EffortLogger Input");
        Button effortLoggerDisplayButton = createButton("EffortLogger Display");
        Button effortLoggerDeletionButton = createButton("EffortLogger Deletion");
        Button storyInputButton = createButton("Story Input");

        // Add the label and buttons to the VBox
        root.getChildren().addAll(
                greetingLabel,
                effortLoggerInputButton,
                effortLoggerDisplayButton,
                effortLoggerDeletionButton,
                storyInputButton
        );

        // Set up the scene and stage
        Scene scene = new Scene(root);
        primaryStage.setTitle("Post Login Screen");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private Button createButton(String text) {
        Button button = new Button(text);
        button.setPrefWidth(200);
        button.setStyle("-fx-font-size: 18px;");
        // You can add event handlers here if needed
        // For example:
        // button.setOnAction(event -> handleButtonClick(text));
        return button;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
