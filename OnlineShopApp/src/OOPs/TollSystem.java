package OOPs;

class Vehicles{
	String registrationNumber;
	
	public Vehicles(String regNo) {
		registrationNumber = regNo;
	}
	
	public double calculateToll(){
		return 50.0;
	}
	
	   public String getRegistrationNumber() {    
		   return registrationNumber;    
		   } 
	
}

class Cars extends Vehicles{
	
	public Cars(String regNo) {
		super(regNo);
	}
	
	  @Override     
	  public double calculateToll() {      
		  return 50.0 + 20.0;
	  }
}

class Truck extends Vehicles{
	 private int axles;    
	 
	 public Truck(String registrationNumber, int axles) {      
		 super(registrationNumber);   
		 this.axles = axles;   
		 }
	 
	  @Override     
	  public double calculateToll() {     
		  return 100.0 + (axles * 50.0);
		     } 
	  
}

public class TollSystem {
	public static void main(String[] args) {
		
		Vehicles cr = new Cars("MH-05-AB-2111");
		
		Vehicles tk = new Truck("MH-23-TZ-1144", 5);
		
		System.out.println("Vehicle: "+ cr.getRegistrationNumber()+ " Toll : "+ cr.calculateToll());
		
		System.out.println("Vehicle: "+ tk.getRegistrationNumber()+ " Toll : "+ tk.calculateToll());
		
	}

}
