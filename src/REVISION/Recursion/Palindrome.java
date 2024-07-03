package REVISION.Recursion;

public class Palindrome {
	public static void main(String[] args) {
		int[] arr = {1, 2, 2, 2, 1};
		System.out.println(palindrome(arr, 0));
	}

	public static boolean palindrome(int[] arr, int i) {
		if(i > arr.length / 2) return true;

		return (arr[i] == arr[arr.length - i - 1]) && palindrome(arr, i + 1);
	}
}
