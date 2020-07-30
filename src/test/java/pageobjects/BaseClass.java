package pageobjects;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import utilities.Browserfactory;
import utilities.ExcelHandler;


public class BaseClass {
	public WebDriver driver ;
	public ExcelHandler xldataprovider;
	
	@BeforeSuite
	public void ReadExcel() {
		xldataprovider = new ExcelHandler();
	}
	@BeforeClass
	public void fnOpenApplication() {		
		driver=Browserfactory.OpenApplication(driver, "FireFox","https://demo.midtrans.com/");
	}

	@AfterClass
	public void fnClosetheapplication() throws InterruptedException {
		Browserfactory.QuitBrowser(driver);
	}

}
