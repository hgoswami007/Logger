package hardikgoswami.Abstract;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.google.common.collect.Table.Cell;




// To read the excel data user require to Apache POI file
public class excelData {
	
	public void readDataToExcel() throws IOException{
		
		FileInputStream fis = new FileInputStream("D:\\DemoFile.xlsx");
		XSSFWorkbook workbook= new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("Add sheetName");
		Row row = sheet.getRow(0);
		Cell cell = (Cell) row.getCell(0);
		System.out.println(sheet.getRow(0).getCell(0));
	}

}
