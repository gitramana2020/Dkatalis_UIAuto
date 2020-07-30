package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Paymentmethod {
	WebDriver driver;
	public Paymentmethod(WebDriver ldriver){
		this.driver=ldriver;		
	}
	@FindBy(xpath="//*[contains(text(),'Select Payment')]")
	@CacheLookup
	WebElement titlePaymentSection;
	
	@FindBy(xpath="//*[contains(@class,'list-title text-actionable-bold') and text() = 'Credit Card']")
	@CacheLookup
	WebElement lnkCeditCardPAyment;

	public void clickonCrediCardPAyment() throws InterruptedException {
		WebDriverWait wd= new WebDriverWait(driver, 60);
		wd.until(ExpectedConditions.elementToBeClickable(titlePaymentSection));
		lnkCeditCardPAyment.click();
		
		
	}
}
