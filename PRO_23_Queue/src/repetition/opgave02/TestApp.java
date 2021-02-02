package repetition.opgave02;

public class TestApp {

	public static void main(String[] args) {
		Deque<String> deq = new Deque<>();

		// Add methods.
		deq.addFirst("A");
		System.out.println("Expected: A \nResult: " + deq.toString() + "\n");

		deq.addFirst("B");
		System.out.println("Expected: B, A \nResult: " + deq.toString() + "\n");

		deq.addLast("C");
		System.out.println("Expected: B, A, C \nResult: " + deq.toString() + "\n");

		// get methods.
		System.out.println("Expected: B, \nResult: " + deq.getFirst() + "\n");
		System.out.println("Expected: C, \nResult: " + deq.getLast() + "\n");

		// size
		System.out.println("Expected: 3 \nResult: " + deq.size() + "\n");

		// Remove methods
		deq.removeFirst();
		System.out.println("Expected: A, C \nResult: " + deq.toString() + "\n");

		deq.removeLast();
		System.out.println("Expected: A \nResult: " + deq.toString() + "\n");

		deq.removeFirst();
		System.out.println("Expected: empty \nResult: " + deq.toString() + "\n");
	}

}
