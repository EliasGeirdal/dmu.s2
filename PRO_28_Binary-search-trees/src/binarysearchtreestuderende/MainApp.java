package binarysearchtreestuderende;

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
		System.out.println("Size: " + bst.size());
		System.out.println("Removed: " + bst.removeMin());
		System.out.println("Removed: " + bst.removeMin());
		bst.print();
		System.out.println("Removed: " + bst.removeMin());
		System.out.println("Removed: " + bst.removeMin());
		System.out.println("Removed: " + bst.removeMin());
		System.out.println("Removed: " + bst.removeMin());
		System.out.println("Removed: " + bst.removeMin());
		System.out.println("Removed: " + bst.removeMin());
		System.out.println("Removed: " + bst.removeMin());
		bst.print();
//		while (!bst.isEmpty()) {
//		}
	}
}
