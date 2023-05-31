package handlingfiles;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class GetExcelData {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis1=new FileInputStream("./src/test/resources/testdata.xlsx");
        Workbook wb = WorkbookFactory.create(fis1);
       Sheet sheet = wb.getSheet("Sheet1");
        int count = sheet.getLastRowNum();
        for(int i=0;i<count;i++)
        {
        	String text=sheet.getRow(i).getCell(0).getStringCellValue();
        	System.out.println(text);
        }
        wb.close();
	}

}
