import java.awt.*;

public class Model {
	int x, y;
	int W, H;
	Picture pic;
	
	public Model(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public void addPicture(Image img, int[] m_Pix){
		pic = new Picture(img, m_Pix);
	}
	
	
	
	
}

class Picture{
	private Image img;
	private int m_Pix[];
	
	public Picture (Image img, int[] m_Pix){
		this.img = img; 
		this.m_Pix = m_Pix;
	}
}
