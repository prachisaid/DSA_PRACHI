package REVISION.Recursion;

public class CountSteps {
	public static void main(String[] args) {
		System.out.println(countSteps(14, 0));
	}

	public static int countSteps(int n, int steps) {
		if(n == 0) return steps;

		if(n%2 == 0) {
			return countSteps(n/2, steps + 1);
		}
		else {
			return countSteps(n-1, steps + 1);
		}
	}
}
