package recursion;

public class CountInversionII {
	public static void main(String[] args) {
		long[] arr = {2, 4, 1, 3, 5};
		System.out.println(inversionCount(arr, arr.length));
	}

	static long inversionCount(long[] arr, long N){
		return mergeSortInPlace(arr, N, 0, arr.length - 1);
	}

	static long mergeSortInPlace(long[] arr, long N, int s, int e) {
		long cnt = 0;
		if(s >= e) {
			return cnt;
		}

		int m = s + (e - s) / 2;

		cnt += mergeSortInPlace(arr, N, s, m);
		cnt += mergeSortInPlace(arr, N, m + 1, e);

		cnt += merge(arr, s, m, e);

		return cnt;
	}


	static long merge(long[] arr, int s, int m, int e) {
		long cnt = 0;
		long[] ans = new long[e - s + 1];
		int i = s;
		int j = (m + 1);
		int k = 0;

		while(i <= m && j <= e) {
			if(arr[i] > arr[j]) {
				cnt += (m - i + 1);
				ans[k++] = arr[j];
				j++;
			}
			else{
				ans[k++] = arr[i];
				i++;
			}
		}

		while(i <= m) {
			ans[k++] = arr[i++];
		}

		while(j <= e) {
			ans[k++] = arr[j++];
		}

		for(int it = 0; it < k; it++) {
			arr[s + it] = ans[it];
		}

		return cnt;
	}
}
