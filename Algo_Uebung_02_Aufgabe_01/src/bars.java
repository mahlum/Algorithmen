import java.awt.*;
import java.util.*;

public class bars extends Component{ 
	double length;
	int x, y;
	Vector<saveTheValues> vec;
	
	public bars(Vector<saveTheValues> vec, int x, int y, double length){
		this.vec = vec;
		this.x = x;
		this.y = y;
		this.length = length;
	}
	
	public void paint(Graphics g){
		y = 40;
		for(int i = vec.size()-1; i > -1; --i){
			g.setColor(vec.get(i).col);
			g.fillRect(x+80, y + 15, (int)(length*vec.get(i).count), 30);
			y += 50;
		}
	}
}
