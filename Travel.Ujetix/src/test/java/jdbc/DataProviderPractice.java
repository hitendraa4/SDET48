package jdbc;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPractice {
	@DataProvider
	public Object[][] data()
	{
		Object[][] ar= new Object[3][3];
		ar[0][0]="admin1";
		ar[0][1]="login1";
		ar[0][2]="pass1";
		
		ar[1][0]="admin3";
		ar[1][1]="login2";
		ar[1][2]="pass2";
		
		ar[2][0]="admin3";
		ar[2][1]="login2";
		ar[2][2]="pass2";
		
		return ar;
		
		
	}
	
	@DataProvider
	public Object[][] data1()
	{
		Object[][] ar= new Object[4][4];
		ar[0][0]="Rahul";
		ar[0][1]="QA";
		ar[0][2]="bengaluru";
		ar[0][3]=25;
		
		ar[1][0]="Abhishekk";
		ar[1][1]="QA";
		ar[1][2]="jaipur";
		ar[1][3]=25;
		
		ar[2][0]="Tilak";
		ar[2][1]="QA";
		ar[2][2]="masoor";
		ar[2][3]=25;
		
		ar[3][0]="Himanshu";
		ar[3][1]="QA";
		ar[3][2]="Ghuwati";
		ar[3][3]=25;
		return ar;
		
	}
	
	@DataProvider
	public Object[][] data3()
	{
		Object[][] ar= new Object[4][5];
		
		ar[0][0]="Rahul";
		ar[0][1]="QA";
		ar[0][2]="Bengaluru";
		ar[0][3]=25;
		ar[0][4]="*";
		
		ar[1][0]="Abhishekk";
		ar[1][1]="QA";
		ar[1][2]="Jaipur";
		ar[1][3]=25;
		ar[1][4]="*";
		
		ar[2][0]="Tilak";
		ar[2][1]="QA";
		ar[2][2]="Masoor";
		ar[2][3]=25;
		ar[2][4]="*";
		
		ar[3][0]="Himanshu";
		ar[3][1]="QA";
		ar[3][2]="Ghuwati";
		ar[3][3]=25;
		ar[3][4]="*";
		return ar;
		
	}
	
	
	
	
	@Test(dataProvider = "data")
	public void print(String name, String login, String pass)
	{
		System.out.println(name+"---->"+login+"------->"+pass);
	}
	
	
	
	
	
	
	
   @Test(dataProvider = "data1")
   public void employee(String name,String job,String place,int age )
   {
	   System.out.println(name+"->"+job+" "+place+" "+age);
   }
   
   
   
   
   
   
   @Test(dataProvider = "data3")
   public void employee(String name,String job,String place,int age,String rating )
   {
	   System.out.println(name+"->"+job+" "+place+" "+age+" "+rating);
   }
}
