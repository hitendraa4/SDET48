package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class Jdbc {

	

	public static void main(String[] args) throws Exception {
		
			Driver driver=new Driver();
			DriverManager.registerDriver(driver);
			
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql","root","root");
			try {
				Statement stat = con.createStatement();
			String query="insert into persons values(12,'sv','Himanshu','Bharatpur','Karnataka');";
			
			             int result = stat.executeUpdate(query);
			             if(result==1)
			             {
			            	 System.out.println("data is added");
			             }
			             else {
			            	 System.out.println("data is nt added");
			             }
			
		}
		 finally {
			 con.close();
		}

	}

}
