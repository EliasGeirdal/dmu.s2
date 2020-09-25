package opgave_05;

public class Indkoeber implements Observer {
	private String navn;
//	private List<BogTitel> bogtitler = new LinkedList<>();

	public Indkoeber(String navn) {
		this.navn = navn;
	}

//	public void addBogTitel(BogTitel bt) {
//		if (!bogtitler.contains(bt)) {
//			bogtitler.add(bt);
//		}
//	}
//
//	public void removeBogTitel(BogTitel bt) {
//		if (bogtitler.contains(bt)) {
//			bogtitler.remove(bt);
//		}
//	}

	public String getNavn() {
		return navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	@Override
	public void update(Subject s) {
		// TODO Auto-generated method stub
		if (s instanceof BogTitel) {
			BogTitel bt = (BogTitel) s;
			if (bt.getAntal() < 6) {
				System.out.println("Der skal bestilles 10 bøger med titlen: " + bt.getTitel());
				bt.indkoebTilLager(10);
			}
		}
	}
}
