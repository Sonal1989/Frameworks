package com.datadriven.test;

import Utility.Xls_Reader;

public class ExcelOperations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Xls_Reader reader=new Xls_Reader("/Users/SKadam/workspace/Frameworks/src/test/java/com/testdata/TestData.xlsx");
reader.addSheet("HomePage");

if(reader.isSheetExist("HomePage1")){
	System.out.println("sheet already exists");
	
}
else{
	reader.addSheet("HomePage1");
}
int colCount=reader.getColumnCount("LoginTest");
System.out.println(colCount);

System.out.println(reader.getCellRowNum("LoginTest", "username", "Test3"));

	}

}
