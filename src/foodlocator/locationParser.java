package foodlocator;

import java.util.Scanner;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.*;
import java.io.*;
import java.net.*;

import java.io.IOException;
import java.io.InputStream;
import javax.xml.parsers.ParserConfigurationException;
import java.net.MalformedURLException;

/*import java.net.HttpURLConnection;
import java.net.URL;
import java.net.MalformedURLException;
import java.io.IOException;
import java.io.InputStream;
import java.io.File;
*/
/*
import javax.lang.model.element.Element;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
*/

public class locationParser {

	private static String APIKEY = "AIzaSyBq_j2SJHZj7trix3uZW3IH-859UXN5skQ";
	
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
		String	zipcode;	// Get THIS from GOOGLE
		int 	type;		// 0 is healthy, 1 is junkfood
		String	address;	// E.g 3828 W Dimond Blvd, Anchorage,AK
		String	phone;
		type = 1;		// Junk foods are in csv files
		
		zipcode = "ERROR";		// If this comes out as ERROR, then it did not manage to get set below.
		
		// Example string: -149.95038,61.13712,"McDonalds-Anchorage,AK","3828 W Dimond Blvd, Anchorage,AK, (907) 248-0597"
		// Useful site: https://regex101.com/
		
		// NOTE: The following approach might prove non-expandable!
		// Currently delimits assuming everything has the same amount of hyphens, quote-marks, etc.
		// Might be better to delimit into two two floats, then two strings, and work from there.
		
		
		// TODO: Replace this with better csv handling
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
		
		// Get XML by putting address into the Google URL
		String search = "https://maps.googleapis.com/maps/api/geocode/xml?address=" + address + "&key=" + APIKEY;
		sc = new Scanner(search).useDelimiter(" ");
		String empty_search = "";
		while (sc.hasNext()){
			empty_search = empty_search + sc.next() + "%20";
		}
		search = empty_search;
		sc.close();
		System.out.print("\n Search string: \n " + search + "\n");
		try {
			URL search_url = new URL(search);
			// This is how you instantiate a document builder factory
			DocumentBuilderFactory db_fact = DocumentBuilderFactory.newInstance();
			try {
				DocumentBuilder	db_build = db_fact.newDocumentBuilder();
				try {
					Document doc = db_build.parse(search_url.openStream()); //TODO: Fix IOException on this line!!
					
					Element root = doc.getDocumentElement();
					
					NodeList list = doc.getElementsByTagName("address_component"); //Each address component has a long_name, short_name, and then types. We want the one with type postal_code
					
					for (int ii = 0; ii < list.getLength(); ii ++){
						Node listNode = list.item(ii);
						if (listNode.getNodeType() == Node.ELEMENT_NODE){ // If this is a node that is actually an element...
							Element listNodeElement = (Element) listNode; // 
							zipcode = listNodeElement.getElementsByTagName("postal_code").item(0).getTextContent();
						}
					}
					
				} catch (SAXException e){
					System.out.println("SAXException in locationParser! doc is messed up :(");
				} catch (IOException e){
					System.out.println("IOException in locationParser! doc is messed up :(");
					e.printStackTrace();
				}
				
			} catch (ParserConfigurationException e){
				System.out.println("ParserConfigurationException in locationParser! db_build is messed up :(");
			}
			/*
			try {
				HttpURLConnection gapi_connection = (HttpURLConnection) search_url.openConnection();
				gapi_connection.setRequestMethod("GET");	//We're asking to get info, not send info
				gapi_connection.setRequestProperty("Accept", "application/xml"); // I don't understand this; had to get this from Java documentation
				
				// To send to the Document Builder
				InputStream xml = gapi_connection.getInputStream();
				// This is how you instantiate a document builder factory
				DocumentBuilderFactory db_fact = DocumentBuilderFactory.newInstance();
				try {
					DocumentBuilder	db_build = db_fact.newDocumentBuilder();
					try {
						Document doc = db_build.parse(xml);
						
						
						
					} catch (SAXException e){
						System.out.println("SAXException in locationParser! doc is messed up :(");
					}
					
				} catch (ParserConfigurationException e){
					System.out.println("ParserConfigurationException in locationParser! db_build is messed up :(");
				}
				
				
			} catch (IOException e){
				System.out.println("IOException in locationParser; HttpURLConnection is messed up :(");
			}
			*/
		} catch (MalformedURLException e){
			System.out.println("Malformed URL! MalformedURLException in  locationparser; search_url is messed up. :(");
		}
		
		LocationObject result = new LocationObject(name, latitude, longitude, zipcode, address, type, -1, phone); // -1 is distance; change upon search
		return result;
	}

/*
public LocationObject(	String storeName, float storeLat, float storeLong, int storeZipcode,
String storeStreetAddress, int storeType, float storeDistance, String storePhone) {
	}
*/
}