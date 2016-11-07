package foodlocator;

public class ObjectConverter {
	public static LocationResultObject locObj_to_locResObj(LocationObject loc_in){
		return new LocationResultObject(loc_in.getStoreName(), loc_in.getStoreStreetAddress(), "-1", loc_in.getStorePhone());
	}
	
	public static LocationResultObject locObj_to_locResObj(LocationObject loc_in, float lon_in, float lat_in){
		float distance = GeocodeDistance.distance(lat_in, lon_in, loc_in.getStoreLat(), loc_in.getStoreLong());
		return new LocationResultObject(loc_in.getStoreName(), loc_in.getStoreStreetAddress(), "-1", loc_in.getStorePhone());
	}
	
}
