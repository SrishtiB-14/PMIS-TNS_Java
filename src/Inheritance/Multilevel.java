package Inheritance;

class Device{
	
	void poweron() {
		System.out.println("This device is on...");
	}
}

class DabbaPhone extends Device{
	
	void makeCall() {
		System.out.println("Call can be made...");
	}
}

class SmartPhone extends DabbaPhone{
	
	void browseInternet() {
		System.out.println("We can browse Internet...");
	}
}

public class Multilevel {
	public static void main(String[] args) {
		
		SmartPhone sam = new SmartPhone();
		
		sam.browseInternet();
		sam.makeCall();
		sam.poweron();
	}

}
