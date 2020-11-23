package opgave_02;

public class MainApp {

	public static void main(String[] args) {
		Faelles faelles = new Faelles();
		MyThread t1 = new MyThread("A", faelles, 0);
		MyThread t2 = new MyThread("B", faelles, 1);

		try {
			t1.start();
			t2.start();
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(faelles.getGlobal());
	}

}
