package opgave3;

public class LottoThread extends Thread {

	Lottoraek[] raekker;
	Lottoraek rigtig;
	int[] rigtige = new int[8];

	/**
	 * 
	 * @param array
	 */
	public LottoThread(Lottoraek[] array, Lottoraek rigtig) {
		this.raekker = array;
		this.rigtig = rigtig;
	}

	@Override
	public void run() {
		for (int i = 0; i < raekker.length; i++) {
			if (raekker[i].antalrigtige(rigtig) == 0) {
				rigtige[0]++;
			} else if (raekker[i].antalrigtige(rigtig) == 1) {
				rigtige[1]++;
			} else if (raekker[i].antalrigtige(rigtig) == 2) {
				rigtige[2]++;
			} else if (raekker[i].antalrigtige(rigtig) == 3) {
				rigtige[3]++;
			} else if (raekker[i].antalrigtige(rigtig) == 4) {
				rigtige[4]++;
			} else if (raekker[i].antalrigtige(rigtig) == 5) {
				rigtige[5]++;
			} else if (raekker[i].antalrigtige(rigtig) == 6) {
				rigtige[6]++;
			} else if (raekker[i].antalrigtige(rigtig) == 7) {
				rigtige[7]++;
			}
		}
	}

	public int[] getRigtige() {
		return rigtige;
	}
}
