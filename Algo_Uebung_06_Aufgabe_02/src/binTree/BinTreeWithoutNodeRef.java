/**
 * Hier wird der bin√§re Baum implementiert OHNE NodeRef
 */

package binTree;

public class BinTreeWithoutNodeRef<K extends Comparable<K>, D> {
	// private NodeRef m_Root = new NodeRef();
	private Node m_Root = null;

	class Node {
		K m_Key;
		D m_Data;
		Node m_Left;
		Node m_Right;

		public Node(K key, D data) {
			m_Key = key;
			m_Data = data;
			m_Left = null;
			m_Right = null;
		}
	}

	public void insert_help(K key, D data) {
		if (m_Root == null)
			m_Root = new Node(key, data);
		else
			insert(key, data, m_Root);
	}

	private void insert(K key, D data, Node actualNode) {
		final int TMP = key.compareTo(actualNode.m_Key);
		if (TMP < 0) {
			if (actualNode.m_Left == null)
				actualNode.m_Left = new Node(key, data);
			else
				insert(key, data, actualNode.m_Left);
		} else {
			if (actualNode.m_Right == null)
				actualNode.m_Right = new Node(key, data);
			else
				insert(key, data, actualNode.m_Right);
		}
	}

	public void giveMeTheFuckingNodeData(K key) {
		if (search(key) != null)
			System.out.println("Zu dem Schl¸ssel " + key
					+ " gibt es folgende Daten: " + (search(key).m_Data));
		else
			System.out.println("Zu dem Schl¸ssel " + key
					+ " gibt es folgende Daten: " + (search(key)));
	}

	private Node search(K key) {
		Node actualNode = m_Root;
		while (actualNode != null) {
			final int RES = key.compareTo(actualNode.m_Key);
			if (RES == 0)
				return actualNode;
			actualNode = RES < 0 ? actualNode.m_Left : actualNode.m_Right;
		}
		return null;
	}

	public void remove_help(K key) {
		/* 1. Fall = n2d == m_Root */
		if (key == m_Root.m_Key)
			removeRoot(m_Root);
		else
			remove(key, m_Root);
	}

	private void removeRoot(Node actualNode) {
		if (actualNode.m_Right != null && actualNode.m_Left != null) {
			Node tmp = actualNode.m_Right;
			while (tmp.m_Left != null) {
				tmp = tmp.m_Left;
			}
			tmp.m_Left = actualNode.m_Left;
			m_Root = actualNode.m_Right;
		} else if (actualNode.m_Right == null && actualNode.m_Left != null)
			m_Root = actualNode.m_Left;
		else if (actualNode.m_Right != null && actualNode.m_Left == null)
			m_Root = actualNode.m_Right;
		else if (actualNode.m_Right == null && actualNode.m_Left == null)
			m_Root = null;
	}

	private void remove(K key, Node actualNode) {
		/* 2. Fall = n2d != m_Root */
		final int RES = key.compareTo(actualNode.m_Key);
		if (RES < 0) {
			if (actualNode.m_Left.m_Key == key) {
				Node tmp;
				if (actualNode.m_Left.m_Right != null
						&& actualNode.m_Left.m_Left != null) {
					tmp = actualNode.m_Left.m_Right;
					while (tmp.m_Left != null) {
						tmp = tmp.m_Left;
					}
					tmp.m_Left = actualNode.m_Left.m_Left;
					actualNode.m_Left = actualNode.m_Left.m_Right;
				} else if (actualNode.m_Left.m_Right == null
						&& actualNode.m_Left.m_Left != null)
					actualNode.m_Left = actualNode.m_Left.m_Left;
				else if (actualNode.m_Left.m_Right != null
						&& actualNode.m_Left.m_Left == null)
					actualNode.m_Left = actualNode.m_Left.m_Right;
				else if (actualNode.m_Left.m_Right == null
						&& actualNode.m_Left.m_Left == null)
					actualNode.m_Left = null;
			} else
				remove(key, actualNode.m_Left);
		} else {
			if (actualNode.m_Right.m_Key == key) {
				Node tmp;
				if (actualNode.m_Right.m_Right != null
						&& actualNode.m_Right.m_Left != null) {
					tmp = actualNode.m_Right.m_Right;
					while (tmp.m_Left != null) {
						tmp = tmp.m_Left;
					}
					tmp.m_Left = actualNode.m_Right.m_Left;
					actualNode.m_Left = actualNode.m_Right.m_Right;
				} else if (actualNode.m_Right.m_Right == null
						&& actualNode.m_Right.m_Left != null)
					actualNode.m_Right = actualNode.m_Right.m_Left;
				else if (actualNode.m_Right.m_Right != null
						&& actualNode.m_Right.m_Left == null)
					actualNode.m_Right = actualNode.m_Right.m_Right;
				else if (actualNode.m_Right.m_Right == null
						&& actualNode.m_Right.m_Left == null)
					actualNode.m_Right = null;
			} else
				remove(key, actualNode.m_Right);
		}
	}

	// private void remove(K key, Node actualNode){
	// /* 2. Fall = n2d != m_Root */
	// final int RES = key.compareTo(actualNode.m_Key);
	// if(RES < 0){
	// comparer(key, actualNode.m_Left);
	// } else {
	// comparer(key, actualNode.m_Right);
	// }
	// }
	//
	// private void comparer(K key, Node needIt){
	// if(needIt.m_Key == key){
	// Node tmp;
	// if(needIt.m_Right != null && needIt.m_Left != null){
	// tmp = needIt.m_Right;
	// while(tmp.m_Left != null){
	// tmp = tmp.m_Left;
	// }
	// tmp.m_Left = needIt.m_Left;
	// needIt = needIt.m_Right;
	// }
	// else if(needIt.m_Right == null && needIt.m_Left != null)
	// needIt.m_Left = needIt.m_Left;
	// else if(needIt.m_Right != null && needIt.m_Left == null)
	// needIt = needIt.m_Right;
	// else if(needIt.m_Right == null && needIt.m_Left == null)
	// needIt = null;
	// } else
	// remove(key, needIt);
	// }
}
