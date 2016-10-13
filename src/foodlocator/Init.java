package foodlocator;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/* Software map:
 *  - Init (launches the GUI)
 *  - "Search" class with relevant builders
 *  - Text parser, interface
 *   - Zip parser
 *   - Address parser
 *  - And then all the confusing backend stuff
 * 
 */


public class Init extends Application {


	
	public static void main(String[] args){
		launch(args);
	}
	
	public void start(Stage initialStage){
	
		// width and height define the window size in pixels
		//  Expressing everything in terms of width and height
		//  will make it easy to change it later on.
		int width;
		int height;
		
		width = 640;
		height = 640;
		
		// Set up the BorderPane, Scene, and apply the Scene to the Stage
		BorderPane titlePane = new BorderPane();
		
		Scene titleScene = new Scene(titlePane, width, height);
		initialStage.setScene(titleScene);
		initialStage.setTitle("Title");
		
		// Create the title text, and add it to the titlePane's children
		Text foodLocatorTitle = new Text( width/16, height/8, "Food Locator");
		foodLocatorTitle.setFont(Font.font("Arial", FontWeight.NORMAL, 40));
		
		titlePane.getChildren().add(foodLocatorTitle);
		
		initialStage.show();
	
	
	
	}
}
