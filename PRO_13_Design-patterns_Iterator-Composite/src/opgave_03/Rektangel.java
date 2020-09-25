package opgave_03;

public class Rektangel extends Figur {
	private int l, b;
	private double areal;

	public Rektangel(String navn, int l, int b) {
		setNavn(navn);
		this.l = l;
		this.b = b;
		areal = l * b;
	}

	public int getL() {
		return l;
	}

	public void setL(int l) {
		this.l = l;
	}

	public int getB() {
		return b;
	}

	public void setB(int b) {
		this.b = b;
	}

	@Override
	public double getAreal() {
		return areal;
	}

}
