package OOPs;

class Car{
	
	String colour;
	String brand;
	int speed;
	
	public Car(String colour, String brand, int speed) {
		super();
		this.colour = colour;
		this.brand = brand;
		this.speed = speed;
	}
	
	void displayInfo() {
		System.out.println(brand+" \n"+ colour +"\n"+ speed+"km/hr");
	}
	
	void accelerate(int incr) {
		int og_speed = speed;
		speed += incr;
		
		System.out.println("Original speed: "+ og_speed);
		System.out.println("Increased speed: "+ speed);
	}
	
	
}

public class Driving {
	public static void main(String[] args) {
		
		Car c1 = new Car("Red","Porshe",360);
		c1.displayInfo();
		c1.accelerate(50);
		
		
		System.out.println("-----------------");
		
		Car c2 = new Car("Black","BMW",380);
		c2.displayInfo();
		c2.accelerate(60);
		
	}

}
