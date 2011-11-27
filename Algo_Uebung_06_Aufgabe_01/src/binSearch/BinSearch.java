package binSearch;

import binSearch.*;

public class BinSearch<K extends Comparable<K>,D> {
	private int m_iNextFree;
	private Node<K,D>[] m_pData;	
	
	public BinSearch(int iNrOfEntries){
		m_iNextFree = 0;
		m_pData = new Node[iNrOfEntries];
	}
	
	//suchen !
		
	public Node<K,D> search(K key){
		int iL = 0; 
		int iR = m_iNextFree-1;
		while(iL <= iR){
			final int MIDDLE = (iL + iR) / 2;
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
		for(int i = (m_pData.length) / 2; i >= 0; --i)
			downheap(i, m_pData.length);
		for(int i = m_pData.length - 1; i > 0; --i){
			swap(0,i);
			downheap(0, i);
		}
	}
	
	private void downheap(int i, int len){
		int child = 2*i+1;														
		K tmp;	
		Node nodetmp = m_pData[i];
		for (tmp = m_pData[i].m_Key; 2*i+1 < len; i = child) {							
			child = 2 * i + 1;		
			nodetmp = m_pData[i];
			if ((child != len-1) && (m_pData[child].m_Key.compareTo(m_pData[child+1].m_Key) < 0)) 	
				child++;															
			if (tmp.compareTo(m_pData[child].m_Key) < 0)									
				m_pData[i] = m_pData[child];											
			else																	
				break;
		}
		m_pData[i] = nodetmp;			
	}
	
	private void swap(int i, int b){
		Node tmp = m_pData[i];
		m_pData[i] = m_pData[b];
		m_pData[b] = tmp;
	}

	public Node<K, D>[] getM_pData() {
		return m_pData;
	}

	public void setM_pData(Node<K, D>[] m_pData) {
		this.m_pData = m_pData;
	}
}

