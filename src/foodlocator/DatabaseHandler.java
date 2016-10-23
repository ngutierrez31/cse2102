package foodlocator;

import java.util.ArrayList;
import java.io.*;


/* storeName
 * storeLat
 * storeLong
 * storeZipcode
 * storeStreetAddress
 * storeType
 * storeDistance
 * storePhone
 */

public class DatabaseHandler {

	private ArrayList<LocationObject> LocationList = new ArrayList<LocationObject>();
	
	public void Add(LocationObject Location){
		LocationList.add(Location);
	}
	
	// Finish this
	public void Generate(){
		FileWriter database_out = null;
		try {
			database_out = new FileWriter("location_database.txt");
			LocationObject top = null;
			while (this.size() != 0){
				top = this.Pop();
				database_out.write("" 	+ top.getStoreName() + "/"
										+ top.getStoreLat() + "/"
										+ top.getStoreLong() + "/"
										+ top.getStoreZipcode() + "/"
										+ top.getStoreStreetAddress() + "/"
										+ top.getStoreType() + "/"
										+ top.getStoreDistance() + "/"
										+ top.getStorePhone() + "\n");
			}
			database_out.close();
		} catch (IOException e){
			System.out.println("IO Exception on DatabaseHandler.Generate()");
		} finally {
			
		}
	}
	
	public boolean DB_Exists(){
		File database = new File("location_database.txt");
		return database.exists();
	}
	
	public int size(){
		return LocationList.size();
	}
	
	public LocationObject Top(){
		return LocationList.get(size()-1);
	}
	
	public void Delete_Top(){
		LocationList.remove(size()-1);
	}
	
	public LocationObject Pop(){
		return LocationList.remove(size()-1);
	}
	
	
	
	/* Add(Location) - Adds a location to the list
	 * Generate()	 - Generates the txt based on the list. "/" delimits attributes, "\n" delimits places.
	 * Top()		 - Reads the top element in the list
	 * Delete_Top()	 - Deletes the top element in the list
	 * Pop()		 - Returns Top() and runs Delete_Top();
	 * LoadFromDatabase() - Replaces the current list with the one in the database
	 * All()		 - Returns the ArrayList<LocationObject>
	 */

	
}
