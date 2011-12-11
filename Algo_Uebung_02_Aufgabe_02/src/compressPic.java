import java.util.Vector;

public class compressPic {
	
	public static int[] tocompress(Vector<saveTheValues> vec, int length){
		int[] m_Pix = new int[length];
		int half, bestColor = 100000, pos = 0;
		//erst die hälfte des Vectors berechen
		System.out.println("Es gibt " + vec.size() +" verschiedene Farbwerte");
		if(vec.size() % 2 == 0)
			half = vec.size()/2;
		else
			half = (vec.size()+1)/2;
		System.out.println("Die Hälfte aller Farbwerte ist dann "+ half);
		
		for(int i = 0; i < half; ++i){
			bestColor = 255+255+255;
			for(int j = vec.size()-1; j > half-1; --j){
				int DiffRed = Math.abs(vec.get(i).col.getRed() - vec.get(j).col.getRed());
				int DiffGreen = Math.abs(vec.get(i).col.getGreen() - vec.get(j).col.getGreen());
				int DiffBlue = Math.abs(vec.get(i).col.getBlue() - vec.get(j).col.getBlue());
				int sum = DiffRed + DiffGreen + DiffBlue;
				if(sum < bestColor){
					bestColor = sum;
					pos = j;	
				}
				if(j % 100 == 0)
					System.out.print(j + " ");
			}
			for(int s = 0; s < vec.get(i).count; ++s){
				vec.get(pos).ls.add(vec.get(i).ls.get(s).getLocation());
				++vec.get(pos).count;
			}
		}
		
		for(int i = vec.size()-1; i > half-1; --i){
			for(int j = 0; j < vec.get(i).count; ++j)
				m_Pix[vec.get(i).ls.get(j).x * vec.get(i).ls.get(j).y] = vec.get(i).colVal;
		}		
		return m_Pix;
	}
}



