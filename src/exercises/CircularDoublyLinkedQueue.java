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
		while (this.header.getNext() != header) {
			this.removeLast();
		}

	}

	@Override
	public E getFirst() {
		if (this.isEmpty()) {
			return null;
		}
		Node curNode = this.header;
		Node nextNode = curNode.getNext();
		E result = nextNode.getValue();
		return result;
	}

	@Override
	public E getLast() {
		if (this.isEmpty()) {
			return null;
		}
		E result = null;
		Node curNode = this.header;
		result = curNode.getPrev().getValue();
		return result;
	}

	@Override
	public void addFirst(E element) throws IllegalArgumentException {
		if (this.isEmpty()) {
			this.header = new Node(null, new Node(element, this.header, this.header), null);

			this.currentSize++;

		} else {

			Node temp = new Node(element, this.header.getNext(), this.header);
			this.header.setNext(temp);
			this.header.setPrev(temp);
		}
		this.currentSize++;
	}

	@Override

	public void addLast(E element) throws IllegalArgumentException {
		if (this.isEmpty()) {
			Node newNode = new Node(element, this.header, this.header);

			this.header.setPrev(newNode);
			this.header.setNext(newNode);

			currentSize++;
		} else {
			Node headPrev = new Node(element, this.header, this.header.getPrev());

			this.header.setPrev(headPrev);
		}
		currentSize++;

	}

	@Override
	public E removeFirst() {
		if (this.isEmpty()) {
			return null;
		}

		Node headNode = this.header;

		Node headNext = this.header.getNext();

		E result = headNext.getValue();

		this.header.setNext(headNext.getNext());
		headNext.getNext().setPrev(headNode);
		headNext.setValue(null);
		headNext.setNext(null);
		headNext.setPrev(null);
		currentSize--;
		return result;
	}

	@Override
	public E removeLast() {
		if (this.isEmpty()) {
			return null;
		}
		Node headNode = this.header;
		Node headPrev = this.header.getPrev();
		E result = headPrev.getValue();

		headPrev.getPrev().setNext(headNode);
		headNode.setPrev(headPrev.getPrev());
		headPrev.setValue(null);
		headPrev.setPrev(null);
		headPrev.setNext(null);
		currentSize--;
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public E[] toArray() {
		E[] arr = (E[]) new Object[size()];
		int i = 0;
		if (arr.length == 0) {
			return arr;
		}
		while (this.header.getNext() != null && this.header.getNext() != this.header) {
			arr[i++] = this.header.getNext().getValue();
			this.header = this.header.getNext();
		}
		return arr;
	}

	public static void main(String[] args) {
		CircularDoublyLinkedQueue<Object> cdllq = new CircularDoublyLinkedQueue<Object>();

		cdllq.addFirst("hi");
		cdllq.addFirst("bye");
		cdllq.addLast("tschuss");
		cdllq.addFirst("ciao");
		cdllq.addLast("arigaTO");
		cdllq.addLast("jinja");
		cdllq.addFirst("kawaii");
		cdllq.addLast("hai");
		cdllq.addLast("sugoi");
		cdllq.removeFirst();
		cdllq.removeFirst();
		cdllq.removeLast();
		cdllq.removeLast();

		Object[] array = cdllq.toArray();

		for (Object obj : array) {
			System.out.println(obj);
		}

	}

}
