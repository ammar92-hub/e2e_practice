package testcases;

import org.apache.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageobjects.HomePage_Objects;
import resources.Base;



public class HomePage extends Base{
	
	public WebDriver driver;
	
	String pageTitle ="My Store";
	
	org.apache.log4j.Logger  log = LogManager.getLogger("HomePage");
	
	@BeforeTest
	public void loadPage() throws Throwable
	{
		
		log.info("Browser is being initialized");
		driver = initBrowser();
		
		//Assert.assertEquals(driver.getTitle(), pageTitle);
		
		
		Assert.assertEquals(driver.getTitle(), pageTitle, "Page title is incorrect");
		
		System.out.println("Test case passed");
		
		Thread.sleep(400);
		
				
	}
	
	
	@Test
	public void signIn() throws InterruptedException
	{
		HomePage_Objects h1 = new HomePage_Objects(driver);
		h1.login().click();
		
		Thread.sleep(1500);
	}
	
	
	@AfterTest
	
	public void tearDown()
	{
		driver.close();
	}
	
	
	

}
