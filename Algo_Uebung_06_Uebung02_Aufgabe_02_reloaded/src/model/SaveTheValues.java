package model;

import java.awt.Color;
import java.awt.Point;
import java.util.LinkedList;

public class SaveTheValues {
		int colVal;
		Color col;
		int count;
		Point point;
		LinkedList<Point> ls = new LinkedList<Point>();
		
		public SaveTheValues(int colVal, int x, int y){
			this.colVal = colVal;
			col = new Color(colVal);
			count = 0;
			point = new Point(x,y);
			ls.add(point);
		}
	
}


