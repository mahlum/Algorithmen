package redBlackTreeWithNode;

public class BlackRedTree <K extends Comparable<K>, D>{
	private NodeRef m_Root = new NodeRef();
	
	class Node {
		K m_Key;
		D m_Data;
		NodeRef m_Left = new NodeRef();
		NodeRef m_Right = new NodeRef();
		boolean m_blsRed = true;
		
		public Node(K key, D data){
			m_Key = key;
			m_Data = data;
		}
		
		public boolean is4Node(){
			return m_Left.get() != null && m_Left.get().m_blsRed
					&& m_Right.get() != null && m_Right.get().m_blsRed;
		}
		
		void convert4Node(){
			m_Left.get().m_blsRed = false;
			m_Right.get().m_blsRed = false;
			m_blsRed = true;
		}
		
	}
	
	class NodeRef{
		private Node m_Node = null;
		
		public void set(Node n){
			m_Node = n;
		}
		
		public Node get(){
			return m_Node;
		}
	}
	
	public void insert(K key, D data){
		NodeRef node = m_Root;
		NodeRef dad = null;
		NodeRef grandDad = null;
		while(node.get() != null){
			if(node.get().is4Node()){
				node.get().convert4Node();
				split(key, node, dad, grandDad);
				if(grandDad != null){
					node = grandDad;
					dad = null;
				}
			}
			grandDad = dad;
			dad = node;
			final int RES = key.compareTo(node.get().m_Key);
			if(RES == 0) return;
			node = RES < 0 ? node.get().m_Left : node.get().m_Right;
		}
		node.set(new Node(key, data));
		split(key, node, dad, grandDad);
		m_Root.get().m_blsRed = false;
	}
	
	private void split(K key, NodeRef node, NodeRef dad, NodeRef grandDad){
		if(dad != null && dad.get() != null && grandDad != null && grandDad.get() != null
			&& dad.get().m_blsRed){
				grandDad.get().m_blsRed = true;
				if(grandDad.get().m_Key.compareTo(key) <= 0 !=
						dad.get().m_Key.compareTo(key) <= 0)
					rotate(node, dad);
				rotate(dad, grandDad);
				grandDad.get().m_blsRed = false;
			}
	}
	
	public Node search(K key){
		Node tmp = m_Root.get();
		while(tmp != null){
			final int RES = key.compareTo(tmp.m_Key);
			if(RES == 0) return tmp;
			tmp = RES < 0 ? tmp.m_Left.get() : tmp.m_Right.get();
		}
		return null;
	}
	
	private void rotate(NodeRef node, NodeRef dad){
		Node son = node.get();
		if(dad.get().m_Left == node){
			// clockwise rotation
			node.set(son.m_Right.get());
			son.m_Right.set(dad.get());
		}else{
			// counter-clockwise rotation
			node.set(son.m_Left.get());
			son.m_Left.set(dad.get());
		}
		dad.set(son);
	}

}
