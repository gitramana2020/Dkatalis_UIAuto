package pageobjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class ShoopingCart {
	 WebDriver driver ;

	public ShoopingCart(WebDriver ldriver)  // Constructor to initiate the driver
	{
		this.driver=ldriver;
//		
	}
	@FindBy(xpath="//*[contains(text(),'BUY NOW')]")
	@CacheLookup
	WebElement btnBuyNow;

	@FindBy(xpath="//div[@class='cart-checkout']")
	@CacheLookup
	WebElement btnCartChekout;
	
	@FindBy(xpath="//*[contains(text(),'Shopping Cart')]")
	@CacheLookup
	WebElement titleShoppingCart;
	
	
	public void fnBuynCheckout() throws InterruptedException
	{
		
		btnBuyNow.click();
		Thread.sleep(5000);
		Assert.assertTrue(driver.getPageSource().contains("Midtrans Pillow"));
		btnCartChekout.click();
	}

	
	
	
}
