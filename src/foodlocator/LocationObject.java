package foodlocator;

import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.model.GeocodingResult;

public class LocationObject {

	private String 	storeName;			// E.g. Wendy's
	private float 	storeLat;			// Geocode
	private float 	storeLong;
	private int 	storeZipcode;
	private String 	storeStreetAddress;	// E.g. 123 Place Drive, Storrs CT
	private int 	storeType;			// 0 = Health, 1 = Junk
	private float 	storeDistance;		// Initialize to -1, populate with a value in miles when applicable
	
	// Constructors
	public LocationObject(	String storeName, float storeLat, float storeLong, int storeZipcode,
							String storeStreetAddress, int storeType, float storeDistance) {
		this.storeName = storeName;
		this.storeLat = storeLat;
		this.storeLong = storeLong;
		this.storeZipcode = storeZipcode;
		this.storeStreetAddress = storeStreetAddress;
		this.storeType = storeType;
		this.storeDistance = storeDistance;
	}
	
	// Getters and setters
	public String getStoreName() {
		return storeName;
	}
	
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	public float getStoreLat() {
		return storeLat;
	}
	public void setStoreLat(float storeLat) {
		this.storeLat = storeLat;
	}
	public float getStoreLong() {
		return storeLong;
	}
	public void setStoreLong(float storeLong) {
		this.storeLong = storeLong;
	}
	public int getStoreZipcode() {
		return storeZipcode;
	}
	public void setStoreZipcode(int storeZipcode) {
		this.storeZipcode = storeZipcode;
	}
	public String getStoreStreetAddress() {
		return storeStreetAddress;
	}
	public void setStoreStreetAddress(String storeStreetAddress) {
		this.storeStreetAddress = storeStreetAddress;
	}
	public int getStoreType() {
		return storeType;
	}
	public void setStoreType(int type) {
		this.storeType= storeType;
	}
	public float getStoreDistance() {
		return storeDistance;
	}
	public void setStoreDistance(float storeDistance) {
		this.storeDistance = storeDistance;
	}
	
	
	
}
