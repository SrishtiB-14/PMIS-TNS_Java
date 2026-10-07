package Practice1;

import java.util.Scanner;

public class Addition {
	
	public static int sum(int a, int b) {
		int sum =0;
		for(int i=a; i<=b;i++){
			if(i % 2!=0) {
				sum= sum+i;
			}
		}
		return sum ;
	}
	
	// n*n - formula for sum of 1st consecutive odd numbers
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter starting Number");
		
		int n1 = sc.nextInt();
		
		System.out.println("Enter End Number");
		int n2 = sc.nextInt();
		
		int res =sum(n1,n2);
		
		System.out.println("Sum of all odd numbers: "+res);
		
		
		
	}

}
