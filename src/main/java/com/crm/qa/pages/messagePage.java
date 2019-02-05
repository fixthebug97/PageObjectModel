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
		
		get_the_xpath(messageIcon);
	}
	
	public void searchUsers(String user) {
		
		get_the_xpath(searchUser, user);
		
	}
	
	public void selectUsers() {
		
		get_the_xpath(selectUser);
	}
	
	public void typemessages(String text) {
		get_the_xpath(typeMessage, text);
		
	}
	
	public void sendMessage() {
		get_the_xpath(sendMessage);
		
	}
	
	
	
}
