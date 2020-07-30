import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import utilities.ExcelHandler;

public class Sample {
	XSSFWorkbook wkbk= null;
	public static void main(String[] args) throws InterruptedException {
		//		System.setProperty("webdriver.chrome.driver", "/Users/ramana/Downloads/chromedriver");
		//		WebDriver driver= new ChromeDriver();
		//		
		//		driver.get("https://demo.midtrans.com/");
		//		driver.findElement(By.xpath("//*[contains(text(),'BUY NOW')]")).click();
		//		Thread.sleep(5000);
		//		
		//		driver.findElement(By.xpath("//div[@class='cart-checkout']")).click();
		//		Thread.sleep(5000);
		//		
		//		driver.switchTo().frame("snap-midtrans");	
		//		//Click on Contiune
		//		driver.findElement(By.xpath("//a[@class='button-main-content']")).click();
		//		Thread.sleep(5000);
		////		driver.switchTo().defaultContent()
		//		driver.findElement(By.xpath("//span[@class='credit-card-full sprite']")).click();

		Sample objExcelData= new Sample();
//		double res=objExcelData.getxlintValue("CCDetails", 1, 2);
		String res=objExcelData.getxlStringValue("CCDetails", 1, 1);
		System.out.println(res);
	}

	public Sample() {
		File inputdata= new File("./Data/AllCCDetails.xlsx");
		try {
			FileInputStream fis= new FileInputStream(inputdata);
			wkbk= new XSSFWorkbook(fis);
		} catch (Exception e) {			
			e.printStackTrace();
		}
	}
	public String getxlStringValue(String Sheetname,int rownum,int columnnum)
	{
		String xlStrinvalue=wkbk.getSheet(Sheetname).getRow(rownum).getCell(columnnum).getStringCellValue();
		return xlStrinvalue;
	}
	public double getxlintValue(String Sheetname,int rownum,int columnnum)
	{
		double xlintvalue=wkbk.getSheet(Sheetname).getRow(rownum).getCell(columnnum).getNumericCellValue();
		return xlintvalue;
	}

}
