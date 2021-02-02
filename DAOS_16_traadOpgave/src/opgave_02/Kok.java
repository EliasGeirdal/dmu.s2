package opgave_02;

public class Kok extends Thread {
	private String name;
	private Common cmn;

	public Kok(String name, Common common) {
		this.name = name;
		cmn = common;
	}

	public void run() {
		int i = 0;
		while (true) {
			try {
				sleep(1000);
				cmn.udFoerBestilling();
				System.out.println("Bestilling fuldført.\n");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
//		i++;
	}
}
