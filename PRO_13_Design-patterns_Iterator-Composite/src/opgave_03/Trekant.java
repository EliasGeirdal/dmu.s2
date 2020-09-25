package opgave_03;

public class Trekant extends Figur {
	private int højde, grundlinje;
	private double areal;

	public Trekant(String navn, int højde, int grundlinje) {
		setNavn(navn);
		this.setHøjde(højde);
		this.setGrundlinje(grundlinje);
		areal = 0.5 * højde * grundlinje;
	}

	@Override
	public double getAreal() {
		return areal;
	}

	public int getHøjde() {
		return højde;
	}

	public void setHøjde(int højde) {
		this.højde = højde;
	}

	public int getGrundlinje() {
		return grundlinje;
	}

	public void setGrundlinje(int grundlinje) {
		this.grundlinje = grundlinje;
	}

}
