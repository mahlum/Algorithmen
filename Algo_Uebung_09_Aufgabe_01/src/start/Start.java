package start;

import redBlackTreeWithNode.*;
//import redBlackTreeWithoutNode.*;

public class Start {
	public static void main(String[] args){
		BlackRedTree<Integer, Integer> tree = new BlackRedTree<Integer, Integer>();
		
//		Integer[] keys = {13, -7, 34, 3, 5, 12, 9, -200, 45, 14, -1 , 15, -6, 18, -9, 44};
//		Integer[] data = {13, -7, 34, 3, 5, 12, 9, -200, 45, 14, -1 , 15, -6, 18, -9, 44};
		
		Integer[] keys = {1200,253,173,795,498,56,300,789,893,270,997,561,76,628,950,675,334,671,156,304,690,7,536,958,402,856};
		Integer[] data = {1200,253,173,795,498,56,300,789,893,270,997,561,76,628,950,675,334,671,156,304,690,7,536,958,402,856};
		
//		Integer[] keys = new Integer[50];
//		Integer[] data = new Integer[keys.length];
		
//		for (int i = 0; i < keys.length; ++i){
//			keys[i] = (int)(Math.random()*1000);
//			data[i] = keys[i];
//		}
		
		for (int i = 0; i < keys.length; ++i){
			System.out.print(keys[i] + ",");
			tree.insert(keys[i], data[i]);
			System.out.println();
			System.out.println();
			tree.outputTree_help();
			System.out.println("\n----------------------------------------------------");
		}
		System.out.println("\n----------------------------------------------------");
		tree.outputTree_help();
	}
}
