package interpolationSearch;

public class StringDistance {
	public static<K extends Comparable<K>> int calcMiddle(K keyone, K keytwo){
		char[] charKeyL = keyone.toString().toUpperCase().toCharArray();
		char[] charKeyR = keytwo.toString().toUpperCase().toCharArray();
		return charKeyL[0] - charKeyR[0];
	}
}
