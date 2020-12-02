package opgave4;

public class MainApp {
	public static void main(String[] args) {
		// Opgave 4.1
		StackQueue sq = new StackQueue(10);
		sq.enqueue("Lars");
		sq.enqueue("Ole");
		sq.enqueue("Mads");
		sq.enqueue("Peter");
		System.out.println(sq.toString());
		sq.dequeue();
		System.out.println(sq.toString());
		sq.dequeue();
		sq.dequeue();
		sq.dequeue();
		System.out.println(sq.toString());

		// Opgave 4.2
		QueueStack qs = new QueueStack(10);
		qs.push("A");
		qs.push("B");
		qs.push("C");
		qs.push("D");
		System.out.println(qs.toString());
		qs.pop();
		System.out.println(qs.toString());

	}
}
