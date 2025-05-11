package testScript;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LogOutPage;
import pages.LoginPage;
import pages.ManageContactPage;
import utilities.ExcelUtility;

public class ManageContactTest extends Base {
	public LogOutPage logoutpage;
	public ManageContactPage managecontactpage;

	@Test(description="verify If User Able To Update ManageContactDetails")
	public void verifyIfUserAbleToUpdateManageContactDetails() throws Exception {
		String username = ExcelUtility.readStringData(1, 0, "loginpage");
		String password = ExcelUtility.readStringData(1, 1, "loginpage");
		String phonenumber = ExcelUtility.readIntegerData(1, 0, "managecontact");
		String email = ExcelUtility.readStringData(1, 1, "managecontact");
		String address = ExcelUtility.readStringData(1, 2, "managecontact");
		String deliverytime = ExcelUtility.readIntegerData(1, 3, "managecontact");
		String deliverycharge = ExcelUtility.readIntegerData(1, 4, "managecontact");
		LoginPage loginpage = new LoginPage(driver);// parameterized construction need to create constructor in page
													// class
		loginpage.enterUserName(username).enterPassword(password);
		//loginpage.enterPassword(password);
		logoutpage = loginpage.clickSignIn();
		// ManageContactPage managecontactpage = new ManageContactPage(driver);
		managecontactpage = logoutpage.clickManageContactMoreInfo();
		managecontactpage.clickAction().enterphone(phonenumber).enterEmail(email).enterAddress(address)
				.enterDeliveryTime(deliverytime).enterDeliveryCharge(deliverycharge).clickUpdate();
		/*
		 * managecontactpage.enterphone(phonenumber);
		 * managecontactpage.enterEmail(email); managecontactpage.enterAddress(address);
		 * managecontactpage.enterDeliveryTime(deliverytime);
		 * managecontactpage.enterDeliveryCharge(deliverycharge);
		 * managecontactpage.clickUpdate();
		 */
		boolean isgreenalertdisplayed = managecontactpage.isAlertDisplayed();
		Assert.assertTrue(isgreenalertdisplayed);
	}

}
