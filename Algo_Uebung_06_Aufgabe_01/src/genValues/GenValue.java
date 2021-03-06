package genValues;

import binSearch.*;
import interpolationSearch.*;

public class GenValue {
	BinSearch bs;
	Integer intKeys;    // K key (Integer)
	String  StringKey;  // K key (String)
	int intValues; 		// D Data
	String tmpField;
	
	public void genIntValues(int values){
		bs = new BinSearch(values);
		for(int i = 0; i < values; ++i){
			intKeys = (int)(Math.random()*(values*10)+1);
			bs.insert(intKeys, intKeys+100);
		}
		bs.sort();
	}
	
	public void genStringValues(int values){
		bs = new BinSearch(values);
		for (int i = 0; i < values; ++i){
			tmpField = String.valueOf((char)(Math.random()*26+'A'));
			for(int j = 0; j < (int)(Math.random()*30+5); ++j){
				char tmpChar = (char)(Math.random()*26+'A');
				tmpField = tmpField + String.valueOf(tmpChar);
			}
			bs.insert(tmpField, tmpField);
			if(i % 500000 == 0)
				System.out.print(i + " " + tmpField + " | ");
			tmpField = "";
		}
		System.out.println();
		bs.sort();
	}
	
	public void searchIntIt(int value){
		Node tmp;
		intKeys = (Integer)bs.getM_pData()[value / 4].m_Key;
//		tmp = new Node(1,bs.search((Integer)value).m_Data);
		tmp = bs.search(intKeys); 
		if(tmp != null)
			System.out.println("Fuer den Schl�ssel " + tmp.m_Key + " gibt es folgene Daten: " + tmp.m_Data);
		else
			System.out.println("Kein Wert gefunden!");
	}
	
	public void searchStringIt(int value){
		Node tmp;
		StringKey = (String)bs.getM_pData()[value / 4 + 200].m_Key;
		tmp = bs.search(StringKey);
		if(tmp != null)
			System.out.println("Bin�re suche Erg: " + tmp.m_Data);
		else
			System.out.println("Kein Wert gefunden!");
	}
	
	public void StringIntSearch(int value){
		Node tmp;
		StringKey = (String)bs.getM_pData()[value / 4 + 200].m_Key;
		tmp = 
	}
	
	public void searchSeq(int values){
		StringKey = (String)bs.getM_pData()[values / 4 + 200].m_Key;
		for(int i = 0; i < bs.getM_pData().length; ++i){
			if(StringKey == bs.getM_pData()[i].m_Key){
				System.out.println("Seq Suche Erg: " + bs.getM_pData()[i].m_Data + " " + i);
			}
		}
	}
}
