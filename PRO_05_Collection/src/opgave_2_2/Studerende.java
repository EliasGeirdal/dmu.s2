package opgave_2_2;

import java.util.ArrayList;
import java.util.List;

public class Studerende implements Comparable<Studerende> {
	private int studieNr;
	private String navn;
	private List<Integer> karakterer = new ArrayList<>();
	private Skole skole; // nullable

	public Studerende(int studieNr, String navn, List<Integer> karakterer) {
		this.studieNr = studieNr;
		this.navn = navn;
		this.karakterer = karakterer;
	}

	public void addKarakter(int karakter) {
		this.karakterer.add(karakter);
	}

	public double gennemsnit() {
		double result = 0;
		for (Integer element : karakterer) {
			result += element;
		}
		return result / karakterer.size();
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

	@Override
	public int compareTo(Studerende o) {
		// TODO Auto-generated method stub
		return studieNr - o.getStudieNr();
	}

}
