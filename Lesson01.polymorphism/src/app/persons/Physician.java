package app.persons;

public class Physician extends Employee {

	public Physician(double salary) {
		super(salary);
	}

	public void heal() {
		System.out.println("I am healing");
	}

	public void work() {
		System.out.println("I am working like a physician");
	}
}
