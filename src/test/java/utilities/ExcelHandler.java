package utilities;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelHandler {

	XSSFWorkbook wkbk= null;
	public ExcelHandler() {
		File inputdata= new File("./Data/AllCCDetails.xlsx");
		try {
			FileInputStream fis= new FileInputStream(inputdata);
			wkbk= new XSSFWorkbook(fis);
		} catch (Exception e) {			
			e.printStackTrace();
		}
	}
	public String getxlStringValue(int rownum,int columnnum)
	{
		String xlStrinvalue=wkbk.getSheet("CCDetails").getRow(rownum).getCell(columnnum).getStringCellValue();
		return xlStrinvalue;
	}
	public double getxlintValue(int rownum,int columnnum)
	{
		double xlintvalue=wkbk.getSheet("CCDetails").getRow(rownum).getCell(columnnum).getNumericCellValue();
		return xlintvalue;
	}
}
