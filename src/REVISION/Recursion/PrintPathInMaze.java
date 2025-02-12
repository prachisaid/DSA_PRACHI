package REVISION.Recursion;

import java.util.ArrayList;
import java.util.List;

public class PrintPathInMaze {
	public static void main(String[] args) {
		System.out.println(funcD(3, 3, ""));
	}

	private static List<String> func(int row, int col, String path) {
		List<String> ans = new ArrayList<>();
		if(row == 1 && col == 1) {
			ans.add(path);
			return ans;
		}

		if(row > 1)
			ans.addAll(func(row - 1, col, path + "D"));
		if(col > 1)
			ans.addAll(func(row, col - 1, path + "R"));

		return ans;
	}

	private static List<String> funcD(int row, int col, String path) {
		List<String> ans = new ArrayList<>();
		if(row == 1 && col == 1) {
			ans.add(path);
			return ans;
		}

		if(row > 1) ans.addAll(funcD(row - 1, col, path + "U"));
		if(row > 1 && col > 1) ans.addAll(funcD(row - 1, col - 1, path + "D"));
		if(col > 1) ans.addAll(funcD(row, col - 1, path + "L"));

		return ans;
	}
}
