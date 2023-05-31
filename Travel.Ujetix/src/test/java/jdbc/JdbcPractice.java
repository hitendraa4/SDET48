package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class JdbcPractice {

	public static void main(String[] args) throws SQLException {
		// Registering the MySQL JDBC driver
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);

		// Establishing a connection between the application and the database
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql", "root", "root");
		try {
			// Creating a statement object to execute SQL queries
			Statement statement = connection.createStatement();

			// Defining the SQL query
			String query = "SELECT * FROM persons";

			// Executing the query and obtaining the result set
			ResultSet resultSet = statement.executeQuery(query);

			// Iterating through the result set and printing the values
			while (resultSet.next()) {
				String dvd = resultSet.getString(3);
				System.out.println(dvd);
			}
		} finally {
			// Closing the database connection
			connection.close();
		}
	}
}
