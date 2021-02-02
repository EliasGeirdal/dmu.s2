package repetition.opgave02;

public class TestApp {

	public static void main(String[] args) {
		Person<?> personString = new Person<>("Ole B");
		System.out.println(personString);

		Person<Navn> personNavn = new Person<>(new Navn("Anton", "B"));
		Person<Navn> personNavnOther = new Person<>(new Navn("Bent", "B"));
		System.out.println(personNavn);

		System.out.println(personNavn.compareTo(personNavnOther));

	}

}
