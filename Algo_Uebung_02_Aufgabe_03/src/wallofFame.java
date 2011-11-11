import java.awt.*;
import java.awt.image.MemoryImageSource;
import java.awt.image.PixelGrabber;
import java.util.Vector;

public class wallofFame extends Frame implements Runnable {
	SlideShow ss;
	static int i = 0;

	public wallofFame(Vector<picValues> vec, int W, int H) {
		super("Hey Pictures ...");
		setLayout(new BorderLayout());
		ss = new SlideShow(vec, W, H);
		add(BorderLayout.CENTER, ss);
		setVisible(true);
		pack();
		ss.newGrab();
		animate();
	}

	public void animate() {
		ss.shuffle(i);
	}

	public void update(Graphics g) {
		paint(g);
	}

	public void run() {
		while (true) {
			ss.newGrab();
			i = 0;
			System.out.println(ss.i);
			while (i < 100) {
				try {
					Thread.sleep(30);
				} catch (InterruptedException e) {
				}
				i += 1;
				ss.shuffle(i);
			}
			++ss.i;
			if(ss.i == ss.vec.size())
				ss.i = 0;
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
			}
		}
		// ss.repaint();
	}
}
