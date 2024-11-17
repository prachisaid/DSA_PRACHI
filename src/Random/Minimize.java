package Random;

import java.util.Scanner;

public class Minimize {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		while(t-- > 0) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int eq = Integer.MAX_VALUE;

			for (int i = a; i <= b; i++) {
				eq = Math.min(eq, (i - a) + (b - i));
			}

			System.out.println(eq);
		}
	}
}
