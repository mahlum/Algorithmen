package start;

import redBlackTreeWithNode.*;

public class Start {
	public static void main(String[] args){
		BlackRedTree<Integer, Integer> tree = new BlackRedTree<Integer, Integer>();
		
		Integer[] keys = {13, -7, 34, 3, 5, 12, 9, -200, 45, 14, -1 , 15, -6, 18, -9, 44};
		Integer[] data = {13, -7, 34, 3, 5, 12, 9, -200, 45, 14, -1 , 15, -6, 18, -9, 44};
		
		for (int i = 0; i < keys.length; ++i){
			System.out.print(keys[i] + "|");
			tree.insert(keys[i], data[i]);
		}
		System.out.println("\n----------------------------------------------------");
	}
}
