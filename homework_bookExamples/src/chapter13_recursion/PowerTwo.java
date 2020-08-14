package chapter13_recursion;

public class PowerTwo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(pow2(11));
	}

	public static int pow2(int n) {

		if (n == 0) {
			return 1;
		} else if (n < 0) {
			return -1;
		}
		return (pow2(n - 1) * 2);
	}

}
