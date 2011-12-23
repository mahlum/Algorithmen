package binTree;

public class BinTree<K extends Comparable<K>,D> {
	private NodeRef m_Root = new NodeRef();
	
	class Node {
		K m_Key;
		D m_Data;
		NodeRef m_Left = new NodeRef();
		NodeRef m_Right = new NodeRef();		
		
		public Node (K key, D data){
			m_Key = key;
			m_Data = data;
		}	
	}
	
	class NodeRef {
		private Node m_Node = null;
		
		public void set(Node n){
			m_Node = n;
		}
		
		public Node get() {
			return m_Node;
		}
	}
	
	public void insert(K key, D data){
		NodeRef tmp =
	}
	

}
