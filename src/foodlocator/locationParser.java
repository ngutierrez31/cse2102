package foodlocator;

import java.util.Scanner;

public class locationParser {

	
	public static LocationObject txtParser(String nameIn, String lineIn){
		
		/*
		 * ## This is what is bork##
		 * ## It is because of the & symbol; & -> %26
		 * LINE: 6610 Marie Curie Dr (Int. of 175 & 108) Elkridge, MD 21075, Phone:  410-953-8139 
 		 *  Address in: 6610 Marie Curie Dr (Int. of 175 & 108) Elkridge
		 */
		
		
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
		String badphone;
		badphone = sc.next();				// Phone:  801.359.7913
		if (!badphone.matches(".*\\d+.*")){
			badphone = "NOPHONE NOPHONE NOPHONE";
		}
		// System.out.println("DEBUG Phone: " + badphone);
		
		// While zipstate is not alphanumeric, zipstate = sc.next(); See line one of wholefoods if you wanna know why. TODO, DO THIS WHEN YOU GET BACK
		if (!zipstate.matches(".*\\d+.*")){ // Regex; \d means digit, +.* means to loop over the hole thing
			zipstate = "NO ZIPCODE";
		}
		
		sc.close();
		
		if (!zipstate.equals("NO ZIPCODE")){
			sc = new Scanner(zipstate);
			sc.next(); zipcode = sc.next();
			sc.close();
		} else {
			zipcode = "NO ZIPCODE";
		}
		
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
		if (sc.hasNext()){
			phone = "(" + sc.next();
		} else {
			phone = "-NO PHONE-";
		}
		sc.close();
		
		zipcode = XmlParser.getZipcode(address);
				
		LocationObject result = new LocationObject(name, latitude, longitude, zipcode, address, type, -1, phone); // -1 is distance; change upon search
		return result;
	}
	
	private void safeNext(Scanner scanner){ //Returns the next non-empty string
		
	}

}