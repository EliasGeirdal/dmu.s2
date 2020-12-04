package opgave_05;

/**
 * This class implements a hash set using separate chaining.
 */
public class HashSetLinearProbing {
	private Object[] buckets;
	private int currentSize;
	private static final String DELETED = "DELETED";

	/**
	 * Constructs a hash table.
	 *
	 * @param bucketsLength the length of the buckets array
	 */
	public HashSetLinearProbing(int bucketsLength) {
		buckets = new Object[bucketsLength];
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
		Object current = buckets[h];
		boolean found = false;
		int i = 1;
		while (!found && current != null) {
			if (current.equals(x)) {
				found = true;
			} else {
				current = buckets[(h + i) % buckets.length];
				i++;
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
		Object current = buckets[h];
		boolean found = false;
		if (contains(x)) {
			found = true;
		}
		if (!found) {
			if (buckets[h] == null) {
				buckets[h] = x;
			} else {
				int i = 1;
				while (current != null && current != DELETED) {
					current = buckets[(h + i) % buckets.length];
					i++;
				}
				buckets[((h + i) % buckets.length) - 1] = x;
			}
			currentSize++;
		}
		if (loadFactor()) {
			reHash();
		}
		return !found;
	}

	public void reHash() {
//		Object[] newBuckets = new Object[buckets.length * 2];
//		for (int i = 0; i < currentSize; i++) {
//			if (buckets[i] != null) {
//				int h = 
//			}
//		}
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
		Object current = buckets[h];
		boolean found = false;
		if (!contains(x)) {
			return found;
		}
		int i = 1;
		while (!found && current != null) {
			if (current.equals(x)) {
				buckets[((h + i) % buckets.length) - 1] = DELETED;
				found = true;
			} else {
				current = buckets[(h + i) % buckets.length];
				i++;
			}
		}
		currentSize--;
		return found;
	}

	/**
	 * Gets the number of elements in this set.
	 *
	 * @return the number of elements
	 */
	public int size() {
		return currentSize;
	}

	private int hashValue(Object x) {
		int h = x.hashCode();
		if (h < 0) {
			h = -h;
		}
		h = h % buckets.length;
		return h;
	}

	// method only for test purpose
	public void writeOut() {
		for (int i = 0; i < buckets.length; i++) {
			System.out.println(i + "\t" + buckets[i]);
		}
	}

}
