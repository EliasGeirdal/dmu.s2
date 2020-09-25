package opgave_04;

import java.util.Comparator;

public class Kunde implements Comparable<Kunde> {
	private String navn;
	private int nummer;
	private static Comparator<Kunde> comparator;

	public Kunde(String navn, int nummer) {
		this.navn = navn;
		this.nummer = nummer;
	}

	public void setComparator(Comparator<Kunde> o) {
		comparator = o;
	}

	public String getNavn() {
		return navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	public int getNummer() {
		return nummer;
	}

	public void setNummer(int nummer) {
		this.nummer = nummer;
	}

	@Override
	public String toString() {
		return "Kunde [navn=" + navn + ", nummer=" + nummer + "]";
	}

	@Override
	public int compareTo(Kunde o) {
		return comparator.compare(this, o);
	}
}
