package repetition.opgave02;

public class Person<T extends Comparable<T>> implements Comparable<Person<T>> {
	private T navn;

	public Person(T navn) {
		this.navn = navn;
	}

	public T getNavn() {
		return navn;
	}

	public void setNavn(T navn) {
		this.navn = navn;
	}

	@Override
	public String toString() {
		return navn.toString();
	}

	@Override
	public int compareTo(Person<T> o) {
		return navn.compareTo(o.getNavn());
	}

}
