package queueopgaver;

import java.util.NoSuchElementException;

public class LinkedQueue implements QueueI {
	private LinearNode head, tail;
	private int size;

	public LinkedQueue() {
		head = new LinearNode();
	}

	@Override
	public boolean isEmpty() {
		if (size == 0) {
			return true;
		}
		return false;
	}

	@Override
	public void enqueue(Object newElement) {
		LinearNode newNode = new LinearNode(newElement);
		if (isEmpty()) {
			head = newNode;
			tail = newNode;
		} else {
			tail.setNext(newNode);
			tail = newNode;
		}
		size++;
	}

	@Override
	public Object dequeue() {
		if (isEmpty()) {
			throw new NoSuchElementException("Queue is empty.");
		}
		LinearNode removed = head;
		head = head.getNext();
		size--;
		return removed;
	}

	@Override
	public Object getFront() {
		if (isEmpty()) {
			throw new NoSuchElementException("Queue is empty.");
		}
		return head;
	}

	@Override
	public int size() {
		return size;
	}

}
