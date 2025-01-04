package classes.week4;
/**
 * This GCD example shows the difference between slow GCD to fast GCD (with mod operation).
 * 
 * Introduction to Computer Science in Java CS.Ariel University.

 * 
 */
import java.util.Scanner;

public class GCD4 {
	public static boolean debug_flag = false;
	public static void main(String[] args) {
	//	double[] a = {0.1,1.3,-2};
	//	sort(a);
	//	System.out.println(e[1]); //3
	//	System.out.println(r); // 3
		// create a scanner so we can read the command-line input
		Scanner scanner = new Scanner(System.in);
		int flag = 4;

		String s = "abc";
		while(flag >= 1 && flag <=4) {
			System.out.print("Enter in integer x=");
			int x = scanner.nextInt();
			System.out.print("Enter in integer y=");
			int y = scanner.nextInt();
			long g = 0;
			if(flag==1) {
				g=gcd1(x,y);
			}
			if(flag==2) {
				g=gcd2(x,y);
			}
			if(flag==3) {
				g=gcd3(x,y);
			}
			if(flag==4) {
				g=gcd4(x,y);
			}
			System.out.println(g);
			System.out.print("Enter 1 for slow GCD, 2 for fast GCD or 0 to exit:");
			flag = scanner.nextInt();
		}
		System.out.println("Bye Bye...");
	}

	public static void sort(double[] a) {

	}

	/**
	 * This is an inefficient implementation of GCD algorithm, simple search.
	 * @param x
	 * @param y
	 * @return the Greater Common Divider (GCD) of x and y.
	 */
	public static long gcd1(long x, long y) {
		if(x<y) {	long t=x; x=y; y=t;}
		long ans=1, n=2;
		while(y>=n) {
			if (x % n == 0 && y % n == 0) {
				ans = n;
				if (debug_flag) {
					System.out.print(n + " divides: " + x + "," + y);
				}
			}
			n = n + 1;
		}
		return ans;
	}

	public static int max(int a, int b, int c)  {
		int ans = a;
		ans = max(max(a,b),c);
		 return ans;
	}
	public static int max(int a, int b)  {
		int ans = a;
		if(b>a) {ans = b;}
		return ans;
	}
	/**
	 * This is a simplify (not so efficient) implementation of GCD algorithm, as in
	 * https://en.wikipedia.org/wiki/Euclidean_algorithm
	 * @param x
	 * @param y
	 * @return the Greater COmmon Divider (GCD) of x and y.
	 */
	public static long gcd2(long x, long y) {
		while (x != y) {
			if(debug_flag) {
				System.out.print("gcd("+x+","+y+")=");}
        	if(x > y) {x=x-y;}
            else {y=y-x;}
        }
		return y;
	}
	public static long gcd3(long x, long y) {
		while (y != 0)  {long t = y; y=x%y; x=t;}
		return x;
	}
	public static long gcd4(long x, long y) {
		// if b=0, a is the GCD
		if (y == 0)  {return x;}
		return gcd4(y, x % y);
	}
}
