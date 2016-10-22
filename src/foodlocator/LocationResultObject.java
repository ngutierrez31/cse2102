package foodlocator;
// SimpleStringProperty used so we can update the location if necessary in the future.



import javafx.beans.property.SimpleStringProperty;

public class LocationResultObject {

	private SimpleStringProperty storeName;		// Name of the store. E.g. Wholefoods, McDonalds
	private SimpleStringProperty storeAddress;	// Address of the store
	private SimpleStringProperty storeDistance;	// Distance from user; -1 if searching within zip code
	private SimpleStringProperty storePhone;	
	

	// Constructors
	public LocationResultObject(SimpleStringProperty storeName, SimpleStringProperty storeAddress,
								SimpleStringProperty storeDistance, SimpleStringProperty storePhone){
		this.storeName 		= storeName;
		this.storeAddress 	= storeAddress;
		this.storeDistance 	= storeDistance;
		this.storePhone 	= storePhone;
	}
	
	public LocationResultObject(String storeName, String storeAddress, String storeDistance, String storePhone){
		this.storeName.set(storeName);
		this.storeAddress.set(storeAddress);
		this.storeDistance.set(storeDistance);
		this.storePhone.set(storePhone);
	}

	// Getters and setters below
	public SimpleStringProperty getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName.set("storeName");
	}

	public SimpleStringProperty getStoreAddress() {
		return storeAddress;
	}

	public void setStoreAddress(String storeAddress) {
		this.storeAddress.set(storeAddress);
	}

	public SimpleStringProperty getStoreDistance() {
		return storeDistance;
	}

	public void setStoreDistance(float storeDistance) {
		this.storeDistance.set("" + storeAddress);
	}
	
	public SimpleStringProperty getStorePhone() {
		return storePhone;
	}

	public void setStorePhone(SimpleStringProperty storePhone) {
		this.storePhone = storePhone;
	}
	
}
