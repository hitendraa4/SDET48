package jdbc;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.collections.iterators.ObjectArrayIterator;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ujetix.genericutilities.IPathConstant;

public class ExceldataPeovider {
	
	@DataProvider
	public Object[][] getDataExcel(String sheet) throws Throwable, IOException
	{
		FileInputStream fi=new FileInputStream(IPathConstant.excelFilePath);
		
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet(sheet);
		int row=sh.getLastRowNum()+1;
		int cell=sh.getRow(0).getLastCellNum();
	
		
		Object[][] ar=new Object[row][cell];
		for(int i=0;i<row;i++)
		{
			for(int j=0;j<cell;j++)
			{
				ar[i][j]=sh.getRow(i).getCell(j).getStringCellValue();
				
			}
		}
		return ar;
		
	}

}
