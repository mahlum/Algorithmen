package model;

import java.math.*;
import java.util.*;

/**
 * QuickSort Implementierung
 * 
 * @author peters
 * 
 *         19.11.2011: Hinzufï¿½gen der Switch-Case Anweisung um die
 *         verschiedenen Pivotelemente wï¿½hlen zu kï¿½nnen: 0: Der mittlere
 *         Wert von field(fï¿½r iLeft und iRight) 1: Das Mittelmaï¿½ (=
 *         Durchschnitt) der beiden Werte in iLeft und iRight 2: Immer das linke
 *         Element als Pivotelement wï¿½hlen 3: Immer das rechte Element als
 *         Pivotelement wï¿½hlen
 * 
 *         13.12.2011: Modifikation des Quicksorts für die Sortierung der
 *         einzelnen Farben der Übung 7 in Algo und Datenstrukturen
 */

public class ColorQuicksort {
	public static void quick_sort(Vector<ValueColor> field, int c1) {
		quick_sort_help(field, 0, field.size() - 1, c1);
		// System.out.println("Rot\tBlau\tGrün");
		// for(int i = 0; i < field.size(); ++i)
		// System.out.print(field.get(i).col.getRed() + "\t" +
		// field.get(i).col.getGreen() + "\t" + field.get(i).col.getBlue() +
		// "\n");
		// Nun die second choice sortieren :) , dazu erstmal iLeft und iRight
		// bestimmen :)
//		for (int i = 0; i < field.size(); ++i)
//			System.out.print(field.get(i).col.getRed() + "\t" + field.get(i).col.getGreen() + "\t" + field.get(i).col.getBlue() + "\n");
//		System.out.println("STOOOOOOOP");
		
		int iLeft = 0, iRight;
		int ch1 = c1, ch2 = c1+1;
		if(ch2 > 2) ch2 = 0;
		
		do {
			switch (ch1) {
			case 0:
				iLeft = field.get(0).col.getRed();
				break;
			case 1:
				iLeft = field.get(0).col.getGreen();
				break;
			case 2:
				iLeft = field.get(0).col.getBlue();
				break;
			}
			iLeft = 0;
			iRight = iLeft;
			while (iLeft != field.size()) {
				switch (ch1) {
				case 0:
					while (iRight + 1 != field.size() && field.get(iLeft).col.getRed() == field.get(iRight + 1).col.getRed())
						++iRight;
					break;
				case 1:
					while (iRight + 1 != field.size() && field.get(iLeft).col.getGreen() == field.get(iRight + 1).col.getGreen())
						++iRight;
					break;
				case 2:
					while (iRight + 1 != field.size() && field.get(iLeft).col.getBlue() == field.get(iRight + 1).col.getBlue())
						++iRight;
					break;
				}
				quick_sort_help(field, iLeft, iRight, ch2);
				iLeft = iRight + 1;
				iRight = iLeft;
			}
//			for (int i = 0; i < field.size(); ++i)
//				System.out.print(field.get(i).col.getRed() + "\t" + field.get(i).col.getGreen() + "\t" + field.get(i).col.getBlue() + "\n");
//			System.out.println("STOOOOOOOP");
			++ch1;
			++ch2;
			if(ch1 > 2) ch1 = 0;
			if(ch2 > 2) ch2 = 0;
		} while(c1 != ch1);
	}

	private static void quick_sort_help(Vector<ValueColor> field, int iLeft,
			int iRight, int choice) {
		final ValueColor MID;
		MID = field.get((iLeft + iRight) / 2);

		int l = iLeft;
		int r = iRight;

		while (l < r) {

			switch (choice) {
			case 0:
				while (returnErg(field.get(l).col.getRed(), MID.col.getRed(),
						true)) {
					++l;
				}
				while (returnErg(field.get(r).col.getRed(), MID.col.getRed(),
						false)) {
					--r;
				}
				break;
			case 1:
				while (returnErg(field.get(l).col.getGreen(),
						MID.col.getGreen(), true)) {
					++l;
				}
				while (returnErg(field.get(r).col.getGreen(),
						MID.col.getGreen(), false)) {
					--r;
				}
				break;
			case 2:
				while (returnErg(field.get(l).col.getBlue(), MID.col.getBlue(),
						true)) {
					++l;
				}
				while (returnErg(field.get(r).col.getBlue(), MID.col.getBlue(),
						false)) {
					--r;
				}
				break;
			}
			if (l <= r)
				swap(field, l++, r--);
		}
		if (iLeft < r)
			quick_sort_help(field, iLeft, r, choice);
		if (iRight > l)
			quick_sort_help(field, l, iRight, choice);
	}

	private static boolean returnErg(int v1, int v2, boolean choice) {
		if (choice)
			return v1 < v2 ? true : false;
		else
			return v1 > v2 ? true : false;

	}

	private static void swap(Vector<ValueColor> field, int l, int r) {
		ValueColor temp = field.get(l);
		field.set(l, field.get(r));
		field.set(r, temp);
	}
}
