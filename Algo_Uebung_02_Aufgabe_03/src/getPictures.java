import java.awt.*;
import java.awt.image.MemoryImageSource;
import java.awt.image.PixelGrabber;

public class getPictures extends FileDialog {
	private Image m_Img;
	private MemoryImageSource m_ImgSrc;
	private int[] m_Pix;

	public getPictures(Frame father, int W, int H) {
		super(father, "Choose Picture...");
		setVisible(true);
		m_Pix = new int[W * H];
		m_Img = getToolkit().getImage(this.getDirectory() + this.getFile())
				.getScaledInstance(W, H, Image.SCALE_SMOOTH);
		MediaTracker mt = new MediaTracker(this);
		mt.addImage(m_Img, 0);
		try {
			mt.waitForAll();
			PixelGrabber grab = new PixelGrabber(m_Img, 0, 0, W, H, m_Pix, 0, W);
			grab.grabPixels();
			m_ImgSrc = new MemoryImageSource(W, H, m_Pix, 0, W);
			m_Img = createImage(m_ImgSrc);
		} catch (InterruptedException e) {
		}
		System.out.println("Pause");
	}

	public Image getM_Img() {
		return m_Img;
	}

	public void setM_Img(Image m_Img) {
		this.m_Img = m_Img;
	}

	public MemoryImageSource getM_ImgSrc() {
		return m_ImgSrc;
	}

	public void setM_ImgSrc(MemoryImageSource m_ImgSrc) {
		this.m_ImgSrc = m_ImgSrc;
	}

	public int[] getM_Pix() {
		return m_Pix;
	}

	public void setM_Pix(int[] m_Pix) {
		this.m_Pix = m_Pix;
	}

}
