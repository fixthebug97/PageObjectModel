package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.base.Testbase;

public class messagePage extends Testbase {
	
	@FindBy(xpath="//a[@data-control-name='compose_message']")
	WebElement messageIcon;
	
	@FindBy(xpath="//input[@placeholder='Type a name or multiple names…']")
	WebElement searchUser;
	
	@FindBy(xpath="//button[@data-control-name='add_recipient']")
	WebElement selectUser;
	
	@FindBy(xpath="//div[@role='textbox']")
	WebElement typeMessage;
	
	@FindBy(xpath="//button[@data-control-name='send']")
	WebElement sendMessage;
	
	public messagePage() {
		
		PageFactory.initElements(driver, this);
	}

	public void createMessage() {
		
		messageIcon.click();
	}
	
	public void searchUsers(String user) {
		
		searchUser.sendKeys(user);
		
	}
	
	public void selectUsers() {
		
		selectUser.click();
	}
	
	public void typemessages(String text) {
		typeMessage.sendKeys(text);
		
	}
	
	public void sendMessage() {
		sendMessage.click();
		
	}
	
	
	
}
