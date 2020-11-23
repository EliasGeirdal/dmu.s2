package opgave_03;

import java.util.EmptyStackException;

import opgave_01.Stack;

public class DropOutStackEnkelt implements Stack {
	private Node first, position, previous, beforeLastAdded;
	private final int SIZE;
	private int pos;
	private boolean full, isAfterRemoved;

	public DropOutStackEnkelt(int size) {
		SIZE = size;
		pos = 0;
	}

	private void resetPosIfNeeded() {
		if (pos == SIZE) {
			pos = 0;
			full = true;
		}
	}

	private void pushFull(Object element) {
		if (!isAfterRemoved) {
			position.data = element;
		} else if (isAfterRemoved) {
			Node newNode = new Node(element);
			newNode.next = position.next;
			position = newNode;
			isAfterRemoved = false;
		}
	}

	@Override
	public void push(Object element) {
		resetPosIfNeeded();
		if (full) {
			pushFull(element);

		} else if (first == null) {
			first = new Node(element);
			position = first;
		} else {
			Node newNode = new Node(element);
			position.next = newNode;
		}
		pos++;
		if (first.next != null) {
			beforeLastAdded = previous;
			previous = position;
			if (pos == SIZE) {
				position = first;
			} else {
				position = position.next;
			}
		}
	}

	@Override
	public Object pop() {
		Object popped;
		if (!full && pos == 0) {
			throw new EmptyStackException();
		} else {
			popped = previous;
			beforeLastAdded.next = position;
		}
		pos--;
		isAfterRemoved = true;
		return popped;
	}

	@Override
	public Object peek() {
		return null;
	}

	@Override
	public boolean isEmpty() {
		return false;
	}

	@Override
	public int size() {
		return -1;
	}

	@Override
	public String toString() {
		String result = "";
		Node runThrough = first;
		while (runThrough != null) {
			result += runThrough.data + " ";
			runThrough = runThrough.next;
		}
		return result;
	}

	public class Node {
		public Node next;
		public Object data;

		public Node(Object data) {
			this.data = data;
		}
	}

}
