package basics;

import java.util.Scanner;

public class Calculator {
	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter your Choice (1.Triangle, 2.Square, 3.Rectangle");
		
		int a = sc.nextInt();
		
		switch (a) {
		case 1:{ System.out.println("Enter base ");
				int b =sc.nextInt();
				System.out.println("Enter height ");
				int h = sc.nextInt();
				float sol = (float) 0.5* b*h;
				System.out.println("Area of Triangle : "+ sol+ " sq.units");
		} break;
		case 2:{
			System.out.println("Enter side ");
			int s =sc.nextInt();
			int sol = s*s;
			System.out.println("Area of Square : "+ sol+ " sq.units");
		}break;
		case 3:{ System.out.println("Enter length ");
					int l =sc.nextInt();
					System.out.println("Enter breadth ");
					int bh = sc.nextInt();
					int sol = l*bh;
		System.out.println("Area of Rectangle : "+ sol+ " sq.units");
} break;
		default: System.out.println("Invalid Choice");
			
		}
	}

}
