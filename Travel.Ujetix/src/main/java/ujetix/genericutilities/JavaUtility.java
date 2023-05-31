package ujetix.genericutilities;

import java.util.Date;
import java.util.Random;

public class JavaUtility {
	
	/**
	 * this method is used to get random number
	 * @return
	 */

	public int getRandomNumber()
	{
		Random r=new Random();
		int rn = r.nextInt(1000);
		return rn;
	}
	/**
	 * this method is used to get Current date
	 * @return
	 */
	public String getCurrentDate()
	{
		Date d=new Date();
		String currentDate = d.toString();
		return currentDate;
	}
	
	/**
	 * this method is used to get current system in required  date format
	 */
	
	public String  getSystemDateFormat()
	{
		Date d=new Date();
		String cd = d.toString();
		   String[] dd = cd.split(" ");
		   
		    int month=d.getMonth();
		    String week=dd[0];
		    String cdate=dd[2];
		    String year=dd[5];
		    
		    String dateFormat=month+" "+week+" "+cdate+" "+year;
		    
		return dateFormat;
	}

}
