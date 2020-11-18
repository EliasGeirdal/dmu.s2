package opgaver;

public class MainApp {

	public static void main(String[] args) {
		// Opgave 1
//		Opg_01_SortedLinkedList sortedList = new Opg_01_SortedLinkedList();
//		String s1 = "d";
//		String s2 = "a";
//		String s3 = "c";
//		String s4 = "b";
//		String s5 = "b";
//		String s6 = "b";
//		sortedList.addElement(s1);
//		sortedList.addElement(s2);
//		sortedList.addElement(s3);
//		sortedList.addElement(s4);
//		sortedList.removeElement(s2);

//		System.out.println(sortedList.toString());
//		System.out.println(sortedList.countElements());

		// Opgave 2.
//		Opg_02_SortedDoublyLinkedList sortedList = new Opg_02_SortedDoublyLinkedList();
//		String s1 = "d";
//		String s2 = "a";
//		String s3 = "c";
//		String s4 = "b";
//		String s5 = "f";
//		String s6 = "e";
//		sortedList.addElement(s1);
//		sortedList.addElement(s2);
//		sortedList.addElement(s3);
//		sortedList.addElement(s4);
//		sortedList.addElement(s5);
//		sortedList.addElement(s6);

//		System.out.println(sortedList.toString());
//		sortedList.removeElement(s1);
//		sortedList.removeFirst();
//		sortedList.removeLast();
//		System.out.println(sortedList.toString());
//		System.out.println(sortedList.countElements());

		// Opgave 3
//		Opg_02_SortedDoublyLinkedList sortedList = new Opg_02_SortedDoublyLinkedList();
//		Opg_02_SortedDoublyLinkedList newList = new Opg_02_SortedDoublyLinkedList();
//		String s1 = "d";
//		String s2 = "a";
//		String s3 = "c";
//		String s4 = "b";
//		String s5 = "e";
//		newList.addElement(s1);
//		newList.addElement(s2);
//		newList.addElement(s3);
//		sortedList.addElement(s4);
//		sortedList.addElement(s5);
//
//		sortedList.addAll(newList);
//		System.out.println(sortedList.toString());

		// opgave 4
		Opg_02_SortedDoublyLinkedList sortedList = new Opg_02_SortedDoublyLinkedList();
		String s1 = "d";
		String s2 = "a";
		String s3 = "c";
		String s4 = "d";
		String s5 = "e";
		sortedList.addElement(s1);
		sortedList.addElement(s2);
		sortedList.addElement(s3);
		sortedList.addElement(s4);
		sortedList.addElement(s5);
		System.out.println(sortedList.recursiveCount());
	}

}
