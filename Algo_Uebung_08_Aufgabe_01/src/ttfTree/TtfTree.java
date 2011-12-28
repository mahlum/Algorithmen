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
				m_KeyLeft = key;
				m_DataLeft = data;
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
		
		// Nun den Baum runtergehen, bis richtigen Punkt gefunden. Falls vollen Node gefunden, diesen Aufsplitten
		while(tmp.get() != null){
			if(tmp.m_Node.m_KeyLeft != null &&
					tmp.m_Node.m_KeyMiddle != null &&
					tmp.m_Node.m_KeyRight != null){
				tmp = newNode(tmp);
			}
				
			
			//Pfad wählen :) 
			if(key.compareTo(tmp.get().m_KeyLeft) < 0) tmp = tmp.get().m_Left;
			else if(key.compareTo(tmp.get().m_KeyMiddle) < 0) tmp = tmp.get().m_MiddleLeft;
			else if(key.compareTo(tmp.get().m_KeyRight) < 0) tmp = tmp.get().m_MiddleRight;
			else tmp = tmp.get().m_Right;
		}
	}
	
	public NodeRef newNodeRoot(NodeRef tmp){
		NodeRef newRoot = new NodeRef();
		newRoot.set(new Node(tmp.m_Node.m_KeyMiddle, tmp.m_Node.m_DataMiddle));
		newRoot.m_Node.m_Left = new NodeRef();
		newRoot.m_Node.m_Left.set(new Node(tmp.m_Node.m_KeyLeft, tmp.m_Node.m_DataLeft));
		newRoot.m_Node.m_Right = new NodeRef();
		newRoot.m_Node.m_Right.set(new Node(tmp.m_Node.m_KeyRight, tmp.m_Node.m_DataRight));
		
		// Linker Knoten: Verweise �ndern
		newRoot.m_Node.m_Left.m_Node.m_Left.set(tmp.m_Node.m_Left.m_Node);
		newRoot.m_Node.m_Left.m_Node.m_Right.set(tmp.m_Node.m_MiddleLeft.m_Node);
		
		// Rechter Knoten: Verweise ändern
		newRoot.m_Node.m_Right.m_Node.m_Left.set(tmp.m_Node.m_MiddleRight.m_Node);
		newRoot.m_Node.m_Right.m_Node.m_Right.set(tmp.m_Node.m_Right.m_Node);
		
		return newRoot;
	}
	
	// tmp = aktueller tmp, tmpSplit = Node to Split
	public NodeRef newNode(NodeRef tmp, NodeRef tmpSplit){
		if(tmpSplit.m_Node.m_KeyMiddle.compareTo(tmp.m_Node.m_KeyLeft) < 0){
			// Erstmal umsortieren
			tmp.m_Node.m_KeyRight = tmp.m_Node.m_KeyMiddle;
			tmp.m_Node.m_DataRight = tmp.m_Node.m_DataMiddle;
			tmp.m_Node.m_KeyMiddle = tmp.m_Node.m_KeyLeft;
			tmp.m_Node.m_DataMiddle = tmp.m_Node.m_DataLeft;
			tmp.m_Node.m_KeyLeft = tmpSplit.m_Node.m_KeyMiddle;
			tmp.m_Node.m_DataLeft = tmpSplit.m_Node.m_DataMiddle;
			// Nun müssen die Verweise geändert werden
			
			
			
		} else if (tmp.m_Node.m_KeyMiddle != null && tmpSplit.m_Node.m_KeyMiddle.compareTo(tmp.m_Node.m_KeyMiddle) < 0){
			tmp.m_Node.m_KeyRight = tmp.m_Node.m_KeyMiddle;
			tmp.m_Node.m_DataRight = tmp.m_Node.m_DataMiddle;
			tmp.m_Node.m_KeyMiddle = tmpSplit.m_Node.m_KeyMiddle;
			tmp.m_Node.m_DataMiddle = tmpSplit.m_Node.m_DataMiddle;
		} else {
			tmp.m_Node.m_KeyRight = tmpSplit.m_Node.m_KeyMiddle;
			tmp.m_Node.m_DataRight = tmpSplit.m_Node.m_DataMiddle;
		}
		
		
			
		return null;
	}
	
	public Node search(K key){
		Node tmp = m_Root.get();
		return null;
	}
}
