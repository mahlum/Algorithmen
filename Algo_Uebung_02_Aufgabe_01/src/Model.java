import java.awt.Point;
import java.util.Vector;


public class Model {
	int x, y;
	Vector<saveTheValues> vec;
	int[] m_Pix;
	
	public Model(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public void countColors(int[] m_Pix, int W, int H){
		vec = new Vector<saveTheValues>(100,100);
		this.m_Pix = m_Pix;
		// new with Points Gathering :D 
		for(int y = 0; y < H; ++y){
			for(int x = 0; x < W; ++x){
				boolean done = false;
				for(int i = 0; i < vec.size(); ++i){
					if(vec.get(i).colVal == m_Pix[y*W+x]){
						++vec.get(i).count;
						Point point = new Point(x,y);
						vec.get(i).ls.add(point);
						done = true;
					}
				}
				if(done == false){
					vec.add(new saveTheValues(m_Pix[y*W+x], x, y));
				}
			}
		}
	}
	
	public void outputColors(){
		//erst sortieren
		BubbleSort.sort(vec);
		new Histogramm(vec);
		//dann ausgeben
//		for(int i = 0; i < vec.size(); ++i){
//			System.out.println("Farbe: " + Integer.toHexString(vec.get(i).colVal) + " count:" + vec.get(i).count);
//		}
	}
	
}
