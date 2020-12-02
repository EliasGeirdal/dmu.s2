package linkedDropOutStack;

import java.util.EmptyStackException;

public class LinkedStack<T> implements Stack<T> {
	protected int count; // indicates the next open slot
	protected LinearNode<T> top;

	/*******************************************************************
	 * Creates an empty stack.
	 *******************************************************************/
	public LinkedStack() {
		count = 0;
		top = null;
	}

	/*******************************************************************
	 * Adds the specified element to the top of this stack.
	 *******************************************************************/
	@Override
	public void push(T element) {
		LinearNode<T> temp = new LinearNode<>(element);

		temp.setNext(top);
		top = temp;
		count++;
	}

	/*******************************************************************
	 * Removes the element at the top of this stack and returns a reference to it.
	 * Throws an EmptyStackException if the stack is empty.
	 *******************************************************************/
	@Override
	public T pop() throws EmptyStackException {
		if (isEmpty()) {
			throw new EmptyStackException();
		}

		T result = top.getElement();
		top = top.getNext();
		count--;

		return result;
	}

	/*******************************************************************
	 * Returns a reference to the element at the top of this stack. The element is
	 * not removed from the stack. Throws an EmptyStackException if the stack is
	 * empty.
	 *******************************************************************/
	@Override
	public T peek() throws EmptyStackException {
		if (isEmpty()) {
			throw new EmptyStackException();
		}

		return top.getElement();
	}

	/*******************************************************************
	 * Returns true if this stack is empty and false otherwise.
	 *******************************************************************/
	@Override
	public boolean isEmpty() {
		return (count == 0);
	}

	/*******************************************************************
	 * Returns the number of elements in the stack.
	 *******************************************************************/
	@Override
	public int size() {
		return count;
	}

	/*******************************************************************
	 * Returns a string representation of this stack.
	 *******************************************************************/
	@Override
	public String toString() {
		String result = "";
		LinearNode<T> current = top;

		while (current != null) {
			result = result + (current.getElement()).toString() + "\n";
			current = current.getNext();
		}

		return result;
	}
}