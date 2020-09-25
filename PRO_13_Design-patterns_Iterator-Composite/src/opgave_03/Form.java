package opgave_03;

import java.util.ArrayList;
import java.util.List;

public class Form extends Figur {
	private List<Figur> figurer = new ArrayList<>();

	public Form() {
	}

	@Override
	public void addFigur(Figur figur) {
		if (!figurer.contains(figur)) {
			figurer.add(figur);
		}
	}

	@Override
	public String tegn() {
		String tegn = "";
		for (Figur figur : figurer) {
			tegn += figur.tegn() + "\n";
		}
		return tegn;
	}

	@Override
	public double getAreal() {
		double sum = 0;
		for (Figur figur : figurer) {
			sum += figur.getAreal();
		}
		return sum;
	}

}
