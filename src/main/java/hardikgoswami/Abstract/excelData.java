package hardikgoswami.Abstract;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

// To read the excel data user require to Apache POI file
public class excelData {

	public ArrayList readDataToExcel() throws IOException {
		ArrayList dataExcle = new ArrayList();
		FileInputStream fis = new FileInputStream("C:\\Users\\Admin\\eclipse-workspace\\Introduction\\Book.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("Policy");

		Iterator<Row> row = sheet.rowIterator();

		while (row.hasNext()) {
			Row r = row.next();			
			if (r.getCell(0).getStringCellValue().equalsIgnoreCase("State")) {
				
				Iterator<Cell> cv = r.cellIterator();
				while (cv.hasNext()) 
				{
//					System.out.println(cv.next().getStringCellValue());
					dataExcle.add(cv.next().getStringCellValue());
				}
				
			}

		}
		return dataExcle;
	}
}
