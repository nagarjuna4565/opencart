package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	@DataProvider(name = "LoginData")
	public String[][] LoginData() throws IOException {

	    String path = ".\\testData\\Opencart_LoginData.xlsx";

	    ExcelUtility xlutil = new ExcelUtility(path);

	    int totalRows = xlutil.getRowCount("Sheet1");     // includes header
	    int totalCols = xlutil.getColumnCount("Sheet1");  // number of columns

	    // Create 2D array for TestNG (excluding header row)
	    String loginData[][] = new String[totalRows - 1][totalCols];

	    for (int i = 1; i < totalRows; i++) {  // start at 1 to skip header
	        for (int j = 0; j < totalCols; j++) {
	            loginData[i - 1][j] = xlutil.getCellData("Sheet1", i, j);
	        }
	    }

	    return loginData;  //return 2d array
	}
	
	//Data provider2
	//Data provider3
	//Data provider4
	
	
}
