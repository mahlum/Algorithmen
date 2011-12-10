/**
 * Hier wird der binäre Baum implementiert MIT NodeRef
 */

package binTree;

public class BinTree<K extends Comparable<K>,D> {
	private NodeRef m_Root = new NodeRef();
	
	class Node {
		K m_Key;
		D m_Data;
		NodeRef m_Left = new NodeRef();
		NodeRef m_Right = new NodeRef();
		
		public Node(K key, D data){
			m_Key = key;
			m_Data = data;
		}
	}
	
	class NodeRef {
		private Node m_Node = null;
		
		public void set(Node n){
			m_Node = n;
		}
		
		public Node get(){
			return m_Node;
		}
	}

	public void insert(K key, D data){
		NodeRef tmp = m_Root;
		while (tmp.get() != null){
			tmp = (key.compareTo(tmp.get().m_Key) < 0) ? tmp.get().m_Left : tmp.get().m_Right;
		}
		tmp.set(new Node(key,data));
	}

	public Node search(K key){
		Node tmp = m_Root.get();
		while(tmp != null){
			final int RES = key.compareTo(tmp.m_Key);
			if(RES == 0)
				return tmp;
			tmp = RES < 0 ? tmp.m_Left.get() : tmp.m_Right.get();
		}
		return null;
	}

	public void remove(K key){
		NodeRef tmp = m_Root;
		while(tmp.get() != null && tmp.get().m_Key != key){
			tmp = key.compareTo(tmp.get().m_Key) < 0 ? tmp.get().m_Left : tmp.get().m_Right;
		}
		Node next = null;
		if(tmp.get() == null){
			return;
		} else if(tmp.get().m_Right.get() == null){
			next = tmp.get().m_Left.get();
		} else {
			next = tmp.get().m_Right.get();
			NodeRef pNF = next.m_Left;
			while(pNF.get() != null)
				pNF = pNF.get().m_Left;
			pNF.set(tmp.get().m_Left.get());
		}
		tmp.set(next);
	}
}

