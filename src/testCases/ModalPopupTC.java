package testCases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import utilities.MasterClass;

public class ModalPopupTC extends MasterClass{

	@Test
	public void popupHandle() {
		logger = extent.startTest("Popup handling test case");
		
		driver.manage().deleteAllCookies();
		
		openAUT("https:\\www.flipkart.com");
		captureScreenshot();
		logger.log(LogStatus.INFO, "Open Flipkart");
		driver.findElement(By.xpath("//input[@class='_2IX_2- VJZDxU']")).sendKeys("mukesh.jhorar1208@gmail.com");
		logger.log(LogStatus.INFO, "Enter email address");
		driver.findElement(By.xpath("//input[@class='_2IX_2- _3mctLh VJZDxU']")).sendKeys("yashika1208");
		logger.log(LogStatus.INFO, "Enter password");
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2HKlqd _3AWRsL']")).click();
		captureScreenshot();
		logger.log(LogStatus.INFO, "Click on login button");
		logger.log(LogStatus.PASS, "Modal popup handling successfully");
		
		
		
		extent.endTest(logger);
		
		
		
		
	}
}
