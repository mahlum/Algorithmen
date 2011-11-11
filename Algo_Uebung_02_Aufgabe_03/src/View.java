import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class View extends Frame {
	private Model mod;
	private getPictures gp;

	public View(Model mod) {
		this.mod = mod;
		setSize(mod.x, mod.y);
		setLocation(200, 200);
		
		setLayout(new GridLayout(2, 1));

		Button newPic = new Button("neues Bild");
		Button startShow = new Button("Diashow starten");

		add(newPic);
		add(startShow);

		newPic.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				gp = new getPictures(View.this, View.this.mod.x,
						View.this.mod.y);
				View.this.mod.savePictures(View.this.gp.getM_Img(),
						View.this.gp.getM_Pix());
				System.out.println(View.this.mod.vec.get(View.this.mod.vec.size()-1).m_Pix.length);
			}
		});

		
		startShow.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e){
				if(View.this.mod.vec.size() != 0)
					View.this.mod.startShow();
			}
		});
		
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
		pack();

		setVisible(true);
	}

	public getPictures getGp() {
		return gp;
	}

	public void setGp(getPictures gp) {
		this.gp = gp;
	}

}
