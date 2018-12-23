package testCases;

import java.util.ArrayList;
import java.util.Iterator;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.base.Testbase;
import com.crm.qa.pages.SignUp;




public class SignUpPageTest extends Testbase {
SignUp signUp;
	public SignUpPageTest() 
	{
		super();
		
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		
		signUp=new SignUp();
	}
	
	@Test(priority=1)
	public void verifyTitle() {
	String title=signUp.verifyTitle();
	Assert.assertEquals(title, "LinkedI: Log In or Sign Up");
		
	}
	
	@Test(priority=2)
	public void validateLogo() {
		
		boolean flag=signUp.verifyLogo();
		Assert.assertTrue(flag);
	}
	
	@DataProvider
	public Iterator<Object[]> gettestdata(){
		ArrayList<Object[]> data=getdatafromexcel();
		return data.iterator();
		
	}
	
	@Test(dataProvider="gettestdata",priority=3)
	public void SignUp(String name,String lastname,String email, String password) {
		
		signUp.requireFields(name, lastname, email, password);
	}
	
	
	
	@AfterMethod
	public void tearDown() {
		
		driver.quit();
	}
	
}
