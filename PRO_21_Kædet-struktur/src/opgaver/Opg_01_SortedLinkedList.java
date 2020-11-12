package opgaver;

import java.util.NoSuchElementException;

public class Opg_01_SortedLinkedList {
	private Node first;
	private Node position;
	private Node previous;

	public Opg_01_SortedLinkedList() {
		first = null;
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
		if (first == null) {
			newNode.next = first;
			first = newNode;
			position = first;
		} else if (first.next == null) {
			if (first.data.compareTo(element) > 0) {
				newNode.next = first;
				first = newNode;
			} else {
				first.next = newNode;
			}
		} else {
			while (!added) {

				if (position.data.compareTo(element) > 0) {
					newNode.next = previous.next;
					previous.next = newNode;
					added = true;
				} else if (position.next == null) {
					position.next = newNode;
					added = true;
				}
				previous = position;
				position = position.next;
			}
		}
		position = first;
		previous = position;
	}

	/**
	 * Fjerner et element fra listen.
	 * 
	 * @param element det element der fjernes
	 * @return true hvis elementet blev fjernet, men ellers false.
	 */
	public boolean removeElement(String element) {
		boolean deleted = false;
		Node previous = first;
		position = first;
		if (first.next == null) {
			if (first.data.equals(element)) {
				first = first.next;
			}
		}
		while (position != null && !deleted) {
			if (position.data.equals(element)) {
				if (position.equals(first)) {
					first = first.next;
				}
				previous.next = position.next;
				deleted = true;
			} else {
				previous = position;
				position = position.next;
			}
		}
		return deleted;
	}

	/**
	 * Returnerer antallet af elementer i listen.
	 */
	public int countElements() {
		int count = 0;
		Node next = first;
		while (next != null) {
			count++;
			next = next.next;
		}
		return count;
	}

	@Override
	public String toString() {
		String result = "[";
		Node next;
		if (first == null) {
			throw new NoSuchElementException();
		}
		if (first.next == null) {
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

	class Node {
		public String data;
		public Node next;
	}

}
