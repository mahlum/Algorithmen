package model;

import java.util.*;

public class CompressPic {
		
	public static int[] compress(Vector<SaveTheValues> vec, int length, int W){
		int[] m_Pix = new int[length];
		int half, bestColor = 3*255, pos =0;
		System.out.println("Es gibt " + vec.size() +" verschiedene Farbwerte");
		if(vec.size() % 2 == 0)
			half = vec.size()/2;
		else
			half = (vec.size()+1)/2;
		System.out.println("Die H�lfte aller Farbwerte ist dann "+ half);
		
		System.out.println("Compressstart!");
		long timeStart = System.currentTimeMillis();
		for(int i = 0; i <= half; ++i){
			bestColor = 255+255+255;
			for(int j = vec.size()-1; j > half; --j){
				int DiffRed = Math.abs(vec.get(i).col.getRed() - vec.get(j).col.getRed());
				int DiffGreen = Math.abs(vec.get(i).col.getGreen() - vec.get(j).col.getGreen());
				int DiffBlue = Math.abs(vec.get(i).col.getBlue() - vec.get(j).col.getBlue());
				int sum = DiffRed + DiffGreen + DiffBlue;
				if(sum < bestColor){
					bestColor = sum;
					pos = j;	
				}
//				if(j % 100 == 0)
//					System.out.print(j + " ");
			}
			
			
				
			for(int s = 0; s <= vec.get(i).count; ++s){
				if(vec.get(i).ls.get(s).x == 13 && vec.get(i).ls.get(s).y == 0)
					System.out.println("STOP");
//				System.out.println(vec.get(i).ls.get(s).getLocation());
				vec.get(pos).ls.add(vec.get(i).ls.get(s).getLocation());
				++vec.get(pos).count;
			}
			
		}
		long timeEnd = System.currentTimeMillis();
		System.out.println("Dauer: " +(timeEnd - timeStart));
		
		for(int i = vec.size()-1; i > half-1; --i){
			for(int j = 0; j <= vec.get(i).count; ++j)
				m_Pix[vec.get(i).ls.get(j).y * W + vec.get(i).ls.get(j).x] = vec.get(i).colVal;
		}		
		return m_Pix;		
	}
	
	
}

