package quickSort;
import java.math.*;

import binSearch.*;

/**
 * QuickSort Implementierung
 * 
 * @author peters
 * 
 *	19.11.2011: Hinzufügen der Switch-Case Anweisung um die verschiedenen
 *         		Pivotelemente wählen zu können: 
 *         0: Der mittlere Wert von field(für iLeft und iRight) 
 *         1: Das Mittelmaß (= Durchschnitt) der beiden Werte in iLeft und iRight 
 *         2: Immer das linke Element als Pivotelement wählen 
 *         3: Immer das rechte Element als Pivotelement wählen
 * 
 * 
 */

public class Quicksort {
	public static <K extends Comparable<K>> void quick_sort(Node[] field) {
		quick_sort_help(field, 0, field.length - 1);
	}

	static <K extends Comparable<K>> void quick_sort_help(Node[] field, int iLeft,
			int iRight) {
		final K MID;
		MID = (K)field[(iLeft + iRight) / 2].m_Key;
		
		int l = iLeft;
		int r = iRight;

		while (l < r) {
			while (((K)field[l].m_Key).compareTo(MID) < 0) {
				++l;
			}
			while (((K)field[r].m_Key).compareTo(MID) > 0) {
				--r;
			}
			if (l <= r)
				swap(field, l++, r--);
		}
		if (iLeft < r)
			quick_sort_help(field, iLeft, r);
		if (iRight > l)
			quick_sort_help(field, l, iRight);
	}

	private static <K> void swap(Node[] field, int l, int r) {
		Node temp = field[l];
		field[l] = field[r];
		field[r] = temp;
	}
}

