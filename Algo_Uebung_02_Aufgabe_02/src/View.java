import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;

public class View extends Frame{
	private Model mod;
	getPicInfo pi = new getPicInfo(this);
	
	public View(Model mod){
		super("Teeeesssssttttt");
		this.mod = mod;
		
		
		addWindowListener(new WindowAdapter(){
			@Override
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
		System.out.println(pi.m_Pix[2] + " " + pi.m_Pix.length);
		add(pi);
		setSize(pi.m_Img.getWidth(pi), pi.m_Img.getHeight(pi));
		setVisible(true);
	}
	
	public void update(Graphics g){
		paint(g);
	}
}
