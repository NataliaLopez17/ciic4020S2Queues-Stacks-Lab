package ciic4020.queue;

public interface Queue<E> {

	public void enqueue(E e);
	public E dequeue();
	public E front();
	public boolean isEmpty();
	public void clear();
	public int size();
	public E[] toArray();
}