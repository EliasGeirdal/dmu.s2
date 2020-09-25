package opgave_03;

public abstract class Figur {
	private String navn;

	public abstract double getAreal();

	public void addFigur(Figur figur) {
		throw new UnsupportedOperationException();
	}

	public String tegn() {
		return navn;
	}

	public String getNavn() {
		return navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

}
