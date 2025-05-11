package testScript;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LogOutPage;
import pages.LoginPage;
import pages.ManageFooterPage;
import utilities.ExcelUtility;

public class ManageFooterTest extends Base {
	public LogOutPage logoutpage;
	public ManageFooterPage managefooterpage;

	@Test(description="verify If User Able To UpdateFooterDetails")
	public void verifyIfUserAbleToUpdateFooterDetails() throws Exception {
		/*
		 * String username = "admin"; String password = "admin";
		 */

		String username = ExcelUtility.readStringData(1, 0, "loginpage");
		String password = ExcelUtility.readStringData(1, 1, "loginpage");

		LoginPage loginpage = new LoginPage(driver);// parameterized construction need to create constructor in page
													// class
		loginpage.enterUserName(username).enterPassword(password);
		//loginpage.enterPassword(password);
		logoutpage = loginpage.clickSignIn();
		String address = ExcelUtility.readStringData(1, 0, "managefooter");
		String email = ExcelUtility.readStringData(1, 1, "managefooter");
		String phone = ExcelUtility.readIntegerData(1, 2, "managefooter");

		// ManageFooterPage managefooterPage = new ManageFooterPage(driver);
		managefooterpage = logoutpage.clickManageFooterMoreInfo();
		managefooterpage.clickAction().addAddress(address).addEmail(email).addPhone(phone).updateDetails();
		/*
		 * managefooterpage.addAddress(address); managefooterpage.addEmail(email);
		 * managefooterpage.addPhone(phone); managefooterpage.updateDetails();
		 */
		boolean isGreenAlertDisplayed = managefooterpage.isAlertDisplayed();
		Assert.assertTrue(isGreenAlertDisplayed);
	}

	@Test
	public void verfyIfUpdateButtonIsDisplayed() throws Exception {
		String username = ExcelUtility.readStringData(1, 0, "loginpage");
		String password = ExcelUtility.readStringData(1, 1, "loginpage");

		LoginPage loginpage = new LoginPage(driver);// parameterized construction need to create constructor in page
													// class
		loginpage.enterUserName(username).enterPassword(password);
		//loginpage.enterPassword(password);
		logoutpage = loginpage.clickSignIn();
		// ManageFooterPage managefooterPage = new ManageFooterPage(driver);
		managefooterpage = logoutpage.clickManageFooterMoreInfo();
		managefooterpage.clickAction();
		boolean isUpdateButtonIsDisplayed = managefooterpage.isUpdateDisplayed();
		Assert.assertTrue(isUpdateButtonIsDisplayed);
	}

}
