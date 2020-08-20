package opgaver;

public class Opgave_3 {

	public static int product(int a, int b) {
		if (a == 0) {
			return 0;
		}

		return product(a - 1, b) + b;
	}

	public static int productRus(int a, int b) {
		if (a == 0) {
			return 0;
		}
		if (a >= 1 && a % 2 != 0) {
			return productRus(a - 1, b) + b;
		}
		return productRus(a / 2, 2 * b);

	}

	public static void main(String[] args) {
		System.out.println(product(6, 6));
		System.out.println(productRus(6, 6));
	}
}
