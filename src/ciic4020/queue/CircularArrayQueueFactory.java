package ciic4020.queue;

public class CircularArrayQueueFactory<E> implements QueueFactory<E> {

	private final static int DEFAULT_SIZE = 3;

	@Override
	public Queue<E> newInstance() {
		return new CircularArrayQueue<E>(DEFAULT_SIZE);
	}

}