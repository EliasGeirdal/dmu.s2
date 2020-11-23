package opgave_03;

import java.util.EmptyStackException;
import java.util.LinkedList;

import opgave_01.Stack;

public class DropOutStackDobbelt implements Stack {

	LinkedList<Object> list;
	private boolean full, isAfterRemoved;
	private int SIZE;
	private int position;

	public DropOutStackDobbelt(int size) {
		list = new LinkedList<>();
		SIZE = size;
		position = size - 1;
	}

	private void resetPositionIfNeeded() {
		if (position < 0) {
			position = SIZE - 1;
			full = true;
		}
	}

	public void pushFull(Object element) {
		if (!isAfterRemoved) {
			list.set(position, element);
			position--;
		} else if (isAfterRemoved) {
			list.add(position, element);
			position--;
			isAfterRemoved = false;
		}
	}

	@Override
	public void push(Object element) {
		resetPositionIfNeeded();
		if (full) {
			pushFull(element);
		} else {
			list.push(element);
			position--;
		}

	}

	@Override
	public Object pop() {
		Object popped;
		if (list.size() == 0) {
			throw new EmptyStackException();
		}
		if (!full) {
			popped = list.pop();
			position++;
		} else {
			popped = list.get(position + 1);
			list.remove(list.get(position + 1));
			isAfterRemoved = true;
		}
		return popped;
	}

	@Override
	public Object peek() {
		return list.get(position + 1);
	}

	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}

	@Override
	public int size() {
		return list.size();
	}

	@Override
	public String toString() {
		return list.toString();
	}

}
