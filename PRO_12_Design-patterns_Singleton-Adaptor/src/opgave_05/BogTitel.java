package opgave_05;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class BogTitel extends Observable {
	private String titel;
	private int antal;
	private List<Kunde> kunder = new ArrayList<>();

	public BogTitel(String titel, int antal) {
		this.titel = titel;
		this.antal = antal;
	}

	public void indkoebTilLager(int antal) {
		this.antal += antal;
	}

	public void etKoeb(Kunde k) {
		antal--;
		k.addBogTitel(this);
		setChanged();
		notifyObservers();

	}

	public void addKunde(Kunde k) {
		if (!kunder.contains(k)) {
			kunder.add(k);
		}
	}

	public void removeKunde(Kunde k) {
		if (kunder.contains(k)) {
			kunder.remove(k);
		}
	}

	public ArrayList<Kunde> getKunder() {
		return new ArrayList<Kunde>(kunder);
	}

	public String getTitel() {
		return titel;
	}

	public void setTitel(String titel) {
		this.titel = titel;
	}

	public int getAntal() {
		return antal;
	}

	public void setAntal(int antal) {
		this.antal = antal;
	}

}
