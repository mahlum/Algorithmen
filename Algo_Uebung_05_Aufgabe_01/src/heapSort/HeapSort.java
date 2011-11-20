package heapSort;

public class HeapSort {
//	public static <K extends Comparable<K>> void sort(K[] field){
//		Heap<K> a = new Heap<K>(field.length);
//		for(int i = 0; i < field.length; ++i)
//			a.insert(field[i]);
//		for(int i = 0; i < field.length; ++i)
//			field[field.length - i - 1] = a.remove();
//	}
	
	public static <K extends Comparable<K>> void sort(K[] field){
//		Heap<K> a = new Heap<K>(field.length);
		for(int i = (field.length-1) / 2; i >= 0; --i)
			Heap.downheap(field, field.length-1, i);
		for(int i = field.length-1; i > 0; --i){
			swap(field,0,i);
			Heap.downheap(field, i, 0);
		}
	}
	
	private static<K> void swap(K[] field, int i, int b){
		K tmp = field[i];
		field[i] = field[0];
		field[0] = tmp;
	}
}
