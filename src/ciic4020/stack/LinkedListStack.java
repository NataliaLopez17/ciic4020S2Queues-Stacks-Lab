package ciic4020.stack;

public class LinkedListStack<E> implements Stack<E> {

	// private fields
	private int currentSize;
	private Node header;
	
	@SuppressWarnings("unused")
	private class Node {
		private E value;
		private Node next;
		
		public Node(E value, Node next) {
			this.value = value;
			this.next = next;
		}
		
		public Node(E value) {
			this(value, null); // Delegate to other constructor
		}
		
		public Node() {
			this(null, null); // Delegate to other constructor
		}

		public E getValue() {
			return value;
		}

		public void setValue(E value) {
			this.value = value;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}
		
		public void clear() {
			value = null;
			next = null;
		}				
	} // End of Node class

	public LinkedListStack() {
		currentSize = 0;
		header = new Node();
	}

	@Override
	public int size() {
		return currentSize;
	}

	@Override
	public boolean isEmpty() {
		return size() == 0;
	}

	@Override
	public void push(E e) {
		if (e == null)
			throw new IllegalArgumentException("Parameter cannot be null");
		Node newNode = new Node(e, header.getNext());
		header.setNext(newNode);
		currentSize++;
	}

	@Override
	public E pop() {
		if (isEmpty())
			return null;
		Node rmNode = header.getNext();
		E result = rmNode.getValue();
		header.setNext(rmNode.getNext());
		rmNode.clear();
		currentSize--;
		return result;
	}

	@Override
	public E top() {
		if (isEmpty())
			return null;
		return header.getNext().getValue();
	}

	@Override
	public void clear() {
		while (!isEmpty())
			pop();
	}

	@SuppressWarnings("unchecked")
	@Override
	public E[] toArray() {
		E[] theArray = (E[]) new Object[size()];
		
		/* First node is top of the stack,
		 * which we want at the end of the array. */
		int i = size() - 1;
		for (Node curNode = header.getNext(); curNode != null; curNode = curNode.getNext())
			theArray[i--] = curNode.getValue();
		return theArray;
	}

}