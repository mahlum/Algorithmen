package model;

import java.util.*;

public class GetPoint {
	public static int searchBin(Vector<ValueColor> redCol,
			Vector<ValueColor> greenCol, Vector<ValueColor> blueCol,
			Vector<SaveTheValues> vec, int i) {
		int redPos, greenPos, bluePos, colPos = 0;
		double length, helplength;
		// 1. Die Positionen in dem Rot-Sortierten Vector finden!
		redPos = binSearch(redCol, vec, i, 0);
		greenPos = binSearch(greenCol, vec, i, 1);
		bluePos = binSearch(blueCol, vec, i, 2);
		/** 2. Nun den k�rzesten Abstand der 3 Farbsortierten herausfinden...
		 * Reihenfolge: 
		 * 1. redPos
		 * 2. redPos + 1
		 * 3. greenPos
		 * 4. greenPos + 1
		 * 5. bluePos
		 * 6. bluePos + 1 
		*/
		
		//ROT
		length = distance(vec.get(i).col.getRed() - redCol.get(redPos).col.getRed(), 
				vec.get(i).col.getGreen() - redCol.get(redPos).col.getGreen(), 
				vec.get(i).col.getBlue() - redCol.get(redPos).col.getBlue());
		colPos = redCol.get(redPos).vecPos;
		helplength = distance(vec.get(i).col.getRed() - redCol.get(redPos+1).col.getRed(), 
				vec.get(i).col.getGreen() - redCol.get(redPos+1).col.getGreen(), 
				vec.get(i).col.getBlue() - redCol.get(redPos+1).col.getBlue());
		if(helplength < length) {
			length = helplength;
			colPos = redCol.get(redPos+1).vecPos;
		}
		//GRÜN
		helplength = distance(vec.get(i).col.getRed() - greenCol.get(greenPos).col.getRed(), 
				vec.get(i).col.getGreen() - greenCol.get(greenPos).col.getGreen(), 
				vec.get(i).col.getBlue() - greenCol.get(greenPos).col.getBlue());
		if(helplength < length){
			length = helplength;
			colPos = greenCol.get(greenPos).vecPos;
		}
		helplength = distance(vec.get(i).col.getRed() - greenCol.get(greenPos+1).col.getRed(), 
				vec.get(i).col.getGreen() - greenCol.get(greenPos+1).col.getGreen(), 
				vec.get(i).col.getBlue() - greenCol.get(greenPos+1).col.getBlue());
		if(helplength < length){
			length = helplength;
			colPos = greenCol.get(greenPos+1).vecPos;
		}
		//BLAU
		helplength = distance(vec.get(i).col.getRed() - blueCol.get(bluePos).col.getRed(), 
				vec.get(i).col.getGreen() - blueCol.get(bluePos).col.getGreen(), 
				vec.get(i).col.getBlue() - blueCol.get(bluePos).col.getBlue());
		if(helplength < length){
			length = helplength;
			colPos = blueCol.get(bluePos).vecPos;
		}
		helplength = distance(vec.get(i).col.getRed() - blueCol.get(bluePos+1).col.getRed(), 
				vec.get(i).col.getGreen() -  blueCol.get(bluePos+1).col.getGreen(), 
				vec.get(i).col.getBlue() - blueCol.get(bluePos+1).col.getBlue());
		if(helplength < length){
			length = helplength;
			colPos = blueCol.get(bluePos+1).vecPos;
		}
		
		// 3. Pr�fen, ob es k�rzere Distanzen zum akutellten colPos gibt...
//		System.out.println("length: " + length + " | i: " + vec.get(i).col.getRed());
		redPos = RedfindShortestDistance(redCol, vec, i, length, (int)(vec.get(i).col.getRed()-length));
//		System.out.println("vec-red: " + vec.get(i).col.getRed() + " vec-green: " + vec.get(i).col.getGreen() + " vec-blue: " + vec.get(i).col.getBlue());
//		System.out.println("col-red: " + redCol.get(redPos).col.getRed() + " vec-green: " + redCol.get(redPos).col.getGreen() + " vec-blue: " + redCol.get(redPos).col.getBlue());
		helplength = distance(vec.get(i).col.getRed() - redCol.get(redPos).col.getRed(), 
				vec.get(i).col.getGreen() - redCol.get(redPos).col.getGreen(), 
				vec.get(i).col.getBlue() - redCol.get(redPos).col.getBlue());
		if(helplength < length){
			length = helplength;
			colPos = redCol.get(redPos).vecPos;
		}
		
		greenPos = GreenfindShortestDistance(greenCol, vec, i, length, (int)(vec.get(i).col.getGreen()-length));
		helplength = distance(vec.get(i).col.getRed() - greenCol.get(greenPos).col.getRed(), 
				vec.get(i).col.getGreen() - greenCol.get(greenPos).col.getGreen(), 
				vec.get(i).col.getBlue() - greenCol.get(greenPos).col.getBlue());	
		if(helplength < length){
			length = helplength;
			colPos = greenCol.get(greenPos).vecPos;
		}
		
		bluePos = BluefindShortestDistance(blueCol, vec, i, length, (int)(vec.get(i).col.getBlue()-length));
		helplength = distance(vec.get(i).col.getRed() - blueCol.get(bluePos).col.getRed(), 
				vec.get(i).col.getGreen() - blueCol.get(bluePos).col.getGreen(), 
				vec.get(i).col.getBlue() - blueCol.get(bluePos).col.getBlue());
		if(helplength < length){
			length = helplength;
			colPos = blueCol.get(bluePos).vecPos;
		}
		
		
		
		// 4. Zur�ckgeben
		return colPos;
	}

	private static int binSearch(Vector<ValueColor> vecCol,
			Vector<SaveTheValues> vec, int i, int choice) {
		int iL = 0;
		int iR = vecCol.size() - 1;
		int count = 1;
		//1. Den ersten Anteil fstance(redCol.get(colPos).col.getRed(), redCol.get(colPos).col.getGreen(), redCol.get(colPos).col.getBlue());
//		colPos = Grinden ... Choice: 0 = Red, 1 = Green, 2 = Blue 
		switch(choice){
		case 0: return RedBinSearch(iL, iR, i, count, 0, vecCol, vec);
		case 1: return GreenBinSearch(iL, iR, i, count, 0, vecCol, vec);
		case 2: return BlueBinSearch(iL, iR, i, count, 0, vecCol, vec);
		}
		return 0;
	}

	private static int RedBinSearch(int iLeft, int iRight, int i, int count, int vecPos, Vector<ValueColor> vecCol, Vector<SaveTheValues> vec){
		int iL = iLeft;
		int iR = iRight;
		
		
		while(iL < iR) {
			int MIDDLE = (iL + iR) / 2;
			 
			/**
			 * Ist die gesuchte Farbe kleiner bzw. größer als sein Vorgänger/Nachfolger?
			 */
//			System.out.println("i: " + vec.get(i).col.getRed() + " | MIDDLE: " + vecCol.get(MIDDLE).col.getRed() + " | MIDDLE+1: " + vecCol.get(MIDDLE+1).col.getRed());
			if (vec.get(i).col.getRed() >= vecCol.get(MIDDLE).col.getRed() && vec.get(i).col.getRed() <= vecCol.get(MIDDLE+1).col.getRed()){
				/**
				 * Ist der rote Anteil der gefundenen Farbe == oder < bzw > ?
				 */
//				vecPos = vecCol.get(MIDDLE).vecPos;
				vecPos = MIDDLE;	
//				if(vec.get(i).col.getRed() == 0) 
//					System.out.println("STOP");
				if(vec.get(i).col.getRed() == vecCol.get(MIDDLE).col.getRed()){
					while(MIDDLE-1 > -1 && vecCol.get(MIDDLE-1) != null && vecCol.get(MIDDLE-1).col.getRed() == vec.get(i).col.getRed()){	
						--MIDDLE;
//						System.out.println(MIDDLE + " | " + vecCol.get(MIDDLE).col.getRed() +  " | " + vec.get(i).col.getRed());
//						if(MIDDLE < 0) System.out.println("MIDDLE kleiner 0" + MIDDLE + " i: " + i + " vecRed: " + vec.get(i).col.getRed());
					}
					iL = MIDDLE; 
					while(MIDDLE+1 < vecCol.size() && vecCol.get(MIDDLE+1) != null && vecCol.get(MIDDLE+1).col.getRed() == vec.get(i).col.getRed())
						++MIDDLE;
					iR = MIDDLE;
					
					if(count < 3) vecPos = GreenBinSearch(iL, iR, i, ++count, vecPos, vecCol, vec);
					return vecPos;
					
				} else if(vec.get(i).col.getRed() == vecCol.get(MIDDLE+1).col.getRed()){
					iL = MIDDLE + 1;
					while(MIDDLE+1 < vecCol.size() && vecCol.get(MIDDLE+1) != null && vecCol.get(MIDDLE+1).col.getRed() == vec.get(i).col.getRed())
						++MIDDLE;
					iR = MIDDLE;
					if (count < 3) vecPos = GreenBinSearch(iL, iR, i, ++count, vecPos, vecCol, vec);
					return vecPos; 
					
				} else
					return vecPos;
			} else if(vecCol.get(MIDDLE).col.getRed() < vec.get(i).col.getRed())
				iL = MIDDLE + 1;
			else 
				iR = MIDDLE - 1;
		}
		return vecPos;
	}
	
	private static int GreenBinSearch(int iLeft, int iRight, int i, int count, int vecPos, Vector<ValueColor> vecCol, Vector<SaveTheValues> vec){
		int iL = iLeft;
		int iR = iRight;
		
		while(iL < iR) {
			int MIDDLE = (iL + iR) / 2;
			/**
			 * Ist die gesuchte Farbe kleiner bzw. größer als sein Vorgänger/Nachfolger?
			 */
//			System.out.println("i: " + vec.get(i).col.getGreen() + " | MIDDLE: " + vecCol.get(MIDDLE).col.getGreen() + " | MIDDLE+1: " + vecCol.get(MIDDLE+1).col.getGreen());
			if (vec.get(i).col.getGreen() >= vecCol.get(MIDDLE).col.getGreen() && vec.get(i).col.getGreen() <= vecCol.get(MIDDLE+1).col.getGreen()){
				/**
				 * Ist der rote Anteil der gefundenen Farbe == oder < bzw > ?
				 */
				vecPos = MIDDLE;
				if(vec.get(i).col.getGreen() == vecCol.get(MIDDLE).col.getGreen()){
					while(MIDDLE-1 > -1 && vecCol.get(MIDDLE-1) != null && vecCol.get(MIDDLE-1).col.getGreen() == vec.get(i).col.getGreen()){
						--MIDDLE;
					}
					iL = MIDDLE; 
					while(MIDDLE+1 < vecCol.size() && vecCol.get(MIDDLE+1) != null && vecCol.get(MIDDLE+1).col.getGreen() == vec.get(i).col.getGreen())
						++MIDDLE;
					iR = MIDDLE;
					if(count < 3) vecPos = BlueBinSearch(iL, iR, i, ++count, vecPos, vecCol, vec);
					return vecPos;
					
				} else if(vec.get(i).col.getGreen() == vecCol.get(MIDDLE+1).col.getGreen()){
					iL = MIDDLE + 1;
					while(MIDDLE+1 < vecCol.size() && vecCol.get(MIDDLE+1) != null && vecCol.get(MIDDLE+1).col.getGreen() == vec.get(i).col.getGreen())
						++MIDDLE;
					iR = MIDDLE;
					if (count < 3) vecPos = BlueBinSearch(iL, iR, i, ++count, vecPos, vecCol, vec);
					return vecPos; 
					
				} else
					return vecPos;
			} else if(vecCol.get(MIDDLE).col.getGreen() < vec.get(i).col.getGreen())
				iL = MIDDLE + 1;
			else 
				iR = MIDDLE - 1;
		}
		return vecPos;
	}
	
	private static int BlueBinSearch(int iLeft, int iRight, int i, int count, int vecPos, Vector<ValueColor> vecCol, Vector<SaveTheValues> vec){
		int iL = iLeft;
		int iR = iRight;
		
		while(iL < iR) {
			int MIDDLE = (iL + iR) / 2;
			/**
			 * Ist die gesuchte Farbe kleiner bzw. größer als sein Vorgänger/Nachfolger?
			 */
//			System.out.println("i: " + vec.get(i).col.getBlue() + " | MIDDLE: " + vecCol.get(MIDDLE).col.getBlue() + " | MIDDLE+1: " + vecCol.get(MIDDLE+1).col.getBlue());
			if (vec.get(i).col.getBlue() >= vecCol.get(MIDDLE).col.getBlue() && vec.get(i).col.getBlue() <= vecCol.get(MIDDLE+1).col.getBlue()){
				/**
				 * Ist der rote Anteil der gefundenen Farbe == oder < bzw > ?
				 */
				vecPos = MIDDLE;
				if(vec.get(i).col.getBlue() == vecCol.get(MIDDLE).col.getBlue()){
					while(MIDDLE-1 > -1 && vecCol.get(MIDDLE-1) != null && vecCol.get(MIDDLE-1).col.getBlue() == vec.get(i).col.getBlue()){
						--MIDDLE;
					}
					iL = MIDDLE; 
					while(MIDDLE+1 < vecCol.size() &&vecCol.get(MIDDLE+1) != null && vecCol.get(MIDDLE+1).col.getBlue() == vec.get(i).col.getBlue())
						++MIDDLE;
					iR = MIDDLE;
					if(count < 3) vecPos = RedBinSearch(iL, iR, i, ++count, vecPos, vecCol, vec);
					return vecPos;
					
				} else if(vec.get(i).col.getBlue() == vecCol.get(MIDDLE+1).col.getBlue()){
					iL = MIDDLE + 1;
					while(MIDDLE+1 < vecCol.size() && MIDDLE+1 < vecCol.size() && vecCol.get(MIDDLE+1) != null && vecCol.get(MIDDLE+1).col.getBlue() == vec.get(i).col.getBlue())
						++MIDDLE;
					iR = MIDDLE;
					if (count < 3) vecPos = RedBinSearch(iL, iR, i, ++count, vecPos, vecCol, vec);
					return vecPos; 
					
				} else
					return vecPos;
			} else if(vecCol.get(MIDDLE).col.getBlue() < vec.get(i).col.getBlue())
				iL = MIDDLE + 1;
			else 
				iR = MIDDLE - 1;
		}
		if(count == 2) return vecPos;
		return vecPos;
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
	
	// In dieser Methode wird der Bereich innerhalb der Farbvektoren gechekct, ob es k�rzere gibt!
	// colVec = Farbvektor, length = die momentan kürzeste länge, colPos = Rotwert(des gesuchten) - length
	private static int RedfindShortestDistance(Vector<ValueColor> colVec, Vector<SaveTheValues> vec, int i, double length, int colPos){
		// Mithilfe der Bin�ren Suche den lenVal-length finden !
//		int pos = findLenValLength(colVec, (int)(colPos-length), 0);
		int pos = findRedPos(colVec, colPos);
		int returnPos = pos;
		double lengthHelp; 
//		if(colVec.get(pos).col.getRed() >= (int)(colPos) && colVec.get(pos).col.getRed() <= (int)(colPos+2*length)){
		if(colVec.get(pos).col.getRed() >= (int)(colPos)){
//			System.out.println("pos: " + colVec.get(pos).col.getRed() + " | colPos" + colPos);
			while(pos < colVec.size() && colVec.get(pos).col.getRed() < ((int)(colPos+2*length))){
//				System.out.println("pos: " + colVec.get(pos).col.getRed() + " | colPos: " + colPos);
				lengthHelp = distance(vec.get(i).col.getRed() - colVec.get(pos).col.getRed(), 
						vec.get(i).col.getGreen() - colVec.get(pos).col.getGreen(), 
						vec.get(i).col.getBlue() - colVec.get(pos).col.getBlue());
				if(lengthHelp < length) {
					returnPos = pos;
					length = lengthHelp;
				}
				++pos;				
			}
		} 
		
		return returnPos;
	}
	
	private static int findRedPos(Vector<ValueColor> colVec, int findPoint){
		int iL = 0;
		int iR = colVec.size() - 1;
		int vecPos = 0;
		while(iL <= iR){
			int MIDDLE = (iL + iR) / 2;
//			System.out.println("findPoint: " + findPoint + " | MIDDLE: " + colVec.get(MIDDLE).col.getRed() + " | MIDDLE+1: " + colVec.get(MIDDLE+1).col.getRed());
			if(findPoint >= colVec.get(MIDDLE).col.getRed() && findPoint <= colVec.get(MIDDLE+1).col.getRed()){
//			if(colVec.get(findPoint).col.getRed() >= colVec.get(MIDDLE).col.getRed() && colVec.get(findPoint).col.getRed() <= colVec.get(MIDDLE+1).col.getRed()){
				vecPos = MIDDLE;
//				System.out.println(findPoint);
				if(findPoint == colVec.get(MIDDLE).col.getRed()){
 					while(MIDDLE-1 > -1 && colVec.get(MIDDLE-1) != null && colVec.get(MIDDLE-1).col.getRed() == findPoint)
						--MIDDLE;
					vecPos = MIDDLE;
					return vecPos;
				} else if(findPoint == colVec.get(MIDDLE+1).col.getRed()){
					vecPos = MIDDLE;
					return vecPos; 					
				} else
					return vecPos; 
			} else if(colVec.get(MIDDLE).col.getRed() < findPoint)
				iL = MIDDLE + 1;
			else 
				iR = MIDDLE - 1;
		}
		return vecPos;
	}
	
	private static int GreenfindShortestDistance(Vector<ValueColor> colVec, Vector<SaveTheValues> vec, int i, double length, int colPos){
		// Mithilfe der Bin�ren Suche den lenVal-length finden !
//		if (colPos < 0) System.out.println("Value kleiner Null: " + colPos);
		int pos = findGreenPos(colVec, colPos);
		int returnPos = pos;
		double lengthHelp;
		if(colVec.get(pos).col.getGreen() >= (int)(colPos)){
//			System.out.println("pos: " + colVec.get(pos).col.getGreen() + " | colPos" + colPos);
			while(pos < colVec.size() && colVec.get(pos).col.getGreen() < ((int)(colPos+2*length))){
//				System.out.println("pos: " + colVec.get(pos).col.getGreen() + " | colPos" + colPos);
				lengthHelp = distance(vec.get(i).col.getRed() - colVec.get(pos).col.getRed(), 
						vec.get(i).col.getGreen() - colVec.get(pos).col.getGreen(), 
						vec.get(i).col.getBlue() - colVec.get(pos).col.getBlue());
				if(lengthHelp < length) {
					returnPos = pos;
					length = lengthHelp;
				}
				++pos;				
			}
		}
		return returnPos;
	}
	
	private static int findGreenPos(Vector<ValueColor> colVec, int findPoint){
		int iL = 0;
		int iR = colVec.size() - 1;
		int vecPos = 0;
		while(iL <= iR){
			int MIDDLE = (iL + iR) / 2;
//			System.out.println("findPoint: " + findPoint + " | MIDDLE: " + colVec.get(MIDDLE).col.getGreen() + " | MIDDLE+1: " + colVec.get(MIDDLE+1).col.getGreen());
			if(findPoint >= colVec.get(MIDDLE).col.getGreen() && findPoint <= colVec.get(MIDDLE+1).col.getGreen()){
				vecPos = MIDDLE;
				if(findPoint == colVec.get(MIDDLE).col.getGreen()){
					while(MIDDLE-1 > -1 && colVec.get(MIDDLE-1) != null && colVec.get(MIDDLE-1).col.getGreen() == findPoint)
						--MIDDLE;
					vecPos = MIDDLE;
					return vecPos;
				} else if(findPoint == colVec.get(MIDDLE+1).col.getGreen()){
					vecPos = MIDDLE;
					return vecPos; 					
				} else
					return vecPos; 
			} else if(colVec.get(MIDDLE).col.getGreen() < findPoint)
				iL = MIDDLE + 1;
			else 
				iR = MIDDLE - 1;
		}
		return vecPos;
	}
	
	private static int BluefindShortestDistance(Vector<ValueColor> colVec, Vector<SaveTheValues> vec, int i, double length, int colPos){
		// Mithilfe der Bin�ren Suche den lenVal-length finden !
		int pos = findBluePos(colVec, colPos);
		int returnPos = pos;
		double lengthHelp; 
		if(colVec.get(pos).col.getBlue() >= (int)(colPos)){
//			System.out.println("pos: " + colVec.get(pos).col.getBlue() + " | colPos" + colPos);
			while(pos < colVec.size() && colVec.get(pos).col.getBlue() < ((int)(colPos+2*length))){
				lengthHelp = distance(vec.get(i).col.getRed() - colVec.get(pos).col.getRed(), 
						vec.get(i).col.getGreen() - colVec.get(pos).col.getGreen(), 
						vec.get(i).col.getBlue() - colVec.get(pos).col.getBlue());
				if(lengthHelp < length){
					returnPos = pos;
					length = lengthHelp;
				}
				++pos;				
			}
		}
		return returnPos;
	}
	
	private static int findBluePos(Vector<ValueColor> colVec, int findPoint){
		int iL = 0;
		int iR = colVec.size() - 1;
		int vecPos = 0;
		while(iL <= iR){
			int MIDDLE = (iL + iR) / 2;
//			System.out.println("findPoint: " + findPoint + " | MIDDLE: " + colVec.get(MIDDLE).col.getRed() + " | MIDDLE+1: " + colVec.get(MIDDLE+1).col.getRed());
			if(findPoint >= colVec.get(MIDDLE).col.getRed() && findPoint <= colVec.get(MIDDLE+1).col.getRed()){
				vecPos = MIDDLE;
				if(findPoint == colVec.get(MIDDLE).col.getRed()){
					while(MIDDLE-1 > -1 && colVec.get(MIDDLE-1) != null && colVec.get(MIDDLE-1).col.getBlue() == findPoint)
						--MIDDLE;
					vecPos = MIDDLE;
					return vecPos;
				} else if(findPoint == colVec.get(MIDDLE+1).col.getBlue()){
					vecPos = MIDDLE;
					return vecPos; 					
				} else
					return vecPos; 
			} else if(colVec.get(MIDDLE).col.getBlue() < findPoint)
				iL = MIDDLE + 1;
			else 
				iR = MIDDLE - 1;
		}
		return vecPos;
	}	
}
