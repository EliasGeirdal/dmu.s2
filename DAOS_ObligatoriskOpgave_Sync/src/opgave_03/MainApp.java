package opgave_03;

public class MainApp {

	public static void main(String[] args) {
		Faelles faelles = new Faelles();
		MyThread t1 = new MyThread("A", faelles);
		MyThread t2 = new MyThread("B", faelles);

		t1.start();
		t2.start();
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(faelles.getGlobal());
	}

}
