package repetition.opgave02;

import java.util.NoSuchElementException;

import repetition.opgave01.DequeI;

public class Deque<T> implements DequeI<T> {
	private Node first, last;
	private int size;

	public Deque() {
		size = 0;
	}

	@Override
	public void addFirst(T element) {
		Node newNode = new Node(element);
		if (isEmpty()) {
			first = newNode;
			last = first;
		} else {
			newNode.next = first;
			first.previous = newNode;
			first = newNode;
		}
		size++;
	}

	@Override
	public void addLast(T element) {
		Node newNode = new Node(element);
		if (isEmpty()) {
			first = newNode;
			last = first;
		} else {
			newNode.previous = last;
			last.next = newNode;
			last = newNode;
		}
		size++;
	}

	@Override
	public T removeFirst() {
		T oldVal = null;
		if (isEmpty()) {
			throw new NoSuchElementException("Listen er tom.");
		} else if (size == 1) {
			first = null;
			last = null;
		} else {
			oldVal = first.data;
			first = first.next;
			first.previous = null;
			size--;
			return oldVal;
		}
		return oldVal;
	}

	@Override
	public T removeLast() {
		T oldVal = null;
		if (isEmpty()) {
			throw new NoSuchElementException("Listen er tom.");
		} else if (size == 1) {
			first = null;
			last = null;
		} else {
			oldVal = last.data;
			last = last.previous;
			last.next = null;
			size--;
		}
		return oldVal;
	}

	@Override
	public T getFirst() {
		if (isEmpty()) {
			throw new NoSuchElementException("Listen er tom.");
		}
		return first.data;
	}

	@Override
	public T getLast() {
		if (isEmpty()) {
			throw new NoSuchElementException("Listen er tom.");
		}
		return last.data;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	class Node {
		private T data;
		private Node next, previous;

		public Node(T data) {
			this.data = data;
		}
	}

	@Override
	public String toString() {
		String res = "[";
		Node current = first;
		while (current != null) {
			res += current.data + ", ";
			current = current.next;
		}
		return res + "]";
	}
}
