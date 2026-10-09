package Inheritance;

class Animal{
	
	void eat() {
		System.out.println("This Animal eats");
	}
}

class Dog extends Animal{
	
	void barks() {
		System.out.println("The Dog barks");
	}
}

public class Kingdom {
	public static void main(String[] args) {
		
		Dog d1 = new Dog();
		
		d1.eat();
		d1.barks();
	}
}
