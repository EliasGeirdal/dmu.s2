package opgaver;

public class Opgave_2 {

	public static int power(int n, int p) {
		if (p == 0) {
			return 1;
		}

		return (power(n, p - 1)) * n;
	}

	public static int power2(int n, int p) {
		if (p == 0) {
			return 1;
		}

		if (p % 2 != 0 && p > 0) {
			return power2(n, p - 1) * n;
		}
		return power2((n * n), p / 2);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(power(2, 8));
		System.out.println(power2(2, 8));
	}

}
