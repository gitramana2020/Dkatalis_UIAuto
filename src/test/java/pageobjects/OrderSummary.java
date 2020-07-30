package pageobjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class OrderSummary {
	WebDriver driver;
	public OrderSummary(WebDriver ldriver){
		this.driver=ldriver;
		
	}
	@FindBy(xpath="//*[contains(text(),'Order Summary')]")
	@CacheLookup
	WebElement titleOrderSummary;
	
	@FindBy(xpath="//a[@class='button-main-content']")
	@CacheLookup
	WebElement btnOrderSummaryContinue;
	
	public void fnOrderSummary() {
		
		driver.switchTo().frame("snap-midtrans");		
		WebDriverWait wd= new WebDriverWait(driver, 60);
		wd.until(ExpectedConditions.elementToBeClickable(titleOrderSummary));
		Assert.assertEquals("Order Summary",titleOrderSummary.getText().trim(),"Successfully dispalyed");
		btnOrderSummaryContinue.click();
	
	}
	
}
