package opgave3;

import java.util.Arrays;
import java.util.concurrent.Semaphore;

public class MainApp {
	public static void main(String[] args) throws InterruptedException {
		Semaphore s = new Semaphore(1);
		long l1 = System.nanoTime();
		try {
			Lottoraek rigtig = new Lottoraek();
			Lottoraek[] raekker = new Lottoraek[10000000];
			for (int i = 0; i < raekker.length; i++) {
				raekker[i] = new Lottoraek();
			}
			Lottoraek[] foerste = new Lottoraek[raekker.length / 2];
			Lottoraek[] anden = new Lottoraek[raekker.length / 2];

			for (int i = 0; i < raekker.length / 2; i++) {
				foerste[i] = raekker[i];
			}
			for (int i = 0; i < raekker.length / 2; i++) {
				anden[i] = raekker[5000000 + i];
			}

			LottoThread f1 = new LottoThread(foerste, rigtig);
			LottoThread f2 = new LottoThread(anden, rigtig);
			f1.start();
			f2.start();
			f1.join();
			f2.join();

			int[] rigtige = new int[8];
			for (int i = 0; i < rigtige.length; i++) {
				rigtige[i] = f1.getRigtige()[i] + f2.getRigtige()[i];
			}
			System.out.println(Arrays.toString(rigtige));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		long l2 = System.nanoTime();
		System.out.println("K�retiden var " + (l2 - l1) / 1000000 + " millisekunder");

		// Opgave 3

//		int nul = 0, et = 0, to = 0, tre = 0, fire = 0, fem = 0, seks = 0, syv = 0;

//		for (int i = 0; i < raekker.length; i++) {
//			if (raekker[i].antalrigtige(rigtig) == 0) {
//				nul++;
//			} else if (raekker[i].antalrigtige(rigtig) == 1) {
//				et++;
//			} else if (raekker[i].antalrigtige(rigtig) == 2) {
//				to++;
//			} else if (raekker[i].antalrigtige(rigtig) == 3) {
//				tre++;
//			} else if (raekker[i].antalrigtige(rigtig) == 4) {
//				fire++;
//			} else if (raekker[i].antalrigtige(rigtig) == 5) {
//				fem++;
//			} else if (raekker[i].antalrigtige(rigtig) == 6) {
//				seks++;
//			} else if (raekker[i].antalrigtige(rigtig) == 7) {
//				syv++;
//			}
//		}

//		System.out.println("ingen: " + nul);
//		System.out.println("et: " + et);
//		System.out.println("to: " + to);
//		System.out.println("tre: " + tre);
//		System.out.println("fire: " + fire);
//		System.out.println("fem: " + fem);
//		System.out.println("seks: " + seks);
//		System.out.println("syv: " + syv);
	}

}
