package testScript;

import org.testng.annotations.Test;

import pages.LogOutPage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LogOutTest extends Base {

	@Test
	public void verifyIfUserAbleToLogOut() throws Exception
	{
		/*String username = "admin";
		String password = "admin";*/
	String username = ExcelUtility.readStringData(1, 0, "loginpage");
	String password = ExcelUtility.readStringData(1, 1, "loginpage");
		LoginPage loginpage = new LoginPage(driver);//parameterized construction need to create constructor in page class
		loginpage.enterUserName(username);
		loginpage.enterPassword(password);
		loginpage.clickSignIn();
		LogOutPage logoutpage = new LogOutPage(driver);
		logoutpage.admin();
		logoutpage.logOut();
	}
	
	
}
