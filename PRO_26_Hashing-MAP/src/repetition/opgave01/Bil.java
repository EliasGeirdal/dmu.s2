package repetition.opgave01;

import java.util.Objects;

public class Bil {
	private String regNr, maerke, model, farve;

	public Bil(String regNr, String maerke, String model, String farve) {
		this.regNr = regNr;
		this.maerke = maerke;
		this.model = model;
		this.farve = farve;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Bil) {
			Bil b = null;
			b = (Bil) obj;
			return regNr.equals(b.regNr) && maerke.equals(b.maerke) && model.equals(b.model) && farve.equals(b.farve);
		}
		return false;
	}

	@Override
	public int hashCode() {
		return Objects.hash(regNr, maerke, model, farve);
	}

	public String getRegNr() {
		return regNr;
	}

	public void setRegNr(String regNr) {
		this.regNr = regNr;
	}

	public String getMaerke() {
		return maerke;
	}

	public void setMaerke(String maerke) {
		this.maerke = maerke;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getFarve() {
		return farve;
	}

	public void setFarve(String farve) {
		this.farve = farve;
	}
}
