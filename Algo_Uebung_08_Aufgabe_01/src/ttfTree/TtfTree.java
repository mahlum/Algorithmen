package ttfTree;

public class TtfTree<K extends Comparable<K>, D> {
	private NodeRef m_Root = new NodeRef();
	
	class Node {
		K m_KeyLeft;
		K m_KeyMiddle;
		K m_KeyRight;
		
		D m_DataLeft;
		D m_DataMiddle;
		D m_DataRight;
		
		NodeRef m_Left = new NodeRef();
		NodeRef m_MiddleLeft = new NodeRef();
		NodeRef m_MiddleRight = new NodeRef();
		NodeRef m_Right = new NodeRef();
		
		public Node (K key, D data){
			if(m_KeyLeft == null) {
				m_KeyLeft = key;
				m_DataLeft = data;
			}
			else if(m_KeyMiddle == null) {
				m_KeyMiddle = key;
				m_DataMiddle = data;
			}
			else {
				m_KeyRight = key;
				m_DataRight = data;
			}
		}
	}
	
	class NodeRef {
		private Node m_Node = null;
		
		public void set(Node n) {
			m_Node = n;
		}
		
		public Node get() {
			return m_Node;
		}
	}
	
	public void insert(K key, D data){
		NodeRef tmp = m_Root;
		/**
		 * Hier muss jetzt die Suche rein ...
		 * 
		 * 1. Fall m_Root Node ist voll!
		 * 2. Fall irgendein Node ist voll! :)
		 */
		// Start 1. Fall: 
		if(m_Root.m_Node.m_KeyLeft != null && 
				m_Root.m_Node.m_KeyMiddle != null &&
				m_Root.m_Node.m_KeyRight != null){
			tmp = newNodeRoot(tmp);
		}
		
		
		
		
		
		
		// Ende 1. Fall
		
		
	}
	
	public NodeRef newNodeRoot(NodeRef tmp){
		NodeRef newRoot = new NodeRef();
		newRoot.set(new Node(tmp.m_Node.m_KeyMiddle, tmp.m_Node.m_DataMiddle));
		newRoot.m_Node.m_Left = tmp;
		newRoot.m_Node.m_Right = new NodeRef();
		newRoot.m_Node.m_Right.set(new Node(tmp.m_Node.m_KeyRight, tmp.m_Node.m_DataRight));
		
		// Linker Knoten: Verweise ändern
		tmp.m_Node.m_Right.set(tmp.m_Node.m_MiddleLeft.m_Node);
		tmp.m_Node.m_MiddleLeft = null;
		tmp.m_Node.m_MiddleRight = null;
		// Linker Konten: überflüssige Keys und Data löschen
		tmp.m_Node.m_KeyMiddle = null;
		tmp.m_Node.m_KeyRight = null;		
		tmp.m_Node.m_DataMiddle = null;
		tmp.m_Node.m_DataRight = null;
		
		return null;
	}
	
	
	public Node search(K key){
		Node tmp = m_Root.get();
		return null;
	}
}
