package start;

import genValues.GenValue;
import binSearch.*;

public class Start {
	public static void main(String[] args){
		final int values = 5000000;
		long timeStart, timeEnd;
		
		GenValue gv = new GenValue();
		
		// Erstmal Daten füllen und sortieren
		timeStart = System.currentTimeMillis();
//		gv.genIntValues(values);
		gv.genStringValues(values);
		timeEnd = System.currentTimeMillis();
		System.out.println("Zeit: " + (timeEnd - timeStart));
		
		
		// Daten ausgeben (Beispiele)
		timeStart = System.currentTimeMillis();
		gv.searchSeq(values);
		timeEnd = System.currentTimeMillis();
		System.out.println("Zeit: " + (timeEnd - timeStart));
		
		timeStart = System.currentTimeMillis();
		gv.searchStringIt(values);
		timeEnd = System.currentTimeMillis();
		System.out.println("Zeit: " + (timeEnd - timeStart));
		// Daten ausgeben Ende
		
	}
}
