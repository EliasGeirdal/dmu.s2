package opgave4;

import java.util.NoSuchElementException;

public class QueueStack implements Stack {
	private StackQueue up;
	private StackQueue tmp;

	public QueueStack(int size) {
		up = new StackQueue(size);
		tmp = new StackQueue(size);
	}

	@Override
	public void push(Object newElement) {
		up.enqueue(newElement);
	}

	@Override
	public Object pop() {
		if (up.size() == 0) {
			throw new NoSuchElementException("Stack is empty.");
		}
		int count = 0;
		while (!up.isEmpty()) {
			tmp.enqueue(up.dequeue());
			count++;
		}
		Object removed = null;
		int j = 0;
		while (j < count) {
			if (j == count - 1) {
				removed = tmp.dequeue();
			} else {
				up.enqueue(tmp.dequeue());
			}
			j++;
		}
		return removed;
	}

	@Override
	public Object peek() {
		return up.getFront();
	}

	@Override
	public boolean isEmpty() {
		return up.size() == 0;
	}

	@Override
	public int size() {
		return up.size();
	}

	@Override
	public String toString() {
		return up.toString();
	}
}
