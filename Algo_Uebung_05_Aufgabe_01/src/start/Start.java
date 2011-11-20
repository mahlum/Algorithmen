package start;

import generateValues.*;

public class Start {
	public static void main(String[] args){
		GenerateValues g = new GenerateValues();
		int values = 1500000;
		long timeStart, timeEnd;
		g.genValues(values);
		System.out.println("invers \t\t\t random \t\t sorted");
		for(int i = 0; i < 3; ++i){
			g.sortValues(i);
			timeStart = System.currentTimeMillis();
			g.sortIt();
			timeEnd = System.currentTimeMillis();
			System.out.print(timeEnd - timeStart + " mSec ");
			System.out.print(g.isSorted() + "\t\t ");
			g.reset();
		}
		
	}
}
