package OOPs;

abstract class Payment{
	
	abstract void processPayment(double amt);
	
	void printReceipt() {
		System.out.println("Receipt generated");
	}
}

class UPIpay extends Payment{
	
	@Override
	void processPayment(double amt) {
		 System.out.println("Processing ₹" + amt + " via UPI QR code."); 
	}
}

class CreditCard extends Payment{
	
	@Override
	void processPayment(double amt) {
		System.out.println("Processing ₹" + amt + " via  credit card and OTP"); 
	}
}

public class Abstraction {
	public static void main(String[] args) {
		
		Payment p1 = new CreditCard();
		p1.processPayment(540);
		p1.printReceipt();
		
	}

}
