package repitition.opgave02;

public class TestApp {

	public static void main(String[] args) {
		SortedDoubleLinkedList list = new SortedDoubleLinkedList();
		SortedDoubleLinkedList anotherList = new SortedDoubleLinkedList();
		list.addElement("D");
//		list.addElement("C");
//		list.addElement("A");
//		list.addElement("B");
//		list.addElement("H");
//		list.addElement("S");
//		list.addElement("B");

		anotherList.addElement("A");
		anotherList.addElement("A");
		anotherList.addElement("A");
		anotherList.addElement("A");

//		for (int i = 0; i < 7; i++) {
//			System.out.println(list);
//			System.out.println(list.removeFirst());
//			System.out.println(list + "\n");
//		}

//		for (int i = 0; i < 7; i++) {
//			System.out.println(list);
//			System.out.println(list.removeLast());
//			System.out.println(list);
//		}

//		list.addAll(anotherList);
//		System.out.println(list.toString());

		// test remove method.
//		System.out.println(list.toString());
//		System.out.println(list.removeElement("B"));
//		System.out.println(list.toString());
//		System.out.println(list.removeElement("C"));
//		System.out.println(list.toString());
//		System.out.println(list.removeElement("H"));
//		System.out.println(list.toString());
//		System.out.println(list.removeElement("B"));
//		System.out.println(list.toString());
		System.out.println(list.removeElement("D"));
		System.out.println(list.toString());
	}

}
