import loadPic.*;
import java.awt.*;

public class View extends Frame{
	private Model mod;
	
	public View(Model mod){
		this.mod = mod;
		new LoadPic(this, mod.W, mod.H);
		
	}
}
