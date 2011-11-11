import java.util.*;

public class Start {

	public static void main(String[] args) {
		Distance dist = new Distance();
		long timeStart, timeEnd;
		// erst Fibonacci alle drei :)
//		System.out.println("Fibonacci:");
		for (int i = 1; i < 4; ++i) {
			dist.setValues(3000000, i);
			
			dist.calcFibo();
			timeStart = System.currentTimeMillis();
			dist.sortIt();
			timeEnd = System.currentTimeMillis();
			System.out.println("Fibonacci " + i + ": " + (timeEnd - timeStart) + " mSec");
			
			dist.setValues(2000000, i);
			dist.calcSedgewick();
			timeStart = System.currentTimeMillis();
			dist.sortIt();
			timeEnd = System.currentTimeMillis();
			System.out.println("Sedgewick " + i + ": " + (timeEnd - timeStart) + " mSec");
			
			dist.setValues(2000000, i);
			dist.calcKnuth();
			timeStart = System.currentTimeMillis();
			dist.sortIt();
			timeEnd = System.currentTimeMillis();
			System.out.println("Knuth " + i + ": " + (timeEnd - timeStart) + " mSec");
			
			dist.setValues(2000000, i);
			dist.calcShell();
			timeStart = System.currentTimeMillis();
			dist.sortIt();
			timeEnd = System.currentTimeMillis();
			System.out.println("Shell " + i + ": " + (timeEnd - timeStart) + " mSec");
			
			System.out.println("------------------");
			
			
			
		}
	}
}
