package model;

import java.util.*;

public class GetPoint {
	public static int searchBin(Vector<ValueColor> redCol,
			Vector<ValueColor> greenCol, Vector<ValueColor> blueCol,
			Vector<SaveTheValues> vec, int choice) {
		int pos = 0;
		//1. Die Positionen in dem Rot-Sortierten Vector finden!
		
		return pos;
	}

	private static int binSearch(Vector<ValueColor> colVec, Vector<SaveTheValues> vec, int i){
		int iL = 0;
		int iR = colVec.size() - 1;
		while(iL <= iR){
			final int MIDDLE = (iL + iR) / 2;
			final int FIRST = bigOrSma(colVec.get(MIDDLE).col.getRed(), vec.get(i).col.getRed());
			if(FIRST == 0){
				final int SECOND = bigOrSma(colVec.get(MIDDLE).col.getGreen(), vec.get(i).col.getGreen());
				if(SECOND == 0){
//					final int THIRD = bigOrSma(colVec.get(MIDDLE).col.getBlue(), vec.get(i).col.getBlue());
					if((bigOrSma(colVec.get(MIDDLE).col.getBlue(), colVec.get(i).col.getBlue())) < 0 &&
							bigOrSma(colVec.get(MIDDLE+1).col.getBlue(), colVec.get(i).col.getBlue()) > 0){
						//Abstand berechnen, weil genau die Mitte gefunden, dann Pos zurückgeben :) 
						
					}
				} else if(SECOND < 0)
					iL = MIDDLE + 1;
				else 
					iR = MIDDLE - 1;
			}
			else if(FIRST < 0)
				iL = MIDDLE + 1;
			else
				iR = MIDDLE - 1;
		}
		return 0;
	}

	private static int bigOrSma(int v1, int v2) {
		if (v1 < v2)
			return -1;
		if (v1 > v2)
			return 1;
		return 0;
	}
}
