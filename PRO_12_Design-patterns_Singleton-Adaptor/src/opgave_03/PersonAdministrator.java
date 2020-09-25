package opgave_03;

import java.util.LinkedList;
import java.util.List;

public class PersonAdministrator {
	private static PersonAdministrator personAdministratorUnique;
	private List<Person> personer = new LinkedList<Person>();

	private PersonAdministrator() {
	}

	public void addPerson(Person p) {
		if (!personer.contains(p)) {
			personer.add(p);
		}
	}

	public void removePerson(Person p) {
		if (personer.contains(p)) {
			personer.remove(p);
		}
	}

	public List<Person> getPersoner() {
		return new LinkedList<>(personer);
	}

	public static PersonAdministrator getInstance() {
		if (personAdministratorUnique == null) {
			personAdministratorUnique = new PersonAdministrator();
		}
		return personAdministratorUnique;
	}

}
