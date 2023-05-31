package jdbc;

import org.testng.annotations.Test;

public class DataProviderClass2 {
	
	@Test(dataProviderClass = DataProviderPractice.class,dataProvider = "data")
	public void print(String name, String login, String pass)
	{
		System.out.println(name+"---->"+login+"------->"+pass);
	}

	
	@Test(dataProviderClass = DataProviderPractice.class,dataProvider = "data1")
	public void employee(String name,String job,String place,int age)
	{
		System.out.println(name+"----->"+job+" -->"+place+"-->"+age);
	}
	
	
	
	 @Test(dataProviderClass = DataProviderPractice.class,dataProvider = "data3")
	   public void employee(String name,String job,String place,int age,String rating )
	   {
		   System.out.println(name+"->"+job+" "+place+" "+age+" "+rating);
	   }
}




