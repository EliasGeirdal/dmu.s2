package opgave_01_02;

import javafx.scene.paint.Color;

public class Bil {
	private String regNr, maerke, model;
	private Color farve;

	public Bil(String regNr, String maerke, String model, Color farve) {
		this.regNr = regNr;
		this.maerke = maerke;
		this.model = model;
		this.farve = farve;
	}

	@Override
	public boolean equals(Object o) {
		boolean result = false;
		Bil bil = null;
		if (o instanceof Bil) {
			bil = (Bil) o;
		}
		if (regNr.equals(bil.getRegNr()) && maerke.equals(bil.getMaerke()) && model.equals(bil.getModel())
				&& farve.equals(bil.getFarve())) {
			result = true;
		}
		return result;
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = regNr.hashCode() + maerke.hashCode() + model.hashCode() + farve.hashCode();
		return hash;
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

	public Color getFarve() {
		return farve;
	}

	public void setFarve(Color farve) {
		this.farve = farve;
	}

	@Override
	public String toString() {
		return "Bil [regNr=" + regNr + ", maerke=" + maerke + ", model=" + model + ", farve=" + farve + "]";
	}

}
