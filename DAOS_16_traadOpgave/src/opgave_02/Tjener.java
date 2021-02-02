package opgave_02;

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
		while (true) {
			try {
				sleep(1000);
				cmn.modtagBestilling();
				System.out.println("Bestilling oprettet. \n");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
//			i++;
		}
	}
}
