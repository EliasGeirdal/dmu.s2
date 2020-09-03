package opgave_2_2;

import java.util.Comparator;

public class StuderendeComparator implements Comparator<Studerende> {

	@Override
	public int compare(Studerende o1, Studerende o2) {
		// TODO Auto-generated method stub
		return o1.getNavn().compareTo(o2.getNavn());
	}
}
