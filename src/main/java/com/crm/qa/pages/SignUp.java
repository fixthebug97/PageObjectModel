package com.crm.qa.pages;



import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.base.Testbase;

public class SignUp extends Testbase {
	
	
	
	
	@FindBy(xpath="//img[@src='https://static.licdn.com/sc/h/95o6rrc5ws6mlw6wqzy0xgj7y']")
	WebElement logo;

	
	@FindBy(xpath="//input[@name='firstName']")
	WebElement firstName;
	
	@FindBy(xpath="//input[@name='lastName']")
	WebElement lastName;
	
	@FindBy(xpath="//input[@id='reg-email']")
	WebElement Email;
	
	@FindBy(xpath="//input[@id='reg-password']")
	WebElement Password;
	
	
	
	
	
	public SignUp () {
		
		PageFactory.initElements(driver,this);
	}
	
	
	
	
	public String verifyTitle() {
		
		return getTitle();
	}
	
	public boolean verifyLogo() {
		
		return isDisplayed(logo);
	}
	
	public void requireFields(String name,String lastname, String email, String password) {
		
		get_the_xpath(firstName, name);
		get_the_xpath(lastName, lastname);
		get_the_xpath(Email, email);
		get_the_xpath(Password, password);
		
		
	}
}
