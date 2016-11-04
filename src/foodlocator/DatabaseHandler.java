package foodlocator;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class DatabaseHandler {

	private ArrayList<LocationObject> LocationList = new ArrayList<LocationObject>();
	private String delimiter = ",";
	private int size = 0;
	
	public void add(LocationObject Location){
		// Adds an element to the arraylist
		LocationList.add(Location);
		size ++;
	}
	
	public int size(){
		// Returns how many elements are in the array
		return size;
	}
	
	public void generate(String dbName){
		// Creates a location_database file, encoding all the LocationObjects stored in the LocationList
		FileWriter database_out = null;
		try {
			database_out = new FileWriter(dbName);
			LocationObject top = null;
			while (!this.isEmpty()){
				top = this.pop();
				database_out.write("" 	+ top.getStoreName() + delimiter
										+ top.getStoreLat() + delimiter
										+ top.getStoreLong() + delimiter
										+ top.getStoreZipcode() + delimiter
										+ top.getStoreStreetAddress() + delimiter
										+ top.getStoreType() + delimiter
										+ top.getStoreDistance() + delimiter
										+ top.getStorePhone());
				if (!this.isEmpty()){				// So , doesn't get added to the last entry
					database_out.write(delimiter + "\n");  // Alternatively, add a fake, buffer entry?
				}
			}
			database_out.close();
		} catch (IOException e){
			System.out.println("IO Exception on DatabaseHandler.Generate()");
		} finally {
			
		}
	}
	
	public boolean dbExists(String databaseName){
		// Returns true of the file location_database.txt exists
		return new File(databaseName).exists();
	}
	
	public boolean isEmpty(){
		return size == 0;
	}

	public LocationObject top(){
		// Returns the top of the list
		if (!this.isEmpty()){
			return LocationList.get(size-1);
		} else {
			System.out.println("Error; tried to top on empty database");
			return null;
		}
	}
	
	public void deleteTop(){
		// Deletes the top of the list
		if (!this.isEmpty()){
			LocationList.remove(size-1);
			size --;
		} else {
			System.out.println("Error; tried to deleteTop on empty database");
		}
	}
	
	public LocationObject pop(){
		// Returns the top of the list and deletes it from the list
		if (!this.isEmpty()){
			LocationObject return_me = LocationList.remove(size-1);
			size --;
			return return_me;
		} else {
			System.out.println("Error; tried to pop on empty database");
			return null;
		}
	}
	
	public void loadFromDatabase(String databaseName){
		// Populates the LocationList with what was stored in location_database.txt
		if (this.dbExists(databaseName)){
			FileReader database_in = null;
			BufferedReader br = null;
			try {
				database_in = new FileReader(databaseName);
				LocationObject top = new LocationObject();
				br = new BufferedReader(database_in);
				Scanner sc = new Scanner(br).useDelimiter(delimiter);
				
				while (sc.hasNext()){
					String Add;
					
					Add = sc.next();
					System.out.println("Name: " + Add);
					top.setStoreName	(Add);
					
					Add = sc.next();
					System.out.println("Lat:  " + Add);
					top.setStoreLat		(Float.parseFloat(Add));
					
					Add = sc.next();
					System.out.println("Long: " + Add);
					top.setStoreLong	(Float.parseFloat(Add));
					
					Add = sc.next();
					System.out.println("Zip:  " + Add);
					top.setStoreZipcode	(Add);
					
					Add = sc.next();
					System.out.println("Addr: " + Add);
					top.setStoreStreetAddress(Add);
					
					Add = sc.next();
					System.out.println("Type: " + Add);
					top.setStoreType	(Integer.parseInt(Add));
					
					Add = sc.next();
					System.out.println("Dist: " + Add);
					top.setStoreDistance(Float.parseFloat(Add));
					
					Add = sc.next();
					System.out.println("Phone:" + Add);
					top.setStorePhone	(Add);
					
					this.add(top);
			}
				sc.close();
				br.close();
				database_in .close();
			} catch (IOException e){
				System.out.println("IO Exception on DatabaseHandler.LoadFromDatabase()");
			} finally {
				
			}
		} else {
			System.out.println("Error on LoadFromDatabase: " + databaseName + " does not exist.");
		}
	}
	
	public void deleteDatabase(String databaseName){
		// Deletes the database file
		File database = new File(databaseName);
		if (database.exists()){
			database.delete();
		}
	}
	
	public ArrayList<LocationObject> loadEntire(){
		// Return the entire Location List
		return LocationList;
	}
	
	public void close(){
		
	}
	
}
