package testCases;

import java.io.File;

import org.openqa.selenium.By;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;

import utilities.MasterClass;

public class LoginTC extends MasterClass {

	@BeforeSuite
	public void preRun() {

		if (extent == null) {
			extent = new ExtentReports("E:\\SeleniumCoding\\Selenium\\Reports\\report.html", true);
			extent.loadConfig(new File("E:\\SeleniumCoding\\Selenium\\Reports\\ReportsConfig.xml"));
			openBrowser("Chrome");
			driver.manage().window().maximize();
		}

	}

	@Test
	public void login() {
		logger = extent.startTest("Login test case");

		openAUT("https://opensource-demo.orangehrmlive.com/");
		captureScreenshot();
		logger.log(LogStatus.PASS, "Demo orang HRM Login page opens successfull");
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		logger.log(LogStatus.INFO, "Enter username");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		logger.log(LogStatus.INFO, "Enter password");
		driver.findElement(By.id("btnLogin")).click();
		captureScreenshot();
		logger.log(LogStatus.INFO, "Click on login button");
		logger.log(LogStatus.PASS, "Login Successfully");

		extent.endTest(logger);

	}

	@Test(priority = 1, dependsOnMethods = "login")
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

	@Test(priority = 2, dependsOnMethods = "logout")
	public void popupHandle() throws Exception {
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
		Thread.sleep(2000);
		captureScreenshot();
		logger.log(LogStatus.INFO, "Click on login button");
		logger.log(LogStatus.PASS, "Modal popup handling successfully");

		extent.endTest(logger);

	}

	@AfterSuite
	public void quitBrowser() {
		extent.flush();
		shuttingDown();
	}
}
