import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;

class LabelScrollBar extends Panel {
	TextField m_Lab = new TextField(6);
	Scrollbar m_Bar = new Scrollbar(Scrollbar.HORIZONTAL, 0, 1, 0, 256);
	String m_Prefix;
	
	public LabelScrollBar(String strPrefix){
		m_Prefix = strPrefix;
		m_Lab.setText(m_Prefix);
		m_Lab.setEnabled(false);
		setLayout(new BorderLayout());
		add(BorderLayout.EAST,m_Lab);
		add(BorderLayout.CENTER, m_Bar);
		m_Bar.addAdjustmentListener(new AdjustmentListener(){
			public void adjustmentValueChanged(AdjustmentEvent e){
				m_Lab.setText(m_Prefix + m_Bar.getValue());
			}
		});
	}
}

class ControlledColor extends Panel implements AdjustmentListener {
	LabelScrollBar red = new LabelScrollBar("red ");
	LabelScrollBar green = new LabelScrollBar("green ");
	LabelScrollBar blue = new LabelScrollBar("blue ");
	int[] cols;
	Shade shad;
	
	public ControlledColor(Shade shad, int[] cols){
		this.shad = shad;
		this.cols = cols;
		setLayout(new GridLayout(3,1));
		add(red);
		add(green);
		add(blue);
		red.m_Bar.addAdjustmentListener(this);
		green.m_Bar.addAdjustmentListener(this);
		blue.m_Bar.addAdjustmentListener(this);
	}
	
	public void adjustmentValueChanged(AdjustmentEvent e){
		cols[0] = red.m_Bar.getValue();
		cols[1] = green.m_Bar.getValue();
		cols[2] = blue.m_Bar.getValue();
		shad.reRun();
	}
}

class Shade extends Frame{
	final int W = 500; 
	final int H = 300;
	Image m_Img;
	int[] m_Pix = new int[W*H];
	MemoryImageSource m_ImgSrc;
	int[] col1 = new int[3];
	int[] col2 = new int[3];
	
	public Shade(){
		super("Shade...");
		m_ImgSrc = new MemoryImageSource(W, H, m_Pix, 0, W);
		m_Img = createImage(m_ImgSrc);
		setSize(W,H);
		setVisible(true);
	}
	
	private int compColor(int x1, int x2, int p){
		return x1+(x2-x1)*p / 100;
	}
	
	public void reRun(){
		for(int i = 0; i < W; ++i){
			final int P = 100*i/W;
			final int COL = 0xff000000 
					| compColor(col1[0], col2[0], P) << 16 
					| compColor(col1[1], col2[1], P) << 8
					| compColor(col1[2], col2[2], P);
			for(int j = 0; j < H; ++j){
				m_Pix[i+W*j] = COL;
			}
		}
		m_Img.flush();
		if(getGraphics() != null){
			getGraphics().drawImage(m_Img, 0, 0, getWidth(), getHeight(), null);
		}
	}
}

public class Beispiel_02 extends Frame{
	public Beispiel_02(){
		super("Fade it...");
		Shade shad = new Shade();
		ControlledColor srcCol = new ControlledColor(shad, shad.col1);
		ControlledColor trgCol = new ControlledColor(shad, shad.col2);
		setLayout(new GridLayout(2,1));
		add(srcCol);
		add(trgCol);
		pack();
		setVisible(true);
	}

	public static void main(String[] args){
		new Beispiel_02();
	}

}
