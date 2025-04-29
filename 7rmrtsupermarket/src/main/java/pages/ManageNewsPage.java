package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageNewsPage {

	WebDriver driver;
	@FindBy(xpath="//p[text()='Manage News']")WebElement managenews;
	@FindBy(xpath="//a[contains(@href,'https://groceryapp.uniqassosiates.com/admin/list-news')]")WebElement managenewsmoreinfo;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")WebElement clicknew;
	@FindBy(xpath="//textarea[@id='news']")WebElement enternews;
	@FindBy(xpath="//button[@class='btn btn-danger']")WebElement save;
	@FindBy(xpath="//div[@class=\"alert alert-success alert-dismissible\"]")WebElement greenalert;
	
	public ManageNewsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);//pagefactory - tolocate webelement /initelements-to initialize webelement,a static method
	}
	public void clickMoreInfo()
	{
		managenewsmoreinfo.click();
		//managenews.click();
	}
	
	public void clickNew()
	{
		clicknew.click();
	}
	public void enterText(String textvalue)
	{
		enternews.sendKeys(textvalue);
	}
	
	public void clickSave()
	{
		save.click();
	}
	public boolean isGreenAlertDisplayed()
	{
		return greenalert.isDisplayed();
	}
}
