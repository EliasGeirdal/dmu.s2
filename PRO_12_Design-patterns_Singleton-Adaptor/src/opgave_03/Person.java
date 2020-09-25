package opgave_03;

public class Person {
	private String navn;
	private int nummer;

	public Person(String navn, int nummer) {
		this.navn = navn;
		this.nummer = nummer;
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
		return "Person [navn=" + navn + ", nummer=" + nummer + "]";
	}

}
