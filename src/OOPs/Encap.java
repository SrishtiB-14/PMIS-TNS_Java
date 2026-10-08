package OOPs;

class BankAccount{
	
	private String accHolder;
	private double bal;
	
	
	
	public BankAccount(String accHolder, double bal) {
		this.accHolder = accHolder;
		setBal(bal);
	}
	
	
	

	
	public String getAccHolder() {
		return accHolder;
	}
	public void setAccHolder(String accHolder) {
		this.accHolder = accHolder;
	}
	
	
	
	public double getBal() {
		return bal;
	}
	public void setBal(double bal) {
		if(bal >=0) {
		this.bal = bal;
		}else {
			System.out.println("Invalid Amount: it cannot be negative");
		}
	}
	

	
	
}

public class Encap {
	
	public static void main(String[] args) {
		
		BankAccount b1 = new BankAccount("Shruti",100000);
		
		b1.setBal(-100);
		
		
		
		
	}

}
