package utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Browserfactory {

	public static WebDriver OpenApplication(WebDriver driver,String BrowserName, String URL) {

		if(BrowserName.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver");
			driver= new ChromeDriver();

		}else if(BrowserName.equalsIgnoreCase("FireFox")) {
			System.setProperty("webdriver.gecko.driver", "Drivers/geckodriver");
			driver= new FirefoxDriver();
		}else {
			System.out.println(" Please give valid browser Name");
		}
		driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);	
		driver.get(URL);
		driver.manage().window().maximize();		
		return driver;		
	}

	public static void QuitBrowser(WebDriver driver) throws InterruptedException {
		Thread.sleep(10000);
//		driver.quit();
	}
}
