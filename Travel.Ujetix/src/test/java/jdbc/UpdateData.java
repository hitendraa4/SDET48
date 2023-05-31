package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class UpdateData {
public static void main(String[] args) throws Exception {
	Driver driver=new Driver();
	DriverManager.registerDriver(driver);
	
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql","root","root");
	try {
		Statement stat = con.createStatement();
		String query="insert into persons values(15,'singh','abhi','jaipur','Rajasthan')";
		int result = stat.executeUpdate(query);
		if(result==1)
		{
			System.out.println("data is added succesfully");
		}
		else {
			System.out.println("data is not added successfully");
		}
	}
		finally {
			con.close();
		}
	}
	
}

