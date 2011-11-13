package values;

import java.util.Stack;
import distributionCounting.*;

public class GenerateValues {
	private int[] field, count;
	
	public void setValues(int values, int choice, int m) {
		field = new int[values];
		switch (choice) {
		case 1:
			for (int i = values-1; i > -1; --i)
				field[i] = i;
			break;
		case 2:
			for (int i = 0; i < values; ++i)
				field[i] = (int) (Math.random() * m);
			break;
		case 3:
			for (int i = 0; i < values; ++i)
				field[i] = i;
			break;
		}
		
	}
	
	public boolean isSorted(){
		boolean sorted = true;
		for(int i = 0; i < field.length-1; ++i)
			if(field[i+1] < field[i])
				sorted = false;
		return sorted;
	}
	
	public void sortIt(int j){
		count = DistributionCounting.distribution_counting(field, j);
	}
	
	public int[] getCount() {
		return count;
	}

	public void setCount(int[] count) {
		this.count = count;
	}
	
	public int getCountValue(int i){
		if(i < count.length && i > -1)
			return count[i];
		else
			return 0;
	}

	public int[] getField() {
		return field;
	}

	public void setField(int[] field) {
		this.field = field;
	}
	
	public Integer getFieldValue(int i){
		if(i < field.length && i > -1)
			return field[i];
		else
			return 0;
	}
	
}
