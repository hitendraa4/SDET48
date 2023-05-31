package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class ReadDataFrom {

	public static void main(String[] args) throws Exception {
     Driver driver=new Driver();
     DriverManager.registerDriver(driver);
     
   Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Hitendra","root","root");
   try {  Statement stat = con.createStatement();
     String query="select * from employee";
     ResultSet result = stat.executeQuery(query);
    while(result.next())
    {
    	String data = result.getString(2)+" "+result.getString(3);
    	System.out.println(data);
    }
   }
    finally {
    	con.close();
    }
     
	}

}
