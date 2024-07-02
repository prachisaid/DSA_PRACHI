package REVISION.Recursion;

public class CountNumberOfZeros {
	public static void main(String[] args) {
		System.out.println(countZerosII(100090800));
	}

	public static int countZerosI(int n) {
		if(n % 10 == n) {
			if(n == 0) return 1;
			else return 0;
		}

		int count = 0;
		int rem = n % 10;
		if(rem == 0) {
			count++;
		}

		return count + countZerosI(n/10);
	}

	public static int countZerosII(int n) {
		return helper(n , 0);
	}

	public static int helper(int n, int count) {
		if(n%10 == n) {
			if(n == 0) return count + 1;
			else return count;
		}

		if(n%10 == 0) return helper(n/10, count + 1);
		else return helper(n/10, count);
	}
}
