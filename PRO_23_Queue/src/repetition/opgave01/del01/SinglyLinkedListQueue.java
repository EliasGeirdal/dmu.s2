package repetition.opgave01.del01;

import java.util.NoSuchElementException;

import repetition.QueueI;

public class SinglyLinkedListQueue<T> implements QueueI<T> {
	class Node {
		private T data;
		private Node next;

		public Node(T data) {
			this.data = data;
		}
	}

	private Node first, last;
	private int size;

	public SinglyLinkedListQueue() {
		first = null;
		last = null;
	}

	@Override
	public boolean isEmpty() {
		return first == null;
	}

	@Override
	public void enqueue(T newElement) {
		Node newNode = new Node(newElement);
		if (isEmpty()) {
			first = newNode;
			last = first;
		} else {
			last.next = newNode;
			last = newNode;
		}
		size++;
	}

	@Override
	public T dequeue() {
		if (isEmpty()) {
			throw new NoSuchElementException("Don't be a fool, wrap that tool.");
		}
		T oldNode = first.data;
		first = first.next;
		size--;
		return oldNode;
	}

	@Override
	public T getFront() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		return first.data;
	}

	@Override
	public int size() {
		return size;
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
