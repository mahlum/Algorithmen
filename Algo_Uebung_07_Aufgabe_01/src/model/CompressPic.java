package model;

import java.util.Vector;

public class CompressPic {
	public static int[] compress(Vector<SaveTheValues> vec, int length, int W, int H){
		//Leeren m_Pix mit der L�nge des �bergebenen m_Pix anlegen
		int[] m_Pix = new int[length];
		// Wieviele Farben gibt es denn eigentlich?
		System.out.println(vec.size() + " verschiedene Farben! 50% davon sind: " + vec.size()/2);
		//Nun muss erstmal f�r die drei Farbwerte drei Vectoren angelegt werden, die 
		//nur die Farben beinhalten, die sp�ter "behalten" werden sollen!
		//1. 3 neue Vectoren f�r Rot, Gr�n und Blau anlegen! 
		Vector<ValueColor> redCol = new Vector<ValueColor>(vec.size()/2, 100);
		Vector<ValueColor> greenCol = new Vector<ValueColor>(vec.size()/2, 100);
		Vector<ValueColor> blueCol = new Vector<ValueColor>(vec.size()/2, 100);
		//2. Die 3 Vectoren mit den jeweiligen Werten f�llen !
		for(int i = vec.size()/2+1; i < vec.size(); ++i){
			redCol.add(new ValueColor(vec.get(i).col, i));
			greenCol.add(new ValueColor(vec.get(i).col, i));
			blueCol.add(new ValueColor(vec.get(i).col, i));
		}
		//3. Die Vectoren m�ssen nun sortiert werden ... Mithilfe des Quicksorts!	
		ColorQuicksort.quick_sort(redCol, 0);
		ColorQuicksort.quick_sort(greenCol, 1);
		ColorQuicksort.quick_sort(blueCol, 2);
		
//		outputColors(redCol);
//		System.out.println("STOOOOOOOOOP");
		
		//4. Nun die jeweiligen "�hnlichen" Farben suchen
		for(int i = 0; i <= vec.size()/2; ++i){
			
		}
		
		return null;
	}
	
	private static void outputColors(Vector<ValueColor> vC){
		System.out.println("Rot\tGr�n\tBlau");
		for(int i = 0; i < vC.size(); ++i){
			System.out.print(vC.get(i).col.getRed() + "\t" + vC.get(i).col.getGreen() + "\t" + vC.get(i).col.getBlue() + "\n");
		}
	}
}
