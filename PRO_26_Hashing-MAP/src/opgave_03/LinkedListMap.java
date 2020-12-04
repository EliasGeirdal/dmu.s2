package opgave_03;

import java.util.LinkedList;

import dictionaryelev.Dictionary;

public class LinkedListMap<K, V> implements Dictionary<K, V> {
	private LinkedList<Node> list = new LinkedList<>();

	@Override
	public V get(K key) {
		if (list.isEmpty()) {
			return null;
		}
		Node current = list.getFirst();
		V value = null;
		for (Node node : list) {
			if (node.key.equals(key)) {
				value = current.value;
				break;
			}
		}
		return value;
	}

	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}

	@Override
	public V put(K key, V value) {
		if (key.equals(null) || value.equals(null)) {
			return null;
		}
		Node newNode = new Node(key, value);
		if (isEmpty()) {
			list.add(newNode);
			return null;
		}
		V val = null;
		for (Node node : list) {
			if (node.key.equals(key)) {
				val = node.value;
				node.value = value;
			}
		}
		if (val == null) {
			list.add(newNode);
		}
		return val;
	}

	@Override
	public V remove(K key) {
		if (isEmpty() || key.equals(null)) {
			return null;
		}
		V val = null;
		for (Node node : list) {
			if (node.key.equals(key)) {
				val = node.value;
				list.remove(node);
				break;
			}
		}
		return val;
	}

	@Override
	public int size() {
		return list.size();
	}

	class Node {
		K key;
		V value;

		Node(K key, V value) {
			this.key = key;
			this.value = value;
		}
	}

}
