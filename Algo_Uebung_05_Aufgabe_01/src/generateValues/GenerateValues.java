package generateValues;

import heapSort.HeapSort;
import quickSort.*;

public class GenerateValues {
	private String[] field;
	private String[] tmpField;
	
	public void sortValues(int choice) {
		switch (choice) {
		case 0:
			Quicksort.quick_sort(field, 0);
			for (int i = 0; i < field.length/2; ++i){
				String tmp = field[i];
				field[i] = field[(field.length-1) - i];
				field[(field.length-1) - i] = tmp;
			}
			break;
		case 1:
			break;
		case 2:
			Quicksort.quick_sort(field, 0);
			break;
		}
		
	}
	
	public void genValues(int values){
		field = new String[values];
		for (int i = 0; i < values; ++i){
			for(int j = 0; j < 15; ++j){
				char tmpChar = (char)(Math.random()*26+'A');
				field[i] = field[i] + String.valueOf(tmpChar);
			}
		}
		tmpField = field;
	}
	
	public void sortIt(){
		HeapSort.sort(field);
	}
	
	public void reset(){
		field = tmpField;
	}
	
	public String[] getField() {
		return field;
	}

	public void setField(String[] field) {
		this.field = field;
	}

	
}
