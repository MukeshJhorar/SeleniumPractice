package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import utilities.MasterClass;

public class DropDownRadioButtonCheckBoxTC extends MasterClass{

	@Test
	public void handleDropDown() {
		
		logger = extent.startTest("Dropdown handling test case");
		
		
		driver.manage().deleteAllCookies();
		driver.get("https://seleniumautomationpractice.blogspot.com/");
		captureScreenshot();
		logger.log(LogStatus.INFO, "Open URL");
		driver.findElement(By.xpath("//a[contains(text(), 'Testing')]")).click();
		logger.log(LogStatus.INFO, "Clcik on Testing form page");
		selectByIndex("//select[starts-with(@id,'ts_country')]", 3);
		captureScreenshot();
		logger.log(LogStatus.INFO, "Dropdown selected");
		logger.log(LogStatus.PASS, "Dropdown select successfully");
		
		
		extent.endTest(logger);
		
	}
	
	
	@Test(priority = 1, dependsOnMethods = "handleDropDown")
	public void handleRadioButton() {
		
		logger = extent.startTest("Radio button handle");
		
		WebElement radio1 = driver.findElement(By.xpath("//input[starts-with(@value, 'male')]"));
		logger.log(LogStatus.INFO, "1 Radion button select");
		WebElement radio2 = driver.findElement(By.xpath("//input[starts-with(@value, 'female')]"));
		logger.log(LogStatus.INFO, "2 Radio button select");
		radio1.click();
		captureScreenshot();
		logger.log(LogStatus.PASS, "1 Radio button is selected");
		System.out.println(radio1.isSelected());
		System.out.println(radio2.isSelected());
		System.out.println(driver.findElements(By.xpath("//input[starts-with(@type,'radio')]")).size());
		
		extent.endTest(logger);
	}
	

	@Test(priority = 2, dependsOnMethods = "handleRadioButton") 
	void selectCheckBox() {
		logger = extent.startTest("Check box is selected");
		
		WebElement button = driver.findElement(By.name("Submit1"));
		Actions action = new Actions(driver);
		action.moveToElement(button);
		action.perform();
		
		driver.findElement(By.xpath("//input[starts-with(@value,'cricket')]")).click();
		captureScreenshot();
		logger.log(LogStatus.INFO, "Selecting the check box");
		logger.log(LogStatus.PASS, "Check box is selected");
		
		System.out.println(driver.findElements(By.xpath("//input[@type  = 'checkbox']")));
		
		extent.endTest(logger);
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
































