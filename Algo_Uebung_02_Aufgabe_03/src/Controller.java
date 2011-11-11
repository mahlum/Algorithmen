
public class Controller {
	private Model mod;
	private View view;
	
	public Controller(){
		mod = new Model(400,300);
		view = new View(mod);
	}
}
