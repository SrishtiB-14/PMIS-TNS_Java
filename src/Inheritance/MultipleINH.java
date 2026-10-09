package Inheritance;

interface Mother{
	 void message();
}

interface Father{
	void message();
}

class Child implements Mother,Father{
	@Override
	public void message() {
		System.out.println("Loving both Mother and Father");
		
	}
	
}

public class MultipleINH {
	public static void main(String[] args) {
		Child c1 = new Child();
		c1.message();
		
		Mother m1 = new Child();
		m1.message();
		
		Father f1 = new Child();
		f1.message();
	}

}
