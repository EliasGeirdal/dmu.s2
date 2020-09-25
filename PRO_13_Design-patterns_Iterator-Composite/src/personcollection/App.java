package personcollection;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PersonCollection pc = new PersonCollection();
		Person p = new Person("åle");
		Person p2 = new Person("Ole");
		Person p3 = new Person("Mette");
		Person p4 = new Person("Pelle");
		pc.add(p);
		pc.add(p2);
		pc.add(p3);
		pc.add(p4);
		for (Person person : pc) {
			System.out.println(person.toString());
		}
	}

}
