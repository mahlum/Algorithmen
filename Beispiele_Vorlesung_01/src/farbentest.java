import java.awt.*;

public class farbentest {
	public static void main(String[] args){
		Color red;
		red = Color.BLUE;
		
		System.out.println(red.getRGB());
		System.out.println(red.getAlpha());
		System.out.println(red.getRed());
		System.out.println(red.getBlue());
		System.out.println(red.getGreen());
		
		double len = 716;
		double dx = 200;
		double dy = 300;
		double x = 0, y = 0;
		
		double erg;
		
		for(int i = 0; i < len; ++i){
			x = x + dx/len;
			y = y + dy/len;
			System.out.println((int)x + " " + (int)y);
		}
		
		
	}
}
