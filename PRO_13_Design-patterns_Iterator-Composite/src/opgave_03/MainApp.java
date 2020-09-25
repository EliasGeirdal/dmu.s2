package opgave_03;

public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Figur form = new Form();

		Figur ellipse = new Ellipse("Hoved", 5, 8);

		Figur trekant = new Trekant("Hat", 2, 3);
		Figur rektangel = new Rektangel("Mund", 2, 2);
		form.addFigur(trekant);
		form.addFigur(rektangel);
		System.out.println(form.getAreal());
		System.out.println(trekant.getAreal());
		System.out.println(form.tegn());
	}

}
