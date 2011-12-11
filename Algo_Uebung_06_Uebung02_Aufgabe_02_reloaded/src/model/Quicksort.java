package model;
import java.math.*;
import java.util.*;

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
	public static <K extends Comparable<K>> void quick_sort(Vector<SaveTheValues> field) {
		quick_sort_help(field, 0, field.size() - 1);
	}

	private static <K extends Comparable<K>> void quick_sort_help(Vector<SaveTheValues> field, int iLeft,
			int iRight) {
		final SaveTheValues MID;
		MID = field.get((iLeft + iRight) / 2);
		
		int l = iLeft;
		int r = iRight;

		while (l < r) {
			while (field.get(l).count < MID.count) {
				++l;
			}
			while (field.get(r).count > MID.count) {
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

	private static void swap(Vector<SaveTheValues> field, int l, int r) {
		SaveTheValues temp = field.get(l);
		field.set(l, field.get(r));
		field.set(r, temp);
	}	
}

