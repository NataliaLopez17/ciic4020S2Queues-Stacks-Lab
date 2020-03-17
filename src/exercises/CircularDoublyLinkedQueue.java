package exercises;

import ciic4020.queue.Deque;

public class CircularDoublyLinkedQueue<E> implements Deque<E> {

	private int currentSize;
	private Node header;

	@SuppressWarnings("unused")
	private class Node {
		private E value;
		private Node next, prev;

		public Node(E value, Node next, Node prev) {
			this.value = value;
			this.next = next;
			this.prev = prev;
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

		public Node getPrev() {
			return prev;
		}

		public void setPrev(Node prev) {
			this.prev = prev;
		}

		public void clear() {
			value = null;
			next = prev = null;
		}
	}

	@Override
	public int size() {
		return this.currentSize;
	}

	@Override
	public boolean isEmpty() {
		return this.size() == 0;
	}

	@Override
	public void clear() {
		while (!this.isEmpty()) {
			this.removeFirst();
		}

	}

	@Override
	public E getFirst() {
		Node curNode = this.header;
		E result = curNode.getValue();
		return result;
	}

	@Override
	public E getLast() {
		E result = null;
		Node curNode = this.header;
		result = curNode.getPrev().getValue();
		return result;
	}

	@Override
	public void addFirst(E element) throws IllegalArgumentException {
		if (this.isEmpty()) {
			this.header = new Node(null, null, null);
			this.header.setNext(new Node(element, null, null));
			this.currentSize++;
		} else {
			if (this.header.getPrev() == null) {
				Node temp = new Node(element, null, null);
				this.header.setNext(temp);
				this.currentSize++;
			} else {
				Node newNode = this.header;
				Node temp = new Node(element, newNode.getNext(), newNode.getPrev());
				this.header.setNext(temp);
				this.currentSize++;
			}

		}
	}

	@Override
	public void addLast(E element) throws IllegalArgumentException {
		if (this.isEmpty()) {
			Node newNode = new Node(element, this.header, null);
			this.header.setPrev(newNode);
			currentSize++;
		}

		Node curNode = this.header;
		Node newNode = curNode.getNext();
		Node result = null;
		result.setValue(element);
		result.setPrev(curNode.getPrev());
		result.getPrev().setNext(result);
		result.setNext(curNode);
		curNode.setPrev(result);

		currentSize++;

	}

	@Override
	public E removeFirst() {
		if (this.isEmpty()) {
			return null;
		}
		Node curNode = this.header;
		Node nextNode = curNode.getNext();
		E result = curNode.getNext().getValue();
		curNode.setNext(nextNode.getNext());
		nextNode.clear();
		currentSize--;
		return result;
	}

	@Override
	public E removeLast() {
		if (this.isEmpty()) {
			return null;
		}
		Node curNode = this.header;
		E result = curNode.getPrev().getValue();
		curNode.getPrev().getPrev().setNext(curNode);
		curNode.getPrev().clear();
		currentSize--;
		return result;
	}

	@Override
	public E[] toArray() {
		@SuppressWarnings("unchecked")
		E[] theArray = (E[]) new Object[size()];
		Node curNode = this.header;
		theArray[0] = curNode.getValue();
		int i = 1;
		while (curNode.getNext() != header) {
			theArray[i++] = curNode.getNext().getValue();
			curNode = curNode.getNext();
		}
		return theArray;
	}

	public static void main(String[] args) {
		CircularDoublyLinkedQueue<Object> cdllq = new CircularDoublyLinkedQueue<Object>();
		cdllq.addFirst("hi");
		cdllq.addFirst("bye");
		cdllq.addFirst("ciao");
		cdllq.addLast("arigaTO");
		cdllq.addFirst("kawaii");
		cdllq.addLast("sugoi");

		Object[] array = cdllq.toArray();

		for (Object obj : array) {
			System.out.println(obj);
		}
		System.out.println("================");

	}

}
