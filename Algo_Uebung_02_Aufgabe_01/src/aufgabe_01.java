import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;

class Shuffle extends Component {
	final int W = 500;
	final int H = 300;
	Image m_Img1, m_Img2, m_Img;
	int[] m_Img1Pix = new int[W * H];
	int[] m_Img2Pix = new int[W * H];
	int[] m_Pix = new int[W * H];
	MemoryImageSource m_ImgSrc;

	public Shuffle(Frame father) {
		try {
			FileDialog diag = new FileDialog(father);
			diag.setVisible(true);
			m_Img1 = getToolkit()
					.getImage(diag.getDirectory() + diag.getFile())
					.getScaledInstance(W, H, Image.SCALE_SMOOTH);
			diag.setFile("");
			diag.setVisible(true);
			m_Img2 = getToolkit()
					.getImage(diag.getDirectory() + diag.getFile())
					.getScaledInstance(W, H, Image.SCALE_SMOOTH);
			MediaTracker mt = new MediaTracker(this);
			mt.addImage(m_Img1, 0);
			mt.addImage(m_Img2, 0);
			mt.waitForAll();
			PixelGrabber grab1 = new PixelGrabber(m_Img1, 0, 0, W, H,
					m_Img1Pix, 0, W);
			PixelGrabber grab2 = new PixelGrabber(m_Img2, 0, 0, W, H,
					m_Img2Pix, 0, W);
			grab1.grabPixels();
			grab2.grabPixels();
			m_ImgSrc = new MemoryImageSource(W, H, m_Pix, 0, W);
			m_Img = createImage(m_ImgSrc);
			System.out.println("Pause");
		} catch (InterruptedException e) {
		}
	}

	public void update(Graphics g) {
		paint(g);
	}

	public void paint(Graphics g) {
		g.drawImage(m_Img, 0, 0, this);
	}
	
	public Dimension getPreferredSize(){
		return getMinimumSize();
	}
	
	public Dimension getMinimumSize(){
		return new Dimension(W, H);
	}
	
	private int compColor(int x1, int x2, int p) {
		return x1+(x2-x1)*p/100;
	}
	
	private int compPix(int pix1, int pix2, int p){
		final int RED = compColor((pix1 >> 16) & 0xff, (pix2 >> 16) & 0xff, p);
		final int GREEN = compColor((pix1 >> 8) & 0xff, (pix2 >> 8) & 0xff, p);
		final int BLUE = compColor(pix1 & 0xff, pix2 & 0xff, p);
		return 0xff000000 | (RED << 16) | (GREEN << 8) | BLUE;
	}
	
	public void shuffle(int p){
		for(int i = 0; i < W*H; ++i)
			m_Pix[i] = compPix(m_Img1Pix[i], m_Img2Pix[i], p);
		m_Img.flush();
		repaint();
	}

}

class Pic extends Frame {
	public Pic(){
		super("Hey Pictures ...");
		setLayout(new BorderLayout());
		final Shuffle SHUF = new Shuffle(this);
		final Scrollbar BAR = new Scrollbar(Scrollbar.HORIZONTAL, 100, 1, 0, 101);
		final Label LAB = new Label("100 %");
		Panel pan = new Panel();
		pan.setLayout(new BorderLayout());
		add(BorderLayout.CENTER, SHUF); add(BorderLayout.SOUTH, pan);
		pan.add(BorderLayout.CENTER, BAR); 
		pan.add(BorderLayout.EAST, LAB);
		BAR.addAdjustmentListener(new AdjustmentListener(){
			public void adjustmentValueChanged(AdjustmentEvent e){
				SHUF.shuffle(BAR.getValue());
				LAB.setText(BAR.getValue() + " %");
			}
		});
		pack();
		setVisible(true);
		SHUF.shuffle(100);
	}
	
	public void update(Graphics g){
		paint(g);
	}
}

public class aufgabe_01 {
	public static void main(String[] args) throws Exception {
//		Controller c = new Controller();
//		c.simulate();
		new Pic();
	}
}
