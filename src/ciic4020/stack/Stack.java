package ciic4020.stack;

public interface Stack<E> {
	
	public int size();
	public boolean isEmpty();
	public void push(E e);
	public E pop();
	public E top();
	public void clear();
	 /* The toArray method is for testing purposes only; 
	  * it's not really part of the ADT */
	public E[] toArray();
}