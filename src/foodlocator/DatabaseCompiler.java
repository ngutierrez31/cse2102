package foodlocator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class DatabaseCompiler {
	// Using the location parser and database handler,
	// Sends a bunch of strings from a txt or csv file to the appropriate locationParser.
	// Takes the LocationObject from that locationParser, and sends it to a DatabaseHandler.
	// The DatabaseHandler is then used to generate a location database.
	
	public void compileDatabase(String FilenameIn, String type, String FilenameOut){ // type is txt or csv
		File file = new File(FilenameIn + "." + type);
		if (file.isFile()){
			BufferedReader br = null;
			
			
			
		} else {
			System.out.println("Error! String provided to DatabaseCompiler does not match a file.");
		}
		/* Look to see if the file at Filename exists.
		 * If so, loop over each line.
		 *  For each line, send it to the appropriate locationparser based off "type"
		 *  Send the object from each locationparser to a DB Handler
		 * Generate database from handler, with name from FilenameOut.
		 */
		
		
	}
}
