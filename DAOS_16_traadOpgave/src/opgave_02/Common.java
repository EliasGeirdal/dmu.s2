package opgave_02;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Common {
	private int tjenerTaeller = 0, kokTaeller = 0;
	private Semaphore sem = new Semaphore(1);
	private Semaphore sem1 = new Semaphore(0);

	public Common() {
	}

	public void modtagBestilling() throws InterruptedException {
		sem.acquire();
		int temp = tjenerTaeller;
		tagerRandomTid(100);
		tjenerTaeller = temp + 1;
		System.out.println("Tjenertæller: " + tjenerTaeller);
		sem.release();
		sem1.re
	}

	public void udFoerBestilling() throws InterruptedException {
		if (tjenerTaeller > kokTaeller) {
			sem.acquire();
			int temp = kokTaeller;
			tagerRandomTid(200);
			kokTaeller = temp + 1;
			System.out.println("koktæller:" + kokTaeller);
			sem.release();
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
