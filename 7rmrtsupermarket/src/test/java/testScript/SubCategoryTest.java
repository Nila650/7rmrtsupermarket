package testScript;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LogOutPage;
import pages.LoginPage;
import pages.SubCategoryPage;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class SubCategoryTest extends Base {
	public LogOutPage logoutpage;
	public SubCategoryPage subcategorypage;

	@Test(description ="verify If User Is Able To AddSubCategoryDetails")
	public void verifyIfUserIsAbleToAddSubCategoryDetails() throws Exception {
		String username = ExcelUtility.readStringData(1, 0, "loginpage");
		String password = ExcelUtility.readStringData(1, 1, "loginpage");
//String category1 = ExcelUtility.readStringData(1, 0, "subcategory");
		FakerUtility fakerutility = new FakerUtility();
		String category1 = fakerutility.creatARandomFirstName();
		LoginPage loginpage = new LoginPage(driver);// parameterized construction need to create constructor in page
													// class
		loginpage.enterUserName(username).enterPassword(password);
		//loginpage.enterPassword(password);
		logoutpage = loginpage.clickSignIn();
		// SubCategoryPage subcategorypage = new SubCategoryPage(driver);

		subcategorypage = logoutpage.clickSubCategoryMoreInfo();
		subcategorypage.clickNew().addCategory().enterSubCategory(category1).uploadImage().clickSave();
		/*
		 * subcategorypage.addCategory(); subcategorypage.enterSubCategory(category1);
		 * subcategorypage.uploadImage(); subcategorypage.clickSave();
		 */
		boolean isgreenalertdisplayed = subcategorypage.isAlertDisplyed();
		Assert.assertTrue(isgreenalertdisplayed);

	}

	@Test
	public void verifyIfUserIsAbleToUpdateSubCategoryDetails() throws Exception {
		String username = ExcelUtility.readStringData(1, 0, "loginpage");
		String password = ExcelUtility.readStringData(1, 1, "loginpage");
		String category1 = ExcelUtility.readStringData(1, 0, "subcategory");
		String editcategory = ExcelUtility.readStringData(1, 1, "subcategory");
		LoginPage loginpage = new LoginPage(driver);// parameterized construction need to create constructor in page
													// class
		loginpage.enterUserName(username);
		loginpage.enterPassword(password);
		logoutpage = loginpage.clickSignIn();
		// SubCategoryPage subcategorypage = new SubCategoryPage(driver);
		subcategorypage = logoutpage.clickSubCategoryMoreInfo();
		subcategorypage.clickAction().updatecategory().updateSubCategory(editcategory).updateImage().updateSave();
		/*
		 * subcategorypage.updatecategory();
		 * subcategorypage.updateSubCategory(editcategory);
		 * subcategorypage.updateImage(); subcategorypage.updateSave();
		 */
		boolean isgreenalertdisplayed = subcategorypage.isUpdateAlertDisplyed();
		Assert.assertTrue(isgreenalertdisplayed);

	}
}
