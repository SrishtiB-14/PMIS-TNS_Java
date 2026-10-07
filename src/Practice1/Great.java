package Practice1;

import java.util.Scanner;

public class Great {
	
	public static int greater(int a, int b) {
		return (a>b)? a: b;
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter 1st number");
		int n1 = sc.nextInt();
		
		System.out.println("Enter 2nd number");
		int n2 = sc.nextInt();
		
		int res = greater(n1,n2);
		
		System.out.println("Largest number between "+n1+" and "+n2+ " : "+res);
		
		
	}

}
