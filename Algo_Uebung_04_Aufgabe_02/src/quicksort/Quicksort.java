package quicksort;
import java.math.*;

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
	public static <K extends Comparable<K>> void quick_sort(K[] field,
			int choice) {
		quick_sort_help(field, 0, field.length - 1, choice);
	}

	static <K extends Comparable<K>> void quick_sort_help(K[] field, int iLeft,
			int iRight, int choice) {
		final K MID;
		switch (choice) {
		case 0:
			MID = field[(iLeft + iRight) / 2];
			break;
		case 1:
			MID = add((K)field[iLeft], (K)field[iRight]);
			break;
		case 2:
			MID = field[iLeft];
			break;
		case 3:
			MID = field[iRight];
			break;
		default:
			MID = null;
			System.out.println("Fehler ! K ist kein Numbertyp!");
			break;
		}

		int l = iLeft;
		int r = iRight;

		while (l < r) {
			while (field[l].compareTo(MID) < 0) {
				++l;
			}
			while (field[r].compareTo(MID) > 0) {
				--r;
			}
			if (l <= r)
				swap(field, l++, r--);
		}
		if (iLeft < r)
			quick_sort_help(field, iLeft, r, choice);
		if (iRight > l)
			quick_sort_help(field, l, iRight, choice);
	}

	private static <K> void swap(K[] field, int l, int r) {
		K temp = field[l];
		field[l] = field[r];
		field[r] = temp;
	}
	
	
	private static <K> K add(K one, K two){
		if(one instanceof Integer) 
			return (K)new Integer(((Integer)one + (Integer)two)/2);
		if(one instanceof Double)
			return (K)new Double(((Double)one + (Double)two)/2);
		if(one instanceof Float)
			return (K)new Float(((Float)one + (Float)two)/2);
		if(one instanceof Long)
			return (K)new Long(((Long)one + (Long)two)/2);
		return null;
	}
	
	
}

