package opgave_05;

public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Saelger sælger = new Saelger("Hansen");
		Indkoeber indkøber = new Indkoeber("Jensen");
		BogTitel b1 = new BogTitel("Anders And", 6);
		BogTitel b2 = new BogTitel("Java", 8);
		Kunde k1 = new Kunde("Læsehest1");
		Kunde k2 = new Kunde("Læsehest2");
		Kunde k3 = new Kunde("Læsehest3");

		b1.addObserver(sælger);
		b1.addObserver(indkøber);
		b2.addObserver(indkøber);

		b2.etKoeb(k1);
		System.out.println(k1.getNavn() + " købt" + " " + b2.getTitel());
		b2.etKoeb(k2);
		System.out.println(k2.getNavn() + " købt" + " " + b2.getTitel());
		b2.etKoeb(k3);
		System.out.println(k3.getNavn() + " købt" + " " + b2.getTitel());
		b1.etKoeb(k1);
		System.out.println(k1.getNavn() + " købt" + " " + b1.getTitel());
		b1.etKoeb(k2);
		System.out.println(k2.getNavn() + " købt" + " " + b1.getTitel());
		b1.etKoeb(k3);
		System.out.println(k3.getNavn() + " købt" + " " + b1.getTitel());

	}

}
