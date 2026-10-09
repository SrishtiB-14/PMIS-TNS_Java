package Inheritance;

class Bird{
	void voice() {
		System.out.println("All birds make voice");
	}
}

class Sparrow extends Bird{
	void voice() {
		System.out.println("Chiu Chiu");
		super.voice();
	}
}

public class Demo {
	public static void main(String[] args) {
		
		Sparrow sp = new Sparrow();
		sp.voice();
	}

}
