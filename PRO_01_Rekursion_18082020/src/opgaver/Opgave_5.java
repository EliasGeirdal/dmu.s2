package opgaver;

public class Opgave_5 {

	public static int sfd(int a, int b) {
		if (b <= a && a % b == 0) {
			return b;
		}
		if (a < b) {
			return sfd(b, a);
		} else {
			return sfd(b, a % b);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(sfd(1701, 3768));
	}

}
