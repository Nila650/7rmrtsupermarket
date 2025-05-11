package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.PageUtility;

public class LogOutPage {
	WebDriver driver;
	@FindBy(xpath = "//a[@data-toggle='dropdown']")
	WebElement admin;
	@FindBy(xpath = "//i[@class='ace-icon fa fa-power-off']")
	WebElement logout;
	@FindBy(xpath = "//button[text()='Sign In']")
	WebElement signIn;
	@FindBy(xpath = "((//a[contains(@href,'https://groceryapp.uniqassosiates.com/admin/list-admin')])[2])")
	WebElement adminuserpagemoreinfo;
	@FindBy(xpath = "((//a[contains(@href,'https://groceryapp.uniqassosiates.com/admin/list-category')])[2])")
	WebElement managecategorymoreinfo;
	@FindBy(xpath = "((//a[contains(@href,'https://groceryapp.uniqassosiates.com/admin/list-contact')])[2])")
	WebElement managecontactmoreinfo;
	@FindBy(xpath = "((//a[contains(@href,'https://groceryapp.uniqassosiates.com/admin/list-footertext')])[2])")
	WebElement managefootermoreinfo;
	@FindBy(xpath = "//a[contains(@href,'https://groceryapp.uniqassosiates.com/admin/list-sub-category')]")
	WebElement subcategorymoreinfo;
	@FindBy(xpath = "//a[contains(@href,'https://groceryapp.uniqassosiates.com/admin/list-news')]")
	WebElement managenewsmoreinfo;

	public LogOutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public AdminUsersPage adminUserInfo() {
		adminuserpagemoreinfo.click();
		return new AdminUsersPage(driver);
	}

	public ManageNewsPage manageNewsMoreInfo() {
		managenewsmoreinfo.click();
		// managenews.click();
		return new ManageNewsPage(driver);
	}

	public ManageCategoryPage clickManageCategoryMoreInfo() {
		managecategorymoreinfo.click();
		return new ManageCategoryPage(driver);
	}

	public ManageContactPage clickManageContactMoreInfo() {
		managecontactmoreinfo.click();
		return new ManageContactPage(driver);
	}

	public ManageFooterPage clickManageFooterMoreInfo() {
		// moreinfo.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", managefootermoreinfo);
		return new ManageFooterPage(driver);
	}

	public SubCategoryPage clickSubCategoryMoreInfo() {
		subcategorymoreinfo.click();
		return new SubCategoryPage(driver);
	}

	public void admin() {
		admin.click();

	}

	public void logOut() {
		logout.click();
	}

	public boolean isLoginPageLoaded() {
		return signIn.isDisplayed();

	}
}
