package ciic4020.queue;

public interface QueueFactory<E> {

	public Queue<E> newInstance();

}