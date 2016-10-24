package foodlocator;

public class DatabaseTestClient {

	public static void main(String[] args) {
		LocationObject Location1 = new LocationObject("Wendys", 	(float) 12.34, (float) 56.78, "12345", "123 Placeland Drive", 1, (float) 13.1, "(860)-444-4444");
		LocationObject Location2 = new LocationObject("Wholefoods", (float) 13.37, (float) 7.20, "90210",  "456 Cooly Avenue", 	2, (float) 2.3,  "(860)-555-5555");
		LocationObject Location3 = new LocationObject("Pamble", 	(float) 14.37, (float) 17.20, "6269", "789 Plagle Avenue", 	3, (float) 5.2,  "(123)-456-7890");
		
		DatabaseHandler DB = new DatabaseHandler();
		
		print("Starting testing of DatabaseTestClient");
		print("Adding Locations to database");
		
		DB.add(Location1);
		DB.add(Location2);
		
		if (DB.size() == 2){
			print("GOOD - DB size == 2");
		} else {
			print("BAD  - DB size not 2");
		}
		
		DB.deleteDatabase();
		
		if (DB.dbExists()){
			print("BAD  - DB should not already exist.");
		} else {
			print("GOOD - DB does not already exist.");
		}
		
		print ("Now, adding Location 3.");
		DB.add(Location3);
		
		if (DB.size() == 3){
			print("GOOD - Size is now 3");
		} else {
			print("BAD - Size is not 3.");
			print("Size is: " + DB.size());
		}
		
		print ("Generating database");
		
		DB.generate();
		
		if (DB.dbExists()){
			print("GOOD - DB exists after generating.");
		} else {
			print("BAD  - DB does not exist after generating");
		}
		
		DB.pop();
		DB.deleteTop();
		DB.pop();
		
		print("You should see an error relating to DB.pop now and ONLY now.:");
		DB.pop();
		
		DB.add(Location2);
		
		DB.loadFromDatabase();
		
		print("GOOD - If you got here, the database loaded!");
	}
	
	public static void print(String input){
		System.out.println(input);
	}
	
	
	/* storeName
	 * storeLat
	 * storeLong
	 * storeZipcode
	 * storeStreetAddress
	 * storeType
	 * storeDistance
	 * storePhone
	 */

}
