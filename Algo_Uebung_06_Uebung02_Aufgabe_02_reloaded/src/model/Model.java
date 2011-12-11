package model;

import java.awt.Color;
import java.awt.Point;
import java.util.LinkedList;
import java.util.Vector;

public class Model {
	int x, y;
	Vector<SaveTheValues> vec;
	public int[] m_Pix;

	public Model() {
		x = 400;
		y = 700;
	}

	public void countColors(int[] m_Pix, int W, int H) {
		vec = new Vector<SaveTheValues>(100, 100);
		this.m_Pix = new int[m_Pix.length];
		for(int i = 0; i < m_Pix.length; ++i){
			this.m_Pix[i] = m_Pix[i];
		}
		// new with Points Gathering :D
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
			if(y % 70 == 0) System.out.println();
		}
		System.out.println();
	}

	public void sortColors() {
		Quicksort.quick_sort(vec);
		outputSortedColors();
	}

	public void compress(int W) {
		m_Pix = CompressPic.compress(vec, m_Pix.length, W);
	}

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
}

