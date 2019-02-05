package testCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.base.Testbase;
import com.crm.qa.pages.homePage;
import com.crm.qa.pages.loginPage;
import com.crm.qa.pages.messagePage;

public class MessagePageTest extends Testbase{
	loginPage loginPage;
	homePage homePage;
	messagePage messagePage;
	public MessagePageTest() {
		
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage=new loginPage();
		homePage=loginPage.login(properties.getProperty("username"), properties.getProperty("password"));
		messagePage=homePage.messageClick();

	}
	@Test(priority=1)
	public void clickMessageIcon() {
		
		messagePage.createMessage();
	}
	
	@Test(priority=2)
	public void searchUsername() {
		clickMessageIcon();
		messagePage.searchUsers(properties.getProperty("user"));
	}
	
	@Test(priority=3)
	public void selectUser() {
		searchUsername();
		messagePage.selectUsers();
	}
	
	@Test(priority=4)
	public void typeMessage() {
		selectUser();
		messagePage.typemessages(properties.getProperty("text"));
	}
	
	@Test(priority=5)
	public void sendMessage() {
		typeMessage();
		messagePage.sendMessage();
	}
	
	
	
	@AfterMethod
	public void tearDown() {
		
		quit();
	}
	
	
}
