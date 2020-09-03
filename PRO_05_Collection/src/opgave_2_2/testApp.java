package opgave_2_2;

import java.util.ArrayList;
import java.util.List;

public class testApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Skole s1 = new Skole("Super skole");

		List<Integer> k = new ArrayList<>();
		k.add(4);
		k.add(7);
		k.add(10);
		k.add(2);

		Studerende stud1 = new Studerende(1, "Studyman", k);
		Studerende stud2 = new Studerende(2, "FE male", k);
		Studerende stud3 = new Studerende(3, "Iron man", k);
		s1.addStuderende(stud1);
		s1.addStuderende(stud2);
		s1.addStuderende(stud3);

		System.out.println(s1.toString());
		System.out.println(s1.gennemsnit());
		System.out.println(s1.toString());
	}

}
