package interpolationSearch;

import quickSort.Quicksort;
import binSearch.Node;

public class InterpolationSearch<K extends Comparable<K>, D> {
	private int m_iNextFree;
	private Node<K,D>[] m_pData;	
	
	public InterpolationSearch(int iNrOfEntries){
		m_iNextFree = 0;
		m_pData = new Node[iNrOfEntries];
	}
	
	//suchen !
		
	public Node<K,D> search(K key){
		int iL = 0; 
		int iR = m_iNextFree-1;
		K keyL = m_pData[iL].m_Key;
		K keyR = m_pData[iR].m_Key;
		
		while(iL <= iR){
//			final int MIDDLE = (iL + iR) / 2;
			final int MIDDLE = iL + (StringDistance.calcMiddle(key, keyL)) * (iR-iL) / (StringDistance.calcMiddle(keyR, key));
			System.out.println(MIDDLE);
			final int RES = m_pData[MIDDLE].m_Key.compareTo(key);
			if(RES == 0)
				return m_pData[MIDDLE];
			else if(RES < 0)
				iL = MIDDLE + 1;
			else
				iR = MIDDLE - 1;
		}
		return null;
	}
	
	public Node<K,D> searchInt(K key){
		int iL = 0; 
		int iR = m_iNextFree-1;
		int keyL = (Integer)m_pData[iL].m_Key;
		int keyR = (Integer)m_pData[iR].m_Key;
		while(iL <= iR){
//			final int MIDDLE = (iL + iR) / 2;
			final int MIDDLE = iL + ((Integer)key - keyL) * (iR-iL) / (keyR - keyL);
			final int RES = m_pData[MIDDLE].m_Key.compareTo(key);
			if(RES == 0)
				return m_pData[MIDDLE];
			else if(RES < 0)
				iL = MIDDLE + 1;
			else
				iR = MIDDLE - 1;
		}
		return null;
	}
	
	//Einfügen & Sortieren
	
	public void insert(K key, D data){
		m_pData[m_iNextFree++] = new Node<K,D>(key,data);
	}
	
	public void sort(){
		Quicksort.quick_sort(m_pData);
	}
	
	public Node<K, D>[] getM_pData() {
		return m_pData;
	}

	public void setM_pData(Node<K, D>[] m_pData) {
		this.m_pData = m_pData;
	}
}
