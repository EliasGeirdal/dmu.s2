package opgave_01;

public class MyThread extends Thread {
	private String name;
	private Faelles faelles;

	public MyThread(String name, Faelles faelles) {
		this.name = name;
		this.faelles = faelles;
	}

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			faelles.kritiskSektion();
			faelles.tagerRandomTid(50);
		}
		System.out.println(faelles.getGlobal());
	}
}
