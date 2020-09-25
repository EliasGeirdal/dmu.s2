package opgave_04;

import spiritusadapter.Spiritus;

public class AdaptorSpiritus extends Vare {
	private Spiritus spiritus;

	public AdaptorSpiritus(Spiritus spiritus) {
		super(spiritus.getPrisen(), spiritus.getBetgenelse());
		this.spiritus = spiritus;
	}

	@Override
	public String getNavn() {
		return spiritus.getBetgenelse();
	}

	@Override
	public void setNavn(String s) {
		spiritus.setBetgenelse(s);
	}

	@Override
	public int getPris() {
		return spiritus.getPrisen();
	}

	@Override
	public void setPris(int pris) {
		spiritus.setPrisen(pris);
	}

	@Override
	public double beregnMoms() {
		// TODO Auto-generated method stub
		return spiritus.hentMoms();
	}

}
