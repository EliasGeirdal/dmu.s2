package repetition.opgave03;

import java.util.LinkedList;

import dictionaryelev.Dictionary;

public class LinkedListMap<K, V> implements Dictionary<K, V> {
	class Node {
		private K key;
		private V value;

		public Node(K key, V value) {
			this.key = key;
			this.value = value;
		}
	}

	private LinkedList<Node> list = new LinkedList<>();

	@Override
	public V get(K key) {
		if (key == null) {
			return null;
		}
		for (Node node : list) {
			if (node.key.equals(key)) {
				return node.value;
			}
		}
		return null;
	}

	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}

	@Override
	public V put(K key, V value) {
		if (key == null | value == null) {
			return null;
		}
		V oldVal = null;
		for (Node node : list) {
			if (node.key.equals(key)) {
				oldVal = node.value;
				node.value = value;
			}
		}
		if (oldVal == null) {
			list.add(new Node(key, value));
		}
		return oldVal;
	}

	@Override
	public V remove(K key) {
		if (key == null) {
			return null;
		}
		for (Node node : list) {
			if (node.key.equals(key)) {
				return list.remove(node) ? node.value : null;
			}
		}
		return null;
	}

	@Override
	public int size() {
		return list.size();
	}

	@Override
	public String toString() {
		return list.toString();
	}

}
