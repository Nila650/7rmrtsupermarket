package testScript;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtility;

public class ManageNewsTest extends Base {
	@Test
	public void verifyIfUserIsAbleToSaveNews() throws Exception
	{
		/*String username = "admin";
		String password = "admin";*/
		String username = ExcelUtility.readStringData(1, 0, "managenews");
		String password = ExcelUtility.readStringData(1, 1, "managenews");
		String text = ExcelUtility.readStringData(1, 2, "managenews");

		//String text = "welcome";
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(username);
		loginpage.enterPassword(password);
		loginpage.clickSignIn();
		ManageNewsPage managenewspage = new ManageNewsPage(driver);
		managenewspage.clickMoreInfo();
		managenewspage.clickNew();
		managenewspage.enterText(text);
		managenewspage.clickSave();
		boolean isalertloaded = managenewspage.isGreenAlertDisplayed();
		Assert.assertTrue(isalertloaded);
	}
	
	
	
}
