package app.persons;

public class Employee extends Person {

	double salary;

	public Employee(double salary) {
		super();
		this.salary = salary;
	}

	public void work() {
		System.out.println("I am working");
	}

}
