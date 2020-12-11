package opgave_03;

import java.util.Random;

public class Common {
	private int tjenerTaeller = 0, kokTaeller = 0;

	public Common() {
	}

	public synchronized void modtagBestilling() throws InterruptedException {
		int temp = tjenerTaeller;
		tagerRandomTid(100);
		tjenerTaeller = temp + 1;
		System.out.println("Tjenertæller: " + tjenerTaeller);
		notify();
	}

	public synchronized void udFoerBestilling() throws InterruptedException {
		if (tjenerTaeller == kokTaeller) {
			wait();
			int temp = kokTaeller;
			tagerRandomTid(200);
			kokTaeller = temp + 1;
			System.out.println("koktæller:" + kokTaeller);
		}
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
}
