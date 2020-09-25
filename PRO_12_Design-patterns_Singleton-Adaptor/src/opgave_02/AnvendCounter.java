package opgave_02;

public class AnvendCounter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Counter c = Counter.getInstance();
		c.count();
		c.times2();
		System.out.println(c.getValue());
		Counter c2 = Counter.getInstance();
//		Counter c3 = new Counter();
		System.out.println(c2.getValue());
		c.zero();
		System.out.println(c.getValue());
	}

}
