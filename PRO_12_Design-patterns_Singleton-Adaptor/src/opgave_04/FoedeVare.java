package opgave_04;

public class FoedeVare extends Vare {

	public FoedeVare(int pris, String navn) {
		super(pris, navn);
	}

	@Override
	public double beregnMoms() {
		return (super.getPris() * 1.05) - super.getPris();
	}

}
