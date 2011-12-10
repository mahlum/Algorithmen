package startBinTree;

import binTree.*;

public class StartBinTreeWithoutNodeRef {
	public static void main(String[] args){
		BinTreeWithoutNodeRef<Integer, Integer> btwn = new BinTreeWithoutNodeRef<Integer, Integer>();
		Integer[] keys = {13, 11, 39, 8, 12, 35, 41, 4, 9, 28, 37, 40, 48};
		Integer[] values = {0, 1,  2, 3,  4,  5,  6, 7, 8,  9, 10, 11, 12};
		
		for(int i = 0; i < keys.length; ++i)
			btwn.insert_help(keys[i], values[i]);
		
		btwn.giveMeTheFuckingNodeData(keys[8]);
		
		btwn.remove_help(keys[8]);
		btwn.giveMeTheFuckingNodeData(keys[8]);
		btwn.remove_help(keys[3]);
		btwn.giveMeTheFuckingNodeData(keys[3]);
		btwn.remove_help(keys[5]);
		btwn.giveMeTheFuckingNodeData(keys[5]);
		btwn.remove_help(keys[0]);
		btwn.giveMeTheFuckingNodeData(keys[0]);
		btwn.remove_help(keys[12]);
		btwn.giveMeTheFuckingNodeData(keys[12]);
	}
}
