package bagopgave;

public class LinkedBag<E> implements Bag<E> {
	private Node<E> first;
	private final int CAPACITY;
	private int currentSize;

	public LinkedBag() {
		CAPACITY = 22;
		currentSize = 0;
		first = null;
	}

	@Override
	public int getCurrentSize() {
		return currentSize;
	}

	@Override
	public boolean isFull() {
		return currentSize == CAPACITY;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return currentSize == 0;
	}

	@Override
	public boolean add(E newEntry) {
		if (isFull()) {
			return false;
		}
		Node<E> newNode = new Node<E>(newEntry);
		if (first == null) {
			first = newNode;
		} else {
			newNode.next = first;
			first = newNode;
		}
		currentSize++;
		return true;
	}

	@Override
	public E remove() {
		if (isFull()) {
			return null;
		}
		E removed = first.data;
		first = first.next;
		currentSize--;
		return removed;
	}

	@Override
	public boolean remove(E anEntry) {
		if (isEmpty() || !contains(anEntry)) {
			return false;
		}
		Node<E> current = first;
		Node<E> previous = first;
		if (first.next == null) {
			first = null;
			currentSize--;
			return true;
		}
		while (current != null) {
			if (current.data.equals(anEntry)) {
				previous.next = current.next;
				currentSize--;
				return true;
			}
			previous = current;
			current = current.next;
		}
		return false;
	}

	@Override
	public void clear() {
		first = null;
		currentSize = 0;
	}

	@Override
	public int getFrequencyOf(E anEntry) {
		int count = 0;
		Node<E> current = first;
		while (current != null) {
			if (current.data.equals(anEntry)) {
				count++;
			}
			current = current.next;
		}
		return count;
	}

	@Override
	public boolean contains(E anEntry) {
		return getFrequencyOf(anEntry) > 0;
	}

	@Override
	public E[] toArray() {
		@SuppressWarnings("unchecked")
		E[] arr = (E[]) new Object[currentSize];
		Node<E> current = first;
		int i = 0;
		while (current != null) {
			arr[i] = current.data;
			current = current.next;
			i++;
		}
		return arr;
	}

	public class Node<T> {
		Node<T> next;
		T data;

		public Node(T element) {
			data = element;
		}
	}

}
