package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	@DataProvider(name="Manufacturer")
	public String[] getData() throws IOException{
		String path = ".\\testData\\InputData.xlsx";
		ExcelUtility excelUtility = new ExcelUtility(path);
		String manufacturer[] = new String[1];
		manufacturer[0] = excelUtility.getCellData("Sheet1", 1, 0);
		return manufacturer;
	}
}
