package distributionCounting;

public class DistributionCounting {
	
	public static int[] distribution_counting(int[] field, int m){
		int[] count = new int[m];
		for(int i = 0; i < m; ++i){
			count[i] = 0;
		}
		for(int i = 0; i < field.length; ++i){
			++count[field[i]];
		}
		for(int i1 = 0, i2 = 0; i1 < m; ++i1){
			for(int i3 = 0; i3 < count[i1]; ++i3){
				field[i2++] = i1;
			}
		}
		return count;
	}
		
}
