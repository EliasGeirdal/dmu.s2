package eksempel2;

public class TraadKlassen extends Thread {

	private int max = 0;
	private int[] array;

	public TraadKlassen(int[] array) {
		this.array = array;
	}

	@Override
	public void run() {
		for (int i = 0; i < array.length; i++) {
			if (array[i] > max) {
				max = array[i];
			}
		}
	}

	public int getMax() {
		return max;
	}
}
