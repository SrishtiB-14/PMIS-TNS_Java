package OOPs;

class Vehicle{
	String brand;
	
	void startEngine() {
		System.out.println(brand + " engine started."); 
	}
}


class Bike extends Vehicle{
	
	boolean hasCarrier;
	
	void kickStand() {
		System.out.println("Kickstand put down");
	}
}

public class Inhertance {
	
	public static void main(String[] args) {
		
		Bike b1 = new Bike();
		b1.brand = "Honda";
		b1.hasCarrier = true;
		
		b1.startEngine();
	}

}
