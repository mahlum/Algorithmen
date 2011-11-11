import java.awt.*;
import java.awt.event.*;
import java.util.*;


public class Histogramm extends Frame{
	Vector<saveTheValues> vec;

	
	public Histogramm(Vector<saveTheValues> vec){
		super("Histogramm");
		this.vec = vec;
		setLocation(200, 100);
		setVisible(true);
		ScrollPane ScrollingPanel = new ScrollPane(ScrollPane.SCROLLBARS_ALWAYS);
		ScrollingPanel.add(new count(vec));
		ScrollingPanel.getVAdjustable().setUnitIncrement(1);
		ScrollingPanel.getHAdjustable().setUnitIncrement(1);
		ScrollingPanel.setSize(400,400);
		add(ScrollingPanel);
		pack();
	}	
}
