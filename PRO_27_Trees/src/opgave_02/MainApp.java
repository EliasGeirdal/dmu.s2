package opgave_02;

public class MainApp {
	public static void main(String[] args) {
		// left
		BinaryTree<Integer> t15 = new BinaryTree<>(15);
		BinaryTree<Integer> t11 = new BinaryTree<>(11, null, t15);

		BinaryTree<Integer> t25 = new BinaryTree<>(25);
		BinaryTree<Integer> t30 = new BinaryTree<>(30, t25, null);

		BinaryTree<Integer> t22 = new BinaryTree<>(22, t11, t30);
		// /Left

		// right
		BinaryTree<Integer> t88 = new BinaryTree<>(88);
		BinaryTree<Integer> t90 = new BinaryTree<>(90, t88, null);

		BinaryTree<Integer> t77 = new BinaryTree<>(77, null, t90);
		// /right

		// root
		BinaryTree<Integer> t45 = new BinaryTree<>(45, t22, t77);
		// /root

		System.out.println(t45.size());
		System.out.println(t45.height());
		t45.inOrder();
		System.out.println();
		t45.preOrder();
		System.out.println();
		t45.postOrder();

	}
}
