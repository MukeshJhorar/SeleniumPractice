package testCases;

import utilities.MasterClass;

public class Clickable extends MasterClass{

	public static void main(String[] args) {
		
		openBrowser("chrome");
		
		openAUT("https://seleniumautomationpractice.blogspot.com/");
		
		click("//a[starts-with(text(),'Short Wait')]");
		
		commonWait(10);
		
		getAttribute("//a[starts-with(text(),' DO NOT PUSH')]", "href");
		
		getText("//a[starts-with(text(),' DO NOT PUSH')]");
		
		click("//a[starts-with(text(),' DO NOT PUSH')]");
		
		driver.navigate().back();
		
		driver.navigate().back();
		
		click("//a[starts-with(text(),'Long ')]");
		
		customWait("//a[starts-with(text(),' DO NOT PUSH')]", 60);
		
		click("//a[starts-with(text(),' DO NOT PUSH')]");
		
		
		shuttingDown();
	}
}
