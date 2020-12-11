package opgave_01;

public class MainApp {
	public static void main(String[] args) {
		Common cm = new Common();

		Tjener elias = new Tjener("Elias", cm);
		Tjener villads = new Tjener("Villads", cm);
		Kok james = new Kok("James", cm);

		villads.start();
		elias.start();
		james.start();
	}
}
