
public class Controller {
	private Model mod;
	private View view;
	
	public Controller(){
		mod = new Model(500, 500);
		view = new View(mod);
	}
	
	public void simulate(){
		mod.countColors(view.pi.m_Pix, view.pi.W, view.pi.H);
		mod.outputColors();
	}
}
