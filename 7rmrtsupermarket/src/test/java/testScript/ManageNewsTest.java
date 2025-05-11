package testScript;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AdminUsersPage;
import pages.LogOutPage;
import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtility;

public class ManageNewsTest extends Base {
	public LogOutPage logoutpage;
	public ManageNewsPage managenewspage;

	@Test(description="verify If User Is Able To SaveNews")
	public void verifyIfUserIsAbleToSaveNews() throws Exception {
		/*
		 * String username = "admin"; String password = "admin";
		 */
		String username = ExcelUtility.readStringData(1, 0, "managenews");
		String password = ExcelUtility.readStringData(1, 1, "managenews");
		String text = ExcelUtility.readStringData(1, 2, "managenews");

		// String text = "welcome";
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(username).enterPassword(password);
		// loginpage.enterPassword(password);
		logoutpage = loginpage.clickSignIn();

		// ManageNewsPage managenewspage = new ManageNewsPage(driver);
		managenewspage = logoutpage.manageNewsMoreInfo();
		managenewspage.clickNew().enterText(text).clickSave();
		/*
		 * managenewspage.enterText(text); managenewspage.clickSave();
		 */
		boolean isalertloaded = managenewspage.isGreenAlertDisplayed();
		Assert.assertTrue(isalertloaded);

	}

}
