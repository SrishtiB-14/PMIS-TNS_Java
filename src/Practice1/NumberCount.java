package Practice1;

import java.util.Scanner;

public class NumberCount {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int pos = 0;
		int neg = 0;
		int zero = 0;
		char choice;
		
		do {
			
			System.out.println("Enter a number");
			int num = sc.nextInt();
			
			if(num > 0) {
				pos++;
			}else if(num < 0) {
				neg++;
			}else {
				zero++;
			}
			
			System.out.println("Do you want to enter another number? (Y/N)");
			choice = sc.next().charAt(0);
			
		}while(choice == 'Y' || choice == 'y');
		
		
		System.out.println("Positive Numbers : "+pos);
		System.out.println("Negative Numbers : "+neg);
		System.out.println("No. of Zeros : "+pos);
	}

}
