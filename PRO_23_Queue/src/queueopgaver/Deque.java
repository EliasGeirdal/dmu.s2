package queueopgaver;

import java.util.NoSuchElementException;

public class Deque implements DequeI {
	private DoubleNode head, tail;
	private int size;

	public Deque() {
		head = new DoubleNode();
		tail = new DoubleNode();
		size = 0;
	}

	@Override
	public boolean isEmpty() {
		if (size == 0) {
			return true;
		}
		return false;
	}

	@Override
	public void addFirst(Object newElement) {
		DoubleNode newNode = new DoubleNode(newElement);
		newNode.setNext(head);
		head = newNode;
		if (isEmpty()) {
			tail = head;
		}
		size++;

	}

	@Override
	public void addLast(Object newElement) {
		if (isEmpty()) {
			addFirst(newElement);
		} else {
			DoubleNode newNode = new DoubleNode(newElement);
			tail.setNext(newNode);
			tail = newNode;
			size++;
		}
	}

	@Override
	public Object removeFirst() {
		if (isEmpty()) {
			throw new NoSuchElementException("Queue is empty.");
		}
		DoubleNode removed = head;

		head = head.getNext();
		size--;
		return removed;

	}

	@Override
	public Object removeLast() {
		if (isEmpty()) {
			throw new NoSuchElementException("Queue is empty.");
		}
		DoubleNode removed = tail;
		tail = tail.getPrevious();
		size--;
		return removed;
	}

	@Override
	public Object getFirst() {
		if (isEmpty()) {
			throw new NoSuchElementException("Queue is empty.");
		}
		return head;
	}

	@Override
	public Object getLast() {
		if (isEmpty()) {
			throw new NoSuchElementException("Queue is empty.");
		}
		return tail;
	}

	@Override
	public int size() {
		return size;
	}

}
