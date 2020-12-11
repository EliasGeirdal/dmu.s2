package binarysearchtreestuderende;

/**
 * This class implements a binary search tree whose nodes hold objects that
 * implement the Comparable interface.
 */
public class BinarySearchTree<E extends Comparable<E>> {
	private Node root;

	/**
	 * Constructs an empty tree.
	 */
	public BinarySearchTree() {
		root = null;
	}

	/**
	 * returns size of tree.
	 * 
	 * @return size of tree.
	 */
	public int size() {
		return size(root);
	}

	/**
	 * recursive helper method for size.
	 * 
	 * @param n
	 * @return
	 */
	private int size(Node n) {
		return n == null ? 0 : 1 + size(n.left) + size(n.right);
	}

	/**
	 * returns true if the tree is empty.
	 * 
	 * @return true if empty, false if not.
	 */
	public boolean isEmpty() {
		return root == null;
	}

	/**
	 * Returnerer det største element i det binære søgetræ.
	 **/
	public E findMax() {
		return findMax(root);
	}

	private E findMax(Node n) {
		if (n == null)
			return null;
		return findMax(n.right) == null ? n.data : findMax(n.right);
	}

	/**
	 * Fjerner knuden med det mindste element i det binære søgetræ og returnerer
	 * værdien af dette.
	 **/
	public E removeMin() {
		return removeMin(root, root);
	}

	private E removeMin(Node n, Node parent) {
		E removed = null;
		if (root.left == null) {
			removed = root.data;
			root = root.right;
		} else {
			if (n.left == null && n.right == null) {
				removed = n.data;
				if (parent.left.data.equals(n.data)) {
					parent.left = null;
				} else {
					parent.right = null;
				}
				return removed;
			} else if (n.right == null) {
				return removeMin(n.left, n);
			} else if (n.left == null) {
				if (n.right.left != null) {
					removed = replace(n);
				} else {
					removed = n.data;
					parent.left = n.right;
				}
			}
		}
		return removed == null ? removeMin(n.left, n) : removed;
	}

	private E replace(Node n) {
		E data = n.data;
		Node current = n.right, parent = n, toBeReplaced = n;
		while (current.left != null) {
			parent = current;
			current = current.left;
		}
		toBeReplaced.data = current.data;
		parent.left = current.right;
		return data;
	}

	/**
	 * Inserts a new node into the tree.
	 *
	 * @param obj the object to insert
	 */
	public void add(E obj) {
		Node newNode = new Node();
		newNode.data = obj;
		newNode.left = null;
		newNode.right = null;
		if (root == null) {
			root = newNode;
		} else {
			root.addNode(newNode);
		}
	}

	/**
	 * Tries to find an object in the tree.
	 *
	 * @param obj the object to find
	 * @return true if the object is contained in the tree
	 */
	public boolean find(E obj) {
		Node current = root;
		boolean found = false;
		while (!found && current != null) {
			int d = current.data.compareTo(obj);
			if (d == 0) {
				found = true;
			} else if (d > 0) {
				current = current.left;
			} else {
				current = current.right;
			}
		}
		return found;
	}

	/**
	 * Tries to remove an object from the tree. Does nothing if the object is not
	 * contained in the tree.
	 *
	 * @param obj the object to remove
	 */
	public void remove(E obj) {
		// Find node to be removed

		Node toBeRemoved = root;
		Node parent = null;
		boolean found = false;
		while (!found && toBeRemoved != null) {
			int d = toBeRemoved.data.compareTo(obj);
			if (d == 0) {
				found = true;
			} else {
				parent = toBeRemoved;
				if (d > 0) {
					toBeRemoved = toBeRemoved.left;
				} else {
					toBeRemoved = toBeRemoved.right;
				}
			}
		}

		if (found) {

			// toBeRemoved contains obj

			// If one of the children is empty, use the other

			if (toBeRemoved.left == null || toBeRemoved.right == null) {
				Node newChild;
				if (toBeRemoved.left == null) {
					newChild = toBeRemoved.right;
				} else {
					newChild = toBeRemoved.left;
				}

				if (parent == null) // Found in root
				{
					root = newChild;
				} else if (parent.left == toBeRemoved) {
					parent.left = newChild;
				} else {
					parent.right = newChild;
				}

			} else {

				// Neither subtree is empty

				// Find smallest element of the right subtree

				Node smallestParent = toBeRemoved;
				Node smallest = toBeRemoved.right;
				while (smallest.left != null) {
					smallestParent = smallest;
					smallest = smallest.left;
				}

				// smallest contains smallest child in right subtree

				// Move contents, unlink child

				toBeRemoved.data = smallest.data;
				if (smallestParent == toBeRemoved) {
					smallestParent.right = smallest.right;
				} else {
					smallestParent.left = smallest.right;
				}
			}
		}
	}

	/**
	 * Prints the contents of the tree in sorted order.
	 */
	public void print() {
		print(root);
		System.out.println();
	}

	/**
	 * Prints a node and all of its descendants in sorted order.
	 *
	 * @param parent the root of the subtree to print
	 */
	private void print(Node parent) {
		if (parent != null) {
			print(parent.left);
			System.out.print(parent.data + " ");
			print(parent.right);
		}
	}

	/**
	 * A node of a tree stores a data item and references to the left and right
	 * child nodes.
	 */
	private class Node {
		private E data;
		private Node left;
		private Node right;

		/**
		 * Inserts a new node as a descendant of this node.
		 *
		 * @param newNode the node to insert
		 */
		private void addNode(Node newNode) {
			int comp = newNode.data.compareTo(data);
			if (comp < 0) {
				if (left == null) {
					left = newNode;
				} else {
					left.addNode(newNode);
				}
			} else if (comp > 0) {
				if (right == null) {
					right = newNode;
				} else {
					right.addNode(newNode);
				}
			}
		}
	}
}
