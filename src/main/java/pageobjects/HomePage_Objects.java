package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage_Objects {
	
	public WebDriver driver;
	
	By signInButton = By.xpath(("//a[@class='login']"));
	
	
	public HomePage_Objects(WebDriver driver)
	{
		this.driver = driver;
	}
	
	
	public WebElement login()
	{
		return driver.findElement(signInButton);
	}
	
	
	
	

}
