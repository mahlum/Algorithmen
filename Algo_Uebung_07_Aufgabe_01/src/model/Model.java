package model;

import java.awt.Point;
import java.util.*;

public class Model {
	Vector<SaveTheValues> vec;
	public int[] m_Pix;
	
	public Model(){
		
	}
	
	//Erstmal den Vector anlegen mit der jeweiligen Anzahl der Farben! 
	public void countColors(int[] m_Pix, int W, int H){
		vec = new Vector<SaveTheValues>(1000,10000);
		this.m_Pix = new int[m_Pix.length];
		//Füllen des m_Pix, das komprimiert werden soll
		for(int i = 0; i < m_Pix.length; ++i)
			this.m_Pix[i] = m_Pix[i];
		// nun die einzelnen Farbpunkte durchgehen und den Vector füllen
		for (int y = 0; y < H; ++y) {
			for (int x = 0; x < W; ++x) {
				boolean done = false;
				for (int i = 0; i < vec.size(); ++i) {
					if (vec.get(i).colVal == this.m_Pix[y * W + x]) {
						++vec.get(i).count;
						vec.get(i).ls.add(new Point(x, y));
						done = true;
					}
				}
				if (done == false) {
					vec.add(new SaveTheValues(this.m_Pix[y * W + x], x, y));
				}
			}
			System.out.print(y + " ");
			if(y % 50 == 0) System.out.println();
		}
		System.out.println();
	}
	
	// Nun den Vector sortieren mit dem geänderten Quicksort 
	// evtl. sollte noch eine "Choice für die einzelnen Farbwerte eingesetzt werden... mal sehen
	public void sortColors(){
		Quicksort.quick_sort(vec);
		outputSortedColors();
	}
	
	// Zur Sicherheit die Sortierten Farben ausgeben ! 
	private void outputSortedColors() {
		System.out.println("Farbe\t\t\t\t\tRot\t\tGrün\t\tBlau\t\tAnzahl");
		for (int i = 0; i < vec.size(); ++i) {
			System.out.print(vec.get(i).col + "\t\t\t"
					+ vec.get(i).col.getRed() + "\t\t"
					+ vec.get(i).col.getGreen() + "\t\t"
					+ vec.get(i).col.getBlue() + "\t\t" + vec.get(i).count
					+ "\n");
		}
	}
	
	// Nun das "Bild" komprimieren ! Dazu den Sortierten Vector übergeben und 
	// die Länge des m_Pix sowie die Höhe und Breite des Bildes (W,H)
	public void compress(int W, int H){
		this.m_Pix = CompressPic.compress(vec, m_Pix.length, W, H);
	}
}
