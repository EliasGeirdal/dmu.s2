package opgaver;

import java.util.NoSuchElementException;

public class Opg_02_SortedDoublyLinkedList {
	private class Node {
		public String data;
		public Node next;
		public Node previous;
	}

	private Node first;
	private Node last;
	private Node position;
	private Node lastVisited;

	/**
	 * Laver en tom sorteret doubly linked list.
	 */
	public Opg_02_SortedDoublyLinkedList() {
		Node sentinelFirst = new Node();
		Node sentinelLast = new Node();
		sentinelFirst.previous = null;
		sentinelFirst.next = sentinelLast;
		sentinelLast.previous = sentinelFirst;
		sentinelLast.next = null;
		this.first = sentinelFirst;
		this.last = sentinelLast;
	}

	/**
	 * Tilføjer et element til listen, så listen fortsat er sorteret i henhold til
	 * den naturlige ordning på elementerne.
	 * 
	 * @param element det der indsættes
	 */
	public void addElement(String element) {
		boolean added = false;
		Node newNode = new Node();
		newNode.data = element;
		position = first;
		lastVisited = first;
		if (first.data == null) {
			newNode.next = first.next;
			newNode.previous = first.previous;
			last.previous = newNode;
			first = newNode;
		} else if (first.next.data == null) {
			if (first.data.compareTo(element) > 0) {
				first.previous = newNode;
				newNode.next = first;
				last = first;
				first = newNode;
			} else {
				newNode.next = first.next;
				first.next = newNode;
				last = newNode;
			}
		} else {
			while (!added) {
				if (position.data.compareTo(element) > 0) {
					newNode.next = lastVisited.next;
					lastVisited.next.previous = newNode;
					lastVisited.next = newNode;
					newNode.previous = lastVisited;
					added = true;
				} else if (position.equals(last)) {
					position.next = newNode;
					newNode.previous = position;
					last = newNode;
					added = true;
				}
				lastVisited = position;
				position = position.next;
			}
		}
		position = first;
		lastVisited = position;
	}

	/**
	 * Fjerner et element fra listen.
	 * 
	 * @param element det element der fjernes
	 * @return true hvis elementet blev fjernet, men ellers false.
	 */
	public boolean removeElement(String element) {
		return false;
	}

	public String removeFirst() {
		return null;
	}

	public String removeLast() {
		return null;
	}

	public int countElements() {
		return 0;
	}

	@Override
	public String toString() {
		String result = "[";
		Node next;
		if (first.data == null) {
			throw new NoSuchElementException();
		}
		if (first.next.data == null) {
			result += first.data;
		} else {
			result += first.data;
			next = first.next;
			while (next != null) {
				result += " " + next.data;
				next = next.next;
			}
		}
		return result + "]";
	}
}
