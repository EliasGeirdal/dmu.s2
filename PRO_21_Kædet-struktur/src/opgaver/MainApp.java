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
		Opg_02_SortedDoublyLinkedList sortedList = new Opg_02_SortedDoublyLinkedList();
		String s1 = "d";
		String s2 = "a";
		String s3 = "c";
		String s4 = "b";
		String s5 = "f";
		String s6 = "e";
		sortedList.addElement(s1);
		sortedList.addElement(s2);
		sortedList.addElement(s3);
		sortedList.addElement(s4);
		sortedList.addElement(s5);
		sortedList.addElement(s6);

		System.out.println(sortedList.toString());
//		System.out.println(sortedList.countElements());
	}

}
