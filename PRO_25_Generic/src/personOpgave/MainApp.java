package personOpgave;

import java.util.ArrayList;
import java.util.Collections;

public class MainApp {
	public static <T, S> void main(String[] args) {
		ArrayList<Person<?>> list = new ArrayList<>();
		Person<Navn> p1 = new Person<>(new Navn("A", "B"));
		Person<Navn> p2 = new Person<>(new Navn("B", "B"));
		Person<Navn> p3 = new Person<>(new Navn("C", "A"));
		Person<String> p4 = new Person<>("D", "D");

		list.add(p2);
		list.add(p1);
		list.add(p3);
		list.add(p4);

		System.out.println(list);
		Collections.sort(list);
		System.out.println(list);

	}
}
