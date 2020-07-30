package pageobjects;

import org.testng.annotations.Test;

import utilities.ExcelHandler;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;


public class Midtranssales extends BaseClass{

	@Test
	public void TcSuccessfulTransaction() throws InterruptedException  // Constructor to initiate the driver
	{
		// Creating page object for respective classes 		
		ShoopingCart objShoppingCartcls =PageFactory.initElements(driver,ShoopingCart.class);		
		objShoppingCartcls.fnBuynCheckout();

		OrderSummary objSOrderSummarycls =PageFactory.initElements(driver,OrderSummary.class);		
		objSOrderSummarycls.fnOrderSummary();

		Paymentmethod objPaymentmethodcls =PageFactory.initElements(driver,Paymentmethod.class);		
		objPaymentmethodcls.clickonCrediCardPAyment();
	
		Paymentsection objPaymentsection =PageFactory.initElements(driver,Paymentsection.class);		
		objPaymentsection.enterCCdetails(
				xldataprovider.getxlStringValue(1, 0), 
				xldataprovider.getxlStringValue(1, 1), 
				xldataprovider.getxlintValue(1, 2)
				);
		
		Paymentsection_OTP objPaymentsection_OTP =PageFactory.initElements(driver,Paymentsection_OTP.class);		
		objPaymentsection_OTP.enterOTPdetails( 
				xldataprovider.getxlintValue(1, 3)
				);
	
		
			
		
		
		
	}
}
