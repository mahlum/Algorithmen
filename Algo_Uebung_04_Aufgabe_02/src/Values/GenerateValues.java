package Values;

import java.util.Stack;
import quicksort.*;

public class GenerateValues {
	private Integer[] field;
	
	public void setValues(int values, int choice) {
		field = new Integer[values];
		switch (choice) {
		case 1:
			for (int i = values-1; i > -1; --i)
				field[i] = i;
			break;
		case 2:
			for (int i = 0; i < values; ++i)
				field[i] = (int) (Math.random() * 5000000);
			break;
		case 3:
			for (int i = 0; i < values; ++i)
				field[i] = i;
			break;
		}
		
	}
	
	public void sortIt(int j){
		Quicksort.quick_sort(field, j);
	}
	
	public Integer getFieldValue(int i){
		if(i < field.length && i > -1)
			return field[i];
		else
			return 0;
	}

	public Integer[] getField() {
		return field;
	}

	public void setField(Integer[] field) {
		this.field = field;
	}
	
	
}
