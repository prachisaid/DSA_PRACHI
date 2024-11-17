package REVISION;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.*;

interface demo {
	void add();
	void sub();
}

class interfaceDemo implements demo {
	public void add() {
		System.out.println("Addition");
	}

	public void sub() {
		System.out.println("Subtraction");
	}
}

public class Demo2 {
	public static void main(String[] args) {
//		List<Integer> lst = new ArrayList<>();
//		demo d = new interf();
//		We cannot create object of interface
//		But we can create an object of class which implements the interface
//		Set<Integer> set = new HashSet<>();
//		ArrayList<Integer> arr = new ArrayList<>();
//		SortedSet<Integer> ss = new TreeSet<>();
//		Map<Integer, Integer> map = new TreeMap<>();
	}
}
