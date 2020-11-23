package opgave_03;

import java.util.Random;

public class Faelles {
	private int global;

	public Faelles() {
		global = 0;
	}

	public synchronized void kritiskSektion() {
		int tmp;
		tmp = global;
		tagerRandomTid(100);
		global = tmp + 1;
	}

	public void tagerRandomTid(int max) {
		Random r = new Random();
		int nyMax = Math.abs(r.nextInt() % max + 1);

		for (int i = 0; i < nyMax; i++) {
			for (int j = 0; j < nyMax; j++) {
				int n = 1 + 1;
				n = 1 - 1;
			}
		}
	}

	public int getGlobal() {
		return global;
	}
}
