package heapSort;

public class Heap<K extends Comparable<K>> {
	private int m_iNext;		// der nächste freie Index ...
	private K[] m_Keys; 		// die einzelnen Schlüssel
	
	public Heap(int iSize){
		m_iNext = 0;
		m_Keys = (K[])new Comparable[iSize];
	}
	
	public void insert(K key){
		m_Keys[m_iNext] = key;
		upheap(m_iNext);
		++m_iNext;
	}
	
	public K remove(){
		K res = m_Keys[0];
		m_Keys[0] = m_Keys[--m_iNext];
		downheap(0);
		return res;
	}
	
	private void upheap(int iIndex){
		K k = m_Keys[iIndex];
		while(iIndex != 0 && m_Keys[(iIndex-1)/2].compareTo(k) < 0){
			m_Keys[iIndex] = m_Keys[(iIndex-1)/2];
			iIndex = (iIndex - 1)/2;
		}
		m_Keys[iIndex] = k;
	}
	
	private void downheap(int iIndex){
		K k = m_Keys[iIndex];
		while(iIndex < m_iNext / 2){
			int iSon = 2 * iIndex + 1;
			if(iSon < m_iNext-1 && m_Keys[iSon].compareTo(m_Keys[iSon+1])< 0)
				++iSon;
			if(k.compareTo(m_Keys[iSon]) >= 0)
				break;
			m_Keys[iIndex] = m_Keys[iSon];
			iIndex = iSon;
		}
		m_Keys[iIndex] = k;
	}
	
	

}
