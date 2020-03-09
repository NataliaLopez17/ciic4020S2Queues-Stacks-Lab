package ciic4020.queue;

public class CircularArrayQueue<E> implements Queue<E> {

	// private fields
	private E[] elements;
	private int front, rear;
	
	@SuppressWarnings("unchecked")
	public CircularArrayQueue(int initialCapacity) {
		if (initialCapacity < 2)
			throw new IllegalArgumentException("Capacity must be at least 2!");
		elements = (E[]) new Object[initialCapacity];
		front = rear = 0;
	}

	@Override
	public void enqueue(E e) {
		if (e == null)
			throw new IllegalArgumentException("Parameter cannot be null");
		if (size() == elements.length - 1) // Don't wait until it's completely full
			reAllocate();
		elements[rear] = e;
		rear = (rear + 1) % elements.length;
	}

	@SuppressWarnings("unchecked")
	private void reAllocate() {
		/* Use elements.length instead of size() to declare newElements.
		 * This covers edge cases, such as when size() == 0 and elements.length == 1,
		 * or when size() == 1 and elements.length == 2. */
		E[] newElements = (E[]) new Object[2*elements.length]; // Do NOT use size() here
		int oldPos = front;
		/* We'll take the opportunity to "reset" front to be 0 while we're at it */
		for (int i = 0; i < size(); i++) {
			newElements[i] = elements[oldPos];
			oldPos = (oldPos + 1) % elements.length;
		}
		/* The size() method uses front and elements.length, so it's important to
		 * modify rear BEFORE modifying front or elements. */
		rear = size(); // Do this first!
		front = 0; 
		elements = newElements;
	}

	@Override
	public E dequeue() {
		if (isEmpty())
			return null;
		E result = elements[front];
		elements[front] = null;
		front = (front + 1) % elements.length;
		return result;
	}

	@Override
	public E front() {
		if (isEmpty())
			return null;
		return elements[front];
	}

	@Override
	public boolean isEmpty() {
		return size() == 0;
	}

	@Override
	public void clear() {
		while (!isEmpty())
			dequeue();
	}

	@Override
	public int size() {
		/* By using the calculation below, we avoid the need for currentSize.
		 * However, we must take extra care when re-allocating a new array. */
		return (rear - front + elements.length) % elements.length;
	}

	@SuppressWarnings("unchecked")
	@Override
	public E[] toArray() {
		E[] theArray = (E[]) new Object[size()];
		int oldPos = front;
		for (int i = 0; i < size(); i++) {
			theArray[i] = elements[oldPos];
			oldPos = (oldPos + 1) % elements.length;
		}
		return theArray;
	}

}