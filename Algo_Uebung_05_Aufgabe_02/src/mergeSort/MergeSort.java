package mergeSort;

public class MergeSort {
	public static <K extends Comparable<K>> void merge_sort(K[] field, boolean choice) {
		if(choice)
			merge_sort_help(field, 0, field.length - 1);
		if(choice == false)
			merge_sort_help_2(field, 0, field.length - 1);
	}

	private static <K extends Comparable<K>> void merge_sort_help(K[] field,
			int iLeft, int iRight) {
		if (iLeft < iRight) {
			final int MIDDLE = (iLeft + iRight) / 2; 			
			
			merge_sort_help(field, iLeft, MIDDLE);
			merge_sort_help(field, MIDDLE + 1, iRight); 
			K[] tmp = (K[]) new Comparable[iRight - iLeft + 1]; 
			for (int i = iLeft; i <= iRight; ++i)
				tmp[i - iLeft] = field[i]; 	

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
	
	private static <K extends Comparable<K>> void merge_sort_help_2(K[] field,
			int iLeft, int iRight) {
		if (iLeft < iRight) {
			final int MIDDLE = (iLeft + iRight) / 2; 			
			K[] tmp = (K[]) new Comparable[iRight - iLeft + 1]; 
			merge_sort_help_2(field, iLeft, MIDDLE);
			merge_sort_help_2(field, MIDDLE + 1, iRight); 
			
			for (int i = iLeft; i <= iRight; ++i)
				tmp[i - iLeft] = field[i]; 	

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
