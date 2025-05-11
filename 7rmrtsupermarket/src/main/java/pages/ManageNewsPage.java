package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class ManageNewsPage {

	WebDriver driver;
	@FindBy(xpath = "//p[text()='Manage News']")
	WebElement managenews;
	@FindBy(xpath = "//a[contains(@href,'https://groceryapp.uniqassosiates.com/admin/list-news')]")
	WebElement managenewsmoreinfo;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement clicknew;
	@FindBy(xpath = "//textarea[@id='news']")
	WebElement enternews;
	@FindBy(xpath = "//button[@class='btn btn-danger']")
	WebElement save;
	@FindBy(xpath = "//div[@class=\"alert alert-success alert-dismissible\"]")
	WebElement greenalert;

	public ManageNewsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);// pagefactory - tolocate webelement /initelements-to initialize
												// webelement,a static method
	}
	/*
	 * public void manageNewsMoreInfo() { managenewsmoreinfo.click();
	 * //managenews.click(); }
	 */

	public ManageNewsPage clickNew() {
		// clicknew.click();

		/*
		 * JavascriptExecutor js = (JavascriptExecutor) driver;
		 * js.executeScript("arguments[0].click();", clicknew);
		 */
		PageUtility PageUtility = new PageUtility(driver);
		PageUtility.jsClick(clicknew);
		return this;
	}

	public ManageNewsPage enterText(String textvalue) {
		enternews.sendKeys(textvalue);
		return this;
	}

	public ManageNewsPage clickSave() {
		save.click();
		return this;
	}

	public boolean isGreenAlertDisplayed() {
		return greenalert.isDisplayed();
	}
}
