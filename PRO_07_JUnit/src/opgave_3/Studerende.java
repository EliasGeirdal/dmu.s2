package opgave_3;

import java.util.ArrayList;
import java.util.List;

public class Studerende {
	private int studieNr;
	private String navn;
	private List<Integer> karakterer = new ArrayList<>();
	private Skole skole; // nullable

	public Studerende(int studieNr, String navn) {
		this.studieNr = studieNr;
		this.navn = navn;
	}

	public void addKarakter(int karakter) {
		this.karakterer.add(karakter);
	}

	public double gennemsnit() {
		double result = 0;
		if (karakterer.size() > 0) {
			for (Integer element : karakterer) {
				result += element;
			}
			result = result / karakterer.size();
		}
		return result;
	}

	public String getNavn() {
		return navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	public int getStudieNr() {
		return studieNr;
	}

	public List<Integer> getKarakterer() {
		return new ArrayList<>(karakterer);
	}

	@Override
	public String toString() {
		return "Studerende [studieNr=" + studieNr + ", navn=" + navn + "]";
	}

}
