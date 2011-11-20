package heapSort;

public class HeapSort {
//	public static <K extends Comparable<K>> void sort(K[] field){
//		Heap<K> a = new Heap<K>(field.length);
//		for(int i = 0; i < field.length; ++i)
//			a.insert(field[i]);
//		for(int i = 0; i < field.length; ++i)
//			field[field.length - i - 1] = a.remove();
//	}
	
//	public void heapSort(int[] a){
//        //build heap
//        for(int i=a.length/2; i>=0; i--){
//                percDown(a, i, a.length);
//        }
//        for(int i=a.length-1; i>0; i--){
//                swap(a, 0, i);//put the max item to the end
//                percDown(a, 0, i);//change the left items to max heap
//        }
//	}
	
	public static <K extends Comparable<K>> void sort(K[] field){
//		Heap<K> a = new Heap<K>(field.length);
		for(int i = (field.length) / 2; i >= 0; --i)
//			Heap.downheap(field, field.length-1, i);
			Heap.downheap(field, i, field.length);
		for(int i = field.length-1; i > 0; --i){
			swap(field,0,i);
			Heap.downheap(field, 0, i);
		}
	}
	
	private static<K> void swap(K[] field, int i, int b){
		K tmp = field[i];
		field[i] = field[b];
		field[b] = tmp;
	}
}
