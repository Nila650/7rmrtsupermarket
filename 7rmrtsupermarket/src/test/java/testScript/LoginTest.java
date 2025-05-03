package testScript;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import utilities.ExcelUtility;
public class LoginTest extends Base {
@Test(groups= {"regression"},retryAnalyzer=retry.Retry.class)
	public void verifyTheUserIsAbleToLoginUsingValidCredentials() throws Exception 
	{
		String username = "admin";
		String password = "abcd";
	/*String username = ExcelUtility.readStringData(1, 0, "loginpage");
	String password = ExcelUtility.readStringData(1, 1, "loginpage");*/
		LoginPage loginpage = new LoginPage(driver);//parameterized construction need to create constructor in page class
		loginpage.enterUserName(username);
		loginpage.enterPassword(password);
		loginpage.clickSignIn();
		boolean isdashboardloaded = loginpage.isHomePageLoaded();
		Assert.assertTrue(isdashboardloaded);
	}
@Test
	public void verifyTheUserIsAbleToLoginUsingCorrectUsernameWrongPassword() throws Exception 
	{
		String username = "admin";
		String password = "nila";
/*	String username = ExcelUtility.readStringData(2, 0, "loginpage");
	String password = ExcelUtility.readStringData(2, 1, "loginpage");*/
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(username);
		loginpage.enterPassword(password);
		loginpage.clickSignIn();
		boolean isalertloaded = loginpage.isAlertDisplayed();
		Assert.assertTrue(isalertloaded);
		
	}
@Test
public void verifyTheUserIsAbleToLoginUsingWrongUsernameCorrectPassword() throws Exception 
{
	/*String username = "nila";
	String password = "admin";*/
	String username = ExcelUtility.readStringData(3, 0, "loginpage");
	String password = ExcelUtility.readStringData(3, 1, "loginpage");
	LoginPage loginpage = new LoginPage(driver);
	loginpage.enterUserName(username);
	loginpage.enterPassword(password);
	loginpage.clickSignIn();
	boolean isalertloaded = loginpage.isAlertDisplayed();
	Assert.assertTrue(isalertloaded);
	
}
@Test
public void verifyTheUserIsAbleToLoginUsingWrongUsernameWrongPassword() throws Exception
{
	
	/*String username = "nila";
	String password = "nila";*/
	String username = ExcelUtility.readStringData(4, 0, "loginpage");
	String password = ExcelUtility.readStringData(4, 1, "loginpage");
	LoginPage loginpage = new LoginPage(driver);
	loginpage.enterUserName(username);
	loginpage.enterPassword(password);
	loginpage.clickSignIn();
	boolean isalertloaded = loginpage.isAlertDisplayed();
	Assert.assertTrue(isalertloaded);
	
}
}
