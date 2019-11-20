package com.datadriven.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Utility.Xls_Reader;

public class ParameterizeTest {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver","D:/Selenium files/chromedriver_win32 _Latest/chromedriver.exe");
	   	WebDriver driver=new ChromeDriver();

	   	driver.get("https://cd-test.veriforce.net/");
	   	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	   	
		//read data from excel
		Xls_Reader reader=new Xls_Reader("/Users/SKadam/workspace/Frameworks/src/test/java/com/testdata/TestData.xlsx");
		
		int rowCount=reader.getRowCount("LoginTest");
		
		int rowCount1=reader.getRowCount("LoginTest1");
		reader.addColumn("LoginTest", "status");
		
		//Parameterize 
		for(int rowNum=2;rowNum<=rowCount;rowNum++){
			
			String username=reader.getCellData("LoginTest", "username", rowNum);
		System.out.println(username);
		
		String password=reader.getCellData("LoginTest", "password", rowNum);
		System.out.println(password);
		
		//enter data
		driver.findElement(By.xpath("//input[@id='usernameInput']")).clear();
		driver.findElement(By.xpath("//input[@id='usernameInput']")).sendKeys(username);
		
		driver.findElement(By.xpath("//input[@id='passwordInput']")).clear();
		driver.findElement(By.xpath("//input[@id='passwordInput']")).sendKeys(password);
		
		reader.setCellData("LoginTest", "status", rowNum, "Pass");
		
		/*driver.findElement(By.xpath("//button[@id='loginButton']")).click();
		//driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
		
		driver.findElement(By.xpath("//button[@class='btn dropdown-toggle dropdown-button btn-default']")).click();
				//button[@class='btn dropdown-toggle dropdown-button btn-default']")).click();
		//driver.findElement(By.xpath("//button[@class='btn dropdown-toggle dropdown-button btn-default']")).click();
		//driver.findElement(By.xpath("//*[@id=DropdownDivConverter_widget_DropdownDivConverter_0]/button/span[2]")).click();
		//driver.findElement(By.xpath("//div[@class='dropdown-div-converter btn-group mx-name-dropdownDivConverter1 open']")).click();
		
		
		driver.findElement(By.linkText("//a[@class=btn-link wag-green fa fa-sign-out]")).click();*/
		
		
		}
		
	
			for(int rowNum1=2;rowNum1<=rowCount1;rowNum1++){
				
				String firstname=reader.getCellData("LoginTest1", "firstname", rowNum1);
			System.out.println(firstname);
			
			String lastname=reader.getCellData("LoginTest1", "lastname", rowNum1);
			System.out.println(lastname);
			
			//enter data
			driver.findElement(By.xpath("//input[@id='usernameInput']")).clear();
			driver.findElement(By.xpath("//input[@id='usernameInput']")).sendKeys(firstname);
			
			driver.findElement(By.xpath("//input[@id='passwordInput']")).clear();
			driver.findElement(By.xpath("//input[@id='passwordInput']")).sendKeys(lastname);
		}
		

	}

}
