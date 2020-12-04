package opgave_04;

import java.util.ArrayList;

import dictionaryelev.Dictionary;

public class ArrayMap<K, V> implements Dictionary<K, V> {
	@SuppressWarnings("unchecked")
	private ArrayList<Node>[] bucket;
	private int currentSize;

	@SuppressWarnings("unchecked")
	public ArrayMap() {
		final int DEFAULT_SIZE = 10;
		bucket = new ArrayList[DEFAULT_SIZE];
		fillBucket();
		currentSize = 0;
	}

	public void fillBucket() {
		for (int i = 0; i < bucket.length; i++) {
			if (bucket[i] == null) {
				bucket[i] = new ArrayList<Node>();
			}
		}
	}

	@Override
	public V get(K key) {
		if (isEmpty() || key.equals(null))
			return null;
		int h = hashValue(key);
		V val = null;
		for (ArrayMap<K, V>.Node element : bucket[h]) {
			if (element.key.equals(key)) {
				val = element.value;
			}
		}
		return val;
	}

	@Override
	public boolean isEmpty() {
		return currentSize == 0;
	}

	@Override
	public V put(K key, V value) {
		if (key.equals(null) || value.equals(null)) {
			return null;
		}
		int h = hashValue(key);
		V val = null;
		for (Node element : bucket[h]) {
			if (element.key.equals(key)) {
				val = element.value;
				element.value = value;
				break;
			}
		}
		if (val == null) {
			bucket[h].add(new Node(key, value));
		}
		currentSize++;
		return val;
	}

	@Override
	public V remove(K key) {
		if (isEmpty() || key.equals(null)) {
			return null;
		}
		int h = hashValue(key);
		V val = null;
		for (Node element : bucket[h]) {
			if (element.key.equals(key)) {
				val = element.value;
				bucket[h].remove(element);
				currentSize--;
				break;
			}
		}
		return val;
	}

	@Override
	public int size() {
		return currentSize;
	}

	private int hashValue(Object x) {
		int h = x.hashCode();
		if (h < 0) {
			h = -h;
		}
		h = h % bucket.length;
		return h;
	}

	@SuppressWarnings("hiding")
	class Node {
		int hash;
		K key;
		V value;

		Node(K k, V v) {
			hash = k.hashCode();
			key = k;
			value = v;
		}
	}

}
