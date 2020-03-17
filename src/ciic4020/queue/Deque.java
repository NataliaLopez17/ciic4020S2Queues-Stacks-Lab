package ciic4020.queue;

/**
 * Interface for a deque: a collection of objects that are inserted and removed
 * at both ends.
 * 
 * @author Roberto Tamassia
 * @author Michael Goodrich
 * @author Juan O. López
 */

public interface Deque<E> {

	/**
	 * Returns the number of elements in the deque.
	 */
	public int size();

	/**
	 * Return whether the deque is empty.
	 */
	public boolean isEmpty();

	/**
	 * Removes all of the elements in the deque.
	 */
	public void clear();

	/**
	 * Returns the first element of the deque, or null if it's empty.
	 */
	public E getFirst();

	/**
	 * Returns the last element of the deque, or null if it's empty.
	 */
	public E getLast();

	/**
	 * Inserts an element to be the first in the deque. An IllegalArgumentException
	 * is thrown if the argument is null.
	 */
	public void addFirst(E element) throws IllegalArgumentException;

	/**
	 * Inserts an element to be the last in the deque. An IllegalArgumentException
	 * is thrown if the argument is null.
	 */
	public void addLast(E element) throws IllegalArgumentException;

	/**
	 * Removes (and returns) the first element of the deque, or returns null if it's
	 * empty.
	 */
	public E removeFirst();

	/**
	 * Removes (and returns) the last element of the deque, or returns null if it's
	 * empty.
	 */
	public E removeLast();

	/**
	 * Temporary method used for testing purposes.
	 */
	public E[] toArray();
}