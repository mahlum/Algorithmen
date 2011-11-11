package loadPic;

import java.awt.*;
import java.awt.image.MemoryImageSource;
import java.awt.image.PixelGrabber;

public class LoadPic extends FileDialog {
	private Image img;
	private int m_Pix[];
	private MemoryImageSource m_ImgSrc;

	public LoadPic(Frame father, int W, int H) {
		super(father, "Choose Picture ...");
		setVisible(true);
		m_Pix = new int[W * H];
		img = getToolkit().getImage(this.getDirectory() + this.getFile())
				.getScaledInstance(W, H, Image.SCALE_SMOOTH);
		MediaTracker mt = new MediaTracker(this);
		mt.addImage(img, 0);
		try{
			mt.waitForAll();
			PixelGrabber grab = new PixelGrabber(img, 0, 0, W, H, m_Pix, 0, W);
			grab.grabPixels();
			m_ImgSrc = new MemoryImageSource(W, H, m_Pix, 0, W);
			img = createImage(m_ImgSrc);
		} catch(InterruptedException e){
			
		}
		System.out.println("Bild geladen ...");
	}

	public Image getImg() {
		return img;
	}

	public void setImg(Image img) {
		this.img = img;
	}

	public int[] getM_Pix() {
		return m_Pix;
	}

	public void setM_Pix(int[] m_Pix) {
		this.m_Pix = m_Pix;
	}

	public MemoryImageSource getM_ImgSrc() {
		return m_ImgSrc;
	}

	public void setM_ImgSrc(MemoryImageSource m_ImgSrc) {
		this.m_ImgSrc = m_ImgSrc;
	}
	
	
}
