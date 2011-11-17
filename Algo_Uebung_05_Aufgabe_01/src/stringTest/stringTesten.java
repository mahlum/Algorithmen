package stringTest;

public class stringTesten {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String field = "Hello";
		char test = (char)(Math.random()*26+'A');
		System.out.println(test);
		String tmpfield = String.valueOf(test);
		
		System.out.println(field);
		field = field + tmpfield;
		System.out.println(field);

	}

}
