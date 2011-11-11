
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
		try{
			Thread.sleep(3000);
		}catch(InterruptedException x){
			
		}
		mod.compressPic();
		System.out.println("FERTIG");
		view.pi.setNewImg(mod.m_Pix);
	}
}
