package model;

import java.util.*;

public class GetPoint_Old {
	public static int searchBin(Vector<ValueColor> redCol,
			Vector<ValueColor> greenCol, Vector<ValueColor> blueCol,
			Vector<SaveTheValues> vec, int i) {
		int redPos, greenPos, bluePos, colPos;
		double length;
		// 1. Die Positionen in dem Rot-Sortierten Vector finden!
		redPos = binSearch(redCol, vec, i, 0);
		greenPos = binSearch(greenCol, vec, i, 1);
		bluePos = binSearch(blueCol, vec, i, 2);
		// 2. Nun den kürzesten Abstand der 3 Farbsortierten herausfinden...
		// (umständlich, aber scheiß egal ! :) )
		length = distance(redCol.get(redPos).col.getRed(), redCol.get(redPos).col.getGreen(), redCol.get(redPos).col.getBlue());
		colPos = redPos;
		if(distance(redCol.get(greenPos).col.getRed(), redCol.get(greenPos).col.getGreen(), redCol.get(greenPos).col.getBlue()) < length){
			length = distance(redCol.get(greenPos).col.getRed(), redCol.get(greenPos).col.getGreen(), redCol.get(greenPos).col.getBlue());
			colPos = greenPos;
		} else if (distance(redCol.get(bluePos).col.getRed(), redCol.get(bluePos).col.getGreen(), redCol.get(bluePos).col.getBlue()) < length){
			length = distance(redCol.get(bluePos).col.getRed(), redCol.get(bluePos).col.getGreen(), redCol.get(bluePos).col.getBlue());
			colPos = bluePos;
		}
		// 3. Prüfen, ob es kürzere Distanzen zum akutellten colPos gibt... 
		colPos = RedfindShortestDistance(redCol, length, colPos);
		length = distance(redCol.get(colPos).col.getRed(), redCol.get(colPos).col.getGreen(), redCol.get(colPos).col.getBlue());
		colPos = GreenfindShortestDistance(greenCol, length, colPos);
		length = distance(redCol.get(colPos).col.getRed(), redCol.get(colPos).col.getGreen(), redCol.get(colPos).col.getBlue());	
		colPos = BluefindShortestDistance(blueCol, length, colPos);
//		length = distance(redCol.get(colPos).col.getRed(), redCol.get(colPos).col.getGreen(), redCol.get(colPos).col.getBlue());
		// 4. Zurückgeben
		return colPos;
	}

	private static int binSearch(Vector<ValueColor> colVec,
			Vector<SaveTheValues> vec, int i, int choice) {
		int iL = 0;
		int iR = colVec.size() - 1;
		int c1 = choice, c2;
		boolean trfl = false;

		while (iL <= iR) {
			final int MIDDLE = (iL + iR) / 2;
			final int FIRST;
			switch (c1) {
			case 0:
				FIRST = bigOrSma(colVec.get(MIDDLE).col.getRed(),
						vec.get(i).col.getRed());
				break;
			case 1:
				FIRST = bigOrSma(colVec.get(MIDDLE).col.getGreen(),
						vec.get(i).col.getGreen());
				break;
			default:
				FIRST = bigOrSma(colVec.get(MIDDLE).col.getBlue(),
						vec.get(i).col.getBlue());
				break;
			}
			if (FIRST == 0) {
				++c1;
				if (c1 > 2)
					c1 = 0;
				final int SECOND;
				switch (c1) {
				case 0:
					SECOND = bigOrSma(colVec.get(MIDDLE).col.getRed(),
							vec.get(i).col.getRed());
					break;
				case 1:
					SECOND = bigOrSma(colVec.get(MIDDLE).col.getGreen(),
							vec.get(i).col.getGreen());
					break;
				default:
					SECOND = bigOrSma(colVec.get(MIDDLE).col.getBlue(),
							vec.get(i).col.getBlue());
					break;
				}
				if (SECOND == 0) {
					++c1;
					if (c1 > 2)
						c1 = 0;
					switch (c1) {
					case 0:
						if ((bigOrSma(colVec.get(MIDDLE).col.getRed(),
								vec.get(i).col.getRed())) < 0
								&& bigOrSma(
										colVec.get(MIDDLE + 1).col.getRed(),
										vec.get(i).col.getRed()) > 0) {
							trfl = true;
						}
						break;
					case 1:
						if ((bigOrSma(colVec.get(MIDDLE).col.getGreen(),
								vec.get(i).col.getGreen())) < 0
								&& bigOrSma(
										colVec.get(MIDDLE + 1).col.getGreen(),
										vec.get(i).col.getGreen()) > 0) {
							trfl = true;
						}
						break;
					default:
						if ((bigOrSma(colVec.get(MIDDLE).col.getBlue(),
								vec.get(i).col.getBlue())) < 0
								&& bigOrSma(
										colVec.get(MIDDLE + 1).col.getBlue(),
										vec.get(i).col.getBlue()) > 0) {
							trfl = true;
						}
						break;
					}

					if (trfl == true) {
						// kÃ¼rzesten Abstand berechnen, weil genau die Mitte
						// gefunden, dann Pos zurueckgeben :)
						double distance = distance(
								colVec.get(MIDDLE).col.getRed()
										- vec.get(i).col.getRed(),
								colVec.get(MIDDLE).col.getGreen()
										- vec.get(i).col.getGreen(),
								colVec.get(MIDDLE).col.getBlue()
										- vec.get(i).col.getBlue());
						if (distance(
								colVec.get(MIDDLE + 1).col.getRed()
										- vec.get(i).col.getRed(),
								colVec.get(MIDDLE + 1).col.getGreen()
										- vec.get(i).col.getGreen(),
								colVec.get(MIDDLE + 1).col.getBlue()
										- vec.get(i).col.getBlue()) < distance)
							return colVec.get(MIDDLE + 1).vecPos;
						else
							return colVec.get(MIDDLE).vecPos;
					}
				} else if (SECOND < 0)
					iL = MIDDLE + 1;
				else
					iR = MIDDLE - 1;
			} else if (FIRST < 0)
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

	private static double distance(int v1, int v2, int v3) {
		return (Math.sqrt(v1 * v1 + v2 * v2 + v3 * v3));
	}
	
	// In dieser Methode wird der Bereich innerhalb der Farbvektoren gechekct, ob es kürzere gibt!
	private static int RedfindShortestDistance(Vector<ValueColor> colVec, double length, double colPos){
		// Mithilfe der Binären Suche den lenVal-length finden !
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
		// Mithilfe der Binären Suche den lenVal-length finden !
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
		// Mithilfe der Binären Suche den lenVal-length finden !
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
