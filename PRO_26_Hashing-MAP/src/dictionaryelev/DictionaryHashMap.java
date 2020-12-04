package dictionaryelev;

import java.util.HashMap;
import java.util.Map;

public class DictionaryHashMap<K, V> implements Dictionary<K, V> {

	private Map<K, V>[] tabel;
	private static int N = 10;
	private int size = 0;

	/**
	 * Constructs a HashMap based on a HashMap.
	 */
	public DictionaryHashMap() {
		tabel = new HashMap[N];
		for (int i = 0; i < N; i++) {
			tabel[i] = new HashMap<K, V>();
		}
	}

	@Override
	public V get(K key) {
		int i = key.hashCode() % N;
		Map<K, V> m = tabel[i];
		return m.get(key);
	}

	@Override
	public boolean isEmpty() {
		boolean empty = true;
		int i = 0;
		while (empty && i < N) {
			empty = (tabel[i]).isEmpty();
			i++;
		}
		return empty;
	}

	@Override
	public V put(K key, V value) {
		int i = key.hashCode() % N;
		Map<K, V> m = tabel[i];
		V val = m.put(key, value);
		size++;
		return val;
	}

	@Override
	public V remove(K key) {
		int i = key.hashCode() % N;
		Map<K, V> m = tabel[i];
		V val = m.remove(key);
		size--;
		return val;
	}

	@Override
	public int size() {
		return size;
	}

}
