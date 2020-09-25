package opgave_03;

public class AnvendPersonAdministrator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person p = new Person("Navn", 2);
		Person p1 = new Person("Navn", 3);
		Person p2 = new Person("Navn", 4);

		PersonAdministrator pAdmin = PersonAdministrator.getInstance();
		pAdmin.addPerson(p);
		pAdmin.addPerson(p2);
		System.out.println(pAdmin.getPersoner());
		pAdmin.removePerson(p2);
		System.out.println(pAdmin.getPersoner());
	}

}
