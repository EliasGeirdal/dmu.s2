package repetition.test;

import repetition.opgave01.ArrayStack;

public class TestApp {

	public static void main(String[] args) {

		// ***********Opgave 1*****************

//		ArrayStack stack = new ArrayStack();
//		stack.push("A");
//		stack.push("B");
//		stack.push("C");
//		stack.push("D");
//		stack.push("E");
//		stack.push("E");
//		stack.push("E");
//		stack.push("E");
//		stack.push("E");
//
//		System.out.println(stack.toString());
//		stack.pop();
//		stack.pop();
//		stack.pop();
//		stack.pop();
//		stack.pop();
//		System.out.println(stack.toString());

		// *************Opgave 2********************
		System.out.println("Following parenthesis match: " + checkParenteses("(3+{5{99{*}}[23[{67}67]]})"));
		System.out.println("Following parenthesis match: " + checkParenteses("(}){\r"));
	}

	public static boolean checkParenteses(String s) {
		ArrayStack<Character> stack = new ArrayStack<>();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
				stack.push(s.charAt(i));
			} else if (s.charAt(i) == ')' || s.charAt(i) == ']' || s.charAt(i) == '}') {
				if (match(s.charAt(i), stack.peek())) {
					stack.pop();
				} else {
					return false;
				}
			}
		}
		return stack.size() == 0 ? true : false;
	}

	private static boolean match(char element, char stackedElement) {
		if (element == ')' && stackedElement == '(')
			return true;
		else if (element == ']' && stackedElement == '[')
			return true;
		else if (element == '}' && stackedElement == '{')
			return true;
		return false;
	}

}
