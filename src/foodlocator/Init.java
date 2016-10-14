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

import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

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
	
		/* What I'm doing right now
		 * 	Get the back button to work
		 *  Set up the search module (searchType, storeTypes, field)
		 *  Set up the result module
		 *  Set up a separate stage and pane for the results
		 *  Set up the text parsers
		 *  Have the "go" button change the stage (and scene), as well as construct a search (and check to see if the search is good)
		 */
		
		// width and height define the window size in pixels
		//  Expressing everything in terms of width and height
		//  will make it easy to change it later on.
		int width;
		int height;
		
		final int[] type; 							// type will represent the kind of search we are doing.
		type = new int[1];							// We can only pass final variables into the button action; by passing an array, we can change this value.
		final Stage currentStage = initialStage;	// A final pointer to initialStage let's us access it from the button action
	
		width = 640;
		height = 640;
		type[0] = -1; // -1 is "not-set", 0 is "By zip code", 1 is "By address"
	
		/// Setting up the scenes we will be using
		// Set up the GridPane, Scene, and apply the Scene to the Stage
		// GridPanes supply a Grid of Layout components, into which we can place buttons and fields with ease.
		// Scene 1
		GridPane titlePane = new GridPane();
		titlePane.setAlignment(Pos.CENTER);
		titlePane.setHgap(width/32);
		titlePane.setVgap(height/32);
		titlePane.setPadding(new Insets(height/64,width/64,height/64,width/64));
		// Initialize our scene and assign stage a scene
		final Scene titleScene = new Scene(titlePane, width, height);
		initialStage.setScene(titleScene);
		initialStage.setTitle("Food Locator");
		
		// Scene 2
		GridPane searchPane = new GridPane();
		searchPane.setAlignment(Pos.CENTER);
		searchPane.setHgap(width/32);
		searchPane.setVgap(height/32);
		searchPane.setPadding(new Insets(height/64,width/64,height/64,width/64));
		final Scene searchScene = new Scene(searchPane, width, height);
		
		// Scene 3
		GridPane resultPane = new GridPane();
		resultPane.setAlignment(Pos.CENTER);
		resultPane.setHgap(width/32);
		resultPane.setVgap(height/32);
		resultPane.setPadding(new Insets(height/64,width/64,height/64,width/64));
		final Scene resultScene = new Scene(searchPane, width, height);
		
		/// Defining all of our elements
		
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
		
		// This string belongs to the second scene, but must be defined before the buttons.
		//  This is because we have to set the text on partTwoText2 before sending it to its scene.
		final Text partTwoText2 = new Text( width/16, height/8, "You should not see this string."); // This is usually the second line of text on the second screen.
		
		// This is the syntax for doing an action on a button click
		searchZipButton.setOnAction(
			new EventHandler<ActionEvent>(){
				public void handle(ActionEvent event){
					// This is a totally separate class, believe it or not.
					// We can only access final variables from here.
					// Because type[0] is actually a pointer, we can change the value at that pointer.
					//  All we can't do is change where the pointer points to, which would happen if we had to change the size of the array dynamically.
					type[0] = 0;
					currentStage.setScene(searchScene);
					currentStage.setTitle("Search by zip code:");
					partTwoText2.setText("food in this zip code: ");
				}
			}
		);
		
		searchAddressButton.setOnAction(
			new EventHandler<ActionEvent>(){
				public void handle(ActionEvent event){
					type[0] = 1;
					currentStage.setScene(searchScene);
					currentStage.setTitle("Search by address:");
					partTwoText2.setText("food near this address:");
				}
			}
		);
		
		// This adds the elements to the titlePane grid
		//titlePane.add(element, Column, Row, Column Span, Row Span)
		titlePane.add(foodLocatorTitle, 0, 0, 3, 1);
		titlePane.add(foodLocatorBody, 2, 1, 3, 1);
		titlePane.add(searchZipButton, 2, 4, 2, 1);
		titlePane.add(searchAddressButton, 4, 4, 2, 1);
		
		
		/// Here are most of the elements for the second screen:
		
		Button partTwoBackButton = new Button("< Back");
		partTwoBackButton.setPrefWidth(width*3/8);
		partTwoBackButton.setPrefHeight(height/8);
		
		partTwoBackButton.setOnAction(
				new EventHandler<ActionEvent>(){
					public void handle(ActionEvent event){
						type[0] = -1;
						currentStage.setScene(titleScene);
						currentStage.setTitle("Food Locator");
					}
				}
			);
		
		
		// We have a lot of strings here and there, they'll have weird names
		final Text partTwoText1= new Text( width/16, height/8, "I want to find");
		partTwoText1.setFont(Font.font("Arial", FontWeight.NORMAL, 30));

		partTwoText2.setFont(Font.font("Arial", FontWeight.NORMAL, 30));
		
		
		// TODO: Add checkbox functionality
		CheckBox partTwoHealthy = new CheckBox("Healthy");		
		CheckBox partTwoJunk 	= new CheckBox("Junk");
		
		// TODO: Add search box functionality
		Button searchButton = new Button("Go");
		searchButton.setPrefWidth(width/8);
		searchButton.setPrefHeight(height/32);	
		
		TextField searchField = new TextField();
		
		// Don't actually need this button yet, but we had it in the UI design, so...
		// TODO: Delete this useless button?
		Button changeTypeButton = new Button("Or, press here to start again");
		changeTypeButton.setPrefWidth(width/2);
		
		searchPane.add(partTwoBackButton,		0,0,4,1);
		searchPane.add(partTwoText1,	1,3,3,1);
		searchPane.add(partTwoHealthy,	2,4,1,1);
		searchPane.add(partTwoJunk,		2,5,1,1);
		searchPane.add(partTwoText2,	1,6,3,1);
		searchPane.add(searchField, 	2,7,3,1);
		searchPane.add(searchButton,	5,7,1,1);
		// searchPane.add(changeTypeButton,1,9,7,1);
		
		
		
		/// Define the part 3 elements
		final Text partThreeText1 = new Text( width/32, height/16, "Results for:");
		partThreeText1.setFont(Font.font("Arial", FontWeight.NORMAL, 30));
		
		Button partThreeBackButton = new Button("< Back");
		partThreeBackButton.setPrefWidth(width*3/8);
		partThreeBackButton.setPrefHeight(height/8);
		
		partThreeBackButton.setOnAction(
				new EventHandler<ActionEvent>(){
					public void handle(ActionEvent event){
						currentStage.setScene(searchScene);
						if (type[0] == 0){
							currentStage.setTitle("Search by zip code");
							partTwoText2.setText("food in this zip code:");
							
						} else if (type[1] == 1){
							currentStage.setTitle("Search by address:");
							partTwoText2.setText("food near this address:");
						}
					}
				}
			);

		
		// This launches the actual window, once all is said and done
		currentStage.show();
	}
}