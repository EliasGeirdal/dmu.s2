package repetition.opgave01;

import java.util.ArrayList;
import java.util.HashSet;

public class test {
	public static void main(String[] args) {
		Bil bil = new Bil("regNr", "maerke", "model", "farve");
		Bil newBil = bil;

		Bil anotherNewBil = new Bil("regNr", "maerke", "model", "farve");

		System.out.println(bil.toString());
		System.out.println(newBil.equals(bil));
		System.out.println(anotherNewBil.equals(bil));

		HashSet<Bil> list = new HashSet<>();
		list.add(bil);
		list.add(newBil);
		list.add(anotherNewBil);
		System.out.println(list.toString());

		ArrayList<Bil> aList = createList(bil, newBil, anotherNewBil);
		System.out.println(aList.toString());

	}

	public static ArrayList<Bil> createList(Bil... values) {
		ArrayList<Bil> result = new ArrayList<>();
		for (Bil bil : values) {
			result.add(bil);
		}
		return result;
	}
}
