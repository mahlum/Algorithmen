package heapSort;

public class Heap<K extends Comparable<K>> {
	private int m_iNext; // der n�chste freie Index ...
	private K[] m_Keys; // die einzelnen Schl�ssel

	public Heap(int iSize) {
		m_iNext = 0;
		m_Keys = (K[]) new Comparable[iSize];
	}

	public void insert(K key) {
		m_Keys[m_iNext] = key;
		upheap(m_iNext);
		++m_iNext;
	}

//	public K remove() {
//		K res = m_Keys[0];
//		m_Keys[0] = m_Keys[--m_iNext];
//		downheap(0);
//		return res;
//	}

	private void upheap(int iIndex) {
		K k = m_Keys[iIndex];
		while (iIndex != 0 && m_Keys[(iIndex - 1) / 2].compareTo(k) < 0) {
			m_Keys[iIndex] = m_Keys[(iIndex - 1) / 2];
			iIndex = (iIndex - 1) / 2;
		}
		m_Keys[iIndex] = k;
	}

	public static <K extends Comparable<K>> void downheap(K[] field,
			int i, int len) {
		int child = 2*i+1;														// child des aktuellen berechnen
		K tmp;																	// tmp Variable deklarieren
		for (tmp = field[i]; 2*i+1 < len; i = child) {							// tmp = aktuelle field[i]-Element
			child = 2 * i + 1;													// child neu berechnen (für downheap)
			if ((child != len-1) && (field[child].compareTo(field[child+1]) < 0)) 	// wenn child != field.length-1 und
																					// field[child] im vergleich zum zweiten 
																					// field[child] kleiner, dann ausführen
				child++;															// child einen höher setzen
			if (tmp.compareTo(field[child]) < 0)									// wenn tmp file < field[child], dann 
				field[i] = field[child];											// tauschen
			else																	// ansonsten abbruch
				break;
		}
		field[i] = tmp;																// evtl. vertauschen
	}
}
