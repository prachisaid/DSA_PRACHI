package REVISION.BinarySearch;

public class KokoEatingBananas {
	public static void main(String[] args) {
		int[] piles = {3, 6, 7, 11};
		System.out.println(minEatingSpeed(piles, 8));
	}

	public static int minEatingSpeed(int[] piles, int h) {
		int s = 1;
		int e = 0;
		int ans = 0;

		for(int pile : piles) {
			e = Math.max(e, pile);
		}

		while(s <= e) {
			int m = s + (e - s) / 2;
			long hours = findTotalHours(piles, m);

			if(hours <= h) {
				ans = m;
				e = m - 1;
			}
			else {
				s = m + 1;
			}
		}

		return ans;
	}

	private static long findTotalHours(int[] piles, int k) {
		long ans = 0;

		for (int pile : piles) {
			ans += (int) Math.ceil((double) pile / k);
		}

		return ans;
	}
}
