/**
 * Juhu es get
 * ht 
 * 
 * ht :D
 */
import Values.*;

public class Start {
	public static void main(String[] args){
		GenerateValues val = new GenerateValues();
		long timeStart, timeEnd;
		try{
			Thread.sleep(3000);
		}catch(InterruptedException e){
			
		}
		
		
		for(int i = 1; i < 4; ++i){
			for(int j = 0; j < 4; ++j){
				val.setValues(100, i);
				timeStart = System.currentTimeMillis();
				val.sortIt(j);
				timeEnd = System.currentTimeMillis();
				System.out.println((timeEnd - timeStart) + " mSec bei " + i + ".ter Choice");
			}
//			for(int j = 30; j < 65; ++j){
//				System.out.print(val.getFieldValue(i) + " ");
//			}
			System.out.println("");
			System.out.println("---------");
		}
		
		
		
	}
}
