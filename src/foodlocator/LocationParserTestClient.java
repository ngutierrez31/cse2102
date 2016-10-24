package foodlocator;

public class LocationParserTestClient {

	public static void main(String[] args) {
		String csv1 = "-73.285156,45.333186,\"BurgerKing-Saint Jean Chrysostome,QC\",\"645B Rue Commerciale, Saint Jean Chrysostome,QC, (418) 834-3238\"";
		String csv2 = "-81.83332,38.47445,\"McDonalds-Winfield,WV\",\"3403 Winfield Rd, Winfield,WV, (304) 586-0385\"";
		String csv3 = "-73.800255,45.487267,\"Wendy's-Dollard Ormeaux,PQ\",\"3600 Sources Rd., Dollard Ormeaux,PQ H9B 1Z9 CA, (514) 683-6263\"";

		String csvzip1 = "G6Z 2C1";
		String csvzip2 = "25213";
		String csvzip3 = "H9B 1Z9";
		
		print("Compare the zips:");
		
		LocationObject csv1_obj = locationParser.csvParser(csv1);
		LocationObject csv2_obj = locationParser.csvParser(csv2);
		LocationObject csv3_obj = locationParser.csvParser(csv3);
		
		print(csvzip1 + " : " + csv1_obj.getStoreZipcode());
		print(csvzip2 + " : " + csv2_obj.getStoreZipcode());
		print(csvzip3 + " : " + csv3_obj.getStoreZipcode());
		
		csv1_obj.printAll();
		csv2_obj.printAll();
		csv3_obj.printAll();
	}

	public static void print(String input){
		System.out.println(input);
	}
}
