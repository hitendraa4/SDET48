package ujetix.genericutilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtility {
	
	/**
	 * this method is used fetch property data
	 * @param Key
	 * @return
	 * @throws IOException
	 */
	public String getPropertyData(String Key) throws IOException
	{
		FileInputStream fis=new FileInputStream(IPathConstant.propertyFilePath);
		
		Properties p=new Properties();
		p.load(fis);
		String data = p.getProperty(Key);
		return data;
		
	}
	
	
	
	

}
