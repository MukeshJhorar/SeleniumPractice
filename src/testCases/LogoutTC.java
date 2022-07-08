package testCases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import utilities.MasterClass;

public class LogoutTC extends MasterClass{

	@Test
	public void logout() {
		 logger = extent.startTest("Logout test case");
		 
		 driver.findElement(By.id("welcome")).click();
		 commonWait(10);
		 logger.log(LogStatus.INFO, "Click on logout button");
		 driver.findElement(By.xpath("//a[text() = 'Logout']")).click();
		 captureScreenshot();
		 logger.log(LogStatus.PASS, "Logout successfully");
		 
		 
		 extent.endTest(logger);
	}
}
