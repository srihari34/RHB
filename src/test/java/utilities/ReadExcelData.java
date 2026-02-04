package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadExcelData {
	
	 private Workbook workbook;
	 private Sheet sheet;

	    public ReadExcelData(String filePath, String sheetName) {
	        try {
	            FileInputStream fis = new FileInputStream(filePath);
	            workbook = WorkbookFactory.create(fis);
	            sheet = workbook.getSheet(sheetName);
	            if (sheet == null) {
	                throw new IllegalArgumentException("Sheet '" + sheetName + "' not found in file: " + filePath);
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

	    // Get cell data as String
	    public String getCellData(int rowNum, int colNum) {
	        Row row = sheet.getRow(rowNum);
	        Cell cell = row.getCell(colNum);
	        return cell.toString();
	    }
	    
	    // Optional: get number of rows
	    public int getRowCount() {
	        return sheet.getPhysicalNumberOfRows();
	        
	    }

}
