package studentlist.compsci.sdsu;

import java.util.AbstractSequentialList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class LinkedList<Type> extends AbstractSequentialList<Type> {
	private Node<Type> tailNode = new NullNode();
	private Node<Type> headNode = new NullNode();
	private int linkedListSize = 0;
	private Node newNode = new NullNode();

	private int getLinkedListSize() {
		return linkedListSize;
	}

	private void setLinkedListSize(int linkedListSize) {
		this.linkedListSize = linkedListSize + 1;
	}

	@Override
	public boolean add(Object genericObject) {
		linkedListSize = getLinkedListSize();
		setLinkedListSize(linkedListSize);
		newNode = newNode.add(genericObject, headNode, tailNode);

		if (linkedListSize == 1)
			headNode = newNode;

		tailNode = newNode;
		return true;
	}

	/** Need to handle the exceptions when getting the data out of index range **/
	@SuppressWarnings("unchecked")
	public Type get(int index) {
		// TODO Auto-generated method stub
		Node<Type> nodePointer = (Node<Type>) headNode;
		int nodeCount = 0;
		try {
			if (index > getLinkedListSize())
				throw new ArrayIndexOutOfBoundsException();
			else {
				while (nodeCount < index) {
					nodePointer = nodePointer.getNext();
					nodeCount = nodeCount + 1;
				}
			}
		} catch (ArrayIndexOutOfBoundsException positionError) {
			return (Type) new NullNode();
		}
		return nodePointer.getData();
	}

	public Iterator<Type> iterator() {
		// TODO Auto-generated method stub
		return new LinkedListIterator<Type>(headNode, tailNode);
	}

	public LinkedList<Type> sort(StrategyPattern<Type> sortingAlgorithm) {
		LinkedList<Type> sortedLinkedList = null;
		Object[] linkedListArray = new Object[linkedListSize];
		linkedListArray = this.toArray(linkedListArray);
		sortedLinkedList = sortingAlgorithm.sort(linkedListArray);
		return sortedLinkedList;
	}

	@Override
	public void add(int index, Object element) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean addAll(Collection c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(int index, Collection c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsAll(Collection c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int indexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int lastIndexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ListIterator listIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListIterator listIterator(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	
	@Override
	public boolean removeAll(Collection c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object set(int index, Object element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return linkedListSize;
	}

	@Override
	public List subList(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		Object[] linkedListArray = new Object[linkedListSize];
		for (int index = 0; index < linkedListSize; index++) {
			linkedListArray[index] = this.get(index);
		}
		return linkedListArray;
	}

	@Override
	public Object[] toArray(Object[] linkedListArray) {
		// TODO Auto-generated method stub
		for (int index = 0; index < linkedListSize; index++) {
			linkedListArray[index] = this.get(index);
		}
		return linkedListArray;
	}

	public String toString(){
		List<String> linkedList=null;
		linkedList=(List<String>) this.stream()
				.collect(Collectors.toList());
		return linkedList.toString();
}
	public static class Node<Type> {
		private Type data;
		private Node<Type> next;
		private Node<Type> previous;

		Node() {
		}

		Node(Type studentObject, Node<Type> next, Node<Type> previous) {
			setData(studentObject);
		}

		public Type getData() {
			return data;
		}

		public void setData(Type data) {
			this.data = data;
		}

		public Node<Type> getNext() {
			return next;
		}

		public void setNext(Node<Type> next) {
			this.next = next;
		}

		public Node<Type> getPrevious() {
			return previous;
		}

		public void setPrevious(Node<Type> previous) {
			this.previous = previous;
		}

		public boolean isNull() {
			return false;
		}

		public Node<Type> add(Object genericObject, Node<Type> linkedListHead,
				Node<Type> linkedListTail) {
			Node<Type> newNode = new Node<Type>((Type) genericObject,
					linkedListHead, linkedListTail);
			linkedListTail.setNext(newNode);
			newNode.setPrevious(linkedListTail);
			linkedListTail = newNode;
			return linkedListTail;
		}
	}

	public static class NullNode extends Node {

		NullNode() {
		}

		public boolean isNull() {
			return true;
		}

		public Node add(Object genericObject, Node linkedListHead,
				Node linkedListTail) {
			Node newNode = new Node(genericObject, linkedListHead,
					linkedListTail);
			return newNode;
		}
	}
}
