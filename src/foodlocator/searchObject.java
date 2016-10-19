package foodlocator;

public class searchObject {
	
	private String searchField;						// The text entered by the user for the search
	
	private int searchType;							// The kind of search we are performing. 0 = By Address, 1 = by Zip
	
	private boolean[] searchStoreTypes = new boolean[2];	// The types of stores we want look for. 0 = Health, 1 = Junk,
	
	// Constructor, for the first two types.
	// If we need to extend this to more types, we might want to use variable-length constructors (if Java supports them), or create multiple constructors. (Overeloading)
	public searchObject(String fieldEntry, int typeEntry, boolean findHealthStore, boolean findJunkStore){
		searchField = fieldEntry;
		searchType = typeEntry;
		searchStoreTypes[0] = findHealthStore;
		searchStoreTypes[1] = findJunkStore;
	}

	// Getters and setters below
	public String getSearchField() {
		return searchField;
	}

	public void setSearchField(String searchField) {
		this.searchField = searchField;
	}

	public int getSearchType() {
		return searchType;
	}

	public void setSearchType(int searchType) {
		this.searchType = searchType;
	}

	public boolean[] getSearchStoreTypes() {
		return searchStoreTypes;
	}

	public void setSearchStoreTypes(boolean[] searchStoreTypes) {
		this.searchStoreTypes = searchStoreTypes;
	}
	
}
