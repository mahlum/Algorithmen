import java.util.Stack;
import java.util.Vector;

/**
 * Get name.
 * @author peters
 * 
 */
public class Distance implements iDist{
	private Integer[] field;
	private Stack<Integer> fillDistance;
	private boolean trfl;
	private int[] dist;
	
	public void setValues(int values, int choice) {
		field = new Integer[values];
		switch (choice) {
		case 1:
			for (int i = values-1; i > -1; --i)
				field[i] = i;
			break;
		case 2:
			for (int i = 0; i < values; ++i)
				field[i] = (int) (Math.random() * 1000000);
			break;
		case 3:
			for (int i = 0; i < values; ++i)
				field[i] = i;
			break;
		}
		
	}
	
	public void sortIt(){
		shellsort.shell_sort(field, dist);
	}
	
	
	private static long fib(int a) {
		if (a == 1 || a == 2)
			return 1;
		else
			return fib(a - 1) + fib(a - 2);
	}
	
	private static long sed(int a) {
		return (long)(Math.pow(4, (a+1))+ 3 * Math.pow(2, a) + 1);
	}
	
	private static long knu(int a){
		return (long)((Math.pow(3, a)- 1)/2);
	}
	
	private static long she(int a){
		return (long)(Math.pow(2, a));
	}
	
	private void toInt(){
		dist = new int[fillDistance.size()];
		int i = 0;
		while(!fillDistance.isEmpty()){
			dist[i++] = fillDistance.lastElement();
			fillDistance.pop();
		}
	}
	
	@Override
	public void calcFibo() {
		// erstmal die Fibonacci-Folge füllen
		fillDistance = new Stack<Integer>();
		trfl = true;
		int i = 0;
		while (trfl) {
			if (i == 0)
				fillDistance.push((int) fib(1));
			else
				fillDistance.add((int) fib(i));
			if (fillDistance.lastElement() > field.length) {
				trfl = false;
				fillDistance.pop();
				fillDistance.remove(fillDistance.firstElement());
				fillDistance.remove(fillDistance.firstElement());
			}
			++i;
		}
		toInt();
	}
	
	@Override
	public void calcSedgewick() {
		fillDistance = new Stack<Integer>();
		trfl = true;
		int i = 0;
		fillDistance.push(1);
		while(trfl) {
			fillDistance.push((int)sed(i));
			if(fillDistance.lastElement() > field.length){
				trfl = false;
			}
			++i;
		}
		toInt();
	}

	@Override
	public void calcKnuth() {
		fillDistance = new Stack<Integer>();
		trfl = true;
		int i = 0;
		fillDistance.push(1);
		while(trfl) {
			fillDistance.push((int)knu(i));
			if(fillDistance.lastElement() > field.length){
				trfl = false;
			}
			++i;
		}
		toInt();
	}

	@Override
	public void calcShell(){
		fillDistance = new Stack<Integer>();
		trfl = true;
		int i = 0;
		while(trfl) {
			fillDistance.push((int)she(i));
			if(fillDistance.lastElement() > field.length){
				trfl = false;
			}
			++i;
		}
		toInt();
	}
}
