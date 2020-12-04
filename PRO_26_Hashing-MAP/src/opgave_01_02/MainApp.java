package opgave_01_02;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import javafx.scene.paint.Color;

public class MainApp {

	public static void main(String[] args) {
		HashSet<Bil> list = new HashSet<>();
		list.add(new Bil("regNr", "toyota", "modl", Color.AQUA));
		list.add(new Bil("regNr", "toyota", "modl", Color.AQUA));
		list.add(new Bil("regNr", "Skoda", "modl", Color.AQUA));

		System.out.println(list);

		Map<Bil, Integer> map = new HashMap<>();
		Bil b1 = new Bil("regNr", "toyota", "modl", Color.AQUA);
		Bil b2 = new Bil("regNr", "toyota", "modl", Color.AQUA);
//		Bil b1 = new Bil("regNr", "toyota", "modl", Color.AQUA);
		map.put(b1, 1);
		map.put(b1, 1);
		map.put(b2, 1);
		System.out.println(map.keySet());
		System.out.println(map.values());
	}

}
