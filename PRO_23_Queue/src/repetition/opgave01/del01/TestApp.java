package repetition.opgave01.del01;

import java.util.EmptyStackException;

public class TestApp {

	public static void main(String[] args) {
		SinglyLinkedListQueue<String> queue = new SinglyLinkedListQueue<String>();

		queue.enqueue("A");
		queue.enqueue("B");
		queue.enqueue("A");
		queue.enqueue("B");

		System.out.println("Expected: A, B, A, B. \nResult: " + queue.toString() + "\n");
		queue.dequeue();
		System.out.println("Expected after dequeue: B, A, B. \nResult: " + queue.toString() + "\n");

		while (!queue.isEmpty()) {
			queue.dequeue();
		}
		System.out.println("Expected: Empty. \nResult: " + queue.toString() + "\n");

		try {
			queue.getFront();
		} catch (EmptyStackException e) {
			System.out.println("Cannot getFront() on an empty stack. You fool.");
		}

	}

}
