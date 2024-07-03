package REVISION.Recursion;

import java.util.ArrayList;
import java.util.List;

public class PrintMatrixPaths {
	public static void main(String[] args) {
//		System.out.println(paths(2, 2, ""));
		List<String> ans = new ArrayList<>();
		paths(2, 2, "", ans);
		System.out.println(ans);
	}

	public static int paths(int row, int col, String p) {
		if(row == 0 && col == 0) {
			System.out.println(p);
			return 1;
		}

		int count = 0;
		if(row > 0) {
			count += paths(row - 1, col, p + 'D');
		}

		if(col > 0) {
			count += paths(row, col - 1, p + 'R');
		}

		return count;
	}

	public static int paths(int row, int col, String p, List<String> ans) {
		if(row == 0 && col == 0) {
			ans.add(p);
			return 1;
		}

		int count = 0;
		if(row > 0) {
			count += paths(row - 1, col, p + 'D', ans);
		}

		if(col > 0) {
			count += paths(row, col - 1, p + 'R', ans);
		}

		if(row > 0 && col > 0) {
			count += paths(row - 1, col - 1, p + 'L', ans);
		}
		return count;
	}
}
