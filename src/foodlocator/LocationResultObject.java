package foodlocator;
// SimpleStringProperty used so we can update the location if necessary in the future.



import javafx.beans.property.SimpleStringProperty;

public class locationResultObject {

	private SimpleStringProperty storeName;	// Name of the store. E.g. Wholefoods, McDonalds
	private SimpleStringProperty storeAddress;		// Address of the store
	private SimpleStringProperty storeDistance;	// Distance from user; -1 if searching within zip code
	
	// Constructor
	public locationResultObject(SimpleStringProperty storeName, SimpleStringProperty storeAddress, SimpleStringProperty storeDistance ){
		this.storeName = storeName;
		this.storeAddress = storeAddress;
		this.storeDistance = storeDistance ;
	}

	// Getters and setters below
	public SimpleStringProperty getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public SimpleStringProperty getStoreAddress() {
		return storeAddress;
	}

	public void setStoreAddress(String storeAddress) {
		this.storeAddress = SimpleStringProperty(storeAddress);
		// TODO: Why can't java see the constructor from here??
	}

	public float getStoreDistance() {
		return storeDistance;
	}

	public void setStoreDistance(float storeDistance) {
		this.storeDistance = storeDistance;
	}
	
}
