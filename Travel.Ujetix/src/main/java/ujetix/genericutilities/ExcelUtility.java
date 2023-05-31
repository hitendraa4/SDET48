package ujetix.genericutilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	
	/**
	 * this method is used to write data in execel file
	 * @param SheetName
	 * @param row
	 * @param cell
	 * @param Data
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	
	public void setExcelData(String SheetName, int row,int cell, String Data ) throws EncryptedDocumentException, IOException 
	{
		FileInputStream fis=new FileInputStream(IPathConstant.excelFilePath);
		  Workbook wb = WorkbookFactory.create(fis);
		  
		  
		 Sheet Sheet = wb.getSheet(SheetName);
		 Row rw = Sheet.createRow(row);
		 rw.createCell(cell).setCellValue(Data);
		 FileOutputStream fos=new FileOutputStream(IPathConstant.excelFilePath);
		 wb.write(fos);
		 wb.close();
	}
	/**
	 * this method is used to get data from excel file
	 * @param SheetName
	 * @param row
	 * @param cell
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	
	public String getExcelData(String SheetName,int row,int cell) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(IPathConstant.excelFilePath);
		  Workbook wb = WorkbookFactory.create(fis);
		  Sheet sheet = wb.getSheet(SheetName);
		  Cell cella = sheet.getRow(row).getCell(cell);
		  DataFormatter df=new DataFormatter();
		  String data=df.formatCellValue(cella);
		  return data;
		  
	}
	/**
	 * this method is used to get the count of row
	 * @param sheetName
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	
	public int getRowNumber(String sheetName) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(IPathConstant.excelFilePath);
		  Workbook wb = WorkbookFactory.create(fis);
		  Sheet sheet = wb.getSheet(sheetName);
		   int rowcount=sheet.getLastRowNum();
		   return rowcount;
	}
	
	// 
	
	public HashMap<String,String> getMultipleData(String sheetName)throws Throwable
	{
		FileInputStream fis=new FileInputStream(IPathConstant.excelFilePath);
		  Workbook wb = WorkbookFactory.create(fis);
		  Sheet sh = wb.getSheet(sheetName);
		  int count=sh.getLastRowNum();
		  
		  HashMap<String,String> map=new HashMap<String,String>();
		  
		  for(int i=0;i<=count;i++)
		  {
			  String key=sh.getRow(i).getCell(0).getStringCellValue();
			  String value=sh.getRow(i).getCell(1).getStringCellValue();
			  map.put(key, value);
		  }
		  return map;
		  
		
	}

}
