package heapSort;

public class HeapSort {
	public static <K extends Comparable<K>> void sort(K[] field){
		Heap<K> a = new Heap<K>(field.length);
		for(int i = 0; i < field.length; ++i)
			a.insert(field[i]);
		for(int i = 0; i < field.length; ++i)
			field[field.length - i - 1] = a.remove();
	}
}
