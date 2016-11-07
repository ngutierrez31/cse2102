package foodlocator;

public class ObjectConverter {
	public static LocationResultObject locObj_to_locResObj(LocationObject loc_in){
		return new LocationResultObject(loc_in.getStoreName(), loc_in.getStoreStreetAddress(), "-1", loc_in.getStorePhone());
		// TODO: CALCULATE DISTANCE USING NATALIA'S CODE
	}
}
