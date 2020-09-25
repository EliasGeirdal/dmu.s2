package opgave_05;

import java.util.ArrayList;
import java.util.List;

public class Kunde {
	private String navn;
	private List<BogTitel> bogtitler = new ArrayList<>();

	public Kunde(String navn) {
		this.navn = navn;
	}

	public void addBogTitel(BogTitel bt) {
		if (!bogtitler.contains(bt)) {
			bogtitler.add(bt);
		}
	}

	public void removeBogTitel(BogTitel bt) {
		if (bogtitler.contains(bt)) {
			bogtitler.remove(bt);
		}
	}

	public String getNavn() {
		return navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	public ArrayList<BogTitel> getBogTitler() {
		return new ArrayList<BogTitel>(bogtitler);
	}
}
