package view;

import java.awt.*;
import java.awt.event.*;

import model.*;

public class View extends Frame{
	private Model mod;
	public ShowOrgPic sop;
	public ShowComPic scp;
	
	public View(Model mod){
		super("Bild komprimieren");
		this.mod = mod;
		sop = new ShowOrgPic(this);
		
		addWindowListener(new WindowAdapter(){
			@Override
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
		setLayout(new GridLayout(2, 1));
		add(sop);
		System.out.println("Farben zählen ...");
		mod.countColors(sop.m_Pix, sop.W, sop.H);
		System.out.println("Nun sortieren ...");
		mod.sortColors();
		System.out.println("Compress ...");
		mod.compress(sop.W, sop.H);
		scp = new ShowComPic(mod.m_Pix);
		add(scp);
		pack();
//		setSize(sop.W+20,800);
		setBounds(400, 200, sop.W+20, 800);
		setVisible(true);
		System.out.println(sop.m_Pix.length);
	}
	
	
}

