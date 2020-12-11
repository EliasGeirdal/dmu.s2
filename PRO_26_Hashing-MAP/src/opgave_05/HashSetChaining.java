package opgave_05;

/**
 * This class implements a hash set using separate chaining.
 */
public class HashSetChaining {
	private Node[] buckets;
	private int currentSize;

	/**
	 * Constructs a hash table.
	 *
	 * @param bucketsLength the length of the buckets array
	 */
	public HashSetChaining(int bucketsLength) {
		buckets = new Node[bucketsLength];
		currentSize = 0;
	}

	/**
	 * Tests for set membership.
	 *
	 * @param x an object
	 * @return true if x is an element of this set
	 */
	public boolean contains(Object x) {
		int h = hashValue(x);
		Node current = buckets[h];
		boolean found = false;
		while (!found && current != null) {
			if (current.data.equals(x)) {
				found = true;
			} else {
				current = current.next;
			}
		}
		return found;
	}

	/**
	 * Adds an element to this set.
	 *
	 * @param x an object
	 * @return true if x is a new object, false if x was already in the set
	 */
	public boolean add(Object x) {
		int h = hashValue(x);

		Node current = buckets[h];
		boolean found = false;
		while (!found && current != null) {
			if (current.data.equals(x)) {
				found = true;
				// Already in the set
			} else {
				current = current.next;
			}

		}
		if (!found) {
			Node newNode = new Node();
			newNode.data = x;
			newNode.next = buckets[h];
			buckets[h] = newNode;
			currentSize++;
		}
		if (loadFactor()) {
			reHash();
		}
		return !found;
	}

	public void reHash() {
		Node[] newBuckets = new Node[buckets.length * 2];
		for (int i = 0; i < currentSize; i++) {
			if (buckets[i] != null) {
				Node current = buckets[i];
				while (current != null) {
					int h = current.data.hashCode();
					if (h < 0) {
						h = -h;
					}
					h = h % newBuckets.length;

					if (newBuckets[h] == null) {
						Node newNode = new Node();
						newNode.data = current.data;
						newBuckets[h] = newNode;
					} else {
						Node newNode = new Node();
						newNode.data = current.data;
						newNode.next = newBuckets[h];
						newBuckets[h] = newNode;
					}
					current = current.next;
				}
			}
		}
		buckets = newBuckets;
	}

	public boolean loadFactor() {
		boolean result = false;
		if ((currentSize + 0.0) / buckets.length > 0.75) {
			result = true;
		}
		return result;
	}

	/**
	 * Removes an object from this set.
	 *
	 * @param x an object
	 * @return true if x was removed from this set, false if x was not an element of
	 *         this set
	 */
	public boolean remove(Object x) {
		int h = hashValue(x);
		Node current = buckets[h];
		Node previous = buckets[h];
		boolean found = false;
		while (!found && current != null) {
			if (current.data.equals(x)) {
				found = true;
				if (previous == current && current.next != null) {
					buckets[h] = current.next;
				} else if (current.next == null) {
					Node newNode = null;
					current = newNode;
				} else {
					previous.next = current.next;
				}
				currentSize--;
			} else {
				previous = current;
				current = current.next;
			}
		}
		return found;
	}

	private int hashValue(Object x) {
		int h = x.hashCode();
		return h < 0 ? (-h) % buckets.length : h % buckets.length;
	}

	/**
	 * Gets the number of elements in this set.
	 *
	 * @return the number of elements
	 */
	public int size() {
		return currentSize;
	}

	// method only for test purpose
	void writeOut() {
		for (int i = 0; i < buckets.length; i++) {
			Node temp = buckets[i];
			if (temp != null) {
				System.out.print(i + "\t");
				while (temp != null) {
					System.out.print(temp.data + "\t");
					temp = temp.next;
				}
				System.out.println();
			}
		}
	}

	class Node {
		public Object data;
		public Node next;
	}

}
