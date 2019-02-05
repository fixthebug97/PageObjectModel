package testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.base.Testbase;
import com.crm.qa.pages.homePage;
import com.crm.qa.pages.loginPage;
import com.crm.qa.pages.messagePage;

public class HomePageTest extends Testbase {
loginPage loginPage;
homePage homePage;
messagePage messagePage;
	public HomePageTest() {
		
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage=new loginPage();
		homePage=loginPage.login(properties.getProperty("username"), properties.getProperty("password"));
	}
	
	@Test(priority=1)
	public void verifyHomePageTitle() {
		
	String homePageTitle=homePage.verifyHomePageTitle();
	Assert.assertEquals(homePageTitle,"LinkedIn","Home page title not matched");
	
	}
	
	@Test(priority=2)
	public void verfiyUserName() {
		
	Assert.assertTrue(homePage.verifyUserName());
		
	} 
	
	@Test(priority=3)
	public void messagePageLogin() {
		messagePage=homePage.messageClick();
		
		
	}
	

	
	
	@AfterMethod
	public void tearDown() {
		
		quit();
	}
}
