package opgave3;

import java.util.Arrays;

public class MainApp {
	public static void main(String[] args) {

		CircularList clist = new CircularList();
		clist.enqueue(new Person("Lars"));
		clist.enqueue(new Person("Ole"));
		clist.enqueue(new Person("Hans"));
		clist.enqueue(new Person("Peter"));
		clist.enqueue(new Person("Simon"));
		clist.enqueue(new Person("Henry"));
		clist.enqueue(new Person("Jenkins"));
		clist.enqueue(new Person("Nike"));
		clist.enqueue(new Person("Bulsara")); // 9

		System.out.println(clist.toString());
		System.out.println(Arrays.toString(clist.kanibalisering(6)));
	}
}
