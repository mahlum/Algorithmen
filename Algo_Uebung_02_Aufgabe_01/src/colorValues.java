import java.awt.*;
import java.util.*;

public class colorValues extends Label{
	Vector<saveTheValues> vec;
	int x;
	int y;
	
	public colorValues(Vector<saveTheValues> vec, int x, int y){
		this.vec = vec;
		this.x = x;
		this.y = y;
	}
	
	public void paint(Graphics g){
		y= 40;
		g.drawRect(30, 40, 20, 20);
		for(int i = vec.size()-1; i > -1; --i){
			g.setColor(Color.black);
			g.drawString(new String().valueOf(Integer.toHexString(vec.get(i).colVal)), x, y + 35);
			y += 50;
		}
	}
}
