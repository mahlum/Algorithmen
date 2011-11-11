import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.math.*;

public class aufgabe_1 extends Frame{
	
	aufgabe_1(){
		super("Malen... ");
		setSize(600,500);
		setVisible(true);
		addWindowListener(new WindowAdapter(){
			@Override
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
	}
	
	public void Run(){
		drawLine(this.getGraphics(), 150, 150, 150, 150, Color.red, Color.black);
//		drawLine(this.getGraphics(), 120, 170, 270, 370, Color.BLACK, Color.yellow);
	}
		
	public static void drawLine(Graphics g, int x1, int y1, int x2, int y2, Color cStart, Color cEnd){
		double dx, dy, dpoints;
		double actPosX = x1, actPosY = y1;
		Color[] cols;
		
					
		dx = x2 - x1;
		dy = y2 - y1;
				
		dpoints = Math.sqrt((dx*dx+dy*dy));
		System.out.println(dpoints);		
		
		for(int i = 0; i < dpoints; ++i){
			final int P = 100*i/(int)dpoints;
			final int COL = 0xff000000 
					| (cStart.getRed()+(cEnd.getRed()-cStart.getRed())*P / 100) << 16
					| (cStart.getGreen()+(cEnd.getGreen()-cStart.getGreen())*P / 100) << 8
					| (cStart.getBlue()+(cEnd.getBlue()-cStart.getBlue())*P / 100);
			Color test = new Color(COL);
			g.setColor(test);
			g.drawLine((int)actPosX, (int)actPosY, (int)(actPosX), (int)(actPosY));
			actPosX = actPosX + dx/dpoints;
			actPosY = actPosY + dy/dpoints;
			System.out.println(actPosX + " " + actPosY + " " + dx + " " + dy + " " + dpoints);
			System.out.println(actPosX + " " + actPosY + " " + dx + " " + dy + " " + dpoints);
		}
	}
	
	public static void main(String[] args){
		aufgabe_1 auf1 = new aufgabe_1();
		try{
			Thread.sleep(300);
		}catch(InterruptedException x){	}
		auf1.Run();
	}
	
	
}
