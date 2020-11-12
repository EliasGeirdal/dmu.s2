package opgaver;

public class Opg_02_SortedDoublyLinkedList {
	private class Node {
		public String data;
		public Node next;
		public Node previous;
	}

	private Node first;
	private Node last;

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
		if (first.data == null) {
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
		// TODO: lav mig
	}

	public String removeFirst() {
		// TODO: lav mig
	}

	public String removeLast() {
		// TODO: lav mig
	}

	public int countElements() {
		// TODO: lav mig
	}

	@Override
	public String toString() {
		// TODO: lav mig
	}
}
