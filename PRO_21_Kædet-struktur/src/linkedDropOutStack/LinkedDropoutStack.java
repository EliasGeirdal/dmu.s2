package linkedDropOutStack;

public class LinkedDropoutStack<T> extends LinkedStack<T> {
	// default dropout, used if none is specified.
	public final int DEFAULT = 5;

	// how many Objects to keep
	int dropout;

	// ----------------------------------------------------------------
	// Constructors
	// ----------------------------------------------------------------
	public LinkedDropoutStack() {
		super();
		dropout = DEFAULT;
	}

	public LinkedDropoutStack(int i) {
		super();
		if (i > 0) {
			dropout = i;
		} else {
			dropout = DEFAULT;
		}
	}

	// ----------------------------------------------------------------
	// getDropout-method to return the dropout
	// ----------------------------------------------------------------
	public int getDropout() {
		return dropout;
	}

	// ----------------------------------------------------------------
	// Tests to ensure that the stack is not more, than the dropout,
	// then adds the element
	// ----------------------------------------------------------------
	@Override
	public void push(T element) {
		if (size() >= dropout) {
			removeEnd();
		}
		super.push(element);
	}

	// ----------------------------------------------------------------
	// private method to remove and drop the last element off of the stack
	// ----------------------------------------------------------------
	private void removeEnd() {
		LinearNode<T> previous = top, current = top;
		while (current.getNext() != null) {
			previous = current;
			current = current.getNext();
		}

		previous.setNext(null);
		count--;
	}

	public static void main(String args[]) {

		LinkedDropoutStack<String> test = new LinkedDropoutStack<>(5);
		test.push("Test1");
		test.push("Test2");
		test.push("Test3");
		test.push("Test4");
		test.push("Test5");

		System.out.println(test);

		test.push("Test6");
		test.push("Test7");

		System.out.println(test);

		// System.out.println(test.peek());

		System.out.println();

		while (!test.isEmpty()) {
			System.out.println(test.pop());
		}

	}

}
