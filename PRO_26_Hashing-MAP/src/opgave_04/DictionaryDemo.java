package opgave_04;

public class DictionaryDemo {

	public static void main(String[] args) {
		// Dictionary map = new DictionaryHashMap<Integer,String>();
//		LinkedListMap<Integer, String> dictionary = new LinkedListMap<Integer, String>();
		ArrayMap<Integer, String> dictionary = new ArrayMap<Integer, String>();
		System.out.println(dictionary.isEmpty());
		System.out.println(dictionary.size());

		dictionary.put(8, "hans");
		dictionary.put(3, "viggo");
		System.out.println(dictionary.isEmpty());
		System.out.println(dictionary.size());

		System.out.println(dictionary.get(8));

		dictionary.put(7, "bent");
		dictionary.put(2, "lene");
		System.out.println(dictionary.isEmpty());
		System.out.println(dictionary.size());
		System.out.println(dictionary.remove(3));

		System.out.println(dictionary.size());

		System.out.println(dictionary.put(8, "Ida"));
		System.out.println(dictionary.get(8));

	}
}
