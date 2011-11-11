import java.awt.*;
import java.awt.event.*;
import java.math.*;

public class bogenmass extends Frame{
	private double ang, length = 10;
	int ix2, iy2, ix3, iy3;
	double sinPhi, cosPhi, dx, dy, x, y, s;
		
	public bogenmass(double x0, double y0, double x1, double y1){
		super("Bogenmass");
		setSize(500,400);
		setVisible(true);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
		try{
			Thread.sleep(300);
		}catch(InterruptedException x){
			
		}
		ang = 25 * Math.PI/180;			// (6)	-> Winkel in Bogenmaß oder so umrechnen
		dx = x1 - x0;					// (1)	
		dy = y1 - y0;					// (2)	
		s = Math.sqrt(dy*dy + dx*dx);	// (3)  s = Hypotenuse
		sinPhi = dy/s;					// (4)
		cosPhi = dx/s;					// (5)
		if(s < length) {				// Pfeil darf nicht kürzer als die Spitze sein ?!?
			x0 = x1 - length*cosPhi;
			y0 = y1 - length*sinPhi;
		}
		
		x = -length*Math.cos(ang);		// Länge x berechnen
		
		y = length*Math.sin(ang);
		
		ix2 = (int)(x1 + x * cosPhi - y * sinPhi);
		iy2 = (int)(y1 + x * sinPhi + y * cosPhi);
		
		System.out.println(x * cosPhi);
		
		ix3 = (int)(x1 + x * cosPhi + y * sinPhi);
		iy3 = (int)(y1 + x * sinPhi - y * cosPhi);
		
		System.out.println(ang);
		
		System.out.println(ix2 + " " + iy2 + " " + cosPhi + " " + sinPhi);
		
		getGraphics().drawLine((int)x0, (int)y0, (int)x1, (int)y1);
		getGraphics().drawLine(ix2, iy2, (int)x1, (int)y1);
		getGraphics().drawLine(ix3, iy3, (int)x1, (int)y1);
	}
	
	
	public static void main(String[] args){
		new bogenmass(120, 132, 250, 100);
	}

}
