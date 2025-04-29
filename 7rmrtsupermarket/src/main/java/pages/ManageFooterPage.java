package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageFooterPage {
WebDriver driver;
@FindBy(xpath="((//a[contains(@href,'https://groceryapp.uniqassosiates.com/admin/list-footertext')])[2])")WebElement moreinfo;
@FindBy(xpath="//a[contains(@href,'https://groceryapp.uniqassosiates.com/admin/Footertext/edit?edit=1')]")WebElement action;
@FindBy(xpath="//textarea[@id='content']")WebElement address;
@FindBy(xpath="//input[@id='email']")WebElement email;
@FindBy(xpath="//input[@id='phone']")WebElement phone;
@FindBy(xpath="//button[@name='Update']")WebElement update;
@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement alert;
public ManageFooterPage(WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements(driver, this);
}
public void clickMoreInfo()
{
	//moreinfo.click();
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].click();",moreinfo);
}
public void clickAction()
{
	action.click();
}
public void addAddress(String addresstext)
{
	address.clear();
	address.sendKeys(addresstext);
}
public void addEmail(String emailtext)
{
	email.clear();
email.sendKeys( emailtext);
}
public void addPhone(String phonetext)
{
	phone.clear();
	phone.sendKeys(phonetext);
}
public void updateDetails()
{
	//update.click();
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].click();",update);
	
}
public boolean isAlertDisplayed()
{
	return alert.isDisplayed();
}
public boolean isUpdateDisplayed()
{
	return update.isDisplayed();
}
}
