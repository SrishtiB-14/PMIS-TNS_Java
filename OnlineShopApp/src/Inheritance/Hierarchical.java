package Inheritance;

class Shapes{
	String colour = "Blue";
}

class Circle extends Shapes{
	
	void drawCircle() {
		System.out.println("Drawing a "+ colour+ " circle");
	}
}

class Rectangle extends Shapes{
	
	void drawRectangle() {
		System.out.println("Drawing a "+colour+" rectangle");
	}
}

public class Hierarchical {
	public static void main(String[] args) {
		
		Circle cr = new Circle();
		cr.drawCircle();
		
		Rectangle rec = new Rectangle();
		rec.drawRectangle();
	}

}
