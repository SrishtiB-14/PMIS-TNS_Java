package Inheritance;

class Animal1{
	String name;

	
	void eat() {
		System.out.println("Animal is eating");
	}
}



public class Dog1 extends Animal1 {
	
	void bark() {
		System.out.println("Dog is barking");
	}

}
