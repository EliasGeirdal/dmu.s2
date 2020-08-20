package opgaver;

public class Opgave_4 {

	public static String reverse(String s) {
		if (s.length() <= 1) {
			return s;
		}
		return s.charAt(s.length() - 1) + reverse(s.substring(0, s.length() - 1));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(reverse("RANSLIRPA"));
	}

}
