package opgaver;

public class Opgave3 {

	public static void main(String[] args) {
		int[] a = { 5, 10, 5, 6, 4, 9, 8 };
		double[] sum = prefixAverage(a);
		for (int i = 0; i < sum.length; i++) {
			System.out.println(sum[i]);
		}

	}

	// O(n)
	public static double[] prefixAverage(int[] inputTal) {
		double[] average = new double[inputTal.length];
		double sum = 0;
		for (int i = 1; i <= inputTal.length; i++) {
			average[i - 1] = (sum + inputTal[i - 1]) / i;
			sum += inputTal[i - 1];
		}
		return average;
	}
}
