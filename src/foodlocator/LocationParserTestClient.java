package foodlocator;

public class LocationParserTestClient {

	public static void main(String[] args) {
		/*
		print("!! Testing the csv parser! \n Compare the zips:");
		
		
		String csv1 = "-73.285156,45.333186,\"BurgerKing-Saint Jean Chrysostome,QC\",\"645B Rue Commerciale, Saint Jean Chrysostome,QC, (418) 834-3238\"";
		String csv2 = "-81.83332,38.47445,\"McDonalds-Winfield,WV\",\"3403 Winfield Rd, Winfield,WV, (304) 586-0385\"";
		String csv3 = "-73.800255,45.487267,\"Wendy's-Dollard Ormeaux,PQ\",\"3600 Sources Rd., Dollard Ormeaux,PQ H9B 1Z9 CA, (514) 683-6263\"";

		String csvzip1 = "G6Z 2C1";
		String csvzip2 = "25213";
		String csvzip3 = "H9B 1Z9";
		
		
		
		LocationObject csv1_obj = locationParser.csvParser(csv1);
		LocationObject csv2_obj = locationParser.csvParser(csv2);
		LocationObject csv3_obj = locationParser.csvParser(csv3);
		
		print(csvzip1 + " : " + csv1_obj.getStoreZipcode());
		print(csvzip2 + " : " + csv2_obj.getStoreZipcode());
		print(csvzip3 + " : " + csv3_obj.getStoreZipcode());
		
		csv1_obj.printAll();
		csv2_obj.printAll();
		csv3_obj.printAll();
		
		*/
		
		print ("\n\n!! Testing the txt parser! \n Compare the long/lats:");

		String txt1 = "205 Summit Blvd, Suite 100 Birmingham, AL  35243, Phone: 205-969-7801  ";	
		String txt2 = "125 N Reino Rd Newbury Park, CA, Phone: 805-375-1984 ";
		String txt3 = "6150 Slauson Ave Culver City, CA 90230, Phone: ";
/*		
		String txtcode1 = "37.7563752, -122.2528046";
		String txtcode2 = "32.9988408, -96.6987141";
		String txtcode3 = "37.8928784, -122.0555321";
*/
		String txtcode1 = "- no longlat -";
		String txtcode2 = txtcode1;
		String txtcode3 = txtcode1;
		
		LocationObject txt1_obj = locationParser.txtParser("NAME GOES HERE", txt1);
		LocationObject txt2_obj = locationParser.txtParser("NAME GOES HERE", txt2);
		LocationObject txt3_obj = locationParser.txtParser("NAME GOES HERE", txt3);
		
		print(txtcode1 + " : " + txt1_obj.getStoreLat() + ", " + txt1_obj.getStoreLong());
		print(txtcode2 + " : " + txt2_obj.getStoreLat() + ", " + txt2_obj.getStoreLong());
		print(txtcode3 + " : " + txt3_obj.getStoreLat() + ", " + txt3_obj.getStoreLong());

		txt1_obj.printAll();
		txt2_obj.printAll();
		txt3_obj.printAll();
		
	}

	public static void print(String input){
		System.out.println(input);
	}
}
