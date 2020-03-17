package exercises;

import ciic4020.queue.Queue;

public class SinglyLinkedQueue<E> implements Queue<E> {

	int currentSize;
	Node header;

	@SuppressWarnings("unused")
	private class Node {
		private E value;
		private Node next;

		public Node(E value, Node next) {
			this.value = value;
			this.next = next;
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
	}

	// End of Node class

	public SinglyLinkedQueue() {
		currentSize = 0;
		header = null;
	}

	@Override
	public void enqueue(E e) {

		if (this.isEmpty()) {
			this.header = new Node(e, null);
			this.currentSize++;
		} else {
			Node newNode = this.header;

			while (newNode.getNext() != null) {
				newNode = newNode.getNext();
			}
			Node temp = new Node(e, null);
			newNode.setNext(temp);
			this.currentSize++;
		}

	}

	@Override
	public E dequeue() {

		if (this.isEmpty()) {
			throw new IllegalArgumentException("cannot dequeue empty queue");
		}
		E result = null;
		result = this.header.value;
		this.header = this.header.next;
		this.currentSize--;
		return result;

	}

	@Override
	public E front() {
		Node temp = null;
		temp = this.header;
		E value = temp.getValue();
		return value;
	}

	@Override
	public boolean isEmpty() {
		return this.size() == 0;
	}

	@Override
	public void clear() {
		while (!this.isEmpty()) {
			this.dequeue();
		}

	}

	@Override
	public int size() {
		return currentSize;
	}

	@SuppressWarnings("unchecked")
	@Override
	public E[] toArray() {
		E[] theArray = (E[]) new Object[size()];

		Node curNode = this.header;

		int i = 0;
		while (curNode.getNext() != null) {
			theArray[i] = curNode.getValue();
			i++;
			curNode = curNode.getNext();
		}
		theArray[i] = curNode.getValue();
		return theArray;
	}

	public static void main(String[] args) {
		SinglyLinkedQueue<Object> ecks = new SinglyLinkedQueue<Object>();
		ecks.enqueue("see");
		ecks.enqueue("bee");
		ecks.enqueue("chee");
		ecks.enqueue("creep");
		ecks.dequeue();
		Object[] lel = ecks.toArray();
		for (Object kek : lel) {
			System.out.println(kek);
		}
	}

}
