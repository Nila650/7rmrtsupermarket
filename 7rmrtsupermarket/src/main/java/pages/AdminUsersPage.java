package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.PageUtility;

public class AdminUsersPage {

	WebDriver driver;
	
	@FindBy(xpath="((//a[contains(@href,'https://groceryapp.uniqassosiates.com/admin/list-admin')])[2])")WebElement moreinfo;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")WebElement newadmin;
	@FindBy(xpath="//input[@id='username']")WebElement usernamevalue;
	@FindBy(xpath="//input[@id='password']")WebElement passwordvalue;
	@FindBy(xpath="//select[@id='user_type']")WebElement usertype;
	@FindBy(xpath="//button[@name='Create']")WebElement save;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement alert;
	
	public AdminUsersPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void adminUserInfo()
	{
		moreinfo.click();
	}
	
	public void createNew()
	{
		newadmin.click();
	}
	public void username(String usernametext)
	{
		usernamevalue.sendKeys(usernametext);
	}
	public void password(String passwordtext)
	{
		passwordvalue.sendKeys(passwordtext);
	}
	public void userType()
	{
		/*Select select = new Select(usertype);
		select.selectByIndex(1);*/
		PageUtility pageutility = new PageUtility(driver);
		pageutility.selectByIndex(usertype, 1);
	}
	public void save() {
		save.click();
	}
	public boolean isAlertDisplayed()
	{
		return alert.isDisplayed();
	}
}
