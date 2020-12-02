package opgave4;

import java.util.NoSuchElementException;

public class StackQueue implements QueueI {

	private ArrayStack up;
	private ArrayStack down;

	public StackQueue(int size) {
		up = new ArrayStack(size);
		down = new ArrayStack(size);
	}

	@Override
	public boolean isEmpty() {
		return up.isEmpty() && down.isEmpty();
	}

	@Override
	public void enqueue(Object newElement) {
		if (up.size() == 0) {
			up.push(newElement);
			down.push(newElement);
		} else {
			int count = 0;
			while (!down.isEmpty()) {
				up.push(down.pop());
				count++;
			}
			down.push(newElement);
			int j = 0;
			while (j < count) {
				down.push(up.pop());
				j++;
			}
			up.push(newElement);
		}
	}

	@Override
	public Object dequeue() {
		if (up.size() == 0) {
			throw new NoSuchElementException("Queue is empty.");
		}
		int count = 0;
		while (!up.isEmpty()) {
			down.push(up.pop());
			count++;
		}
		down.pop();
		int j = 0;
		while (j < count) {
			up.push(down.pop());
			j++;
		}
		return up.pop();
	}

	@Override
	public Object getFront() {
		return up.peek();
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
