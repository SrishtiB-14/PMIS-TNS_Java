package Inheritance;

public class Main {
	public static void main(String[] args) {
		Dog1 d1 = new Dog1();
		d1.name = "Tommy";
		
		System.out.println("Dog name: "+ d1.name);
		d1.eat();
		d1.bark();
	}

}
