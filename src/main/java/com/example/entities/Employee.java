package com.example.entities;

import java.sql.Date;

/**
 * Represent an employee in an HR database.
 */
public class Employee {

	private final int id;
	private final String firstName;
	private final String lastName;
	private final String email;
	private final String department;
	private final Date hireDate;

	/**
	 * Initializes a new instance of the Employee class.
	 * 
	 * @param id         - the identifier of an employee
	 * @param firstName  - the employee's first name
	 * @param lastName   - the employee's last name
	 * @param email      - the employee's email address
	 * @param department - the department an employee belongs to
	 * @param hireDate   - the date an employee was hired at
	 */
	public Employee(int id, String firstName, String lastName, String email, String department, Date hireDate) {

		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.department = department;
		this.hireDate = hireDate;
	}

	/**
	 * Gets the identifier for an employee.
	 * 
	 * @return the identifier of an employee
	 */
	public int getId() {

		return this.id;
	}

	/**
	 * Gets the first name for an employee.
	 * 
	 * @return the employee's first name
	 */
	public String getFirstName() {

		return this.firstName;
	}

	/**
	 * Gets the last name for an employee.
	 * 
	 * @return the employee's last name
	 */
	public String getLastName() {

		return this.lastName;
	}

	/**
	 * Gets the email address for an employee.
	 * 
	 * @return the employee's email address
	 */
	public String getEmail() {

		return this.email;
	}

	/**
	 * Gets the department an employee belongs to.
	 * 
	 * @return the department an employee belongs to
	 */
	public String getDepartment() {

		return this.department;
	}

	/**
	 * Gets the date an employee was hired at.
	 * 
	 * @return the date an employee was hired at
	 */
	public Date getHireDate() {

		return this.hireDate;
	}
}