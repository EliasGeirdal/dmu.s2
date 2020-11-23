package opgave_01;

import java.util.Arrays;
import java.util.EmptyStackException;

public class ArrayStack implements Stack {
	Object[] array;
	private int currentSize = 0;
	private int SIZE;

	public ArrayStack(int size) {
		SIZE = size;
		array = new Object[size];
	}

	private void growIfNeeded() {
		if (currentSize == SIZE) {
			Object[] newArray = new Object[array.length * 2];
			for (int i = 0; i < array.length; i++) {
				newArray[i] = array[i];
			}
			array = newArray;
			SIZE *= 2;
		}
	}

	@Override
	public void push(Object element) {
		growIfNeeded();
		array[currentSize] = element;
		currentSize++;
	}

	@Override
	public Object pop() {
		if (currentSize < 1) {
			throw new EmptyStackException();
		}
		Object popped = array[currentSize - 1];
		array[currentSize - 1] = null;
		currentSize--;
		return popped;
	}

	@Override
	public Object peek() {
		Object peeked = array[currentSize];
		return peeked;
	}

	@Override
	public boolean isEmpty() {
		return array[currentSize] == null;
	}

	@Override
	public int size() {
		return currentSize;
	}

	@Override
	public String toString() {
		return Arrays.toString(array);
	}

}
