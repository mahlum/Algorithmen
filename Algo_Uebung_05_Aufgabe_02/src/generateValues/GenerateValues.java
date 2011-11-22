package generateValues;

import mergeSort.*;
import quickSort.*;

public class GenerateValues {
	private String[] field;
	private String[] tmpField;
	private Integer[] intField;
	private Integer[] tmpintField;
	
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
	
	public void genIntValues(int values){
		intField = new Integer[values];
		for(int i = 0; i < values; ++i){
			intField[i] = (int)(Math.random()*100+1);
		}
		tmpintField = new Integer[values];
		for(int i = 0; i < values; ++i)
			tmpintField[i] = intField[i];
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
				System.out.print(i + " " + field[i] + " | ");
		}
		System.out.println();
		tmpField = new String[values];
		for(int i = 0; i < values; ++i)
			tmpField[i] = field[i];
	}
	
	public void sortIt(){
		MergeSort.merge_sort(field);
	}
	
	public void sortIntIt(){
		MergeSort.merge_sort(intField);
	}
	
	public void reset(){
		field = tmpField;
	}
	
	public void resetInt(){
		intField = tmpintField;
	}
	
	public boolean isSorted(){
		for(int i = 0; i < field.length-1; ++i)
			if(field[i].compareTo(field[i+1]) > 0)
				return false;
		return true;
	}
	
	public boolean isIntSorted(){
		for(int i = 0; i < intField.length-1; ++i)
			if(intField[i].compareTo(intField[i+1]) > 0)
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
