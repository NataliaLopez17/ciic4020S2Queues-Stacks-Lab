package ciic4020.queue;

public class DoublyLinkedQueueFactory<E> implements QueueFactory<E> {

	@Override
	public Queue<E> newInstance() {
		return new DoublyLinkedQueue<E>();
	}

}