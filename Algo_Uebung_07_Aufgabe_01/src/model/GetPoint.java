package model;

import java.util.*;

public class GetPoint {
	public static int searchBin(Vector<ValueColor> redCol,
			Vector<ValueColor> greenCol, Vector<ValueColor> blueCol,
			Vector<SaveTheValues> vec, int i) {
		int redPos, greenPos, bluePos, colPos;
		double length;
		// 1. Die Positionen in dem Rot-Sortierten Vector finden!
		redPos = binSearch(redCol, vec, i, 0);
		greenPos = binSearch(greenCol, vec, i, 1);
		bluePos = binSearch(blueCol, vec, i, 2);
		// 2. Nun den k�rzesten Abstand der 3 Farbsortierten herausfinden...
		// (umst�ndlich, aber schei� egal ! :) )
		length = distance(redCol.get(redPos).col.getRed(), redCol.get(redPos).col.getGreen(), redCol.get(redPos).col.getBlue());
		colPos = redPos;
		if(distance(redCol.get(greenPos).col.getRed(), redCol.get(greenPos).col.getGreen(), redCol.get(greenPos).col.getBlue()) < length){
			length = distance(redCol.get(greenPos).col.getRed(), redCol.get(greenPos).col.getGreen(), redCol.get(greenPos).col.getBlue());
			colPos = greenPos;
		} else if (distance(redCol.get(bluePos).col.getRed(), redCol.get(bluePos).col.getGreen(), redCol.get(bluePos).col.getBlue()) < length){
			length = distance(redCol.get(bluePos).col.getRed(), redCol.get(bluePos).col.getGreen(), redCol.get(bluePos).col.getBlue());
			colPos = bluePos;
		}
		// 3. Pr�fen, ob es k�rzere Distanzen zum akutellten colPos gibt... 
		colPos = RedfindShortestDistance(redCol, length, colPos);
		length = distance(redCol.get(colPos).col.getRed(), redCol.get(colPos).col.getGreen(), redCol.get(colPos).col.getBlue());
		colPos = GreenfindShortestDistance(greenCol, length, colPos);
		length = distance(redCol.get(colPos).col.getRed(), redCol.get(colPos).col.getGreen(), redCol.get(colPos).col.getBlue());	
		colPos = BluefindShortestDistance(blueCol, length, colPos);
//		length = distance(redCol.get(colPos).col.getRed(), redCol.get(colPos).col.getGreen(), redCol.get(colPos).col.getBlue());
		// 4. Zur�ckgeben
		return colPos;
	}

	private static int binSearch(Vector<ValueColor> colVec,
			Vector<SaveTheValues> vec, int i, int choice) {
		int iL = 0;
		int iR = colVec.size() - 1;
		boolean trfl = false;

		while (iL <= iR) {
			final int MIDDLE = (iL + iR) / 2;
			

		}
		return 0;
	}

	private static int RedBinSearch()
	
	
	
	
	
	private static int bigOrSma(int v1, int v2) {
		if (v1 < v2)
			return -1;
		if (v1 > v2)
			return 1;
		return 0;
	}

	private static double distance(int v1, int v2, int v3) {
		return (Math.sqrt(v1 * v1 + v2 * v2 + v3 * v3));
	}
	
	// In dieser Methode wird der Bereich innerhalb der Farbvektoren gechekct, ob es k�rzere gibt!
	private static int RedfindShortestDistance(Vector<ValueColor> colVec, double length, double colPos){
		// Mithilfe der Bin�ren Suche den lenVal-length finden !
		int pos = findLenValLength(colVec, (int)(colPos-length), 0);
		int returnPos = (int)colPos;
		double helpDis; 
		while(colVec.get(pos).col.getRed() < ((int)(colPos+length))){
			helpDis = distance(colVec.get(pos).col.getRed(), colVec.get(pos).col.getGreen(), colVec.get(pos).col.getBlue());
			if(helpDis < length) returnPos = pos;
			++pos;				
		}
		return colVec.get(returnPos).vecPos;
	}
	
	private static int GreenfindShortestDistance(Vector<ValueColor> colVec, double length, double colPos){
		// Mithilfe der Bin�ren Suche den lenVal-length finden !
		int pos = findLenValLength(colVec, (int)(colPos-length), 1);
		int returnPos = (int)colPos;
		double helpDis; 
		while(colVec.get(pos).col.getBlue() < ((int)(colPos+length))){
			helpDis = distance(colVec.get(pos).col.getRed(), colVec.get(pos).col.getGreen(), colVec.get(pos).col.getBlue());
			if(helpDis < length) returnPos = pos;
			++pos;				
		}
		return colVec.get(returnPos).vecPos;
	}
	
	private static int BluefindShortestDistance(Vector<ValueColor> colVec, double length, double colPos){
		// Mithilfe der Bin�ren Suche den lenVal-length finden !
		int pos = findLenValLength(colVec, (int)(colPos-length), 2);
		int returnPos = (int)colPos;
		double helpDis; 
		while(colVec.get(pos).col.getBlue() < ((int)(colPos+length))){
			helpDis = distance(colVec.get(pos).col.getRed(), colVec.get(pos).col.getGreen(), colVec.get(pos).col.getBlue());
			if(helpDis < length) returnPos = pos;
			++pos;				
		}
		return colVec.get(returnPos).vecPos;
	}
	
	private static int findLenValLength(Vector<ValueColor> colVec, int findPoint, int c){
		int iL = 0;
		int iR = colVec.size() - 1;
		while(iL <= iR){
			int MIDDLE = (iL + iR) / 2;
			int RES;
			switch(c){
			case 0: RES = bigOrSma(colVec.get(MIDDLE).col.getRed(),
					findPoint); break;
			case 1: RES = bigOrSma(colVec.get(MIDDLE).col.getGreen(),
					findPoint); break;
			default: RES = bigOrSma(colVec.get(MIDDLE).col.getBlue(),
					findPoint); break;
			}
			if(RES == 0){
				switch(c){
				case 0: while(colVec.get(MIDDLE-1).col.getRed() == findPoint)
					--MIDDLE; break;
				case 1: while(colVec.get(MIDDLE-1).col.getGreen() == findPoint)
					--MIDDLE; break;
				default: while(colVec.get(MIDDLE-1).col.getBlue() == findPoint)
					--MIDDLE; break;
				}
				return MIDDLE; 
			} else if(RES < 0)
				iL = MIDDLE + 1;
			else
				iR = MIDDLE - 1;
		}
		return 0;
	}
}
