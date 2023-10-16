package Week6.Day1HomeAssignment;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class IntegrationWithTC3 {
	
	public static String[][] excelData() throws IOException {


		XSSFWorkbook wb=new XSSFWorkbook("./data/W3Schools.xlsx");


		XSSFSheet sheet=wb.getSheetAt(0);


		XSSFRow row=sheet.getRow(0);

		int rowCount= sheet.getLastRowNum();
		System.out.println("no of rows :"+rowCount);

		int cellCount = row.getLastCellNum();
		System.out.println("no of cells :"+cellCount);
	
		String[][] data = new String[rowCount][cellCount];


		for (int i = 1; i <=rowCount; i++) {

			XSSFRow row2 = sheet.getRow(i);

			for (int j = 0; j <cellCount; j++) {

				String data1 = row2.getCell(j).getStringCellValue();
				System.out.println(data1);
			
				data[i-1][j] = data1;
			}

		}


		wb.close();
		return data;

}


}
