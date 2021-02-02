package opgave_02;

import opgave_01.ArrayStack;
import opgave_03.DropOutStackEnkelt;

public class MainApp {

	public static void main(String[] args) {
		// Opgave 1
//		ArrayStack stack = new ArrayStack(10);
//		stack.push("a");
//		stack.push("b");
//		stack.push("c");
//		System.out.println(stack.toString());
//		System.out.println(stack.pop());

		// Opgave 2
//		String s = " (3+{5{99{*}}[23[{67}67]]})";
//		System.out.println(checkParenteses(s));
//		String s1 = " (}){";
//		try {
//			System.out.println(checkParenteses(s1));
//		} catch (EmptyStackException e) {
//			System.out.println("False");
//		}

		// Opgave 3.a
//		DropOutStack ds = new DropOutStack(5);
//		System.out.println(ds.size());
//		ds.push("a");
//		ds.push("a");
//		ds.push("a");
//		ds.push("a");
//		System.out.println(ds.size());
//		ds.push("a");
//		System.out.println(ds.size());
//		ds.push("a");
//		System.out.println(ds.size());

		// Opgave 3.b
		DropOutStackEnkelt dse = new DropOutStackEnkelt(4);
		dse.push("a");
		dse.push("b");
		dse.push("c");
		System.out.println(dse.toString());
		dse.push("d");
		System.out.println(dse.toString());
		dse.push("e");
		System.out.println(dse.toString());
		dse.push("f");
		System.out.println(dse.toString());
		dse.push("g");
		System.out.println(dse.toString());
		dse.push("h");
		System.out.println(dse.toString());
		dse.pop();
		System.out.println(dse.toString());
//		dse.push("h");
//		System.out.println(dse.toString());
//		dse.push("i");
//		System.out.println(dse.toString());
//		System.out.println(dse.peek());

		// Opgave 3.c
//		DropOutStackDobbelt dso = new DropOutStackDobbelt(4);
//		System.out.println(dso.toString());
//		dso.push("a");
//		dso.push("b");
//		dso.push("c");
//		System.out.println(dso.toString());
//		dso.push("d");
//		System.out.println(dso.toString());
//		dso.push("e");
//		System.out.println(dso.toString());
//		dso.push("f");
//		System.out.println(dso.toString());
//		dso.push("g");
//		System.out.println(dso.toString());
//		dso.push("h");
//		System.out.println(dso.toString());
//		dso.pop();
//		System.out.println(dso.toString());
//		dso.push("h");
//		System.out.println(dso.toString());
//		dso.push("i");
//		System.out.println(dso.toString());
//		System.out.println(dso.peek());

	}

	public static boolean checkParenteses(String s) {
		ArrayStack stack = new ArrayStack(10);
		boolean legal = false;
		for (int i = 0; i < s.length(); i++) {
			String[] st = s.split("");
			if (st[i].equals("(") || st[i].equals("{") || st[i].equals("[")) {
				stack.push(st[i]);
			} else if (st[i].equals(")") || st[i].equals("}") || st[i].equals("]")) {
				stack.pop();
			}
		}
		if (stack.size() == 0) {
			legal = true;
		}
		return legal;
	}

}
