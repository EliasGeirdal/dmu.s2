package dictionaryelev;

public class DictionaryLinked<K, V> implements Dictionary<K, V> {

	private Node start;
	private int size;

	/**
	 * Constructs a HashMap based on a linked list.
	 */
	public DictionaryLinked() {
		start = new Node();
		size = 0;
	}

	@Override
	public V get(K key) {
		if (isEmpty() || key.equals(null)) {
			return null;
		}
		Node current = start;
		V val = null;
		while (current.key != null) {
			if (current.key.equals(key)) {
				val = current.value;
				break;
			}
			current = current.next;
		}
		return val;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public V put(K key, V value) {
		if (key.equals(null) || value.equals(null)) {
			return null;
		}
		V val = get(key);
		if (val == null) {
			Node newNode = new Node(key, value);
			newNode.next = start;
			start = newNode;
			size++;
		} else {
			Node current = start;
			while (current.key != null) {
				if (current.key.equals(key)) {
					current.value = value;
					break;
				}
				current = current.next;
			}
		}
		return val;
	}

	@Override
	public V remove(K key) {
		if (isEmpty() || key.equals(null)) {
			return null;
		}
		V val = null;
		Node current = start.next;
		Node previous = start;
		// check prev
		while (current != null) {
			if (current.key.equals(key)) {
				val = current.value;
				previous.next = current.next;
				size--;
				break;
			}
			previous = current;
			current = current.next;
		}
		return val;
	}

	@Override
	public int size() {
		return size;
	}

	private class Node {
		Node next;
		K key;
		V value;

		Node(K k, V v) {
			key = k;
			value = v;
		}

		Node() {
		}
	}

}
