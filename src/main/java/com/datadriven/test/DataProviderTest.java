package com.datadriven.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utility.TestUtil;

public class DataProviderTest{

	WebDriver driver;
	
	@BeforeMethod
	public void setUp(){
		System.setProperty("webdriver.chrome.driver","D:/Selenium files/chromedriver_win32 _Latest/chromedriver.exe");
		driver=new ChromeDriver();
        driver.manage().window().maximize();
	    driver.manage().deleteAllCookies();
	   	driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	   	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	  	driver.get("https://cd-test.veriforce.net/");
	   	
	}
	
	@DataProvider
	public Iterator<Object[]> getTestData(){
		ArrayList<Object[]> testData=TestUtil.getDatafromExcel();
		return testData.iterator();
		
	}
	
	@Test(dataProvider="getTestData")
	public void excelData(String username,String password){
		
		driver.findElement(By.xpath("//input[@id='usernameInput']")).clear();
		driver.findElement(By.xpath("//input[@id='usernameInput']")).sendKeys(username);
		
		driver.findElement(By.xpath("//input[@id='passwordInput']")).clear();
		driver.findElement(By.xpath("//input[@id='passwordInput']")).sendKeys(password);
		//driver.quit();
	}
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
		
	}
	
	
	
}
