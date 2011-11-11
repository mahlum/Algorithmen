import java.awt.*;
import java.awt.event.*;
import java.util.Vector;

public class count extends Panel {
	int y , x, ylen = 800, xlen = 0;
	Vector<saveTheValues> vec;

	public count(Vector<saveTheValues> vec) {
		this.vec = vec;
	}
	
	public Dimension getPreferredSize(){
		return new Dimension(xlen,ylen);
	}

	@Override
	public void paint(Graphics g) {
		y = 50;
		x = 30;
		for(int i = vec.size()-1; i > -1; --i){
			g.setColor(Color.black);
			g.drawString(new String().valueOf(Integer.toHexString(vec.get(i).colVal)), x, y);
			g.drawString(new String().valueOf(vec.get(i).count+1), x+60, y);
			x = 125;
			for(int j = 0; j < vec.get(i).count+1; ++j){
				if(j % 100 == 0)
					g.drawString("*", x += 5, y);
				if(x > xlen)
					xlen = x+5;
			}
			y += 20;
			ylen = y;
			x = 30;
		}
	}
}
