package repetition.test;

import repetition.opgave02.BinarySearchTree;

public class MainApp {
	public static void main(String[] args) {
		BinarySearchTree<Integer> bst = new BinarySearchTree<>();
		bst.add(45);
		bst.add(22);
		bst.add(30);
		bst.add(25);
//		bst.add(26); test
		bst.add(11);
		bst.add(15);
		bst.add(77);
		bst.add(90);
		bst.add(88);
		bst.print();

		System.out.println("Max value: " + bst.findMax());
		System.out.println("Size: " + bst.size() + "\n");

		System.out.println("removeMin() method:\nExpected: 11.\nActual: " + bst.removeMin());
		while (!bst.isEmpty()) {
			System.out.println("removed: " + bst.removeMin());
		}
		bst.print();

	}
}
