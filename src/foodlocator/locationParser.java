package foodlocator;

import java.util.Scanner;

public class locationParser {

	
	public static LocationObject txtParser(String nameIn, String lineIn){
		float 	longitude;	// Geocode orders are lat/long, but we get long/lat first.
		float 	latitude;		
		String 	name;		//E.g. McDonalds
		String	zipcode;	// Get THIS from GOOGLE
		int 	type;		// 0 is healthy, 1 is junkfood
		String	address;	// E.g 3828 W Dimond Blvd, Anchorage,AK
		String	phone;
		type = 1;		// Junk foods are in csv files
		
		name = nameIn;
		
		longitude = 0;
		latitude = 0;
		
		// 1131 E. Wilmington Ave. Salt Lake City, UT 84106, Phone:  801.359.7913
		
		Scanner sc = new Scanner(lineIn).useDelimiter(",");
		address = sc.next();			// 1131 E. Wilmington Ave. Salt Lake City
		String zipstate = sc.next();	// UT 84106
		String badphone = sc.next();				// Phone:  801.359.7913
		sc.close();
		
		sc = new Scanner(zipstate);
		sc.next(); zipcode = sc.next();
		sc.close();
		
		sc = new Scanner(badphone);
		sc.next(); phone = sc.next();
		sc.close();
		
		longitude = XmlParser.getLong(address);
		latitude = XmlParser.getLat(address);
		
		LocationObject result = new LocationObject(name, latitude, longitude, zipcode, address, type, -1, phone);
		return result;
	}
	
	public static LocationObject csvParser(String lineIn){
		float 	longitude;	// Geocode orders are lat/long, but we get long/lat first.
		float 	latitude;		
		String 	name;		//E.g. McDonalds
		String	zipcode;	// Get THIS from GOOGLE
		int 	type;		// 0 is healthy, 1 is junkfood
		String	address;	// E.g 3828 W Dimond Blvd, Anchorage,AK
		String	phone;
		type = 1;		// Junk foods are in csv files
		
		zipcode = "ERROR";		// If this comes out as ERROR, then it did not manage to get set below.

		Scanner sc = new Scanner(lineIn).useDelimiter("\""); 	//Delimits by the following symbols: , " -
		String longlat = sc.next(); 			//-149.95038,61.13712,	
		String namestate = sc.next();			//McDonalds-Anchorage,AK
		sc.next(); 								//,
		String addressphone = sc.next(); 		//3828 W Dimond Blvd, Anchorage,AK, (907) 248-0597
		sc.close();
		
		sc = new Scanner(longlat).useDelimiter(",");
		longitude = Float.parseFloat(sc.next());
		latitude = Float.parseFloat(sc.next());
		sc.close();
		
		sc = new Scanner(namestate).useDelimiter(",|-");
		name = sc.next();
		sc.close();
		
		// Tested: This part works fine. The address being passed to the GAP is ok
		sc = new Scanner(addressphone).useDelimiter("\\(");
		address = sc.next();
		phone = "(" + sc.next();
		sc.close();
		
		zipcode = XmlParser.getZipcode(address);
				
		LocationObject result = new LocationObject(name, latitude, longitude, zipcode, address, type, -1, phone); // -1 is distance; change upon search
		return result;
	}

}