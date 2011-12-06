package interpolationSearch;

import binSearch.*;

public class InterpolationSearch<K extends Comparable<K>, D> {
	private int m_iNextFree;
	private Node<K, D>[] m_pData;
	
	class Node<K, D>{
		K m_Key;
		D m_Data; 
		
		public Node(K key, D data){
			m_Key = key;
			m_Data = data;
		}
	}
	
	public InterpolationSearch(int iNrOfEntries){
		m_iNextFree = 0;
		m_pData = new Node[iNrOfEntries];
	}
	
	public void insert(K key, D data){
		m_pData[m_iNextFree++] = new Node<K, D>(key, data);
		if(m_iNextFree > 1)
			sort();
	}

	private void sort(){
		for(int i1 = 1; i1 < m_iNextFree; ++i1){
			final K VAL = m_pData[i1].m_Key;
			final Node tmp = m_pData[i1];
			int i2 = i1;
			while(i2 > 0 && m_pData[i2-1].m_Key.compareTo(VAL) > 0){
				m_pData[i2] = m_pData[i2-1];
				--i2;
			}
			m_pData[i2] = tmp;
		}
	}
	
	private boolean isSorted(){
		for(int i = 0; i < m_iNextFree-1; ++i){
			if(m_pData[i].m_Key.compareTo(m_pData[i+1].m_Key) > 0)
				return false;
		}
		return true;
	}
	
	public void search_help(K key){
		System.out.println("K key: " + key + " | D data: " + search(key).m_Data);
	}
	
	private Node<K, D> search(K key){
		return null;
	}
	
	public Node<K, D>[] getM_pData() {
		return m_pData;
	}

	public void setM_pData(Node<K, D>[] m_pData) {
		this.m_pData = m_pData;
	}
}
