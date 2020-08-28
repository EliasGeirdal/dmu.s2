package rekursion;

import java.util.ArrayList;

public class HelperMethods {
	private static int count = 0;

	public static int sum1(ArrayList<Integer> list) {
		int result;
		if (list.size() == 0) {
			result = 0;
		} else {
			result = list.get(0);
			list.remove(0);
			result = result + sum(list);
		}
		return result;
	}

	public static int sum(ArrayList<Integer> list) {
		return sum(list, 0);
	}

	// Rekursiv hjælpemetode med de nødvendige parametre

	private static int sum(ArrayList<Integer> list, int index) {
		int result;
		if (index == list.size()) {
			result = 0;
		} else {
			result = list.get(index) + sum(list, index + 1);
		}
		return result;
	}

	public static int length(ArrayList<Integer> list) {
		return length(list, 0);

	}

	// Rekursiv hjælpemetode med de nødvendige parametre
	private static int length(ArrayList<Integer> list, int index) {
		int result;
		if (index == list.size()) {
			result = 0;
		} else {
			result = 1 + length(list, index + 1);
		}
		return result;
	}

	// Opgave 1
	public static int ligeTal1(ArrayList<Integer> list) {
		int result = 0;
		if (list.size() == 0) {
			return 0;
		} else {
			result = list.get(0);
			list.remove(0);
			if (result % 2 == 0) {
				result = 1 + ligeTal(list);
			} else
				result = 0 + ligeTal(list);
		}
		return result;
	}

	// Opgave 1 - med hjælpemetode
	public static int ligeTal(ArrayList<Integer> list) {
		return ligeTal(list, 0);
	}

	private static int ligeTal(ArrayList<Integer> list, int index) {
		if (index == list.size()) {
			return 0;
		} else {
			if (list.get(index) % 2 == 0) {
				return 1 + ligeTal(list, index + 1);
			} else
				return ligeTal(list, index + 1);
		}
	}

	// opgave 2
	public static boolean palindrom(String tekst) {
		return palindrom(tekst, 0, tekst.length() - 1);
	}

	private static boolean palindrom(String tekst, int start, int slut) {
		if (slut - start <= 1) {
			return true;
		}
		if (tekst.charAt(start) == tekst.charAt(slut)) {
			return palindrom(tekst, start + 1, slut - 1);
		}
		return false;
	}

	// Opgave 3
	public static boolean omTalFindes(ArrayList<Integer> list, int tal) {
		return omTalFindes(list, tal, 0, list.size() - 1);
	}

	private static boolean omTalFindes(ArrayList<Integer> list, int tal, int left, int right) {
		int middle = (left + right) / 2;
		int k = list.get(middle);
		if (k == tal) {
			return true;
		} else if (left < right) {
			if (k < tal) {
				return omTalFindes(list, tal, middle + 1, right);
			} else {
				return omTalFindes(list, tal, left, middle - 1);
			}
		}
		return false;
	}

	// Opgave 4
	public static int ack(int x, int y) {
//		count++;
		if (x == 0) {
			return y + 1;
		} else if (y == 0) {
			return ack(x - 1, 1);
		} else {
			int temp = ack(x, y - 1);
			return ack(x - 1, temp);
		}
	}

	// Opgave 5
	public static int binomial(int n, int m) {
		if (m == 0) {
			return 1;
		} else if (m == n) {
			return 1;
		} else {
			return (binomial(n - 1, m) + binomial(n - 1, m - 1));
		}
	}

	// Opgave 7
	public static int tal(int n) {
		if (n == 0) {
			return 2;
		} else if (n == 1) {
			return 1;
		} else if (n == 2) {
			return 5;
		} else if (n > 2 && n % 2 == 0) {
			return (2 * tal(n - 3)) - tal(n - 1);
		} else
			return tal(n - 1) + tal(n - 2) + (3 * tal(n - 3));
	}

	// Opgave 7.3
	public static int taleIterative(int n) {
		ArrayList<Integer> nliste = new ArrayList<>();
		nliste.add(2);
		nliste.add(1);
		nliste.add(5);
		for (int i = 3; i <= n; i++) {
			if (i % 2 == 0) {
				nliste.add(2 * nliste.get(i - 3) - nliste.get(i - 1));
			} else {
				nliste.add(nliste.get(i - 1) + nliste.get(i - 2) + (3 * nliste.get(i - 3)));
			}
		}
		return nliste.get(n);
	}

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		list.add(7);
//		System.out.println(list);
//		System.out.println("sum: " + sum(list));
//		System.out.println("length: " + length(list));
//
//		System.out.println(list);
//		System.out.println(ligeTal1(list));
//		System.out.println(ligeTal(list));
//		System.out.println(palindrom("ABBA"));
//		System.out.println(omTalFindes(list, 5));
//		System.out.println(ack(1, 3));
//		System.out.println(count);
//		System.out.println(binomial(2, 1));
		// Opgave 7
		System.out.println(tal(3));
		System.out.println(tal(4));
		System.out.println(tal(5));
		System.out.println(tal(6));
//
		System.out.println(taleIterative(3));
		System.out.println(taleIterative(4));
		System.out.println(taleIterative(5));
		System.out.println(taleIterative(6));
	}

}
