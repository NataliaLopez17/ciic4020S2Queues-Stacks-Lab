package ciic4020.stack;

public class ArrayStack<E> implements Stack<E> {

	// private fields
	private int top;
	private E[] elements;
	
	@SuppressWarnings("unchecked")
	public ArrayStack(int initialCapacity) {
		if (initialCapacity < 1)
			throw new IllegalArgumentException();
		top = 0;
		elements = (E[]) new Object[initialCapacity];
	}

	@Override
	public void push(E e) {
		if (e == null)
			throw new IllegalArgumentException("Parameter cannot be null");
		if (size() == elements.length)
			reAllocate();
		elements[top++] = e;
	}

	@SuppressWarnings("unchecked")
	private void reAllocate() {
		E[] newElements = (E[]) new Object[size()*2];
		for (int i = 0; i < size(); i++)
			newElements[i] = elements[i];
		elements = newElements;
	}

	@Override
	public E pop() {
		if (isEmpty())
			return null;
		E result = elements[--top];
		elements[top] = null;
		return result;
	}

	@Override
	public E top() {
		if (isEmpty())
			return null;
		return elements[top-1];
	}

	@Override
	public boolean isEmpty() {
		return size() == 0;
	}

	@Override
	public int size() {
		return top;
	}

	@Override
	public void clear() {
		while (!isEmpty())
			pop();
	}

	@SuppressWarnings("unchecked")
	@Override
	public E[] toArray() {
		E[] asArray = (E[]) new Object[size()];
		/* Copy elements, keeping the top of the stack at the end.
		 * We'll use System.arraycopy, because, why not?. */
		System.arraycopy(elements, 0, asArray, 0, size());
		return asArray;
	}

}