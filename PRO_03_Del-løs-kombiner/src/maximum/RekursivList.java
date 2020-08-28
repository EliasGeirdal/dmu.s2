package maximum;

import java.util.ArrayList;

public class RekursivList {

	public int max(ArrayList<Integer> list) {
		return maximum(list, 0, list.size() - 1);
	}

	private int maximum(ArrayList<Integer> list, int l, int h) {
		if (l == h) {
			return list.get(l);
		} else {
			int m = (l + h) / 2;
			int max1 = maximum(list, l, m);
			int max2 = maximum(list, m + 1, h);
			if (max1 > max2) {
				return max1;
			} else {
				return max2;
			}
		}
	}

	// Opgave 1
	public int sum(ArrayList<Integer> list) {
		return sum(list, 0, list.size() - 1);
	}

	private int sum(ArrayList<Integer> list, int l, int h) {
		int sum = 0;
		if (l == h) {
			sum = list.get(l);
		} else {
			int m = (l + h) / 2;
			int sum1 = sum(list, l, m);
			int sum2 = sum(list, m + 1, h);
			sum = sum1 + sum2;
		}
		return sum;
	}

	// Opgave 2
	public int antalN(ArrayList<Integer> list) {
		return antalN(list, 0, list.size() - 1);
	}

	private int antalN(ArrayList<Integer> list, int l, int h) {
		int result = 0;
		if (l == h) {
			if (list.get(l) == 0) {
				result = 1;
			}
		} else {
			int m = (l + h) / 2;
			result = antalN(list, l, m);
			result += antalN(list, m + 1, h);
		}
		return result;
	}

}
