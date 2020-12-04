package setoperationsopgave;

import java.util.HashSet;
import java.util.Set;

public class SetOperations {

	public static <T> Set<T> union(Set<T> s1, Set<T> s2) {
		Set<T> newSet = new HashSet<T>();
		newSet.addAll(s1);
		newSet.addAll(s2);
		return newSet;
	}

	public static <T> Set<T> differens(Set<T> s1, Set<T> s2) {
		Set<T> newSet = new HashSet<T>();
		for (T element : s1) {
			if (!s2.contains(element)) {
				newSet.add(element);
			}
		}

		for (T element : s2) {
			if (!s1.contains(element)) {
				newSet.add(element);
			}
		}

		return newSet;

	}

	public static <T> Set<T> intesection(Set<T> s1, Set<T> s2) {
		Set<T> newSet = new HashSet<T>();
		for (T element : s1) {
			if (s2.contains(element)) {
				newSet.add(element);
			}
		}
		return newSet;

	}

}
