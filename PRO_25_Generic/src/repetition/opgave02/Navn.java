package repetition.opgave02;

public class Navn implements Comparable<Navn> {
	private String fornavn;
	private String efternavn;

	public Navn(String fornavn, String efternavn) {
		this.fornavn = fornavn;
		this.efternavn = efternavn;
	}

	public String getFornavn() {
		return fornavn;
	}

	public void setFornavn(String fornavn) {
		this.fornavn = fornavn;
	}

	public String getEfternavn() {
		return efternavn;
	}

	public void setEfternavn(String efternavn) {
		this.efternavn = efternavn;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return fornavn + " " + efternavn;
	}

	@Override
	public int compareTo(Navn o) {
		if (fornavn.compareTo(o.fornavn) == 0) {
			return efternavn.compareTo(o.efternavn);
		} else {
			return fornavn.compareTo(o.fornavn);
		}
	}
}
