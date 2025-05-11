package testScript;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import constants.Constants;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends Base {
	@Test(groups = { "regression" }, retryAnalyzer = retry.Retry.class,description="verify user able to login by valid credentials")
	public void verifyTheUserIsAbleToLoginUsingValidCredentials() throws Exception {
		/*
		 * String username = "admin"; String password = "abcd";
		 */
		String username = ExcelUtility.readStringData(1, 0, "loginpage");
		String password = ExcelUtility.readStringData(1, 1, "loginpage");
		LoginPage loginpage = new LoginPage(driver);// parameterized construction need to create constructor in page
													// class
		loginpage.enterUserName(username).enterPassword(password).clickSignIn();
		//loginpage.enterPassword(password);
		//loginpage.clickSignIn();
		boolean isdashboardloaded = loginpage.isHomePageLoaded();
		Assert.assertTrue(isdashboardloaded);
	}

	@Test(description="verify user able to login by invalid credentials")
	public void verifyTheUserIsAbleToLoginUsingCorrectUsernameWrongPassword() throws Exception {
		String username = "admin";
		String password = "nila";
		/*
		 * String username = ExcelUtility.readStringData(2, 0, "loginpage"); String
		 * password = ExcelUtility.readStringData(2, 1, "loginpage");
		 */
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(username).enterPassword(password).clickSignIn();
		/*loginpage.enterPassword(password);
		loginpage.clickSignIn();*/
		boolean isalertloaded = loginpage.isAlertDisplayed();
		Assert.assertTrue(isalertloaded,Constants.LOGINWITHVALIDUSERNAMEANDINVALIDPASSWORD);

	}

	@Test(description="verify user able to login by valid credentials")
	public void verifyTheUserIsAbleToLoginUsingWrongUsernameCorrectPassword() throws Exception {
		/*
		 * String username = "nila"; String password = "admin";
		 */
		String username = ExcelUtility.readStringData(3, 0, "loginpage");
		String password = ExcelUtility.readStringData(3, 1, "loginpage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(username).enterPassword(password).clickSignIn();
		/*loginpage.enterPassword(password);
		loginpage.clickSignIn();*/
		boolean isalertloaded = loginpage.isAlertDisplayed();
		Assert.assertTrue(isalertloaded,Constants.LOGINWITHINVALIDUSERNAMEANDVALIDPASSWORD);

	}

	@Test(description="verify user able to login by valid credentials")
	public void verifyTheUserIsAbleToLoginUsingWrongUsernameWrongPassword() throws Exception {

		/*
		 * String username = "nila"; String password = "nila";
		 */
		String username = ExcelUtility.readStringData(4, 0, "loginpage");
		String password = ExcelUtility.readStringData(4, 1, "loginpage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(username).enterPassword(password).clickSignIn();
		/*loginpage.enterPassword(password);
		loginpage.clickSignIn();*/
		boolean isalertloaded = loginpage.isAlertDisplayed();
		Assert.assertTrue(isalertloaded,Constants.LOGINWITHINVALIDUSERNAMEANDINVALIDPASSWORD);

	}
	/*
	 * @DataProvider(name="LoginProvider") public Object[][] getDataFromTestData()
	 * throws Exception{ return new Object[][] {{ExcelUtility.readStringData(4,
	 * 0,"loginpage"),ExcelUtility.readStringData(4,1,"loginpage")}}; }
	 */
}
