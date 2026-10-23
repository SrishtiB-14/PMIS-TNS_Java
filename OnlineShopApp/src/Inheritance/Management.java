package Inheritance;

class Employee{
	double salary = 30000;
}

class Manager extends Employee{
	double salary = 60000;
	
	void displaySalary() {
		System.out.println("Manager's salary: "+ salary);
		System.out.println("Employee's salary: "+ super.salary);
	}
}

public class Management {
	public static void main(String[] args) {
		
		Manager m1 = new Manager();
		m1.displaySalary();
	}

}
