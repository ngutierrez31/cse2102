package foodlocator;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import javafx.scene.layout.HBox;

import javafx.scene.control.Button;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import javafx.scene.paint.Color;

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
		
		// Create the elements and add them to titlePane
		final Text foodLocatorTitle = new Text( width/16, height/8, "Food Locator");
		foodLocatorTitle.setFont(Font.font("Arial", FontWeight.NORMAL, 40));
		
		Text foodLocatorBody = new Text( width/8, height*3/16, "Find fast food restaurants and health stores near you.");
		foodLocatorBody.setFont(Font.font("Arial", FontWeight.NORMAL, 30));
		foodLocatorBody.setWrappingWidth(width*3/4);
		
		
		// TODO: Buttons!! Learn how these work, get fields interacting
		
		Button searchByZipButton = new Button("Locate within zip code");
		
		searchByZipButton.setLayoutX(120);
		searchByZipButton.setLayoutX(120);
		searchByZipButton.setPrefWidth(120);
		searchByZipButton.setPrefHeight(120);
		
		
		
		searchByZipButton.setOnAction(new EventHandler<ActionEvent>() {
			 
		    @Override
		    public void handle(ActionEvent e) {
		        foodLocatorTitle.setFill(Color.RED);
		    }
		});
		
		
		// We need a HBox in which to store the buttons.
		HBox buttonBox = new HBox(width/8,searchByZipButton);
		
		titlePane.getChildren().add(foodLocatorTitle);
		titlePane.getChildren().add(foodLocatorBody);
		titlePane.getChildren().add(buttonBox);
		
		initialStage.show();
	
	
	
	}
}
