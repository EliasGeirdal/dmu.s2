package opgave_01;

public class Kok extends Thread {
	private String name;
	private Common cmn;

	public Kok(String name, Common common) {
		this.name = name;
		cmn = common;
	}

	public void run() {
		int i = 0;
		while (i < 100) {
			try {
				sleep(100);
				cmn.udFoerBestilling();
				System.out.println("Bestilling fuldført.\n");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		i++;
	}
}
