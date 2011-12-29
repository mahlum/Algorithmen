/**
 *  TODO: newNode bearbeiten (was ist bei middle == null)
 */

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
		if(m_Root.get() != null){
			if(m_Root.get().m_KeyLeft != null && 
				m_Root.get().m_KeyMiddle != null &&
				m_Root.get().m_KeyRight != null){
				newNodeRoot();
			}
		}
		// Ende 1. Fall
		
		// Nun den Baum runtergehen, bis richtigen Punkt gefunden. Falls vollen Node gefunden, diesen Aufsplitten
		/**
		 * Vorgehen
		 * 
		 * 1. Ist der naechste Node voll?
		 * 2. Bin ich am Ende angekommen und kann mein key & data eingefuegt werden? -> while schleife :) 
		 * 
		 */
		tmp = m_Root;
		if(tmp.get() != null){
			while(tmp.get().m_Left.get() != null){
				//Pfad wählen :) 	
				if(oneOfThem(tmp.get(), key)){
					System.out.println("Schon vorhanden");
					return;
				}
				
				if(key.compareTo(tmp.get().m_KeyLeft) < 0){
					if(nodeFull(tmp.get().m_Left.get()))
						tmp = newNode(tmp, tmp.get().m_Left);
					else
						tmp = tmp.get().m_Left;
				} else if(tmp.get().m_KeyMiddle != null && key.compareTo(tmp.get().m_KeyMiddle) < 0) {
					if(nodeFull(tmp.get().m_MiddleLeft.get()))
						tmp = newNode(tmp, tmp.get().m_MiddleLeft);
					else
						tmp = tmp.get().m_MiddleLeft;
				} else if(tmp.get().m_KeyRight != null && key.compareTo(tmp.get().m_KeyRight) < 0) {
					if(nodeFull(tmp.get().m_MiddleRight.get()))
						tmp = newNode(tmp, tmp.get().m_MiddleRight);
					else
					 tmp = tmp.get().m_MiddleRight;
				} else {
					if (tmp.get().m_KeyMiddle == null) {
						if(nodeFull(tmp.get().m_MiddleLeft.get()))
							tmp = newNode(tmp, tmp.get().m_MiddleLeft);
						else
							tmp = tmp.get().m_MiddleLeft;
					}
					else if (tmp.get().m_KeyRight == null){
						if(nodeFull(tmp.get().m_MiddleRight.get()))
							tmp = newNode(tmp, tmp.get().m_MiddleRight);
						else
							tmp = tmp.get().m_MiddleRight;
					}
					else if(nodeFull(tmp.get().m_Right.get()))
						tmp = newNode(tmp, tmp.get().m_Right);
					else
						tmp = tmp.get().m_Right;
				}
			} 
			
			// Am letzen Node angekommen... nun einsortieren ! 
			if(key.compareTo(tmp.get().m_KeyLeft) < 0){
				tmp.get().m_KeyRight = tmp.get().m_KeyMiddle;
				tmp.get().m_DataRight = tmp.get().m_DataMiddle;
				tmp.get().m_KeyMiddle = tmp.get().m_KeyLeft;
				tmp.get().m_DataMiddle = tmp.get().m_DataLeft;
				
				tmp.get().m_KeyLeft = key;
				tmp.get().m_DataLeft = data;
			} else if(tmp.get().m_KeyMiddle == null) {
				tmp.get().m_KeyMiddle = key;
				tmp.get().m_DataMiddle = data;
			} else if(tmp.get().m_KeyMiddle != null && key.compareTo(tmp.get().m_KeyMiddle) < 0 && !oneOfThem(tmp.get(), key)){
				tmp.get().m_KeyRight = tmp.get().m_KeyMiddle;
				tmp.get().m_DataRight = tmp.get().m_DataMiddle;
				
				tmp.get().m_KeyMiddle = key;
				tmp.get().m_DataMiddle = data;
			} else if(!oneOfThem(tmp.get(), key)){
				tmp.get().m_KeyRight = key;
				tmp.get().m_DataRight = data;
			}
		} else {
			tmp.set(new Node(key, data)); 
		}
	}
	
	private boolean nodeFull(Node tmp){
		if(tmp.m_KeyLeft != null && tmp.m_KeyMiddle != null && tmp.m_KeyRight != null)
			return true;
		else
			return false;
	}
	
	private boolean oneOfThem(Node tmp, K key){
		if(tmp.m_KeyLeft == key || tmp.m_KeyMiddle == key || tmp.m_KeyRight == key) 
			return true;
		else 
			return false;
	}
	
	public void newNodeRoot(){ // tmp = alter Root
		NodeRef tmp = m_Root;
		// 1. Neuen NodeRef erstellen, der Root werden soll! (mit Value)
		NodeRef newRoot = new NodeRef();
		newRoot.set(new Node(tmp.get().m_KeyMiddle, tmp.get().m_DataMiddle));
		// 2. Left und MiddleLeft (NodeRefs) setzen (neu anlegen!)
		newRoot.get().m_Left = new NodeRef();
		newRoot.get().m_Left.set(new Node(tmp.get().m_KeyLeft, tmp.get().m_DataLeft));
		newRoot.get().m_MiddleLeft = new NodeRef();
		newRoot.get().m_MiddleLeft.set(new Node(tmp.get().m_KeyRight, tmp.get().m_DataRight));
		// Linker Knoten: Verweise �ndern
		newRoot.get().m_Left.get().m_Left.set(tmp.get().m_Left.get());
		newRoot.get().m_Left.get().m_MiddleLeft.set(tmp.get().m_MiddleLeft.get());
		
		// Rechter Knoten: Verweise ändern
		newRoot.get().m_MiddleLeft.get().m_Left.set(tmp.get().m_MiddleRight.get());
		newRoot.get().m_MiddleLeft.get().m_MiddleLeft.set(tmp.get().m_Right.get());
		
		// Neuen Root setzen !
		m_Root = newRoot;
	}
	
	public NodeRef newNode(NodeRef tmp, NodeRef tmpSplit){// tmp = aktueller tmp, tmpSplit = Node to Split 
		if(tmpSplit.get().m_KeyMiddle.compareTo(tmp.get().m_KeyLeft) < 0){
			tmp = newLeftNode(tmp, tmpSplit);			
		} else if (tmp.get().m_KeyMiddle != null && tmpSplit.get().m_KeyMiddle.compareTo(tmp.get().m_KeyMiddle) < 0){
			tmp = newMiddleNode(tmp, tmpSplit);
		} else {
			tmp = newRightNode(tmp, tmpSplit);
		}

		return tmp;
	}
	
	private NodeRef newLeftNode(NodeRef tmp, NodeRef tmpSplit){
		// Zunaechst keys und data verschieben :) 
		tmp.get().m_KeyRight = tmp.get().m_KeyMiddle;
		tmp.get().m_DataRight = tmp.get().m_DataMiddle;
		tmp.get().m_KeyMiddle = tmp.get().m_KeyLeft;
		tmp.get().m_DataMiddle = tmp.get().m_DataLeft;
		// Von tmpSplit Middle Wert auf Position "Left" setzen		
		tmp.get().m_KeyLeft = tmpSplit.get().m_KeyMiddle;
		tmp.get().m_DataLeft = tmpSplit.get().m_DataMiddle;
		// Verweise verschieben
		tmp.get().m_Right = tmp.get().m_MiddleRight;
		tmp.get().m_MiddleRight = tmp.get().m_MiddleLeft;
		// Neue Verweise anlegen
		tmp.get().m_Left = new NodeRef();
		tmp.get().m_MiddleLeft = new NodeRef();
		// Die neuen Verweise mit Leben fuellen
		tmp.get().m_Left.set(new Node(tmpSplit.get().m_KeyLeft, tmpSplit.get().m_DataLeft));
		tmp.get().m_Left.get().m_Left = tmpSplit.get().m_Left;
		tmp.get().m_Left.get().m_MiddleLeft = tmpSplit.get().m_MiddleLeft;
		
		tmp.get().m_MiddleLeft.set(new Node(tmpSplit.get().m_KeyRight, tmpSplit.get().m_DataRight));
		tmp.get().m_MiddleLeft.get().m_Left = tmpSplit.get().m_MiddleRight;
		tmp.get().m_MiddleLeft.get().m_MiddleLeft = tmpSplit.get().m_Right;	
		
		return tmp;
	}
	
	private NodeRef newMiddleNode(NodeRef tmp, NodeRef tmpSplit){
		// Zunaechst keys und data verschieben! :)
		tmp.get().m_KeyRight = tmp.get().m_KeyMiddle;
		tmp.get().m_DataRight = tmp.get().m_DataMiddle;
		// Von tmpSplit die MiddleWerte auf Position "Middle" setzen
		tmp.get().m_KeyMiddle = tmpSplit.get().m_KeyMiddle;
		tmp.get().m_DataMiddle = tmpSplit.get().m_DataMiddle;
		// Verweise verschieben
		tmp.get().m_Right = tmp.get().m_MiddleRight;
		// Neue Verweise anlegen
		tmp.get().m_MiddleLeft = new NodeRef();
		tmp.get().m_MiddleRight = new NodeRef();
		// Die neuen Verweise mit Leben fuellen
		tmp.get().m_MiddleLeft.set(new Node(tmpSplit.get().m_KeyLeft, tmpSplit.get().m_DataLeft));
		tmp.get().m_MiddleLeft.get().m_Left = tmpSplit.get().m_Left;
		tmp.get().m_MiddleLeft.get().m_MiddleLeft = tmpSplit.get().m_MiddleLeft;
		
		tmp.get().m_MiddleRight.set(new Node(tmpSplit.get().m_KeyRight, tmpSplit.get().m_DataRight));
		tmp.get().m_MiddleRight.get().m_Left = tmpSplit.get().m_MiddleRight;
		tmp.get().m_MiddleRight.get().m_MiddleLeft = tmpSplit.get().m_Right;
		
		return tmp;
	}
	
	private NodeRef newRightNode(NodeRef tmp, NodeRef tmpSplit){
		// Verschieben ist nicht n�tig!
		// Von tmpSplit die MiddleWerte auf Position "Right" setzen
		tmp.get().m_KeyRight = tmpSplit.get().m_KeyMiddle;
		tmp.get().m_DataRight = tmpSplit.get().m_DataMiddle;
		// Verschieben der Verweise nicht n�tig!
		// Neue Verweise anlegen
		tmp.get().m_MiddleRight = new NodeRef();
		tmp.get().m_Right = new NodeRef();
		// Die neuen Verweise mit Leben f�llen
		tmp.get().m_MiddleRight.set(new Node(tmpSplit.get().m_KeyLeft, tmpSplit.get().m_DataLeft));
		tmp.get().m_MiddleRight.get().m_Left = tmpSplit.get().m_Left;
		tmp.get().m_MiddleRight.get().m_MiddleLeft = tmpSplit.get().m_MiddleLeft;
		
		tmp.get().m_Right.set(new Node(tmpSplit.get().m_KeyRight, tmpSplit.get().m_DataRight));
		tmp.get().m_Right.get().m_Left = tmpSplit.get().m_MiddleRight;
		tmp.get().m_Right.get().m_MiddleLeft = tmpSplit.get().m_Right;	
		
		return tmp;
	}
	
	public D search_help(K key){
		return search(key);
	}
	
	private D search(K key){
		NodeRef tmp = m_Root;
		while(tmp.get().m_Left != null){
			if(tmp.get().m_KeyLeft.compareTo(key) == 0) return tmp.get().m_DataLeft;
			if(tmp.get().m_KeyMiddle != null && key.compareTo(tmp.get().m_KeyMiddle) == 0) return tmp.get().m_DataMiddle;
			if(tmp.get().m_KeyRight != null && key.compareTo(tmp.get().m_KeyRight) == 0) return tmp.get().m_DataRight;
			
			if(key.compareTo(tmp.get().m_KeyLeft) < 0) tmp = tmp.get().m_Left;
			else if(tmp.get().m_KeyMiddle != null && key.compareTo(tmp.get().m_KeyMiddle) < 0) tmp = tmp.get().m_MiddleLeft;
			else if(tmp.get().m_KeyRight != null && key.compareTo(tmp.get().m_KeyRight) < 0) tmp = tmp.get().m_MiddleRight;
			else {
				if(tmp.get().m_KeyMiddle == null) tmp = tmp.get().m_MiddleLeft;
				else if(tmp.get().m_KeyRight == null) tmp = tmp.get().m_MiddleRight;
				else tmp = tmp.get().m_Right;
			}
		}
		
		return null;
	}
	
	public void outputTree_help(){
		outputTree(m_Root, 0);
	}
	
	private void outputTree(NodeRef tmp, int indent){
		//REKURSION :) Wie ich es liebe ;)  
		if(tmp.get().m_Right.get() != null) {
			outputTree(tmp.get().m_Right, indent+1);
			outputValue(tmp.get().m_KeyRight, indent);
		}
		if(tmp.get().m_MiddleRight.get() != null) {
			outputTree(tmp.get().m_MiddleRight, indent+1);
			outputValue(tmp.get().m_KeyMiddle, indent);
		}
		if(tmp.get().m_MiddleLeft.get() != null) {
			outputTree(tmp.get().m_MiddleLeft, indent+1);
			outputValue(tmp.get().m_KeyLeft, indent);
		}
		if(tmp.get().m_Left.get() != null) outputTree(tmp.get().m_Left, indent+1);
		
		if(tmp.get().m_Left.get() == null) outputAll(tmp.get(), indent);		
	}
	
	private void outputValue(K value, int indent){
		indent(indent);
		System.out.print(value + "\n");
	}
	
	private void outputAll(Node node, int indent){
		indent(indent);
		if(node.m_KeyLeft != null) System.out.print(node.m_KeyLeft + " ");
		if(node.m_KeyMiddle != null) System.out.print(node.m_KeyMiddle + " ");
		if(node.m_KeyRight != null) System.out.print(node.m_KeyRight);
		System.out.println();
	}
	
	private void indent(int indent){
		for(int i = 0; i <= indent; ++i) System.out.print("\t");
	}
}
