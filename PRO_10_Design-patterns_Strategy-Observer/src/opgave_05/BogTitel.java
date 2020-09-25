package opgave_05;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BogTitel implements Subject {
	private String titel;
	private int antal;
	private List<Kunde> kunder = new ArrayList<>();
	private List<Observer> observers = new LinkedList<>();

	public BogTitel(String titel, int antal) {
		this.titel = titel;
		this.antal = antal;
	}

	public void fire(Subject s) {
		for (Observer observer : observers) {
			observer.update(s);
		}
	}

	public void indkoebTilLager(int antal) {
		// TODO
		this.antal += antal;
	}

	public void etKoeb(Kunde k) {
		antal--;
		k.addBogTitel(this);
		addKunde(k);
		fire(this);
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

	@Override
	public void addObserver(Observer o) {
		// TODO Auto-generated method stub
		if (!observers.contains(o)) {
			observers.add(o);
		}
	}

	@Override
	public void removeObserver(Observer o) {
		// TODO Auto-generated method stub
		if (observers.contains(o)) {
			observers.remove(o);
		}
	}

}
