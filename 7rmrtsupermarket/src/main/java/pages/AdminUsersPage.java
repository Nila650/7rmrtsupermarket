package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.PageUtility;

public class AdminUsersPage {

	WebDriver driver;

	@FindBy(xpath = "((//a[contains(@href,'https://groceryapp.uniqassosiates.com/admin/list-admin')])[2])")
	WebElement adminuserpagemoreinfo;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement newadmin;
	@FindBy(xpath = "//input[@id='username']")
	WebElement usernamevalue;
	@FindBy(xpath = "//input[@id='password']")
	WebElement passwordvalue;
	@FindBy(xpath = "//select[@id='user_type']")
	WebElement usertype;
	@FindBy(xpath = "//button[@name='Create']")
	WebElement save;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alert;

	public AdminUsersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/*
	 * public void adminUserInfo() { adminuserpagemoreinfo.click(); }
	 */

	public AdminUsersPage createNew() {
		newadmin.click();
		return this;
	}

	public AdminUsersPage username(String usernametext) {
		usernamevalue.sendKeys(usernametext);
		return this;
	}

	public AdminUsersPage password(String passwordtext) {
		passwordvalue.sendKeys(passwordtext);
		return this;
	}

	public AdminUsersPage userType() {
		/*
		 * Select select = new Select(usertype); select.selectByIndex(1);
		 */
		PageUtility pageutility = new PageUtility(driver);
		pageutility.selectByIndex(usertype, 1);
		return this;
	}

	public AdminUsersPage save() {
		save.click();
		return this;
	}

	public boolean isAlertDisplayed() {
		return alert.isDisplayed();
	}
}
