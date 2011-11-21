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
			field[i] = String.valueOf((char)(Math.random()*26+'A'));
			for(int j = 0; j < (int)(Math.random()*30+5); ++j){
				char tmpChar = (char)(Math.random()*26+'A');
				field[i] = field[i] + String.valueOf(tmpChar);
			}
			if(i % 500000 == 0)
				System.out.println(i);
		}
		tmpField = field;
	}
	
	public void sortIt(){
		HeapSort.sort(field);
	}
	
	public void reset(){
		field = tmpField;
	}
	
	public boolean isSorted(){
		for(int i = 0; i < field.length-1; ++i)
			if(field[i].compareTo(field[i+1]) > 0)
				return false;
		return true;
	}
	
	public String[] getField() {
		return field;
	}

	public void setField(String[] field) {
		this.field = field;
	}

	
}
