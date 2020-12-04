package personOpgave;

public class Navn implements Comparable<Navn> {
	private String fornavn, efternavn;

	public Navn(String f, String e) {
		fornavn = f;
		efternavn = e;
	}

	@Override
	public int compareTo(Navn o) {
		if (fornavn.compareTo(o.fornavn) == 0) {
			return efternavn.compareTo(o.efternavn);
		}
		return fornavn.compareTo(o.fornavn);
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

}
