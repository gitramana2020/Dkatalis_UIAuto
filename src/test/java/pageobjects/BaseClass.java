package pageobjects;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import utilities.Browserfactory;
import utilities.ExcelHandler;


public class BaseClass {
	public WebDriver driver ;
	public ExcelHandler xldataprovider;
	public ExtentHtmlReporter reporter;
	public static ExtentReports extnreport;
	public static ExtentTest logger;
	@BeforeSuite
	public void ReadExcel() {
		xldataprovider = new ExcelHandler();
		reporter = new ExtentHtmlReporter("./Reports/Dkatalis.html");
		extnreport = new ExtentReports();
		extnreport.attachReporter(reporter);
	}
	@Parameters("browser")
	@BeforeClass
	public void fnOpenApplication(String BrowserName) {		
		try {
			driver=Browserfactory.OpenApplication(driver, BrowserName,"https://demo.midtrans.com/");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@AfterClass
	public void fnClosetheapplication() throws InterruptedException {
		Browserfactory.QuitBrowser(driver);
	}

}
