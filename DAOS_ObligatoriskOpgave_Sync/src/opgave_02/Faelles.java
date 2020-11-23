package opgave_02;

import java.util.Random;

public class Faelles {
	private int global;
	private int turn;
	private boolean flag[];

	public Faelles() {
		global = 0;
		flag = new boolean[2];
		flag[0] = false;
		flag[1] = false;
	}

	public void kritiskSektion() {
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

	public void setFlag(boolean flag, int id) {
		this.flag[id] = flag;
	}

	public boolean getFlag(int id) {
		return flag[id];
	}

	public void setTurn(int turn) {
		this.turn = turn;
	}

	public int getTurn() {
		return turn;
	}
}
