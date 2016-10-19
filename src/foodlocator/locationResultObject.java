package foodlocator;

public class locationResultObject {

	private String storeName;	// Name of the store. E.g. Wholefoods, McDonalds
	private String storeAddress;		// Address of the store
	private float  storeDistance;	// Distance from user; -1 if searching within zip code
	
	// Constructor
	public locationResultObject(String name, String address, float distance){
		storeName = name;
		storeAddress = address;
		storeDistance = distance;
	}


	// Getters and setters below
	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getStoreAddress() {
		return storeAddress;
	}

	public void setStoreAddress(String storeAddress) {
		this.storeAddress = storeAddress;
	}

	public float getStoreDistance() {
		return storeDistance;
	}

	public void setStoreDistance(float storeDistance) {
		this.storeDistance = storeDistance;
	}
	
}