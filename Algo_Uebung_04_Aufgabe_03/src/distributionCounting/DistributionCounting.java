package distributionCounting;

public class DistributionCounting {
	
	public static int[] distribution_counting(int[] field, int m){
		int[] count = new int[m];
		RangeCount[] range = new RangeCount[2];
		calcRange(field, range);
		
//		int[] count1 = new int[Math.abs(range[0].getMax()-range[0].getMin())];
//		int[] count2 = new int[Math.abs(range[1].getMax()-range[1].getMin())];
		int[] count1 = new int[m];
		int[] count2 = new int[m];
		
//		for(int i = 0; i < m; ++i){
//			count[i] = 0;
//		}
		for(int i = 0; i < field.length; ++i){
			if(field[i] < range[0].getMax())
				++count1[Math.abs(range[0].getMin()-field[i])];
			else
				++count2[Math.abs(range[1].getMin()-field[i])];
//			++count[field[i]];
		}
		for(int i1 = 0, i2 = 0; i1 < m; ++i1){
			for(int i3 = 0; i3 < count1[i1]; ++i3){
				field[i2++] = count1[i1];
			}
			i2 = 0;
			for(int i3 = 0; i3 < count2[i1]; ++i3){
				field[i2++ + count1.length] = count2[i1];
			}
		}
		return count;
	}
	
	public static void calcRange(int[] field, RangeCount[] r){
		int range1min = field[0], range2max = field[0], range1max, range2min;
		int[] range = new int[4];
		for(int i = 0; i < field.length; ++i){
			if(field[i] < range1min)
				range1min = field[i];
			if(field[i] > range2max)
				range2max = field[i];
		}
		
		range1max = range1min;
		range2min = range2max;
		
		for(int i = 0; i < field.length; ++i){
			if(field[i] < range2min && field[i] > range1max)
				if((Math.abs(range1min - field[i])) <= (Math.abs(range2max - field[i])))
					range1max = field[i];
				 else
					range2min = field[i];
		}
		
		r[0] = new RangeCount(range1min, range1max);
		r[1] = new RangeCount(range2min, range2max);
	}
	
		
}
