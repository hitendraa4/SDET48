package jdbc;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class ExcelDataProvider2 {

	
	
	
	
	
	
	@DataProvider
	public Object[][] testdata() throws IOException, Throwable
	{
		ExceldataPeovider ep=new ExceldataPeovider();
		Object[][] data = ep.getDataExcel("DataProvider");// sheet name
		return data;
	}
	
	@Test(dataProviderClass = ExceldataPeovider.class,dataProvider = "getDataExcel")
	public void getData(String Fromname,String toName, String no)
	{
		System.out.println("Name---->"+Fromname+"  to---->"+toName+"----->"+no);
		
	}
	   

}
