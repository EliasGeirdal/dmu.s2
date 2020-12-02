package queueopgaver;

public class QueueDemo {
	public static void main(String[] args) {
		// Opgave 1.1

//		QueueI q = new ArrayQueue(10);
//		q.enqueue("Tom");
//		q.enqueue("Diana");
//		q.enqueue("Harry");
//		q.enqueue("Thomas");
//		q.enqueue("Bob");
//		q.enqueue("Brian");
//		System.out.println(q.getFront());
//		System.out.println(q.isEmpty() + " " + q.size());
//		while (!q.isEmpty()) {
//			System.out.println(q.dequeue());
//		}
//		System.out.println();
//		System.out.println(q.isEmpty() + " " + q.size());
//		System.out.println();
//		q.enqueue("Anna");
//		q.enqueue("Lotte");
//		System.out.println(q.isEmpty() + " " + q.size());
//		while (!q.isEmpty()) {
//			System.out.println(q.dequeue());
//		}
//		System.out.println();
//		System.out.println(q.isEmpty() + " " + q.size());

		// Opgave 1.2
//		QueueI lq = new LinkedQueue();
//		lq.enqueue("Henry");
//		lq.enqueue("Tom");
//		LinearNode element = (LinearNode) lq.getFront();
//		System.out.println(element.getElement());
//		LinearNode removed = (LinearNode) lq.dequeue();
//		System.out.println(removed.getElement());
//		LinearNode e = (LinearNode) lq.getFront();
//		System.out.println(e.getElement());
//		LinearNode r = (LinearNode) lq.dequeue();
//		System.out.println(r.getElement());
//
//		System.out.println(lq.isEmpty());
//		System.out.println(lq.size());

		// opgave 2
		DequeI dq = new Deque();
		dq.addFirst("Henry");
		DoubleNode n1 = (DoubleNode) dq.getFirst();
		System.out.println("addFirst: " + n1.getElement());
		dq.addLast("Tom");
		DoubleNode n2 = (DoubleNode) dq.getLast();
		System.out.println("AddLast: " + n2.getElement());
		dq.removeFirst();
		System.out.println("Removed " + n1.getElement());
		System.out.println(dq.size());
		DoubleNode n3 = (DoubleNode) dq.getFirst();
		System.out.println("getFirst " + n3.getElement());
		DoubleNode n4 = (DoubleNode) dq.getLast();
		System.out.println("getLast: " + n4.getElement());
		dq.addFirst("Harry");
		dq.removeLast();
		DoubleNode n5 = (DoubleNode) dq.getLast();
		System.out.println("getLast: " + n5.getElement());
		dq.removeLast();
		dq.removeFirst();

		// Opgave 3

	}
}
