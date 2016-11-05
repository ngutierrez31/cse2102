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

	public static void main(String args[]){
		// Example line:
		//compileDatabase("bubgerkig.csv", "csv", "Bubger Kig", "burgerking-db");
	}
	
	public static void compileDatabase(String FilenameIn, String type, String storeName, String FilenameOut){ // type is txt or csv
		File dataFile = new File(FilenameIn);
		
		if (dataFile.isFile()){
			try{
				FileReader fr = new FileReader(dataFile);
				BufferedReader br = new BufferedReader (fr);
				Scanner sc = new Scanner(br);	//Scanner that goes line by line
				DatabaseHandler db = new DatabaseHandler();
				
				while (sc.hasNextLine()){
					if (type.equals("txt")){
						String line = sc.nextLine();
						System.out.println("LINE: " + line);
						db.add(locationParser.txtParser(storeName, line));
						//db.add(locationParser.txtParser(storeName, sc.nextLine())); 
					} else if (type.equals("csv")) {
						String line = sc.nextLine();
						System.out.println("LINE: " + line);
						db.add(locationParser.csvParser(line)); // Store name not necessary. Ugly code here, TODO?
					}			
				}
				sc.close();
				fr.close();
				br.close();
	
				db.generate(FilenameOut);
				
			} catch (IOException e){
				System.out.println("IO Exception in DatabaseCompiler; problem with BufferedReader on FileReader");
			}
		} else {
			System.out.println("Error! String provided to DatabaseCompiler does not match a file.");
		}
	}
}
