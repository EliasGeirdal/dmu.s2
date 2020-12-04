package personOpgave;

public class Person<T extends Comparable<T>> implements Comparable<Person<T>> {

	private Navn navn;

	public Person(Navn navn) {
		this.navn = navn;
	}

	public Person(String fornavn, String efternavn) {
		navn = new Navn(fornavn, efternavn);
	}

	public Navn getNavn() {
		return navn;
	}

	public void setNavn(Navn navn) {
		this.navn = navn;
	}

	@Override
	public int compareTo(Person<T> o) {
		return navn.compareTo(o.navn);

	}

	@Override
	public String toString() {
		return navn.getFornavn() + " " + navn.getEfternavn();
	}

}
