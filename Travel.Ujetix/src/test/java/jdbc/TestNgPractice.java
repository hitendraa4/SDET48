package jdbc;

import org.testng.annotations.Test;

public class TestNgPractice {
	
	@Test
	public void createUser()
	{
		System.out.println("create User");
	}

	@Test(priority = 1)
	public void updateUser()
	{
		System.out.println("updateUser");
	}
	
	@Test(dependsOnMethods = "createUser" )
	public void deleteUser()
	{
		System.out.println("deleteUser");
	}

	
	@Test
	public void readUser()
	{
		System.out.println("readUser");
	}


}
