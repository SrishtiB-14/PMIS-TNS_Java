package Inheritance;

class BankAccount{
	 String accHolder;
	 
	 public BankAccount(String accHolder) {
		this.accHolder = accHolder;
	}
	 
	 void displayDetails() {
		 System.out.println("Account Holder "+ accHolder);
	 }
}

class SavingsAccount extends BankAccount{
	
	double interestRate = 4.5;
	
	public SavingsAccount(String accHolder) {
		super(accHolder);
	}
	
	void displayDetails() {
		System.out.println("Account Holder: "+accHolder);
		System.out.println("Interest rate : "+ interestRate+"%");
	}
}


public class Banks {
	public static void main(String[] args) {
		
		SavingsAccount sa = new SavingsAccount("Srishti");
		sa.displayDetails();
	}

}
