package distributionCounting;

public class RangeCount {
	private int min, max, count = 0;
	
	public RangeCount(int min,int max){
		this.min = min;
		this.max = max;
	}
	
	public void countLength(){
		++count;
	}

	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
	}

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}
	
	
}
