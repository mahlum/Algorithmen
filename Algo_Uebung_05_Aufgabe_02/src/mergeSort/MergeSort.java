package mergeSort;

public class MergeSort {
	public static <K extends Comparable<K>> void merge_sort(K[] field, int choice){
		switch(choice){
		case 0: merge_sort_help(field, 0, field.length-1); break;
		case 1: merge_sort_help2(field, 0, field.length-1); break;
		}
		
	}
	
	private static<K extends Comparable<K>> void merge_sort_help(K[] field, int iLeft, int iRight){
		if(iLeft < iRight){
			final int MIDDLE = (iLeft + iRight)/2;							//der genaue Mittelwert wird hier bestimmt
			merge_sort_help(field, iLeft, MIDDLE);							//ruft rekursiv die merge_sort_help methode auf
			merge_sort_help(field, MIDDLE+1, iRight);						//bis nur noch ein Element übrig ist
			
			K[] tmp = (K[])new Comparable[iRight-iLeft+1];					//eine tmp-Array vom Typ K anlegen, welches Comparable ist
			
			for(int i = iLeft; i <= iRight; ++i)							//gehe von linken bis zum rechten feld komplett durch
				tmp[i - iLeft] = field[i];									//und setze an der i - iLeften Stelle das field[i] ding
			
			int iL = 0;
//			int iR = tmp.length-1;		
			int iR = MIDDLE+1;
			for(int i = iLeft; i <= iRight; ++i){
//				field[i] = tmp[iL].compareTo(tmp[iR]) < 0 ? tmp[iL++] : tmp[iR--];
				field[i] = tmp[iL].compareTo(tmp[iR]) < 0 ? tmp[iL++] : iR+1 > iRight ? tmp[iR] : tmp[iR++];
			}
		}
	}
	
	private static<K extends Comparable<K>> void merge_sort_help2(K[] field, int iLeft, int iRight){
		if(iLeft < iRight){
			final int MIDDLE = (iLeft + iRight)/2;							//der genaue Mittelwert wird hier bestimmt
			merge_sort_help2(field, iLeft, MIDDLE);							//ruft rekursiv die merge_sort_help methode auf
			merge_sort_help2(field, MIDDLE+1, iRight);						//bis nur noch ein Element übrig ist
			
			K[] tmp = (K[])new Comparable[iRight-iLeft+1];					//eine tmp-Array vom Typ K anlegen, welches Comparable ist
			
			for(int i = iLeft; i <= MIDDLE; ++i)
				tmp[i - iLeft] = field[i];
			for(int i = MIDDLE+1; i <= iRight; ++i)
				tmp[tmp.length-i+MIDDLE] = field[i];
			int iL = 0;
			int iR = tmp.length-1;											
			for(int i = iLeft; i <= iRight; ++i){
				field[i] = tmp[iL].compareTo(tmp[iR]) < 0 ? tmp[iL++] : tmp[iR--];
			}
		}
	}
}
