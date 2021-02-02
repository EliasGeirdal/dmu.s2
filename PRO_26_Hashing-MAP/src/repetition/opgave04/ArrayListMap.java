package repetition.opgave04;

import java.util.ArrayList;

import dictionaryelev.Dictionary;

public class ArrayListMap<K, V> implements Dictionary<K, V> {
	private static final int INITIAL_SIZE = 10;

	class Node {
		private int hash;
		private K key;
		private V value;

		public Node(K key, V val) {
			this.key = key;
			this.value = val;
			hash = hashCode();
		}

	}

	// -------------------------------------------------------------------------------------
	private ArrayList<Node>[] list = null;
	private int size;

	public ArrayListMap() {
		list = new ArrayList[INITIAL_SIZE];
		initArray();
		size = 0;
	}

	private void initArray() {
		for (int i = 0; i < list.length; i++) {
			list[i] = new ArrayList<>();
		}
	}

	@Override
	public V get(K key) {
		if (key == null) {
			return null;
		}
		int index = hashValue(key);
		for (Node node : list[index]) {
			if (node.key.equals(key)) {
				return node.value;
			}
		}
		return null;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public V put(K key, V value) {
		if (key == null | value == null) {
			return null;
		}
		int index = hashValue(key);
		V oldVal = null;
		for (Node element : list[index]) {
			if (element.key.equals(key)) {
				oldVal = element.value;
				element.value = value;
			}
		}
		if (oldVal == null) {
			list[index].add(new Node(key, value));
			size++;
		}
		return oldVal;
	}

	@Override
	public V remove(K key) {
		if (key == null) {
			return null;
		}
		int index = hashValue(key);
		for (Node element : list[index]) {
			if (element.key.equals(key)) {
				size--;
				return list[index].remove(element) ? element.value : null;
			}
		}
		return null;
	}

	@Override
	public int size() {
		return size;
	}

	private int hashValue(K key) {
		int h = key.hashCode();
		return h < 0 ? (-h) % INITIAL_SIZE : h % INITIAL_SIZE;
	}
}
