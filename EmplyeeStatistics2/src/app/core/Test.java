package app.core;

import java.util.HashSet;
import java.util.Set;

public class Test {

	public static void main(String[] args) {

		Set<Employee> emps = new HashSet<Employee>();

		emps.add(null);
		emps.add(new Employee("aaa", "aaa", 4000, "Sales"));
		emps.add(new Employee("bbb", "aaa", 5000, "Legal"));
		emps.add(new Employee("ccc", "aaa", 6000, "Legal"));
		emps.add(new Employee("ddd", "aaa", 7000, "Sales"));
		emps.add(null);

		// ================================
		double avg = EmployeeStatistics.averageSalary(emps);
		int numOfEmps = EmployeeStatistics.numOfEmployees(emps);
		int numOfLegalEmps = EmployeeStatistics.numOfEmployees(emps, "Legal");

		System.out.println("Average Salary: " + avg);
		System.out.println("Number of Employees: " + numOfEmps);
		System.out.println("Number of Legal Employees: " + numOfLegalEmps);

	}

}
