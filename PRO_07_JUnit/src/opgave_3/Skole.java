package opgave_3;

import java.util.ArrayList;
import java.util.List;

public class Skole {
	private String navn;
	private List<Studerende> studerende = new ArrayList<>();

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
		if (studerende.size() == 0) {
			return studerende.get(0).gennemsnit();
		}
		double result = 0;
		for (Studerende element : studerende) {
			result += element.gennemsnit();
		}
		return result / studerende.size();
	}

	public void removeStuderende(Studerende studerende) {
		if (this.studerende.contains(studerende)) {
			this.studerende.remove(studerende);
		}
	}

	public void addStuderende(Studerende studerende) {
		if (!this.studerende.contains(studerende)) {
			this.studerende.add(studerende);
		}
	}

	public String getNavn() {
		return navn;
	}

	@Override
	public String toString() {
		return "Skole [navn=" + navn + ", studerende=" + studerende + "]";
	}
}
