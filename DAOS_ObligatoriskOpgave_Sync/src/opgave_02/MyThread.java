package opgave_02;

public class MyThread extends Thread {
	private String name;
	private Faelles faelles;
	private int thisId;
	private int concurrentId;

	public MyThread(String name, Faelles faelles, int id) {
		this.name = name;
		this.faelles = faelles;
		thisId = id;
	}

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			concurrentId = (thisId + 1) % 2;
			faelles.setFlag(true, thisId);
			faelles.setTurn(concurrentId);
			while (faelles.getFlag(concurrentId) && faelles.getTurn() == concurrentId) {
			}
			faelles.kritiskSektion();
			faelles.tagerRandomTid(50);
			faelles.setFlag(false, thisId);
		}
		System.out.println(faelles.getGlobal());
	}
}
