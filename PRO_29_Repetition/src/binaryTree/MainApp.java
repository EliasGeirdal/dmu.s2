package binaryTree;

public class MainApp {
	public static void main(String[] args) {
		// left subtree
		BinaryTree<String> t2 = new BinaryTree<String>("2");
		BinaryTree<String> t4 = new BinaryTree<String>("4");

		BinaryTree<String> plus24 = new BinaryTree<String>("+", t2, t4);
		BinaryTree<String> t7 = new BinaryTree<String>("7");

		BinaryTree<String> gangeplus7 = new BinaryTree<String>("*", plus24, t7);
		// /left subtree

		// right subtree
		BinaryTree<String> t3 = new BinaryTree<String>("3");
		BinaryTree<String> t8 = new BinaryTree<String>("8");

		BinaryTree<String> plus38 = new BinaryTree<String>("+", t3, t8);
		// /right subtree

		// root
		BinaryTree<String> root = new BinaryTree<String>("+", gangeplus7, plus38);

		System.out.println(root.size());
		System.out.println(root.countElements("+"));
		System.out.println(root.value());
		root.print();

		System.out.println("\n" + root.height());
		root.postOrder();

	}
}
