package view;

import java.awt.*;
import java.awt.image.MemoryImageSource;
import java.awt.image.PixelGrabber;

public class ShowComPic extends Component {
	final int W = 300;
	final int H = 250;
	Image m_img;
	int[] m_Pix = new int[W * H];
	MemoryImageSource m_ImgSrc;

	public ShowComPic(int[] m_Pix) {
		this.m_Pix = m_Pix;
//		try {
//			this.m_img = img;
//			MediaTracker mt = new MediaTracker(this);
//			mt.addImage(m_img, 0);
//			mt.waitForAll();
//			PixelGrabber grab = new PixelGrabber(m_img, 0, 0, W, H, m_Pix, 0, W);
//			grab.grabPixels();
			m_ImgSrc = new MemoryImageSource(W, H, m_Pix, 0, W);
			m_img = createImage(m_ImgSrc);
//		} catch (InterruptedException e) {
//		}
		setSize(W, H);
	}
	
	public void paint(Graphics g) {
		g.drawImage(m_img, 0, 0, this);
	}
	
	public void update(Graphics g){
		g.drawImage(m_img, 0, 0, this);
	}
}
