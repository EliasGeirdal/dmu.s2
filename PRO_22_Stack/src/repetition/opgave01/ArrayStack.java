package repetition.opgave01;

import java.util.Arrays;
import java.util.EmptyStackException;

public class ArrayStack<T> implements Stack<T> {

	private T[] elements;
	private final int INITIAL_SIZE, DEFAULTCAPACITY = 10;
	private static final double LOADFACTOR = 0.75, SHRINKFACTOR = 0.25;
	private int currentSize;

	public ArrayStack(int size) {
		INITIAL_SIZE = size;
		currentSize = 0;
		elements = (T[]) new Object[INITIAL_SIZE];
	}

	public ArrayStack() {
		currentSize = 0;
		INITIAL_SIZE = DEFAULTCAPACITY;
		elements = (T[]) new Object[DEFAULTCAPACITY];
	}

	public void growIfNecessary() {
		if (((double) currentSize / (double) elements.length) >= LOADFACTOR) {
			elements = Arrays.copyOf(elements, elements.length * 2);
		}
	}

	public void shrinkIfNecessary() {
		if ((double) currentSize / (double) elements.length <= SHRINKFACTOR) {
			elements = Arrays.copyOf(elements, elements.length / 2);
		}
	}

	@Override
	public void push(T element) {
		growIfNecessary();
		elements[currentSize] = element;
		currentSize++;
	}

	@Override
	public T pop() {
		shrinkIfNecessary();
		if (isEmpty()) {
			throw new EmptyStackException();
		}
		T popped = elements[currentSize - 1];
		elements[currentSize - 1] = null;
		currentSize--;
		return popped;
	}

	@Override
	public T peek() {
		if (isEmpty()) {
			throw new EmptyStackException();
		}
		return elements[currentSize - 1];
	}

	@Override
	public boolean isEmpty() {
		return currentSize == 0;
	}

	@Override
	public int size() {
		return currentSize;
	}

	@Override
	public String toString() {
		return Arrays.toString(elements);
	}
}
