package OOPs;

class Employee{
	
	private int id;
	private String name;
	private double salary;
	
	

	
	public Employee(int id, String name, double salary) {
		this.id = id;
		this.name = name;
		if(salary >= 0) {
			this.salary = salary;
		}else {
			this.salary = 0.0;
		}
	}
	
	
	
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		if(salary > 0) {
		this.salary = salary;
		}else {
			System.out.println("Salary cannot be negative");
		}
	}
	
	void giveRaise(double percent) {
		double amount = this.salary*(percent/100);
		double newSal = amount + this.salary;
		
		System.out.println("Salary after raise of "+percent+"%  : "+newSal);
	}
	
	
}

public class Company {
	public static void main(String[] args) {
		
		Employee e1 = new Employee(101,"Alice",50000);
		
		e1.giveRaise(8);
		
		Employee e2 = new Employee(102,"Charles",-10000);
		
//		System.out.println(e1.getSalary());
//		System.out.println(e2.getSalary());
		
		e2.setSalary(-200000);
		
	}
	

}
