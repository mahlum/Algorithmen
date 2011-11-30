package start;

import genValues.GenValue;
import binSearch.*;
import interpolationSearch.*;

public class Start {
	public static void main(String[] args){
		final int values = 5000000;
		long timeStart, timeEnd;
		
		GenValue gv = new GenValue();
//		
		// Erstmal Daten füllen und sortieren
		timeStart = System.currentTimeMillis();
//		gv.genIntValues(values);
		gv.genStringValues(values);
		timeEnd = System.currentTimeMillis();
		System.out.println("Zeit: " + (timeEnd - timeStart));
//		
//		
		// Daten ausgeben (Beispiele)
		timeStart = System.currentTimeMillis();
		gv.searchSeq(values);
		timeEnd = System.currentTimeMillis();
		System.out.println("Zeit: " + (timeEnd - timeStart));
//		
		timeStart = System.currentTimeMillis();
		gv.searchStringIt(values);
		timeEnd = System.currentTimeMillis();
		System.out.println("Zeit: " + (timeEnd - timeStart));
		
		//Interpolation Search
		timeStart = System.currentTimeMillis();
		gv.se
		
		// Daten ausgeben Ende
		
		int test = (int)('c' - 'C');
		System.out.println(test);
		
//		Integer o = 13;
//		Integer p = 14;
//		StringDistance.calcDistance(o, p);
		
	
		
	}
}
