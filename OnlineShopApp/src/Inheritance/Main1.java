package Inheritance;

class Employee1{
	String name;
	double salary;
	
	public Employee1(String name,double salary) {
		this.name = name;
		this.salary = salary;
	}
	
	void displayDetails() {
		System.out.println("Employee Name: "+name);
		System.out.println("Employee salary: "+salary);
	}
}

class Manager1 extends Employee1{
	
	String department;
	
	public Manager1(String name,double salary,String department) {
		super(name,salary);
	this.department = department;
		
	}
	
	void displayDetails() {
		super.displayDetails();
		System.out.println("Department: "+department);
		System.out.println("Role : Manager");
	}
	
}


public class Main1 {
	public static void main(String[] args) {
		
		Manager1 m1 = new Manager1("Srishti",500000,"IT");
		m1.displayDetails();
	}

}
