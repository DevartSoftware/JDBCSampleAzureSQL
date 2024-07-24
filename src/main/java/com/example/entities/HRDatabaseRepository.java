package com.example.entities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Represents a data access layer for human resources database.
 */
public class HRDatabaseRepository {

	private static final String JDBC_CONNECTION_STRING = "jdbc:sqlserver://your_azure_server_address;"
			+ "database=database_name;" + "user=user_name;" + "password=your_password;" + "encrypt=true;"
			+ "trustServerCertificate=false;" + "loginTimeout=30;";

	/**
	 * Initializes a new instance of the HumanResourcesDatabaseRepository class.
	 * 
	 * @throws ClassNotFoundException
	 */
	public HRDatabaseRepository() throws ClassNotFoundException {

		// Load the JDBC driver
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	}

	/**
	 * Fetches information on employees from the human resources database.
	 * 
	 * @return a collection of employees fetched from the database
	 * @throws SQLException an error has occurred when accessing the human resources database.
	 */
	public Iterable<Employee> fetchEmployees() throws SQLException {

		ArrayList<Employee> retVal = new ArrayList<Employee>();
		Connection connection = this.getConnection();
		Statement selectStatement = null;
		ResultSet resultSet = null;

		try {
			selectStatement = connection.createStatement();
			resultSet = selectStatement
					.executeQuery("SELECT EmployeeID, FirstName, LastName, Email, Department, HireDate FROM Employees");

			while (resultSet.next()) {
				retVal.add(new Employee(resultSet.getInt("EmployeeID"), resultSet.getString("FirstName"),
						resultSet.getString("LastName"), resultSet.getString("Email"),
						resultSet.getString("Department"), resultSet.getDate("HireDate")));
			}
		} finally {

			if (resultSet != null) {
				resultSet.close();
			}

			if (selectStatement != null) {
				selectStatement.close();
			}

			connection.close();
		}

		return retVal;
	}

	private Connection getConnection() throws SQLException {

		return DriverManager.getConnection(JDBC_CONNECTION_STRING);
	}
}