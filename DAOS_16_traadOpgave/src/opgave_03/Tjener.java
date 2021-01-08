package opgave_03;

public class Tjener extends Thread {
	private String name;
	private Common cmn;

	public Tjener(String name, Common common) {
		this.name = name;
		cmn = common;
	}

	@Override
	public void run() {
		int i = 0;
		while (i < 100) {
			try {
				sleep(1000);
				cmn.modtagBestilling();
				System.out.println("Bestilling oprettet. \n");

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			i++;
		}
	}
}
