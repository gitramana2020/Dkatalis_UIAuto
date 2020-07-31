package pageobjects;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.support.PageFactory;

public class Midtranssales extends BaseClass{

	@Test(priority=1)
	public void TcSuccessfulTransaction() throws InterruptedException   
	{
		logger=	extnreport.createTest("TcSuccessfulTransaction");				
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
		objPaymentsection_OTP.enterOTPdetails(xldataprovider.getxlStringValue(1,3));
		
		
	}
	@Test(priority=2)
	public void TcUnsuccessfulTransaction() throws InterruptedException  
	{
		logger=	extnreport.createTest("TcUnsuccessfulTransaction");		
		// Creating page object for respective classes 		
		ShoopingCart objShoppingCartcls =PageFactory.initElements(driver,ShoopingCart.class);		
		objShoppingCartcls.fnBuynCheckout();

		OrderSummary objSOrderSummarycls =PageFactory.initElements(driver,OrderSummary.class);		
		objSOrderSummarycls.fnOrderSummary();

		Paymentmethod objPaymentmethodcls =PageFactory.initElements(driver,Paymentmethod.class);		
		objPaymentmethodcls.clickonCrediCardPAyment();
	
		Paymentsection objPaymentsection =PageFactory.initElements(driver,Paymentsection.class);		
		objPaymentsection.enterCCdetails(
				xldataprovider.getxlStringValue(2, 0), 
				xldataprovider.getxlStringValue(2, 1), 
				xldataprovider.getxlintValue(2, 2));
		
		Paymentsection_OTP objPaymentsection_OTP =PageFactory.initElements(driver,Paymentsection_OTP.class);		
		objPaymentsection_OTP.enterOTPdetails( 
				xldataprovider.getxlStringValue(2, 3)
				);		
	}
	
	@AfterMethod
	public void verifymethodstatus(ITestResult result)
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			logger.log(Status.FAIL," Test Case Fail "+result.getName());
			logger.log(Status.FAIL," Test Case Fail "+result.getThrowable());
		}else
		{
			logger.log(Status.PASS,result.getName() +" Test Case PASS Scuccessfully");
		}
		extnreport.flush();
	}
	
}


