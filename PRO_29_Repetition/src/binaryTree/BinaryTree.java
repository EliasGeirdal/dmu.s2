package binaryTree;

/**
 * A binary tree in which each node has two children.
 */
public class BinaryTree<E> {
	private Node root;

	/**
	 * Constructs an empty tree.
	 */
	public BinaryTree() {
		root = null;
	}

	/**
	 * Constructs a tree with one node and no children.
	 *
	 * @param rootData the data for the root
	 */
	public BinaryTree(E rootData) {
		root = new Node();
		root.data = rootData;
		root.left = null;
		root.right = null;
	}

	/**
	 * Constructs a binary tree.
	 *
	 * @param rootData the data for the root
	 * @param left     the left subtree
	 * @param right    the right subtree
	 */
	public BinaryTree(E rootData, BinaryTree<E> left, BinaryTree<E> right) {
		root = new Node();
		root.data = rootData;
		if (left != null) {
			root.left = left.root;
		}
		if (right != null) {
			root.right = right.root;
		}
	}

	public int countElements(E element) {
		return countElements(element, root);
	}

	private int countElements(E element, Node n) {
		if (n == null)
			return 0;
		if (n.data.equals(element))
			return 1 + countElements(element, n.right) + countElements(element, n.left);
		return countElements(element, n.right) + countElements(element, n.left);
	}

	public int value() {
		return value(root);
	}

	private int value(Node n) {
		if (isLeaf(n)) {
			return Integer.parseInt(n.data.toString());
		} else {
			if (n.data.equals("+"))
				return value(n.left) + value(n.right);
			else
				return value(n.left) * value(n.right);
			// continue if more operators are needed.
		}
	}

	public void print() {
		inOrder();
	}

	/**
	 * Checks whether this tree is empty.
	 *
	 * @return true if this tree is empty
	 */
	public boolean isEmpty() {
		return root == null;
	}

	/**
	 * Gets the data at the root of this tree.
	 *
	 * @return the root data
	 */
	public E data() {
		return root.data;
	}

	/**
	 * Gets the left subtree of this tree.
	 *
	 * @return the left child of the root
	 */
	public BinaryTree<E> left() {
		BinaryTree<E> result = new BinaryTree<E>();
		result.root = root.left;
		return result;
	}

	/**
	 * Gets the right subtree of this tree.
	 *
	 * @return the right child of the root
	 */
	public BinaryTree<E> right() {
		BinaryTree<E> res = new BinaryTree<E>();
		res.root = root.right;
		return res;
	}

	/**
	 *
	 * @param rootData the new data for the root
	 *
	 * @return the data previous in the root
	 */
	public E replace(E rootData) {
		E oldData = root.data;
		root.data = rootData;
		return oldData;
	}

	/**
	 *
	 * @param n
	 * @return true in n has no children
	 */
	private boolean isLeaf(Node n) {
		return n.left == null && n.right == null;
	}

	/**
	 *
	 * @param n
	 * @return true in n has at least one child
	 */
	private boolean isInternal(Node n) {
		return n.left != null || n.right != null;
	}

	/**
	 *
	 * @return the number of nodes in the tree
	 */
	public int size() {
		return size(root);
	}

	private int size(Node n) {
		if (n == null)
			return 0;
		int size = 0;
		if (isLeaf(n)) {
			size = 1;
		} else {
			size = 1 + size(n.left) + size(n.right);
		}
		return size;
	}

	public int height() {
		return height(root);
	}

	private int height(Node n) {
		if (n == null)
			return 0;
		if (isLeaf(n)) {
			return 1;
		}
		int left = 1 + height(n.left);
		int right = 1 + height(n.right);
		return left > right ? left : right;
	}

	public void inOrder() {
		inOrder(root);
	}

	private void inOrder(Node n) {
		if (isLeaf(n)) {
			System.out.print(n.data + " ");
		} else {
			inOrder(n.left);
			System.out.print(n.data + " ");
			inOrder(n.right);
		}
	}

	public void preOrder() {
		preOrder(root);
	}

	private void preOrder(Node n) {
		System.out.print(n.data + " ");
		preOrder(n.left);
		preOrder(n.right);
	}

	public void postOrder() {
		postOrder(root);
	}

	private void postOrder(Node n) {
		if (isLeaf(n)) {
			System.out.print(n.data + " ");
		} else {
			postOrder(n.left);
			postOrder(n.right);
			System.out.print(n.data + " ");
		}
	}

	public int sum() {
		return sum(root);
	}

	private int sum(Node n) {
		if (n == null) {
			return 0;
		}
		if (isLeaf(n))
			return (int) n.data;
		return (int) n.data + sum(n.left) + sum(n.right);
	}

	public double avg() {
		return (double) sum() / size();
	}

	public boolean remove(Node remove) {
		return remove(remove, root, root);
	}

	private boolean remove(Node remove, Node n, Node parent) {
		if (n == null) {
			return false;
		}
		if (n.data.equals(remove.data)) {
			if (remove.data.equals(root.data))
				deleteTree(); // Consider root = null.
			if (n.data.equals(parent.left.data)) {
				parent.left = null;
			} else {
				parent.right = null;
			}
			System.out.println("removed: " + n.data);
			return true;
		}
		boolean left = remove(remove, n.left, n), right = remove(remove, n.right, n);
		return left == true ? left : right;
	}

	public void deleteTree() {
		root = null;
	}

	private class Node {
		public E data;
		public Node left;
		public Node right;
	}

	public Node getRoot() {
		return root;
	}
}
