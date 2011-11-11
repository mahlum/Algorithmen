import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;
import java.util.Vector;

public class getPicInfo extends Component {
	final int W = 200;
	final int H = 150;
	Image m_Img;
	int[] m_Pix = new int[W * H];
	MemoryImageSource m_ImgSrc;
	Vector<saveTheValues> vec;

	public getPicInfo(Frame father) {
		try {
			FileDialog diag = new FileDialog(father);
			diag.setVisible(true);
			m_Img = getToolkit().getImage(diag.getDirectory() + diag.getFile())
					.getScaledInstance(W, H, Image.SCALE_SMOOTH);
			MediaTracker mt = new MediaTracker(this);
			mt.addImage(m_Img, 0);
			mt.waitForAll();
			PixelGrabber grab = new PixelGrabber(m_Img, 0, 0, W, H, m_Pix, 0, W);
			grab.grabPixels();
			m_ImgSrc = new MemoryImageSource(W, H, m_Pix, 0, W);
			m_Img = createImage(m_ImgSrc);
		} catch (InterruptedException e) {

		}
	}

	public void update(Graphics g) {
		paint(g);
	}

	public void paint(Graphics g) {
		g.drawImage(m_Img, 0, 0, this);
	}
}

