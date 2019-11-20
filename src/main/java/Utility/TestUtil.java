package Utility;

import java.util.ArrayList;

public class TestUtil {

	static Xls_Reader reader;
	
	public static ArrayList<Object[]> getDatafromExcel(){
		ArrayList<Object[]> myData=new ArrayList<Object[]>();
		
			reader=new Xls_Reader("/Users/SKadam/workspace/Frameworks/src/test/java/com/testdata/TestData.xlsx");
		
		
		for(int rowNum=2;rowNum<=reader.getRowCount("LoginTest");rowNum++){
			String Username=reader.getCellData("LoginTest", "username", rowNum);
			String Password=reader.getCellData("LoginTest", "password", rowNum);
			
			Object[] ob={Username,Password};
			myData.add(ob);
		}
		return myData;
	}
	
	
	
}
