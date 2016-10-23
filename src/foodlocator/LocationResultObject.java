package foodlocator;
// SimpleStringProperty used so we can update the location if necessary in the future.



import javafx.beans.property.SimpleStringProperty;

public class LocationResultObject {

	private SimpleStringProperty storeName = new SimpleStringProperty("");		// Name of the store. E.g. Wholefoods, McDonalds
	private SimpleStringProperty storeAddress = new SimpleStringProperty("");	// Address of the store
	private SimpleStringProperty storeDistance = new SimpleStringProperty("");	// Distance from user; -1 if searching within zip code
	private SimpleStringProperty storePhone  = new SimpleStringProperty("");	
	

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
	public String getStoreName() {
		return storeName.get();
	}

	public void setStoreName(String storeName) {
		this.storeName.set("storeName");
	}

	public String getStoreAddress() {
		return storeAddress.get();
	}

	public void setStoreAddress(String storeAddress) {
		this.storeAddress.set(storeAddress);
	}

	public String getStoreDistance() {
		return storeDistance.get();
	}

	public void setStoreDistance(float storeDistance) {
		this.storeDistance.set("" + storeAddress);
	}
	
	public String getStorePhone() {
		return storePhone.get();
	}

	public void setStorePhone(SimpleStringProperty storePhone) {
		this.storePhone = storePhone;
	}
	
}
