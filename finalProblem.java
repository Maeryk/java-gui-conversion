///Author@Gordon Bittner
///This problem should allow the user to enter a number (integer)
/// and display the binary equivalent.
/// fields must be centered
///importing the necessary javafx components
import javafx.application.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javax.swing.*;

public class finalProblem extends Application {
	///creating the necessary fields / variables for the GUI
	private VBox mainBox = new VBox();
	private HBox buttonBox = new HBox();
	private HBox lineBox = new HBox();
	private Label textLabel = new Label("Enter an integer: ");
	private TextField intField = new TextField();
	private Button conversion = new Button("Convert to Binary");
	
	
	private Scene scene;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		///setting alignment / spacing values for the fields
		lineBox.setAlignment(Pos.TOP_CENTER);
		buttonBox.setAlignment(Pos.BOTTOM_CENTER);
		buttonBox.setAlignment(Pos.TOP_CENTER);
		mainBox.setPadding(new Insets(15,15,15,15));
		buttonBox.setPadding(new Insets(15,15,15,15));
		mainBox.setSpacing(15);
		buttonBox.setSpacing(15);
		intField.setPrefWidth(75);
		textLabel.setPrefWidth(100);
		conversion.setPrefWidth(125);
		conversion.setOnAction( e -> {
			if(e.getSource() instanceof Button) {
				try{
					int starting = Integer.parseInt(intField.getText());
					String converted = calculate(starting);
					JOptionPane.showMessageDialog(null, "Binary: " + converted);
				} catch(Exception f) {
					JOptionPane.showMessageDialog(null, "Not a valid value.");
				}
			}
		});
		///adding fields to the hbox / vbox areas
		buttonBox.getChildren().add(conversion);
		lineBox.getChildren().addAll(textLabel, intField);
		mainBox.setCenterShape(true);
		mainBox.getChildren().addAll(lineBox, buttonBox);
		///setting the scene
		scene = new Scene(mainBox, 300, 150);
		primaryStage.setTitle("Conversion to Binary");
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();
	}
	
	public static void main(String[] args){ 
	launch(args);
	}
	///recursive function to create a binary string
	public static String calculate (int start) {
		String binary = "";
		if(start > 0) {
			return calculate(start/2) + Integer.toString(start%2);
		}
		else {
			return binary;
		}
	}
}

				
		
		
		