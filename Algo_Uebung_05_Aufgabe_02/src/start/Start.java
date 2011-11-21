package start;

import generateValues.*;

public class Start {
	public static void main(String[] args){
		GenerateValues g = new GenerateValues();
		int values = 10;
		long timeStart, timeEnd;
//		g.genValues(values);
		g.genIntValues(values);
//		System.out.println("invers \t\t\t random \t\t\t sorted");
//		for(int i = 0; i < 3; ++i){
//			g.sortValues(i);
//			timeStart = System.currentTimeMillis();
		g.sortIntIt(0);
//			timeEnd = System.currentTimeMillis();
//			System.out.print(timeEnd - timeStart + " mSec ");
		System.out.print(g.isIntSorted() + "\t\t ");
//			g.reset();
		System.out.println("\n==========================");
		System.out.println("==========================");
		System.out.println("==========================");
		System.out.println("==========================");
		g.resetInt();
		g.sortIntIt(1);
		System.out.print(g.isIntSorted() + "\t\t ");
//		}
			
	}
}
