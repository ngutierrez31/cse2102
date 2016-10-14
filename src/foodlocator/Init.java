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
		 * 	Get the buttons to click and store a search type (address or zip)
		 *  Change the text based on the type
		 */
		
		// width and height define the window size in pixels
		//  Expressing everything in terms of width and height
		//  will make it easy to change it later on.
		int width;
		int height;
		final int[] type; 							// type will represent the kind of search we are doing.
		type = new int[1];							// Due to technical reasons, type must be a one-integer long array
		final Stage currentStage = initialStage;	//Necessary to initialize our stage here
		// final Scene currentScene; // TODO: GET RID OF THIS?
		String[] searchTypes = new String[2];		// This is where we'll store the string of search types
		
		width = 640;
		height = 640;
		type[0] = -1; // -1 is "null", 0 is "By zip code", 1 is "By address"
		searchTypes[0] = "zip code";
		searchTypes[1] = "address";
		
		
		
		/**************************/
		/* Step One: Title Screen */
		/**************************/
		
		//// Set up the scenes that we will be using
		
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
		// Syntax modeled after Example 4-6 on this doc: http://docs.oracle.com/javase/8/javafx/get-started-tutorial/form.htm
		searchZipButton.setOnAction(
			new EventHandler<ActionEvent>(){
				public void handle(ActionEvent event){
					currentStage.setScene(searchScene);
					currentStage.setTitle("Search by zip code:");
					type[0] = 0;
				}
			}
		);
		
		searchAddressButton.setOnAction(
				new EventHandler<ActionEvent>(){
					public void handle(ActionEvent event){
						currentStage.setScene(searchScene);
						currentStage.setTitle("Search by address:");
						type[0] = 1;
					}
				}
			);
		
		// This adds the elements to the titlePane grid
		//titlePane.add(element, Column, Row, Column Span, Row Span)
		titlePane.add(foodLocatorTitle, 0, 0, 3, 1);
		titlePane.add(foodLocatorBody, 2, 1, 3, 1);
		titlePane.add(searchZipButton, 2, 4, 2, 1);
		titlePane.add(searchAddressButton, 4, 4, 2, 1);
		
		/***************************/
		/* Step Two: Search Screen */
		/***************************/
		
		// TODO: Make the back button actually DO something
		Button backButton = new Button("< Back");
		backButton.setPrefWidth(width*3/8);
		backButton.setPrefHeight(height/8);
		
		// We have a lot of strings here and there, they'll have weird names
		final Text partTwoText1= new Text( width/16, height/8, "I want to find");
		foodLocatorTitle.setFont(Font.font("Arial", FontWeight.NORMAL, 30));
		
		final Text partTwoText2= new Text( width/16, height/8, "food in this " + searchTypes[type[0]] + ":");
		foodLocatorTitle.setFont(Font.font("Arial", FontWeight.NORMAL, 30));
		
		CheckBox partTwoHealthy = new CheckBox("Healthy");		
		CheckBox partTwoJunk 	= new CheckBox("Junk");
		
		Button searchButton = new Button("Go");
		searchButton.setPrefWidth(width/8);
		searchButton.setPrefHeight(height/32);
		
		TextField searchField = new TextField();
		
		Button changeTypeButton = new Button("Or, press here to start again");
		changeTypeButton.setPrefWidth(width/2);
		// TODO: Go back to main screen and reset the type, title!
		
		searchPane.add(backButton,		0,0,4,1);
		searchPane.add(partTwoText1,	1,3,3,1);
		searchPane.add(partTwoHealthy,	2,4,1,1);
		searchPane.add(partTwoJunk,		2,5,1,1);
		searchPane.add(partTwoText2,	1,6,3,1);
		searchPane.add(searchField, 	2,7,3,1);
		searchPane.add(searchButton,	5,7,1,1);
		searchPane.add(changeTypeButton,1,9,7,1);
		// TODO: Find out how to switch scenes on button press
		
		// This launches the actual window, once all is said and done
		initialStage.show();
	}
}
