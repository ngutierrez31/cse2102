package foodlocator;

public class locationParser {

	public static LocationObject txtParser(String lineIn){
		// TODO: Content
		// The below lines are so Eclipse doesn't complete. (Won't compile if this doesn't return a Location
		LocationObject result = new LocationObject();
		return result;
	}
	
	public static LocationObject csvParser(String lineIn){
		// TODO: Content
		// The below lines are so Eclipse doesn't complete. (Won't compile if this doesn't return a Location
		
		String 	long_in; 	// Geocode orders are lat/long, but we get long/lat first. ew.
		String 	lati_in;
		String 	name_in;
		
		float 	longitude;
		float 	latitude;		
		String 	name;		//E.g. McDonalds
		int		zipcode;
		int 	type;		// 0 is healthy, 1 is junkfood
		String	address;	// E.g 3828 W Dimond Blvd, Anchorage,AK
		String	phone;
		
		
		LocationObject result = new LocationObject();
		return result;
	}
}
