package opgave_2_2;

import java.util.Set;
import java.util.TreeSet;

public class Skole {
	private String navn;
	private Set<Studerende> studerende = new TreeSet<>(new StuderendeComparator());

	public Skole(String navn) {
		this.navn = navn;
	}

	public Studerende findStuderende(int studieNr) {
		Studerende stud = null;
		for (Studerende element : this.studerende) {
			if (element.getStudieNr() == studieNr) {
				stud = element;
			}
		}
		return stud;
	}

	public double gennemsnit() {
		double result = 0;
		for (Studerende element : studerende) {
			result += element.gennemsnit();
		}
		return result / studerende.size();
	}

	public void removeStuderende(Studerende studerende) {
		this.studerende.remove(studerende);

	}

	public void addStuderende(Studerende studerende) {
		this.studerende.add(studerende);
	}

	public String getNavn() {
		return navn;
	}

	@Override
	public String toString() {
		return "Skole [navn=" + navn + ", studerende=" + studerende + "]";
	}
}
