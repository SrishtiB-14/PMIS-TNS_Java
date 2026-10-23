package OOPs;

class Calculator{
	
	// Compile time polymorphism
	int add(int a, int b) {
		return a + b;
	}
	
	
	int add(int a, int b, int c) {
		return a + b +c;
	}
	
	double add(double a,double b) {
		return a + b;
	}
}


class Animal{
	
	void sound() {
		System.out.println("All animal makes sound");
	}
}


class Dog extends Animal{
	
	@Override
	void sound() {
		System.out.println("Dog barks Bhaw bhaw...");
	}
}


class Cat extends Animal{
	
	@Override
	void sound() {
		System.out.println("Cat Meow Meow...");
	}
}

public class Polymorphism {
	public static void main(String[] args) {
		
		Calculator c1 = new Calculator();
		
	    System.out.println(c1.add(10, 20));	
		System.out.println(c1.add(13, 18, 16));
		System.out.println(c1.add(10.5, 20));
		
		System.out.println("----------------------------------");
		
		
		//Run- time Polymorphism
		Animal a1 = new Dog();
		a1.sound();
		
		Animal a2 = new Cat();
		a2.sound();
		
		Animal a3 = new Animal();
		a3.sound();
		
		
	}

}
