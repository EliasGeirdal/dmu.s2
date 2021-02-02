package opgave_02;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Common {
	private int tjenerTaeller, kokTaeller;
	private Semaphore sem, sem2;

	public Common() {
		tjenerTaeller = 0;
		kokTaeller = 0;
		sem = new Semaphore(1);
		sem2 = new Semaphore(0);
	}

	public void modtagBestilling() throws InterruptedException {
		sem.acquire();
		int temp = tjenerTaeller;
		tjenerTaeller = temp + 1;
		System.out.println("Tjenertæller: " + tjenerTaeller);
		sem2.release();
		sem.release();
	}

	public void udFoerBestilling() throws InterruptedException {
		sem2.acquire();
		int temp = kokTaeller;
		kokTaeller = temp + 1;
		System.out.println("koktæller:" + kokTaeller);
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
