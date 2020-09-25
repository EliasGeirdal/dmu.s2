package opgave_05;

import java.util.Observable;
import java.util.Observer;

public class Indkoeber implements Observer {
	private String navn;

	public Indkoeber(String navn) {
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
		if (o instanceof BogTitel) {
			BogTitel bt = (BogTitel) o;
			if (bt.getAntal() < 6) {
				System.out.println("Der skal bestilles 10 bøger med titlen: " + bt.getTitel());
				bt.indkoebTilLager(10);
			}
		}
	}
}
