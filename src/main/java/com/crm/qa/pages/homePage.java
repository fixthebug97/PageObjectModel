package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.base.Testbase;

public class homePage extends Testbase {
	
	@FindBy(xpath="//a[@data-control-name=\"identity_welcome_message\"]")
	WebElement userNameLabel;
	
	@FindBy(xpath="//a[@href='/messaging/']")
	WebElement messageLink;
	
	
	public homePage() {
		
		PageFactory.initElements(driver, this);
		
	}
	
	public String verifyHomePageTitle() {
		
		return getTitle();
	}
	
	public boolean verifyUserName() {
		
		return isDisplayed(userNameLabel);
	}
	
	public messagePage messageClick() {
		
		get_the_xpath(messageLink);
		
		return new messagePage();
		
	}
}
