/**
 * Mal sehen, ob Git mich jetzt wieder enttaeuscht ...
 * Author: Timo Peters
 * Date: 2011-11-14
 * Comment: ---
 */


package start;
import values.*;


public class Start {
	public static void main(String[] args){
		GenerateValues val = new GenerateValues();
		int m = 1000000;
		long timeStart, timeEnd;
		try{
			Thread.sleep(3000);
		}catch(InterruptedException e){
		}		
		val.setValues(20000000, 2, m);
		timeStart = System.currentTimeMillis();
		val.sortIt(m);
		timeEnd = System.currentTimeMillis();
		System.out.println((timeEnd - timeStart) + " mSec bei 2.ter Choice");
//		for(int i = 0; i < 800; ++i){
//			System.out.print(i + "\t");
//		}
//		System.out.println();
//		for(int i = 0; i < 800; ++i){
//			System.out.print(val.getCountValue(i)+ "\t");
//		}
		System.out.println(val.isSorted());
	
//		System.out.println("Liste sortiert: " + val.isSorted());
	}
}
