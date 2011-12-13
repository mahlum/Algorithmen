package controller;

import model.*;
import view.*;

public class Controller {
	private Model mod;
	private View view;
	
	public Controller(){
		mod = new Model();
		view = new View(mod);
	}
}
