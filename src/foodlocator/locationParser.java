package foodlocator;

import java.util.Scanner;

public class locationParser {

	
	public static LocationObject txtParser(String nameIn, String lineIn){
		
		/*
		This like broke it:
		634 E 400 S Salt Lake City UT 84102, Phone: 801-359-2462
		There is no comma between the zip code and the thing
		Maybe zipcode should just be the last non-whitecode line in the second part?
		 */
		
		
		
		
		
		
		
		
		
		float 	longitude;	// Geocode orders are lat/long, but we get long/lat first.
		float 	latitude;		
		String 	name;		//E.g. McDonalds
		String	zipcode;	// Get THIS from GOOGLE
		int 	type;		// 0 is healthy, 1 is junkfood
		String	address = "";	// E.g 3828 W Dimond Blvd, Anchorage,AK
		String	phone;
		type = 1;		// Junk foods are in csv files
		
		name = nameIn;
		
		longitude = 0;
		latitude = 0;
		
		// 1131 E. Wilmington Ave. Salt Lake City, UT 84106, Phone:  801.359.7913
		
		// Part one: Reverse string and delimit via "Phone"
		lineIn = new StringBuilder(lineIn).reverse().toString();
		Scanner sc = new Scanner(lineIn).useDelimiter(":enohP");
		
		String firstPart;	// Everything to the left of "Phone"
		String secondPart;	// Everything to the right of "Phone:"
		
		secondPart = new StringBuilder( sc.next() ).reverse().toString();
		if (sc.hasNext()){
			firstPart = new StringBuilder(sc.next()).reverse().toString();
		} else {
			firstPart = new StringBuilder(secondPart).toString();
			secondPart = "NO PHONE";
		}
		sc.close();
		phone = secondPart;
		
		//System.out.println("DEBUG firstPart: [" + firstPart + "]");
		//System.out.println("DEBUG secondPart: [" + secondPart + "]");
		
		// Part two: Delimit firstPart to separate into address and zip
		sc = new Scanner(firstPart);
		zipcode = "{NO ZIP FOUND}";
		while (sc.hasNext()){
			String next = sc.next();
			//System.out.println("Deb. Next: [" + next + "]");
			if (!sc.hasNext()){
				Scanner zpsc = new Scanner(next).useDelimiter(",");
				zipcode = zpsc.next();
				zpsc.close();
			} else {
				address = new StringBuilder(address).append(next + " ").toString();		
			}
		}
		
		
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