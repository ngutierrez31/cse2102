package foodlocator;

import java.util.Scanner;

public class locationParser {

	public static LocationObject txtParser(String lineIn){
		// TODO: Content
		// The below lines are so Eclipse doesn't complete. (Won't compile if this doesn't return a Location
		LocationObject result = new LocationObject();
		return result;
	}
	
	public static LocationObject csvParser(String lineIn){
		// TODO: Test if this parses right, returns a location right!
		// The below lines are so Eclipse doesn't complete. (Won't compile if this doesn't return a Location
		
		float 	longitude;	// Geocode orders are lat/long, but we get long/lat first.
		float 	latitude;		
		String 	name;		//E.g. McDonalds
		int		zipcode;	// Get THIS from GOOGLE
		int 	type;		// 0 is healthy, 1 is junkfood
		String	address;	// E.g 3828 W Dimond Blvd, Anchorage,AK
		String	phone;
		type = 1;		// Junk foods are in csv files
		
		// Example string: -149.95038,61.13712,"McDonalds-Anchorage,AK","3828 W Dimond Blvd, Anchorage,AK, (907) 248-0597"
		// Delimited string: -149.95038, 61.13712, McDonalds, Anchorage, AK, 3828 W Dimond Blvd, Anchorage, AK, (907) 248-0597
		// Useful site: https://regex101.com/
		Scanner sc = new Scanner(lineIn).useDelimiter(",|\"|-"); 	//Delimits by the following symbols: , " -
		longitude = Float.parseFloat(sc.next());
		latitude = 	Float.parseFloat(sc.next());
		name = sc.next();
		sc.next(); sc.next();
		address = 	sc.next() + ", " + sc.next() + ", " + sc.next();
		phone = 	sc.next() + " " + sc.next() + "-" + sc.next();
		
		// TODO : GET ZIPCODE USING GOOGLE
		zipcode = 00000; //Temporary
		
		
		LocationObject result = new LocationObject(name, latitude, longitude, zipcode, address, type, -1, phone); // -1 is distance; change upon search
		return result;
	}

/*
public LocationObject(	String storeName, float storeLat, float storeLong, int storeZipcode,
String storeStreetAddress, int storeType, float storeDistance, String storePhone) {
	}
*/
}