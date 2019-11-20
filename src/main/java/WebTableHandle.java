import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import Utility.Xls_Reader;


public class WebTableHandle {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver","D:/Selenium files/chromedriver_win32 _Latest/chromedriver.exe");
	   	WebDriver driver=new ChromeDriver();

	   	driver.get("https://www.w3schools.com/html/html_tables.asp");
	   	
	  //*[@id="customers"]/tbody/tr[2]/td[1]
	  //*[@id="customers"]/tbody/tr[7]
	   	
	  //*[@id="customers"]
	   	
	  //*[@id="customers"]/tbody/tr[2]/td[2]
	 
	   	
	   	String beforeXpath_Company= "//*[@id='customers']/tbody/tr[";
	   	String afterXpath_Company= "]/td[1]";
	   	
	   	String beforeXpath_Contact= "//*[@id='customers']/tbody/tr[";
	   	String afterXpath_Contact= "]/td[2]";
	   	
	   	String beforeXpath_Country= "//*[@id='customers']/tbody/tr[";
	   	String afterXpath_Country= "]/td[3]";
	   	
	   	
	   	List<WebElement> rows=driver.findElements(By.xpath("//table[@id='customers']//tr"));
	   	System.out.println("Total rows are:" + (rows.size()-1));
	   	int rowCount=rows.size();
	   	
	   	Xls_Reader reader=new Xls_Reader("/Users/SKadam/workspace/Frameworks/src/test/java/com/testdata/TestData.xlsx");
	   	reader.addSheet("TableData");
	   	reader.addColumn("TableData", "CompanyName");
	   	reader.addColumn("TableData", "Contact");
	   	reader.addColumn("TableData", "Country");
	   	
	   	for(int i=2;i<=rowCount;i++){
	   		
	   		String actual_xpathCompany=beforeXpath_Company+i+afterXpath_Company;
	   		String companyname=driver.findElement(By.xpath(actual_xpathCompany)).getText();
	   		System.out.println(companyname);
	   		reader.setCellData("TableData", "CompanyName", i, companyname);
	   		
	   		String actual_xpathContact=beforeXpath_Contact+i+afterXpath_Contact;
	   		String contact=driver.findElement(By.xpath(actual_xpathContact)).getText();
	   		System.out.println(contact);
	   		reader.setCellData("TableData", "Contact", i, contact);
	   		
	   		String actual_xpathCountry=beforeXpath_Country+i+afterXpath_Country;
	   		String country=driver.findElement(By.xpath(actual_xpathCountry)).getText();
	   		System.out.println(country);
	   		reader.setCellData("TableData", "Country", i, country);
	   			 		
	   	}	   	
	}

}
