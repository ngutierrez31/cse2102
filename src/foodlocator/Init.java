package foodlocator;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.geometry.Pos;
import javafx.geometry.Insets;


import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.paint.Color;

import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;


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
		
		/**************************/
		/* Step One: Title Screen */
		/**************************/
		
		// Set up the GridPane, Scene, and apply the Scene to the Stage
		// GridPanes supply a Grid of Layout components, into which we can place buttons and fields with ease.
		GridPane titlePane = new GridPane();
		titlePane.setAlignment(Pos.TOP_LEFT);
		titlePane.setHgap(width/32);
		titlePane.setVgap(height/32);
		titlePane.setPadding(new Insets(height/64,width/64,height/64,width/64));
		
		// Initialize our scene and assign stage a scene
		Scene titleScene = new Scene(titlePane, width, height);
		initialStage.setScene(titleScene);
		initialStage.setTitle("Title");
		
		// Creates text and gives it a font
		final Text foodLocatorTitle = new Text( width/16, height/8, "Food Locator");
		foodLocatorTitle.setFont(Font.font("Arial", FontWeight.NORMAL, 40));
		
		final Text foodLocatorBody = new Text( width/8, height*3/16, "Find fast food restaurants and health stores near you.");
		foodLocatorBody.setFont(Font.font("Arial", FontWeight.NORMAL, 30));
		foodLocatorBody.setWrappingWidth(width*3/4);
		
		// Defines a new button, gives it a label, and a preferred with/height
		Button searchZipButton = new Button("Locate within zip code");
		searchZipButton.setPrefWidth(width*5/16);
		searchZipButton.setPrefHeight(height/4);
		
		Button searchAddressButton = new Button("Locate near address");
		searchAddressButton.setPrefWidth(width*5/16);
		searchAddressButton.setPrefHeight(height/4);
		
		// Sets up functionality for the buttons
		searchZipButton.setOnAction(new EventHandler<ActionEvent>() {
		    public void handle(ActionEvent e) {
		        foodLocatorTitle.setFill(Color.RED);	// TODO: Get rid of this debug code!
		    }
		});
		
		searchAddressButton.setOnAction(new EventHandler<ActionEvent>() {
		    public void handle(ActionEvent e) {
		        foodLocatorTitle.setFill(Color.BLUE);	// TODO: Get rid of this debug code
		    }
		});
		
		// This adds the elements to the titlePane grid
		//titlePane.add(element, Column, Row, Column Span, Row Span)
		titlePane.add(foodLocatorTitle, 0, 0, 3, 1);
		titlePane.add(foodLocatorBody, 2, 1, 3, 1);
		titlePane.add(searchZipButton, 2, 4, 2, 1);
		titlePane.add(searchAddressButton, 4, 4, 2, 1);
		
		/***************************/
		/* Step Two: Search Screen */
		/***************************/
		
		GridPane searchPane = new GridPane();

		searchPane.setAlignment(Pos.TOP_LEFT);
		searchPane.setHgap(width/32);
		searchPane.setVgap(height/32);
		searchPane.setPadding(new Insets(height/64,width/64,height/64,width/64));
		
		Scene searchScene = new Scene(searchPane, width, height);
		
		// TODO: Find out how to switch scenes on button press
		
		// This launches the actual window, once all is said and done
		initialStage.show();
	}
}
