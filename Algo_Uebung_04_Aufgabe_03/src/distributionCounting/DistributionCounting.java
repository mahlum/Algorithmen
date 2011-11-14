package distributionCounting;

public class DistributionCounting {
	
	public static int[] distribution_counting(int[] field, int m){
		int[] count = new int[m];
		int[] range = new int[4];
		range = calcRange(field);
		
		int[] count1 = new int[Math.abs(range[1]-range[0])];
		int[] count2 = new int[Math.abs(range[3]-range[2])];
		
//		for(int i = 0; i < m; ++i){
//			count[i] = 0;
//		}
		for(int i = 0; i < field.length; ++i){
			if(field[i] < range[1])
				++count1[Math.abs(range[0]-field[i])];
			else
				++count2[Math.abs(range[2]-field[i])];
//			++count[field[i]];
		}
		for(int i1 = 0, i2 = 0; i1 < m; ++i1){
			for(int i3 = 0; i3 < count[i1]; ++i3){
				field[i2++] = i1;
			}
		}
		return count;
	}
	
	public static int[] calcRange(int[] field){
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
		range[0] = range1min;
		range[1] = range1max;
		range[2] = range2min;
		range[3] = range2max;
		
		return range;
	}
	
		
}
