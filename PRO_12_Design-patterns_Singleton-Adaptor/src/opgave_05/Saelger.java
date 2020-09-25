package opgave_05;

import java.util.HashSet;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;

public class Saelger implements Observer {
	private String navn;

	public Saelger(String navn) {
		this.navn = navn;
	}

	public String getNavn() {
		return navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		Set<BogTitel> bogtitler = new HashSet<BogTitel>();
		if (o instanceof BogTitel) {
			BogTitel bt = (BogTitel) o;
			for (Kunde kunder : bt.getKunder()) {
				for (BogTitel bogTitel : kunder.getBogTitler()) {
					bogtitler.add(bogTitel);
				}
			}
			bogtitler.remove(bt);
			for (BogTitel bogTitel : bogtitler) {
				System.out.println(bogTitel.getTitel());
			}
		}
	}

}
