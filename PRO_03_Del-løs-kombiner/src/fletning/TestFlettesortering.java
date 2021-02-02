package fletning;

import java.util.ArrayList;

public class TestFlettesortering {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();

//        list.add(45);
//        list.add(12);
//        list.add(56);
//        list.add(37);
//        list.add(48);
//        list.add(12);
//        list.add(34);
//        list.add(4);
//        list.add(56);
		list.add(8);
		list.add(56);
		list.add(45);
		list.add(34);
		list.add(15);
		list.add(12);
		list.add(34);
		list.add(38);
		// [8, 56, 45, 34, 15, 12, 34,
		System.out.println(list);

		FletteSorteringHul sort = new FletteSorteringHul();
		sort.fletteSort(list);
		System.out.println();
		System.out.println(list);
	}

}
