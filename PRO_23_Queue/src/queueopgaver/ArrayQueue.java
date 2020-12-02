package queueopgaver;

import java.util.NoSuchElementException;

/**
 * An implementation of a queue as a array.
 */
public class ArrayQueue implements QueueI {
	private Object[] array;
	private int currentSize;

	/**
	 * Constructs an empty queue.
	 */
	public ArrayQueue(int size) {
		array = new Object[size];
		currentSize = 0;
	}

	/**
	 * Checks whether this queue is empty.
	 *
	 * @return true if this queue is empty
	 */
	@Override
	public boolean isEmpty() {
		return currentSize == 0;
	}

	/**
	 * Grows the array if needed.
	 */
	private void growIfNeeeded() {
		if (currentSize >= array.length) {
			Object[] newArray = new Object[array.length * 2];
			for (int i = 0; i < array.length; i++) {
				newArray[i] = array[i];
			}
			array = newArray;
		}
	}

	/**
	 * Adds an element to the tail of this queue.
	 *
	 * @param newElement the element to add
	 */
	@Override
	public void enqueue(Object newElement) {
		growIfNeeeded();
		array[currentSize] = newElement;
		currentSize++;
	}

	/**
	 * Removes an element from the head of this queue.
	 *
	 * @return the removed element
	 */
	@Override
	public Object dequeue() {
		if (isEmpty()) {
			throw new NoSuchElementException("Array is empty at index: 0");
		}
		Object removed = array[0];
		for (int i = 0; i < currentSize; i++) {
			array[i] = array[i + 1];
		}
		currentSize--;
		return removed;
	}

	/**
	 * Returns the head of this queue. The queue is unchanged.
	 *
	 * @return the head element
	 */
	@Override
	public Object getFront() {
		if (currentSize == 0) {
			throw new NoSuchElementException("Array is empty");
		}
		return array[0];
	}

	/**
	 * The number of elements on the queue.
	 *
	 * @return the number of elements in the queue
	 */
	@Override
	public int size() {
		return currentSize;
	}
}
