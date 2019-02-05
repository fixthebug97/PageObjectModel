package testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.base.Testbase;
import com.crm.qa.pages.homePage;
import com.crm.qa.pages.loginPage;

public class loginPageTest extends Testbase {
	loginPage loginPage;
	homePage homePage;
	 public loginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage=new loginPage();
	}
	
	@Test(priority=1)
	public void loginPageTitleTest () {
		
		String title=loginPage.validateLoginPageTitle();
			Assert.assertEquals(title, "LinkedIn: Log In or Sign Up");
		
	}
	
	@Test(priority=2)
	public void linkedInLogoTest() {
		boolean flag=loginPage.validateImage();
		Assert.assertTrue(flag);
		
	}
	
	@Test(priority=3)
	public void loginTest() {
		homePage=loginPage.login(properties.getProperty("username"), properties.getProperty("password"));
		
	}
	
	
	
	
	
	
	@AfterMethod
	public void tearDown() {
		
		quit();
	}
	
	

}
