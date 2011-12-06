package start;

import interpolationSearch.*;

public class StartIntpolationSearch {
	public static void main(String[] args){
		Integer[] field = {2, -1, 15, 5, 44, 12, -10, 8, 50, 33};
		String[] strField = {"Anthea", "Timo", "Malte", "Juergen", "Guenther", "Sky", "Rene", "Samsung", "Nokia", "iPhone"};
		InterpolationSearch<Integer, String> binSearch = new InterpolationSearch<Integer, String>(field.length);
		for(int i = 0; i < field.length; ++i)
			binSearch.insert(field[i], strField[i]);
		binSearch.search_help(33);
	}
}
