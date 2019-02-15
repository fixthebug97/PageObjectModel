package com.crm.base;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.utils.XLS_Reader;



public class Testbase {
	
	public static WebDriver driver;
	public static Properties properties;


	public Testbase(){
		try {
		properties=new Properties();
		FileInputStream inputStream =new FileInputStream("C:\\Users\\samik\\eclipse-workspace\\PageObjectModel\\src\\main\\java\\com\\crm\\config\\config.Properties");
		properties.load(inputStream);
		}
		
		catch (FileNotFoundException e) {
		e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public static void initialization() {
		
		String browserName = properties.getProperty("browser");
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
			driver  =new ChromeDriver();
			
			}
	
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();;;
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(properties.getProperty("url"));
		
		
		
	}
	
	
	public static ArrayList<Object[]> getdatafromexcel() {
		 ArrayList<Object[]> myData = new ArrayList<Object[]>();
			
		 XLS_Reader reader=new XLS_Reader("C:\\Users\\samik\\eclipse-workspace\\PageObjectModel\\src\\main\\java\\com\\crm\\testdata\\linkedLin_Credentials.xlsx");
		int rowcount=reader.getRowCount("Sheet1");	
		reader.addColumn("Sheet1", "status");
		for (int rownum=2; rownum<=rowcount; rownum++) {
			String firstname=reader.getCellData("Sheet1","FirstName",rownum);
			
			String lastname=reader.getCellData("Sheet1","LastName",rownum);
			String email=reader.getCellData("Sheet1","Email",rownum);
			String password=reader.getCellData("Sheet1","Password",rownum);
			
			reader.setCellData("Sheet1","status", rownum,"Pass");
			
			Object ob[]= {firstname,lastname,email,password};
			myData.add(ob);
		}
		
		return myData;
	
		
	}
	
public void onClick(WebDriver driver,WebElement element, int timeout) {
	new WebDriverWait(driver, timeout).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(element));
	element.click();
}

public void get_the_xpath(WebElement element,String text) {
	
	element.sendKeys(text);
}

public String getTitle() {
	
	return driver.getTitle();
}

public boolean isDisplayed(WebElement element) {
	
	return element.isDisplayed();
}

public void quit() {
	
	driver.quit();
}
}
