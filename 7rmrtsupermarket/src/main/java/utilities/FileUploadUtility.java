package utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebElement;

public class FileUploadUtility {
public void fileUploadUsingSendKeys(WebElement element,String path)
{
	element.sendKeys(path);
}
public void fileUploadUsingRobotClass(WebElement element,String path) throws AWTException
{
	StringSelection ss = new StringSelection(path);
	Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss,null );//to copy to clipboard from ss	
	Robot rb = new Robot();
	rb.delay(2500);// a delay for copy and paste, need to increase amount if not pasted
	rb.keyPress(KeyEvent.VK_CONTROL);//vk-virtual key = to press control key
	rb.keyPress(KeyEvent.VK_V); // to press v key
	rb.keyRelease(KeyEvent.VK_CONTROL);//release ctrl key
	rb.keyRelease(KeyEvent.VK_V);// release v key
	rb.keyPress(KeyEvent.VK_ENTER);//to press enter
	rb.keyPress(KeyEvent.VK_ENTER);// to release enter
}
}
