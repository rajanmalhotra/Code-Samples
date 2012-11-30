package companies.Amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class AncestorMatrix {

	public void createTree(int[][] arr) {

		HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
		ArrayList<Integer> list = null;
		int len = arr.length;
		int sum[] = new int[len];
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len; j++) {
				sum[i] += arr[i][j];
			}
			if (map.containsKey(sum[i])) {
				list = map.get(sum[i]);
			} else {
				list = new ArrayList<Integer>();
				map.put(sum[i], list);
			}
			list.add(i);
			System.out.println(sum[i] + " " + list);
		}
		System.out.println(map);
		Set<Map.Entry<Integer, ArrayList<Integer>>> set = map.entrySet();
		Set<Integer> s = map.keySet();
		System.out.println(s);
		Arrays.sort(s.toArray());
		System.out.println(s);
		Collection<ArrayList<Integer>> lst = map.values();
	}

	public static void main(String[] args) {
		int[][] arr = { { 1, 1, 0, 0, 0, 0, 0 }, { 1, 0, 1, 0, 0, 0, 0 },
				{ 1, 0, 1, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0 },
				{ 1, 0, 0, 0, 0, 0, 0 }, { 1, 0, 0, 0, 0, 0, 0 },
				{ 1, 1, 0, 0, 0, 0, 0 } };
		AncestorMatrix am = new AncestorMatrix();
		am.createTree(arr);
	}
}
