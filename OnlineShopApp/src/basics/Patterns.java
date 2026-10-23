package basics;

public class Patterns {
	public static void main(String[] args) {
		
		int n = 5;
		
		
		/// Triangle pattern
//		for(int i =1; i <=n; i++) {
//			
//			for(int j=1; j <=n-i;j++) {
//				System.out.print("  ");
//			}
//			
//			for(int k =1;k<= i; k++) {
//				System.out.print("* ");
//			}
//			
//			System.out.println();
//		}

		
		
		/// Pattern
//		for(int i=0; i <=n; i++) {
//			
//			for(int j=1; j<=i;j++) {
//				System.out.print("  ");
//			}
//			
//			for(int k =1;k<=n-i; k++) {
//				System.out.print("* ");
//			}
//		
//			
//			System.out.println();
//		}
		
		
		
		/// hollow square w/ diagonals
//		int p = 7;
//		int q = 7;
//		
//		for(int i=1; i<=p;i++) {
//			for(int j=1; j<=q;j++) {
//				if(i== 1 || j==q || i==j || i+j==(p+1) || i== p || j==1) {
//					System.out.print("* ");
//				}else {
//					System.out.print("  ");
//				}
//			}
//			
//			System.out.println();
//			
//		}
		
		
		/// Number Pattern
		
//		for(int i = 1; i <=5;i++) {
//			for(int j =1; j<=i;j++) {
//				System.out.print(j+" ");
//			}
//			
//			System.out.println();
//		}
//		
		
//		for(int i = 1; i <=5;i++) {
//			for(int j =1; j<=5;j++) {
//				System.out.print(i+" ");
//			}
//			
//			System.out.println();
//		}
	
		
//		for(int i = 0; i <=5;i++) {
//			for(int j =1; j<=5-i;j++) {
//				System.out.print(j+" ");
//			}
//			
//			System.out.println();
//		}
		
		
		
//		int num = 1;
//		
//		for(int i = 1; i <=4;i++) {
//			for(int j =1; j<=i;j++) {
//				System.out.print(num+" ");
//				num++;
//			}
//			
//			System.out.println();
//		}
		
		
		for(int i=1; i<=4;i++) {
			for(int j=1;j<=i;j++) {
				if((j+i) % 2==0) {
					System.out.print(1+" ");
				}else {
					System.out.print(0+" ");
				}
			}
			System.out.println();
		}
		

		
	}
}
