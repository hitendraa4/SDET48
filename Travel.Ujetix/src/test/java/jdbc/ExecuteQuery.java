package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class ExecuteQuery {

	public static void main(String[] args) throws SQLException {
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql","root","root");
		try {
			Statement stat = con.createStatement();
		String query="select * from persons";
		
		             ResultSet result = stat.executeQuery(query);
		             while(result.next())
		             {
		            	 System.out.println(result.getString(3)+" "+result.getInt(1)+" "+result.getString(4));
		             }
	}
	 finally {
		 con.close();
	}

	}

}
