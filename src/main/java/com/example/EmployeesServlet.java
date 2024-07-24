package com.example;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.entities.Employee;
import com.example.entities.HRDatabaseRepository;

public class EmployeesServlet extends HttpServlet {

	/**
	 * Serialization ID.
	 */
	private static final long serialVersionUID = -409752557084947443L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		
		try {
			HRDatabaseRepository repository = new HRDatabaseRepository();
			Iterable<Employee> employees = repository.fetchEmployees();
			
			out.println("<h1>Employees</h1>");
			out.println("<table border='1'><tr><th>ID</th><th>First Name</th><th>Last Name</th><th>Email</th><th>Department</th><th>Hire Date</th></tr>");
			
			for (Employee employee : employees) {
				out.println("<tr>"
						+ "<td>" + employee.getId() + "</td>"
						+ "<td>" + employee.getFirstName() + "</td>"
						+ "<td>" + employee.getLastName() + "</td>"
						+ "<td>" + employee.getEmail() + "</td>"
						+ "<td>" + employee.getDepartment() + "</td>"
						+ "<td>" + employee.getHireDate() + "</td>"
						+ "</tr>");
			}
			
			out.println("</table>");
		} catch (SQLException | ClassNotFoundException e) {
			out.println("<p>");
			out.println("An error has occurred while trying to access the human resources database. " + e.getLocalizedMessage() + "<br/>");
			e.printStackTrace(out);
			out.println("</p>");
		} finally {
			out.println("</body></html>");
		}
		out.close();
	}
}
