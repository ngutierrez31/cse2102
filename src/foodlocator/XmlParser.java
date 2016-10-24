package foodlocator;

import java.util.Scanner;

import org.w3c.dom.*;
import org.xml.sax.SAXException;
import org.xml.sax.InputSource;

import javax.xml.parsers.*;
import javax.xml.xpath.*;
import java.io.*;
import java.net.*;

import java.io.IOException;
import java.io.InputStream;
import javax.xml.parsers.ParserConfigurationException;
import java.net.MalformedURLException;

public class XmlParser {

	private static String APIKEY = "AIzaSyBq_j2SJHZj7trix3uZW3IH-859UXN5skQ";
	
	public static String getZipcode(String address_in){
		
		return getElement(address_in, "/GeocodeResponse/result/address_component[type/text()='", "postal_code']/long_name");
		
	}
	
	// getLat, getLong, and subsequently, getGeocode, all untested!
	
	public static float getLat(String address_in){
		return Float.parseFloat(getElement(address_in,"//location/lat/text()",""));
	}
	
	public static float getLong(String address_in){
		return Float.parseFloat(getElement(address_in,"//location/lng/text()",""));
	}
		public static String getElement(String address_in, String elementpath, String element){
	
			InputSource xml_in = getIS(address_in);
			
			XPathFactory factory = XPathFactory.newInstance();
			
			XPath xpath = factory.newXPath();
			
			String element_out = "1234";
			
			try {
				// TODO: THIS IS WHERE IT IS FAILING. xpath is evaluating something here as empty.
				element_out =  xpath.evaluate(elementpath + element,
												xml_in);
			} catch (XPathExpressionException e) {
				System.out.println("XPathExpressionException!");
			}
			return element_out;			
	}
	
	private static InputSource getIS(String address_in){
		try{ 
			return new InputSource(getUrl(address_in).openStream());
		} catch (IOException e){
			System.out.println("IOException in XmlParser.getIS");
		}
		return null;
	}
	
	private static URL getUrl(String address_in){
		String search_string = "https://maps.googleapis.com/maps/api/geocode/xml?address=" + fixAddress(address_in)+ "&key=" + APIKEY;

		try {
			return new URL(search_string);
		} catch (MalformedURLException e){
			System.out.println("MalformedURLException in XmlParser.getUrl");
		} 
		return null;
	}
	
	private static String fixAddress(String address_in){
		// Reformats the address in
		Scanner sc = new Scanner(address_in).useDelimiter(" ");
		String address_out = "";
		while (sc.hasNext()){
			address_out = address_out + sc.next() + "%20";
		}
		sc.close();
		return address_out;
	}
	
	
}
