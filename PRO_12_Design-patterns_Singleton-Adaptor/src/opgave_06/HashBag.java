package opgave_06;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashBag implements Bag, Iterable<String>, Subject {
	private Map<String, Integer> indhold = new HashMap<>();
	private Set<Observer> observers = new HashSet<>();

	@Override
	public void add(String s) {
		if (indhold.containsKey(s)) {
			indhold.put(s, indhold.get(s) + 1);
		} else {
			indhold.put(s, 1);
		}

	}

	@Override
	public void remove(String s) {
		// TODO Auto-generated method stub
		if (indhold.containsKey(s)) {
			if (indhold.get(s) > 1)
				indhold.put(s, indhold.get(s) - 1);
			else
				indhold.remove(s);
		}
	}

	@Override
	public int getCount(String s) {
		if (indhold.containsKey(s)) {
			return indhold.get(s);
		} else
			return 0;
	}

	@Override
	public Iterator<String> iterator() {
		return indhold.keySet().iterator();
	}

	public void fire() {
		for (Observer observer : observers) {
		}
	}

	@Override
	public void registerObserver(Observer o) {
		if (!observers.contains(o)) {
			observers.add(o);
		}
	}

	@Override
	public void removeObserver(Observer o) {
		if (observers.contains(o)) {
			observers.remove(o);
		}
	}

}
