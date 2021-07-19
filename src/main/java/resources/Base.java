package resources;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Base {

	public WebDriver driver;
	public Properties prop;

	public WebDriver initBrowser() throws Throwable {

		try {
			prop = new Properties();

			FileInputStream fis = new FileInputStream(
					"C:\\Users\\shadma\\eclipse-workspace\\E2E_Framework_V1\\src\\main\\java\\resources\\testdata.properties");

			prop.load(fis);

			String browserName = prop.getProperty("browser");

			System.out.println(browserName);

			if (browserName.equals("chrome")) {
				System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\ChromeDriver\\chromedriver.exe");

				driver = new ChromeDriver();

				driver.manage().deleteAllCookies();

				driver.manage().window().maximize();

				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

				driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

				driver.get(prop.getProperty("url"));

				Thread.sleep(800);

			}

			else if (browserName.equals("IE")) {
				System.setProperty("webdriver.ie.driver",
						"C:\\Selenium\\IEDriverServer_x64_3.150.1\\IEDriverServer.exe");

				driver = new InternetExplorerDriver();

				driver.manage().deleteAllCookies();

				driver.manage().window().maximize();

				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

				driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

				driver.get(prop.getProperty("url"));

				Thread.sleep(800);

			}

			else if (browserName.equals("FireFox")) {
				System.setProperty("webdriver.gecko.driver",
						"C:\\Selenium\\geckodriver-v0.26.0-win64\\geckodriver.exe");

				driver = new FirefoxDriver();

				driver.manage().deleteAllCookies();

				driver.manage().window().maximize();

				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

				driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

				driver.get(prop.getProperty("url"));

				Thread.sleep(500);

			}

		}

		catch (Exception e) {
			// TODO: handle exception

			System.out.println(e);
		}

		return driver;
	}

}
