package utilities;

import java.io.File;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class MasterClass {

	public static WebDriver driver;
	public static ExtentReports extent;
	public static ExtentTest logger;
	public static String ScreenShotName;

	public static void openBrowser(String browserName) {
		try {
			if (browserName.equalsIgnoreCase("Chrome")) {
				System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");
				driver = new ChromeDriver();
				System.out.println(browserName + " browser is up and running");
			} else if (browserName.equalsIgnoreCase("Edge")) {
				System.setProperty("webdriver.edge.driver",
						System.getProperty("user.dir") + "\\Drivers\\msedgedriver.exe");
				driver = new EdgeDriver();
				System.out.println(browserName + " browser is up and running");
			} else if (browserName.equalsIgnoreCase("Firefox")) {
				System.setProperty("webdriver.gecko.driver", "E:\\SeleniumCoding\\Selenium\\Drivers\\geckodriver.exe");
				driver = new FirefoxDriver();
				System.out.println(browserName + " browser is up and running");
			} else {
				System.out.println("Invalid browser : - " + browserName);
			}
		} catch (Exception e) {
			System.out.println("UNABLE to launch browser : - " + browserName);
		}

	}

	public static void openAUT(String URL) {
		try {
			driver.get(URL);
			System.out.println("AUT is up and running : - " + URL);
		} catch (Exception e) {
			System.out.println("UNABLE to running AUT : - " + e.getMessage());
		}
	}

	public static void click(String locName) {
		try {
			driver.findElement(By.xpath(locName)).click();
			System.out.println("Click an element having locator : - " + locName);
		} catch (Exception e) {
			System.out.println("UNABLE to click an element having locator : - " + locName);
		}
	}

	public static void enterText(String locName, String data) {
		try {
			driver.findElement(By.id(locName)).sendKeys(data);
			System.out.println("Enter the " + data + " into the textbox having locator : - " + locName);
		} catch (Exception e) {
			System.out.println("UNABLE to enter the " + data + " into the textbox having locator : - " + locName);
		}
	}

	public static Object getAttribute(String xapth, String attri) {

		String text = driver.findElement(By.xpath(xapth)).getAttribute(attri);
		System.out.println(text);
		return text;

	}

	public static Object getText(String xpath) {
		String text = driver.findElement(By.xpath(xpath)).getText();
		System.out.println(text);
		return text;

	}

	public static void commonWait(int time) {
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}

	public static void customWait(String xpath, int time) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, time);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
			System.out.println("Explicit wait is given having locator : - " + xpath);
		} catch (Exception e) {
			System.out.println("UNABLE to given explicit wait having locator : -" + xpath);
		}
	}

	public static void captureScreenshot() {

		Date d = new Date();

		String d1 = d.toString().replace(":", "_").replace(" ", "_");
		ScreenShotName = "Screen_" + d1 + ".jpg";
		System.out.println(ScreenShotName);
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String destPath = "E:\\SeleniumCoding\\Selenium\\Reports\\Screenshots\\" + ScreenShotName;
		File dest = new File(destPath);

		try {
			FileUtils.copyFile(src, dest);
			System.out.println(" --- Screenshots is captured  --- ");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		logger.log(LogStatus.INFO, logger.addScreenCapture(destPath));
	}

	public static void selectByText(String xpath, String text) {
		Select s = new Select(driver.findElement(By.xpath(xpath)));
		s.selectByVisibleText(text);
	}

	public static void selectByValue(String xpath, String value) {
		Select s = new Select(driver.findElement(By.xpath(xpath)));
		s.deselectByValue(value);

	}

	public static void selectByIndex(String xpath, int indexNo) {
		try {
			new Select(driver.findElement(By.xpath(xpath))).selectByIndex(indexNo);
			System.out.println("Select the option having index position " + indexNo + " using :- " + xpath);
		} catch (Exception e) {
			System.out.println("UNABLE to select the option having index position " + indexNo + " using : - " + xpath);
		}
	}

	public static void shuttingDown() {
		driver.quit();
		System.out.println("Quitting the execution process.");
	}

}
