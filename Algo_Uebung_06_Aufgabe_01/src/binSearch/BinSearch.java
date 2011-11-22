package binSearch;

public class BinSearch<K extends Comparable<K>,D> {
	class Node<K,D>{ 			// evtl. hier noch ändern zu <K extends Comparable<K>,D>
		K m_Key;
		D m_Data;
		
		public Node(K key, D data){
			m_Key = key;
			m_Data = data;
		}
	}
	
	private int m_iNextFree;
	private Node<K,D>[] m_pData;	
	
	public BinSearch(int iNrOfEntries){
		m_iNextFree = 0;
		m_pData = new Node[iNrOfEntries];
	}
	
	public void insert(K key, D data){
		m_pData[m_iNextFree++] = new Node<K,D>(key,data);
	}
	
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
	
	

}
