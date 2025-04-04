package vtiger.practise;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;



public class ReadDataFromExcel {
public static void main(String[] args) throws EncryptedDocumentException, IOException {
	//load file into fileinput stream
	FileInputStream fis=new FileInputStream("./src/test/resources/excel1.xlsx");
	//create workbook using workbookfactory
	Workbook wb=WorkbookFactory.create(fis);
	
	//navigate to sheet
	Sheet sh = wb.getSheet("Organization");
	//navigate to row
 Row row = sh.getRow(1);
	//navigate to cell
 Cell cell = row.getCell(2);
	//read the response cell value
 String value = cell.getStringCellValue();
 System.out.println(value);
	
}
}
