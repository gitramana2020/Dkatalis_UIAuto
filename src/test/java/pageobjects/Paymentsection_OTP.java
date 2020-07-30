package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Paymentsection_OTP {
	WebDriver driver;
	public Paymentsection_OTP(WebDriver ldriver){
		this.driver=ldriver;		
	}

	@FindBy(xpath="//div[@class='main-container']/div/iframe")
	@CacheLookup
	WebElement frameOTPPaymentSection;

	@FindBy(xpath="//*[contains(text(),'Password')]")
	@CacheLookup
	WebElement webelBankOTPField;

	@FindBy(css="#PaRes")
	@CacheLookup
	WebElement inputPassword;

	@FindBy(xpath="//button[@name='ok']")
	@CacheLookup
	WebElement btnOk;

	public void enterOTPdetails(double  BankOTP) throws InterruptedException{

		Thread.sleep(5000);
		driver.switchTo().frame(frameOTPPaymentSection);
		Thread.sleep(5000);
		inputPassword.click();
		System.out.println(BankOTP);
		inputPassword.sendKeys(String.valueOf(BankOTP));
		btnOk.click();
	}
}
