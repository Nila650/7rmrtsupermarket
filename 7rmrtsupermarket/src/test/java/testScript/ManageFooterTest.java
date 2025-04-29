package testScript;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageFooterPage;
import utilities.ExcelUtility;

public class ManageFooterTest extends Base {

	@Test
	public void verifyIfUserAbleToUpdateFooterDetails() throws Exception
	{
		/*String username = "admin";
		String password = "admin";*/
	
		String username = ExcelUtility.readStringData(1, 0, "loginpage");
		String password = ExcelUtility.readStringData(1, 1, "loginpage");
		
			LoginPage loginpage = new LoginPage(driver);//parameterized construction need to create constructor in page class
			loginpage.enterUserName(username);
			loginpage.enterPassword(password);
			loginpage.clickSignIn();
			String address = ExcelUtility.readStringData(1, 0, "managefooter");
			String email = ExcelUtility.readStringData(1, 1, "managefooter");
			String phone = ExcelUtility.readIntegerData(1, 2, "managefooter");
			ManageFooterPage managefooterPage  = new ManageFooterPage(driver);
			managefooterPage.clickMoreInfo();
			managefooterPage.clickAction();
			managefooterPage.addAddress(address);
			managefooterPage.addEmail(email);
			managefooterPage.addPhone(phone);
			managefooterPage.updateDetails();
			boolean isGreenAlertDisplayed = managefooterPage.isAlertDisplayed();
			Assert.assertTrue(isGreenAlertDisplayed);
	}
	@Test
	public void verfyIfUpdateButtonIsDisplayed() throws Exception
	{
		String username = ExcelUtility.readStringData(1, 0, "loginpage");
		String password = ExcelUtility.readStringData(1, 1, "loginpage");
		
			LoginPage loginpage = new LoginPage(driver);//parameterized construction need to create constructor in page class
			loginpage.enterUserName(username);
			loginpage.enterPassword(password);
			loginpage.clickSignIn();
			ManageFooterPage managefooterPage  = new ManageFooterPage(driver);
			managefooterPage.clickMoreInfo();
			managefooterPage.clickAction();
		boolean isUpdateButtonIsDisplayed =	managefooterPage.isUpdateDisplayed();
		Assert.assertTrue(isUpdateButtonIsDisplayed);
	}
	
}
