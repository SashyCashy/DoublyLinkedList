package studentlist.compsci.sdsu;

import studentlist.compsci.sdsu.LinkedList.Node;
import studentlist.compsci.sdsu.LinkedList.NullNode;

@SuppressWarnings("hiding")
public class LinkedListIterator<Type> implements java.util.Iterator<Type> {
	private int iteratorCount = 0;

	// Node nodePointer = new Node().newNullNode();
	private Node nodePointer = new NullNode();
	private Node tailNode = new NullNode();
	

	LinkedListIterator() {
	}

	LinkedListIterator(Node headNode, Node tailNode) {
		nodePointer = headNode;
		this.tailNode = tailNode;
	}

	public boolean hasNext() {
		// TODO Auto-generated method stub
		return (tailNode.getNext() != nodePointer);
	}

	public Type next() {
		// TODO Auto-generated method stub
		iteratorCount = iteratorCount + 1;
		Type getData = (Type) nodePointer.getData();
		nodePointer = nodePointer.getNext();
		return getData;
	}

	public void add(Type genericObject) {
		// TODO Auto-generated method stub
		LinkedList<Type> linkedList = new LinkedList<>();
		linkedList.add(genericObject);
	}

	public String toString() {
		return nodePointer.getData().toString();
	}

}
