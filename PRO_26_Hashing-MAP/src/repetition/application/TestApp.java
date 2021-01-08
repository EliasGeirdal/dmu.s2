package repetition.application;

import repetition.opgave04.ArrayListMap;

public class TestApp {
	public static void main(String[] args) {
//		LinkedListMap<String, Integer> list = new LinkedListMap<String, Integer>();
		ArrayListMap<String, Integer> list = new ArrayListMap<String, Integer>();

		System.out.println("Expected after first put null: " + list.put("A", 1));
		list.put("B", 1);
		System.out.println("Expected 1: " + list.get("A"));
		System.out.println("Expected 1: " + list.get("B"));
		System.out.println("Expected old value after put 1: " + list.put("A", 2));
		System.out.println("Expected 2 after put 2: " + list.get("A"));

		System.out.println("Remove A, expected 2: " + list.remove("A"));
		System.out.println("Remove A (which doesnt exist) expected null: " + list.remove("A"));
	}

}
