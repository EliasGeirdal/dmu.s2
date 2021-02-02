package repitition.opgave02;

public class SortedDoubleLinkedList {
	private class Node {
		public String data;
		public Node next;
		public Node previous;

		public Node(String data) {
			this.data = data;
		}
	}

	private Node first;
	private Node last;
	private int size;

	/**
	 * Laver en tom sorteret doubly linked list.
	 */
	public SortedDoubleLinkedList() {
		first = null;
		last = null;
	}

	/**
	 * Tilføjer et element til listen, så listen fortsat er sorteret i henhold til
	 * den naturlige ordning på elementerne.
	 * 
	 * @param element det der indsættes
	 */
	public void addElement(String element) {
		size++;
		Node newNode = new Node(element);
		if (first == null) {
			first = newNode;
			last = newNode;
			return;
		}
		Node current = first;
		while (current != null) {
			if (current.data.compareTo(element) > 0) {
				if (current == first) {
					newNode.next = first;
					first.previous = newNode;
					first = newNode;
					break;
				}
				newNode.next = current;
				newNode.previous = current.previous;
				current.previous.next = newNode;
				current.previous = newNode;
				current = newNode;
				break;
			}
			if (current.next == null) {
				current.next = newNode;
				newNode.previous = current;
				last = newNode;
				break;
			}
			current = current.next;
		}
	}

	/**
	 * Fjerner et element fra listen.
	 * 
	 * @param element det element der fjernes
	 * @return true hvis elementet blev fjernet, men ellers false.
	 */
	public boolean removeElement(String element) {
		size--;
		boolean removed = false;
		if (first.data.equals(element)) {
			return removeFirst() != null ? true : false;
		} else if (last.data.equals(element)) {
			return removeLast() != null ? true : false;
		} else {
			Node current = first.next;
			Node previous = first;
			while (current != null && !removed) {
				if (current.data.equals(element)) {
					previous.next = current.next;
					current.next.previous = previous;
					removed = true;
				}
				previous = current;
				current = current.next;
			}
		}
		return removed;
	}

	public String removeFirst() {
		size--;
		String removed = first.data;
		first = first.next;
		if (first == null) {
			last = null;
		} else
			first.previous = null;
		return removed;

	}

	public String removeLast() {
		size--;
		String removed = last.data;
		last = last.previous;
		if (last == null) {
			first = null;
		} else
			last.next = null;
		return removed;
	}

	public int countElements() {
		return countElements(first);
	}

	private int countElements(Node n) {
		return n == null ? 0 : 1 + countElements(n.next);
	}

	public int size() {
		return size;
	}

	public Node getFirst() {
		return first;
	}

	public void addAll(SortedDoubleLinkedList list) {
		Node current = list.getFirst();
		while (current != null) {
			addElement(current.data);
			current = current.next;
		}
	}

	@Override
	public String toString() {
		Node current = first;
		String elements = "";
		while (current != null) {
			elements += current.data + ", ";
			current = current.next;
		}

		return elements == "" ? "empty list" : elements;
	}
}
