package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

import org.openqa.selenium.JavascriptExecutor;

public class ManageContactPage {
	WebDriver driver;
	@FindBy(xpath = "((//a[contains(@href,'https://groceryapp.uniqassosiates.com/admin/list-contact')])[2])")
	WebElement managecontactmoreinfo;
	@FindBy(xpath = "//a[contains(@href,'https://groceryapp.uniqassosiates.com/admin/contact/edit_contact?edit=1')]")
	WebElement action;
	@FindBy(xpath = "//input[@id='phone']")
	WebElement phone;
	@FindBy(xpath = "//input[@id='email']")
	WebElement email;
	@FindBy(xpath = "//textarea[@placeholder='Enter the Address']")
	WebElement address;
	@FindBy(xpath = "//textarea[@placeholder='Enter Delivery Time']")
	WebElement deliverytime;
	@FindBy(xpath = "//input[@id='del_limit']")
	WebElement deliverychargelimit;
	@FindBy(xpath = "//button[@name='Update']")
	WebElement update;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alert;

	public ManageContactPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/*
	 * public void clickManageContactMoreInfo() { managecontactmoreinfo.click(); }
	 */
	public ManageContactPage clickAction() {
		action.click();
		return this;
	}

	public ManageContactPage enterphone(String phonenumbertext) {
		phone.clear();
		phone.sendKeys(phonenumbertext);
		return this;
	}

	public ManageContactPage enterEmail(String emailtext) {
		email.clear();
		email.sendKeys(emailtext);
		return this;
	}

	public ManageContactPage enterAddress(String addresstext) {
		address.clear();
		address.sendKeys(addresstext);
		return this;
	}

	public ManageContactPage enterDeliveryTime(String deliverytime2) {
		deliverytime.clear();
		deliverytime.sendKeys(deliverytime2);
		return this;
	}

	public ManageContactPage enterDeliveryCharge(String deliverycharge) {
		deliverychargelimit.clear();
		deliverychargelimit.sendKeys(deliverycharge);
		return this;
	}

	public ManageContactPage clickUpdate() {
		// update.click();
		/*
		 * JavascriptExecutor js = (JavascriptExecutor) driver;
		 * js.executeScript("arguments[0].click();",update);
		 */
		PageUtility PageUtility = new PageUtility(driver);
		PageUtility.jsClick(update);
		return this;

	}

	public boolean isAlertDisplayed() {
		return alert.isDisplayed();
	}
}
