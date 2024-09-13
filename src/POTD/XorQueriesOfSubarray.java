package POTD;

public class XorQueriesOfSubarray {
	public static void main(String[] args) {

	}

	public int[] xorQueries(int[] arr, int[][] queries) {
		int[] ans = new int[queries.length];
		int i = 0;
		for(int[] a : queries){
			int s = a[0] , e = a[1];
			int r = 0;
			while(s <= e){
				r ^= arr[s];
				s++;
			}
			ans[i] = r;
			i++;
		}
		return ans;
	}
}
