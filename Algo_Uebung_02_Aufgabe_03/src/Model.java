import java.awt.Image;
import java.util.*;

public class Model {
	int x, y;
	Vector<picValues> vec;
	
	public Model(int x, int y){
		this.x = x;
		this.y = y;
		vec = new Vector<picValues>(1,1);
	}
	
	public void savePictures(Image img, int[] pix){
		vec.add(new picValues(img, pix));
	}
	
	public void startShow(){
		Thread t = new Thread(new wallofFame(vec, x, y));
//		wallofFame  wof = new wallofFame(vec, x, y);
		t.start();
	}
	
}
