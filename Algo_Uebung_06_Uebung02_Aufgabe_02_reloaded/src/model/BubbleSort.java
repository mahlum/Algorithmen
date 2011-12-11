package model;
import java.util.Vector;


public class BubbleSort{
	public static void sort(Vector<SaveTheValues> vec){
		boolean unsorted = true;
		while(unsorted){
			unsorted = false;
			for(int i = 0; i < vec.size()-1; ++i)
				if(vec.get(i).count > vec.get(i+1).count){
					swap(vec, vec.get(i), vec.get(i+1), i);
					unsorted = true;
				}
		}
//		return vec;
	}
	
	public static void swap(Vector<SaveTheValues> vec,SaveTheValues one, SaveTheValues two, int i){
			vec.set(i, two);
			vec.set(i+1, one);
	}
}
