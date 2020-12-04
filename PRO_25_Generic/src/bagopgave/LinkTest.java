package bagopgave;

import java.util.Arrays;

public class LinkTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedBag<String> list = new LinkedBag<String>();

		list.add("A");
		list.add("B");
		list.add("C");
		list.add("D");
		list.add("E");
		list.add("F");

		System.out.println(Arrays.toString(list.toArray()));
	}

}
