package opgave_03;

public class Ellipse extends Figur {
	private int r1, r2;
	private double areal;

	public Ellipse(String navn, int r1, int r2) {
		setNavn(navn);
		this.r1 = r1;
		this.r2 = r2;
		areal = Math.PI * r1 * r2;
	}

	public int getR1() {
		return r1;
	}

	public void setR1(int r1) {
		this.r1 = r1;
	}

	public int getR2() {
		return r2;
	}

	public void setR2(int r2) {
		this.r2 = r2;
	}

	@Override
	public double getAreal() {
		return areal;
	}

}
