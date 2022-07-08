package testCases;

import org.openqa.selenium.By;

import utilities.MasterClass;

public class GetTextAndAttributes extends MasterClass{

	public static void main(String[] args) {

		openBrowser("Chrome");
		
		
		
		openAUT("https:\\www.github.com");

//		System.out.println(driver.findElement(By.xpath("//h1[starts-with(@class, 'h1-mktg')]")).getText());		
//		System.out.println(driver.findElement(By.xpath("//h1[starts-with(@class, 'h1-mktg')]")).getAttribute("textContent"));		
//		System.out.println(driver.findElement(By.xpath("//h1[starts-with(@class, 'h1-mktg')]")).getAttribute("innerHTML"));
//		System.out.println(driver.findElement(By.xpath("//p[starts-with(@class, 'f2-mktg text-normal')]")).getText());
//		System.out.println(driver.findElement(By.xpath("//p[starts-with(@class, 'f2-mktg text-normal')]")).getAttribute("textContent"));
//		System.out.println(driver.findElement(By.xpath("//p[starts-with(@class, 'f2-mktg text-normal')]")).getAttribute("innerHTML"));
//		System.out.println(driver.findElement(By.xpath("//h3[contains(@class, 'f2-mktg text-gray-light-mktg text-semibold mb-3')]")).getText());
//		System.out.println(driver.findElement(By.xpath("//h3[contains(@class, 'f2-mktg text-gray-light-mktg text-semibold mb-3')]")).getAttribute("textContent"));
//		System.out.println(driver.findElement(By.xpath("//h3[contains(@class, 'f2-mktg text-gray-light-mktg text-semibold mb-3')]")).getAttribute("innerHTML"));
		
		
//		driver.findElement(By.xpath("//a[starts-with(@href, '/login')]")).click();
//		driver.findElement(By.id("login_field")).sendKeys("mukesh.jhorar1208@gmail.com");
//		System.out.println(driver.findElement(By.id("login_field")).getAttribute("value"));
//		driver.findElement(By.id("login_field")).clear();
//		driver.findElement(By.id("login_field")).sendKeys("yashuchoudhary75@gmail.com");
//		System.out.println(driver.findElement(By.id("login_field")).getAttribute("value"));
//		driver.findElement(By.id("password")).sendKeys("yashika1208");
//		System.out.println(driver.findElement(By.id("password")).getAttribute("value"));

		
		click("//a[starts-with(@href, '/login')]");
		
		enterText("login_field", "mukesh.jhorar1208@gmail.com");
		
		getAttribute("//input[@id='login_field']", "value");
		
		getText("//a[starts-with(@data-ga-click,'Sign ')]");
		
		
		
		
		
		
		shuttingDown();
		
	
		
	}
}





