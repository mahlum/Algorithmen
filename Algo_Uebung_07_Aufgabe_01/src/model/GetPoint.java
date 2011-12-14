package model;

import java.util.*;

public class GetPoint {
	public static int searchBin(Vector<ValueColor> redCol,
			Vector<ValueColor> greenCol, Vector<ValueColor> blueCol,
			Vector<SaveTheValues> vec, int i) {
		int redPos, greenPos, bluePos;
		// 1. Die Positionen in dem Rot-Sortierten Vector finden!
		redPos = binSearch(redCol, vec, i, 0);
		greenPos = binSearch(greenCol, vec, i, 1);
		bluePos = binSearch(blueCol, vec, i, 2);
		
		return 0;
	}

	private static int binSearch(Vector<ValueColor> colVec,
			Vector<SaveTheValues> vec, int i, int choice) {
		int iL = 0;
		int iR = colVec.size() - 1;
		int c1 = choice , c2;
		
		while (iL <= iR) {
			final int MIDDLE = (iL + iR) / 2;
			final int FIRST;
			switch(c1){
			case 0: FIRST = bigOrSma(colVec.get(MIDDLE).col.getRed(),
					vec.get(i).col.getRed());
				break;
			case 1: FIRST = bigOrSma(colVec.get(MIDDLE).col.getGreen(),
					vec.get(i).col.getGreen());
				break; 
			default: FIRST = bigOrSma(colVec.get(MIDDLE).col.getBlue(),
					vec.get(i).col.getBlue()); 
				break;
			}
			++c1;
			if(c1 > 2) c1 = 0;
			if (FIRST == 0) {
				final int SECOND;
				switch(c1){
				case 0: SECOND = bigOrSma(colVec.get(MIDDLE).col.getRed(),
						vec.get(i).col.getRed());
					break;
				case 1: SECOND = bigOrSma(colVec.get(MIDDLE).col.getGreen(),
						vec.get(i).col.getGreen()); 
					break;
				default: SECOND = bigOrSma(colVec.get(MIDDLE).col.getBlue(),
						vec.get(i).col.getBlue());
					break;
				}
				++c1;
				if(c1 > 2) c1 = 0;
				if (SECOND == 0) {
					boolean trfl;
					switch(c1){
					case 0: if((bigOrSma(colVec.get(MIDDLE).col.getRed(),
							vec.get(i).col.getRed())) < 0
							&& bigOrSma(colVec.get(MIDDLE + 1).col.getRed(),
									vec.get(i).col.getRed()) > 0) {
						trfl = true;
					}
					break;
					case 1: if((bigOrSma(colVec.get(MIDDLE).col.getGreen(),
							vec.get(i).col.getGreen())) < 0
							&& bigOrSma(colVec.get(MIDDLE + 1).col.getGreen(),
									vec.get(i).col.getGreen()) > 0) {
						trfl = true;
					}
					break;
					default: if((bigOrSma(colVec.get(MIDDLE).col.getBlue(),
							vec.get(i).col.getBlue())) < 0
							&& bigOrSma(colVec.get(MIDDLE + 1).col.getBlue(),
									vec.get(i).col.getBlue()) > 0) {
						trfl = true;
					}
					break;
					}
					
					if (trfl == true) {
						// kürzesten Abstand berechnen, weil genau die Mitte
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
}
