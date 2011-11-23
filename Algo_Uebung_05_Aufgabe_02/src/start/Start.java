package start;

import generateValues.*;

public class Start {
	public static void main(String[] args){
		GenerateValues g = new GenerateValues();
		int values = 10000000;
//		int values = 5000000;
		long timeStart, timeEnd;
		g.genValues(values);
		System.out.println("invers \t\t\t random \t\t\t sorted");
		for(int i = 0; i < 3; ++i){
			g.sortValues(i);
			timeStart = System.currentTimeMillis();
			g.sortIt(true);
			timeEnd = System.currentTimeMillis();
			System.out.print(timeEnd - timeStart + " mSec ");
			System.out.print(g.isSorted() + "\t\t ");
			g.reset();
		}
		System.out.println();
		for(int i = 0; i < 3; ++i){
			g.sortValues(i);
			timeStart = System.currentTimeMillis();
			g.sortIt(false);
			timeEnd = System.currentTimeMillis();
			System.out.print(timeEnd - timeStart + " mSec ");
			System.out.print(g.isSorted() + "\t\t ");
			g.reset();
		}

			
	}
}
