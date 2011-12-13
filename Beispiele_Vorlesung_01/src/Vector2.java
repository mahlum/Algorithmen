import java.util.*;

public class Vector2 {
	public static void main(String[] args){
		Vector<Integer> test = new Vector<Integer>(100);
		Vector<Integer> test2 = new Vector<Integer>(100);
		for(int i = 0; i < 100; ++i)
			test.add(i);
		for(int i = 0; i < test.size() ; i++) 
			System.out.print(test.get(i) + " ");
		System.out.println();
		for(int i = test.size()/2+1; i < test.size(); ++i)
			test2.add(i);
		for(int i = 0; i < test2.size() ; i++) 
			System.out.print(test2.get(i) + " ");
		
		
	}
}
