package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.base.Testbase;

public class loginPage extends Testbase {

	@FindBy(name="session_key")
	WebElement username;
	
	
	@FindBy(name="session_password")
	WebElement password;
	
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginButton;
	
	@FindBy(xpath="//img[@alt='LinkedIn']")
	WebElement image;
	
	
	public loginPage() {
	
		PageFactory.initElements(driver,this);
		
		 
	}
	
	public String validateLoginPageTitle() {
		
		return getTitle();
		
	}
	
	public boolean validateImage() {
		
		return isDisplayed(image);
	}
	
	public homePage login(String uname, String pass) {
		
		get_the_xpath(username, uname);
		get_the_xpath(password, pass);
		get_the_xpath(loginButton);
		
		
		return new homePage();
	}
	
	
	
	
}
