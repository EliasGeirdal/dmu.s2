package opgave_04;

import spiritusadapter.Spiritus;

public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ElVare ev = new ElVare(10, "Pære");
		FoedeVare fv = new FoedeVare(10, "Banan");
		Spiritus s = new Spiritus(100, "Vodka");
		AdaptorSpiritus spiritus = new AdaptorSpiritus(s);
		System.out.println(spiritus.getPris());
		spiritus.setPris(200);
		System.out.println(spiritus.getPris());
		System.out.println(spiritus.beregnMoms());

	}

}
