package opgave_03;

import java.util.Arrays;
import java.util.EmptyStackException;

import opgave_01.Stack;

public class DropOutStack implements Stack {
	private Object[] array;
	private int position = 0;
	private boolean full = false;

	public DropOutStack(int size) {
		array = new Object[size];
	}

	private void resetPositionIfNeeded() {
		if (position >= array.length) {
			position = 0;
			full = true;
		}
	}

	@Override
	public void push(Object element) {
		resetPositionIfNeeded();
		array[position] = element;
		position++;
	}

	@Override
	public Object pop() {
		if (array.length < 1) {
			throw new EmptyStackException();
		}
		Object popped = array[position - 1];
		array[position - 1] = null;
		return popped;
	}

	@Override
	public Object peek() {
		Object peeked = array[position - 1];
		return peeked;
	}

	@Override
	public boolean isEmpty() {
		return array[position] == null;
	}

	@Override
	public int size() {
		int size = 0;
		if (full) {
			size = array.length;
		} else
			size = position;
		return size;
	}

	@Override
	public String toString() {
		return Arrays.toString(array);
	}

}
