import java.awt.Color;
import java.awt.Graphics;
import java.awt.*;


public class aufgabe_2 extends Frame{

	aufgabe_2(){
		super("Malen... Aufgabe 2");
		setSize(600,500);
		setVisible(true);
	}
	
	private int compColor(int x1, int x2, int p){
		return x1+(x2-x1)*p / 100;
	}
	
	public void Run(Color[] cols){
		for(int i = 0; i < getWidth(); i += 2){
			final int P = 100*i/getWidth();
			
			final int COLORstart = 0xff000000 
					| (cols[0].getRed()+(cols[1].getRed()-cols[0].getRed())*P / 100) << 16
					| (cols[0].getGreen()+(cols[1].getGreen()-cols[0].getGreen())*P / 100) << 8
					| (cols[0].getBlue()+(cols[1].getBlue()-cols[0].getBlue())*P / 100);
			Color cStart = new Color(COLORstart);
			
			final int COLORend = 0xff000000 
					| (cols[2].getRed()+(cols[3].getRed()-cols[2].getRed())*P / 100) << 16
					| (cols[2].getGreen()+(cols[3].getGreen()-cols[2].getGreen())*P / 100) << 8
					| (cols[2].getBlue()+(cols[3].getBlue()-cols[2].getBlue())*P / 100);
			Color cEnd = new Color(COLORend);
			
			drawLine(this.getGraphics(), i, 0, i, getHeight(), cStart, cEnd);
		}
		for(int i = 0; i < getHeight(); i += 2){
			final int P = 100*i/getHeight();
			
			final int COLORstartWidth = 0xff000000
					| (cols[0].getRed()+(cols[2].getRed()-cols[0].getRed())*P / 100) << 16
					| (cols[0].getGreen()+(cols[2].getGreen()-cols[0].getGreen())*P / 100) << 8
					| (cols[0].getBlue()+(cols[2].getBlue()-cols[0].getBlue())*P / 100);
			Color cStartWidth = new Color(COLORstartWidth);
			
			final int COLORendWidth = 0xff000000 
					| (cols[1].getRed()+(cols[3].getRed()-cols[1].getRed())*P / 100) << 16
					| (cols[1].getGreen()+(cols[3].getGreen()-cols[1].getGreen())*P / 100) << 8
					| (cols[1].getBlue()+(cols[3].getBlue()-cols[1].getBlue())*P / 100);
			Color cEndWidth = new Color(COLORendWidth);
			
			drawLine(this.getGraphics(), 0, i, getWidth(), i, cStartWidth, cEndWidth);
		}
	}
		
	public static void drawLine(Graphics g, int x1, int y1, int x2, int y2, Color cStart, Color cEnd){
		double dx, dy, dpoints;
		double actPosX = x1, actPosY = y1;
		Color[] cols;
		
					
		dx = x2 - x1;
		dy = y2 - y1;
				
		dpoints = (int)Math.sqrt((dx*dx+dy*dy));
//		System.out.println(dpoints);
//		System.out.println(300/dpoints);
//		
					
		for(int i = 0; i < dpoints; ++i){
			final int P = 100*i/(int)dpoints;
			final int COL = 0xff000000 
					| (cStart.getRed()+(cEnd.getRed()-cStart.getRed())*P / 100) << 16
					| (cStart.getGreen()+(cEnd.getGreen()-cStart.getGreen())*P / 100) << 8
					| (cStart.getBlue()+(cEnd.getBlue()-cStart.getBlue())*P / 100);
			Color test = new Color(COL);
			
			
			g.setColor(test);
			
			
			if(dx != 0 && dy != 0){			
				g.drawLine((int)actPosX, (int)actPosY, (int)(actPosX+(dx/dpoints)), (int)(actPosY+(dy/dpoints)));
				actPosX = actPosX + dx/dpoints;
				actPosY = actPosY + dy/dpoints;
			}else {
				if(dx == 0){
					g.drawLine((int)actPosX, (int)actPosY, (int)actPosX, (int)(actPosY+(dpoints/dy)));
					actPosY = actPosY + dy/dpoints;
				} else {
					g.drawLine((int)actPosX, (int)actPosY, (int)(actPosX+(dpoints/dx)), (int)actPosY);
					actPosX = actPosX + dx/dpoints;
				}
			}
//			System.out.println(actPosX + " " + actPosY + " " + dx + " " + dy + " " + dpoints);
			
		}
	}
	
	public static void main(String[] args) {
		Color[] cols = {Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW};
		aufgabe_2 auf2 = new aufgabe_2();
		try{
			Thread.sleep(300);
		}catch(InterruptedException x){
			
		}
		auf2.Run(cols);

	}

}
