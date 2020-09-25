package opgave_04;

public class ElVare extends Vare {

	public ElVare(int pris, String navn) {
		super(pris, navn);
	}

	@Override
	public double beregnMoms() {
		double moms = 3;
		if (super.getPris() > 3) {
			moms = (super.getPris() * 1.30) - super.getPris();
		}
		return moms;
	}

}
