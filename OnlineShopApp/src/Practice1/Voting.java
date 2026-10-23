package Practice1;

import java.util.Scanner;

public class Voting {
	
	public static boolean vote(int a) {
		if(a >= 18) {
			return true;
		}else
		return false;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter your age");
		int age = sc.nextInt();
		
		if(vote(age)) {
			System.out.println("You are eligible to vote");
		}else {
			System.out.println("You are not eligible to vote. You are under age.");
		}
		
		
	}

}
