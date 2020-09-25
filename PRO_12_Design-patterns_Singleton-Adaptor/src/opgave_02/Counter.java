package opgave_02;

public class Counter {
	private static Counter counterUnique = null;
	private int value;

	private Counter() {
	}

	public static Counter getInstance() {
		if (counterUnique == null) {
			counterUnique = new Counter();
		}
		return counterUnique;
	}

	public void count() {
		value++;
	}

	public void times2() {
		value *= 2;
	}

	public void zero() {
		value = 0;
	}

	public int getValue() {
		return value;
	}

}
