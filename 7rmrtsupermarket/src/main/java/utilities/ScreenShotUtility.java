package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenShotUtility {
	public void getScreenShot(WebDriver driver, String failedTestCase) throws IOException { 
 		TakesScreenshot scrShot = (TakesScreenshot) driver; //interface to take failed testcase
 		File screenShot = scrShot.getScreenshotAs(OutputType.FILE); //method to catch failed testcase
 		String timeStamp = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss").format(new Date()); //to get current date/format-to convert to string
 		File f1 = new File(System.getProperty("user.dir") + "//OutputScreenShot"); //directory where to generate screenshot
 		if (!f1.exists()) { 
 			f1.mkdirs(); //make directory
 		} 
 		String destination = System.getProperty("user.dir") + "//outputScreenShot//" + failedTestCase + timeStamp+ ".png"; 
 		File finalDestination = new File(destination); 
 		FileHandler.copy(screenShot, finalDestination);  //copy screenshopt to finaldestination
  	}
}
