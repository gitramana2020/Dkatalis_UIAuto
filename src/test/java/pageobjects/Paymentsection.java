package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Paymentsection {
	WebDriver driver;
	public Paymentsection(WebDriver ldriver){
		this.driver=ldriver;		
	}
	
	@FindBy(xpath="//*[contains(@class, 'text-page-title-content') and text() = 'Credit Card']")
	@CacheLookup
	WebElement titlePaymentSection;
	
	@FindBy(name="cardnumber")
	@CacheLookup
	WebElement inputCardNumber;
	
	@FindBy(xpath="//input[@placeholder='MM / YY']")
	@CacheLookup
	WebElement inputExpiryDate;
	
	@FindBy(xpath="//input[@placeholder='123']")
	@CacheLookup
	WebElement inputCVV;
	
	@FindBy(xpath="//a[@class='button-main-content']")
	@CacheLookup
	WebElement btnPayNow;
	
	public void enterCCdetails(String CCNumber,String CCExpirydate,double  CCcvvNumber){
		WebDriverWait wd= new WebDriverWait(driver, 60);
		wd.until(ExpectedConditions.elementToBeClickable(titlePaymentSection));		
		inputCardNumber.sendKeys(String.valueOf(CCNumber));
		inputExpiryDate.sendKeys(CCExpirydate);
		inputCVV.sendKeys(String.valueOf(CCcvvNumber));	
		btnPayNow.click();
		Assert.assertTrue(true);
	}
}
