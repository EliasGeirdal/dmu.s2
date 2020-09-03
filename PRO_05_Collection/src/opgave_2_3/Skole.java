package opgave_2_3;

import java.util.HashMap;
import java.util.Map;

public class Skole {
	private String navn;
	private Map<Integer, Studerende> studerende = new HashMap<>();

	public Skole(String navn) {
		this.navn = navn;
	}

	public Studerende findStuderende(int studieNr) {
		return studerende.get(studieNr);
	}

	public double gennemsnit() {
		double result = 0;
		for (Studerende element : studerende.values()) {
			result += element.gennemsnit();
		}
		return result / studerende.size();
	}

	public void removeStuderende(Studerende studerende) {
		this.studerende.remove(studerende.getStudieNr());
	}

	public void addStuderende(Studerende studerende) {
		this.studerende.put(studerende.getStudieNr(), studerende);
	}

	public String getNavn() {
		return navn;
	}

	@Override
	public String toString() {
		return "Skole [navn=" + navn + ", studerende=" + studerende + "]";
	}
}
