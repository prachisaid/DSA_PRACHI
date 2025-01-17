package REVISION.BinarySearch;

public class ValidPerfectSquare {
	public static void main(String[] args) {
		System.out.println(isPerfectSquare(34));
	}

	public static boolean isPerfectSquare(int num) {
		long s = 1;
		long e = num;

		while(s <= e) {
			long m = s + (e -  s) / 2;
			long sqrt = (m * m);

			if(sqrt == num) return true;

			if(sqrt > num) {
				e = m - 1;
			}
			else {
				s = m + 1;
			}
		}

		return false;
	}
}
