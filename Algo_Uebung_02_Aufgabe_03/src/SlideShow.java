import java.awt.*;
import java.awt.image.MemoryImageSource;
import java.awt.image.PixelGrabber;
import java.util.*;

public class SlideShow extends Component {
	Vector<picValues> vec;
	int W, H, i = 0;
	Image m_Img, img1, img2;
	int[] m_Pix;
	int[] m_pix1;
	int[] m_pix2;
	MemoryImageSource m_ImgSrc;
	PixelGrabber grab1, grab2;

	public SlideShow(Vector<picValues> vec, int W, int H) {
		this.W = W;
		this.H = H;
		this.vec = vec;
		m_Pix = new int[W * H];
		m_pix1 = new int[W * H];
		m_pix2 = new int[W * H];
	}

	public void newGrab() {
		try {
			img1 = vec.get(i).m_Img;
			img2 = vec.get(i + 1 == vec.size() ? 0 : i + 1).m_Img;
			grab1 = new PixelGrabber(img1, 0, 0, W, H, m_pix1, 0, W);
			grab2 = new PixelGrabber(img2, 0, 0, W, H, m_pix2, 0, W);
			grab1.grabPixels();
			grab2.grabPixels();
			m_ImgSrc = new MemoryImageSource(W, H, m_Pix, 0, W);
			m_Img = createImage(m_ImgSrc);
		} catch (InterruptedException es) {
		}
	}

	public void update(Graphics g) {
		paint(g);
	}

	public void paint(Graphics g) {
		g.drawImage(m_Img, 0, 0, this);
	}

	public Dimension getPreferredSize() {
		return getMinimumSize();
	}

	public Dimension getMinimumSize() {
		return new Dimension(W, H);
	}

	private int compColor(int x1, int x2, int p) {
		return x1 + (x2 - x1) * p / 100;
	}

	private int compPix(int pix1, int pix2, int p) {
		final int RED = compColor((pix1 >> 16) & 0xff, (pix2 >> 16) & 0xff, p);
		final int GREEN = compColor((pix1 >> 8) & 0xff, (pix2 >> 8) & 0xff, p);
		final int BLUE = compColor(pix1 & 0xff, pix2 & 0xff, p);
		return 0xff000000 | (RED << 16) | (GREEN << 8) | BLUE;
	}

	public void shuffle(int p) {
		for (int i = 0; i < W * H; ++i)
			m_Pix[i] = compPix(m_pix1[i], m_pix2[i], p);
		m_Img.flush();
		repaint();
	}

}
