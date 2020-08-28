/*
 * 
 */
package rekursion;

/**
 * @author mad
 */
public class Hanoi {
	private static int count = 0;

	public static void flyt(int n, int fra, int til) {
		count++;
		if (n == 1) {
			System.out.println("Flyt fra " + fra + " til " + til);
		} else {
			int temp = 6 - fra - til;
			flyt(n - 1, fra, temp);
			System.out.println("Flyt fra " + fra + " til " + til);
			flyt(n - 1, temp, til);
		}
	}

	public static void main(String[] args) {
		flyt(4, 1, 3);
		System.out.println(count);
	}
}
