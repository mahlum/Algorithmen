import java.util.*;
import java.awt.*;
import java.awt.image.*;

class RndColor extends Frame{
	final int W = 300;
	final int H = 200;
	Image m_Img;
	int[] m_Pix = new int[W*H];
	MemoryImageSource m_ImgSrc;
	
	public RndColor(){
		super("Random Color");
		setSize(300,200);
		m_ImgSrc = new MemoryImageSource(W, H, m_Pix, 0, W);
		m_Img = createImage(m_ImgSrc);
		setVisible(true);
	}
	@Override
	public void update(Graphics g){}
	
	@Override
	public void paint(Graphics g){}
	
	public void rnd(){
		Random rnd = new Random();
		while(true){
			for(int i = 0; i < W*H; ++i){
				m_Pix[i] = rnd.nextInt();
			}
			m_Img.flush();
			getGraphics().drawImage(m_Img,0,0,this);
			try{
				Thread.sleep(20);
			} catch(InterruptedException e){}
		}
	}
	
	
}


public class Beispiel_01 {
	public static void main(String[] args){
		RndColor win = new RndColor();
		win.rnd();
	}
}
