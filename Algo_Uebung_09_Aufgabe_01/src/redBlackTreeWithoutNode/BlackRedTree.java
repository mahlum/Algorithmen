package redBlackTreeWithoutNode;


public class BlackRedTree <K extends Comparable<K>, D>{
	private Node m_Root = null;
	
	class Node {
		K m_Key;
		D m_Data;
		Node m_Left = null;
		Node m_Right = null;
		boolean m_blsRed = true;
		
		public Node(K key, D data){
			m_Key = key;
			m_Data = data;
		}
		
		public boolean is4Node(){
			return m_Left != null && m_Left.m_blsRed
					&& m_Right != null && m_Right.m_blsRed;
		}
		
		void convert4Node(){
			m_Left.m_blsRed = false;
			m_Right.m_blsRed = false;
			m_blsRed = true;
		}
		
	}
	
	public void insert(K key, D data){
		boolean letitwalk = true;
		Node node = m_Root;
		if(m_Root == null)
			m_Root = new Node(key, data);
		else {
			while(letitwalk){
				if(node.is4Node()){
					node.convert4Node();
					split_it(key, node);
				}
				final int RES = key.compareTo(node.m_Key);
				if(RES == 0) return;
				if(RES < 0) {
					if(node.m_Left == null) {
						node.m_Left = new Node(key, data);
						letitwalk = false;
					} else {
						final int RES2 = key.compareTo(node.m_Left.m_Key);
						if(RES2 < 0){
							if(node.m_Left.m_Left == null){
								node.m_Left.m_Left = new Node(key,data);
								split_it(key, node);
								letitwalk = false;
							} else {
								node = node.m_Left;
							}
						} else{
							if(node.m_Left.m_Right == null){
								node.m_Left.m_Right = new Node(key, data);
								split_it(key, node);
								letitwalk = false;
							} else 
								node = node.m_Left;
						}
					}					
				} else {
					if(node.m_Right == null) {
						node.m_Right = new Node(key, data);
						letitwalk = false;
					} else {
						final int RES2 = key.compareTo(node.m_Right.m_Key);
						if(RES2 < 0){
							if(node.m_Right.m_Left == null){
								node.m_Right.m_Left = new Node(key, data);
								split_it(key, node);
								letitwalk = false;
							} else 
								node = node.m_Right;
						} else {
							if(node.m_Right.m_Right == null){
								node.m_Right.m_Right = new Node(key, data);
								split_it(key, node);
								letitwalk = false;
							} else
								node = node.m_Right;
						}
					}
				}
			}
		}
		if(m_Root != null) m_Root.m_blsRed = false;
	}
	
	private void split_it(K key, Node node){
		if(key.compareTo(node.m_Key) < 0){
			if(node.m_Left != null && key.compareTo(node.m_Left.m_Key) < 0) {
				if (node.m_Left.m_Left != null) 
					split(key, node.m_Left.m_Left, node.m_Left, node);
			} else if (node.m_Left != null){
				if(node.m_Left.m_Right != null)
					split(key, node.m_Left.m_Right, node.m_Left, node);
			}
		} else {
			if(node.m_Right != null && key.compareTo(node.m_Right.m_Key) < 0) {
				if (node.m_Right.m_Left != null)
					split(key, node.m_Right.m_Left, node.m_Right, node);
			} else if (node.m_Right != null){
				if(node.m_Right.m_Right != null)
					split(key, node.m_Right.m_Right, node.m_Right, node);
			}
		}
	}
	
	private void split(K key, Node node, Node dad, Node grandDad){
		if(dad.m_blsRed){
			grandDad.m_blsRed = true;
			if(grandDad.m_Key.compareTo(key) <= 0 !=
					dad.m_Key.compareTo(key) <= 0)
				rotate(node, dad);
			rotate(dad, grandDad);
			grandDad.m_blsRed = false;
		}
		
	}
	
	private void rotate(Node node, Node dad){
		Node son = node;
		if(dad.m_Left == node){
			// clockwise rotation
			dad.m_Left = son.m_Right;
			son.m_Right = new Node(dad.m_Key, dad.m_Data);
			son.m_Right.m_blsRed = dad.m_blsRed;
			son.m_Right.m_Right = dad.m_Right;
			son.m_Right.m_Left = dad.m_Left;
		}else{
			// counter-clockwise rotation
			dad.m_Right = son.m_Left;
			son.m_Left = new Node(dad.m_Key, dad.m_Data);
			son.m_Left.m_blsRed = dad.m_blsRed;
			son.m_Left.m_Right = dad.m_Right;
			son.m_Left.m_Left = dad.m_Left;
		}
		dad.m_Key = son.m_Key;
		dad.m_Data = son.m_Data;
		dad.m_blsRed = son.m_blsRed;
		dad.m_Left = son.m_Left;
		dad.m_Right = son.m_Right;
	}
	
	public Node search(K key){
		Node tmp = m_Root;
		while(tmp != null){
			final int RES = key.compareTo(tmp.m_Key);
			if(RES == 0) return tmp;
			tmp = RES < 0 ? tmp.m_Left : tmp.m_Right;
		}
		return null;
	}
	
	/**
	 * Baumausgabe 
	 */
	
	public void outputTree_help(){
		outputTree(m_Root, -1);
	}
	
	private void outputTree(Node tmp, int indent){
		//REKURSION :) Wie ich es liebe ;)  
		if(tmp.m_Left == null && tmp.m_Right == null) {
			outputValue(tmp, indent);
		}else {
			if(tmp.m_Right != null) {
				outputTree(tmp.m_Right, indent+1);
				outputValue(tmp, indent);
			} else if(tmp.m_Right == null) outputValue(tmp, indent); 
			
			
			if(tmp.m_Left != null) outputTree(tmp.m_Left, indent+1);
		}
	}
	
	private void outputValue(Node value, int indent){
		indent(indent);
		if(value.m_blsRed) System.out.print("=");
		System.out.print(value.m_Key + "\n");
	}
		
	private void indent(int indent){
		for(int i = 0; i <= indent; ++i) System.out.print("\t");
	}

}
