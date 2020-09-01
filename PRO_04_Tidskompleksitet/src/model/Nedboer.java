package model;

import java.util.ArrayList;

public class Nedboer {

	public static void main(String[] args) {
		System.out.println(bedsteTreFerieUger());
		System.out.println(bedsteFerieUgerStart(3));
		System.out.println(ensNedboer());
		System.out.println(ensNedboer1());
	}

	private static int[] nedboerPrUge = { 20, 10, 12, 12, 13, 14, 15, 10, 8, 7, 13, 15, 10, 9, 6, 8, 12, 22, 14, 16, 16,
			18, 23, 12, 0, 2, 0, 0, 78, 0, 0, 0, 34, 12, 34, 23, 23, 12, 44, 23, 12, 34, 22, 22, 22, 22, 18, 19, 21, 32,
			24, 13 };

	/**
	 * Returnerer ugenummeret for den uge i året, hvor man skal starte ferien, hvis
	 * man ønsker den minimale nedbørsmængde i de tre uger
	 *
	 * @return
	 */
	// O(n) O(1)
	public static int bedsteTreFerieUger() {
		// TODO
		int sum = (nedboerPrUge[0] + nedboerPrUge[1] + nedboerPrUge[2]);
		int uge = 0;
		for (int i = 0; i < nedboerPrUge.length - 2; i++) {
			int sum1 = (nedboerPrUge[i] + nedboerPrUge[i + 1] + nedboerPrUge[i + 2]);
			if (sum1 < sum) {
				sum = sum1;
				uge = i;
			}
		}
		return uge + 1;
	}

	/**
	 * Returnerer ugenummeret for den uge i året, hvor man skal starte ferien, hvis
	 * man ønsker den minimale nedbørsmængde i det "antal" uger, der er angivet i
	 * paramtereren
	 *
	 * @return
	 */

	// O(n^2) O(1)
	public static int bedsteFerieUgerStart(int antal) {
		// TODO
		int maxNedbør = Integer.MAX_VALUE;
		int uge = 0;
		for (int i = 0; i < nedboerPrUge.length - antal; i++) {
			int temp = 0;
			for (int j = i; j < antal + i; j++) {
				temp += nedboerPrUge[j];
			}
			if (temp < maxNedbør) {
				maxNedbør = temp;
				uge = i + 1;
			}
		}
		return uge;
	}

	/**
	 * Returnerer ugenummeret på den første uge hvor nedbøren har været præcis den
	 * samme flest uger i træk
	 *
	 * @return
	 */
	// O(n^2)
	public static int ensNedboer() {
		// TODO
		int uge = 0;
		int maxCount = 0;
		for (int i = 0; i < nedboerPrUge.length - 1; i++) {
			int j = 1 + i;
			int count = 0;
			while (nedboerPrUge[j] == nedboerPrUge[j - 1]) {
				count++;
				j++;
			}
			if (count > maxCount) {
				uge = i;
				maxCount = count;
			}
		}
		return uge + 1;
	}

	// O(n)
	public static int ensNedboer1() {
		// TODO
		ArrayList<Integer> memory = new ArrayList<>();
		memory.add(nedboerPrUge[0]);
		int partFilled = 0;
		int uge = 0;
		int maxCount = 0;
		int count = 1;
		for (int i = 1; i < nedboerPrUge.length - 1; i++) {
			if (nedboerPrUge[i] == memory.get(partFilled)) {
				memory.add(nedboerPrUge[i]);
				count++;
			} else {
				memory.add(nedboerPrUge[i]);
				count = 1; // reset count for next iteration.
			}
			if (count > maxCount) {
				maxCount = count;
				uge = i - (maxCount - 1);// count is initialised as 1, therefore we withdraw 1 to get the week at count
											// 1.
			}
			partFilled++; // keep track of partially filled array.
		}
		return uge + 1;
	}
}
