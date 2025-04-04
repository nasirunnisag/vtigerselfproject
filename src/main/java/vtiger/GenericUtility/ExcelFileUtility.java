package vtiger.GenericUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelFileUtility {
	/**
	 * 
	 * @param sheet
	 * @param row
	 * @param cell
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
public String readDataFromFile(String sheet,int row,int cell) throws EncryptedDocumentException, IOException
{
	FileInputStream fis=new FileInputStream(IConstantUtility.excelfilepath);
	Workbook wb=WorkbookFactory.create(fis);
	Sheet sh = wb.getSheet(sheet);
	Row r = sh.getRow(row);
	Cell c = r.getCell(cell);
	String value = c.getStringCellValue();
	wb.close();
	return value;
}
	public int getRowCount(String sheet) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(IConstantUtility.excelfilepath);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheet);
		int data=sh.getLastRowNum();
		wb.close();
		return data;
	}
	
	public void writeDataIntoExcel(String sheet,int row,int cell,int value) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(IConstantUtility.excelfilepath);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet s=wb.getSheet(sheet);
		Row r=s.getRow(row);
		Cell c = r.createCell(cell);
		c.setCellValue(value);
		FileOutputStream fos=new FileOutputStream(IConstantUtility.excelfilepath);
		wb.write(fos);
		wb.close();
		
	}
	public Object[][] readMultipledatafromxcel(String sheet) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(IConstantUtility.excelfilepath);
		Workbook wb=WorkbookFactory.create(fis);
		
		Sheet sh=wb.getSheet(sheet);
		int lastrow=sh.getLastRowNum();
     	int lastcell = sh.getRow(0).getLastCellNum();
 	
     	Object[][] data=new Object[lastrow][lastcell];
     	for(int i=0;i<lastrow;i++)
     	{
     		for(int j=0;j<lastcell;j++)
     		{
     			data[i][j]=sh.getRow(i).getCell(j).getStringCellValue();	
     		}
     	}
     	return data;
	}
}
