package mergeSort;

public class MergeSort {
	public static <K extends Comparable<K>> void merge_sort(K[] field) {
		merge_sort_help(field, 0, field.length - 1);

	}

	private static <K extends Comparable<K>> void merge_sort_help(K[] field,
			int iLeft, int iRight) {
		if (iLeft < iRight) {
			final int MIDDLE = (iLeft + iRight) / 2; // der genaue Mittelwert
														// wird hier bestimmt
			merge_sort_help(field, iLeft, MIDDLE); // ruft rekursiv die
													// merge_sort_help methode
													// auf
			merge_sort_help(field, MIDDLE + 1, iRight); // bis nur noch ein
														// Element �brig ist

			K[] tmp = (K[]) new Comparable[iRight - iLeft + 1]; // eine
																// tmp-Array vom
																// Typ K
																// anlegen,
																// welches
																// Comparable
																// ist

			for (int i = iLeft; i <= iRight; ++i)
				// gehe von linken bis zum rechten feld komplett durch
				tmp[i - iLeft] = field[i]; // und setze an der i - iLeften
											// Stelle das field[i] ding

			int iL = 0;
			int iR = MIDDLE + 1 - iLeft;
			boolean isSomethingFree = true;
			int i = iLeft;

			while (isSomethingFree) {
				field[i++] = tmp[iL].compareTo(tmp[iR]) < 0 ? tmp[iL++]
						: tmp[iR++];
				if (iR == tmp.length) {
					isSomethingFree = false;
					while (iL != MIDDLE + 1 - iLeft)
						field[i++] = tmp[iL++];
				} else if (iL == MIDDLE + 1 - iLeft) {
					isSomethingFree = false;
					while (iR != tmp.length)
						field[i++] = tmp[iR++];
				}
			}

		}
	}
}
