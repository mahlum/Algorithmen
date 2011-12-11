package view;

import java.awt.*;
import java.awt.event.*;

import model.*;

public class View extends Frame{
	private Model mod;
	ShowOrgPic sop; 
	
	public View(Model mod){
		super("Bild kompriemieren");
		this.mod = mod;
		
		addWindowListener(new WindowAdapter(){
			@Override
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
		
		setSize();
		
	}
	
	
	
	
}

