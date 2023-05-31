package ujetix.genericutilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class DataBaseUtility {
	
	Connection con;
	
	public void getDatabaseConnection(String jdbcUrl) throws Throwable
	{
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		
		 con= DriverManager.getConnection(jdbcUrl);
	}
	
	
	public void closeConnection() throws SQLException
	{
		con.close();
	}
	
	
	public void writeAndExecuteUpdateQuery(String query) throws SQLException
	{
		
			Statement stat = con.createStatement();
		String Query=query;
		
		             int result = stat.executeUpdate(query);
		             if(result==1)
		             {
		            	 System.out.println("data is added");
		             }
		             else {
		            	 System.out.println("data is nt added");
		             }
	}
	
	public void writeAndExecuteQuery(String query,int colstring) throws Throwable
	{
		Statement stat = con.createStatement();
		String Query=query;
		
		ResultSet resultset = stat.executeQuery(Query);
		while (resultset.next()) {
			String dvd = resultset.getString(colstring);
			System.out.println(dvd);
		}

	}



}
