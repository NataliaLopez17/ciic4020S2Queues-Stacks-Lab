package ciic4020.queue.test;

//import ciic4020.queue.DoublyLinkedQueueFactory;
import ciic4020.queue.CircularArrayQueueFactory;
import ciic4020.queue.Queue;
import ciic4020.queue.QueueFactory;

public class QueueTest {

	public static void main(String[] args) {
		//QueueFactory<String> factory = new DoublyLinkedQueueFactory<String>();
		QueueFactory<String> factory = new CircularArrayQueueFactory<String>();
		Queue<String> queue = factory.newInstance();

		queue.enqueue("Jil");
		queue.enqueue("Ron");
		queue.enqueue("Amy");
		queue.enqueue("Ned"); // Should trigger reAllocate if using CircularArray
		printQueue(queue);
		System.out.println("Front of the queue: " + queue.front());
		System.out.println("Size of the queue: " + queue.size());

		System.out.println("Dequeueing " + queue.dequeue());
		System.out.println("Dequeueing " + queue.dequeue());
		printQueue(queue);
		System.out.println("Front of the queue: " + queue.front());
		System.out.println("Size of the queue: " + queue.size());
		
		System.out.println("Enqueueing Xi...");
		queue.enqueue("Xi");
		printQueue(queue);
		System.out.println("Front of the queue: " + queue.front());
		System.out.println("Size of the queue: " + queue.size());
		
		System.out.println("Is the queue empty? " + queue.isEmpty());
		System.out.println("Clearing the queue...");
		queue.clear();
		System.out.println("Is the queue empty? " + queue.isEmpty());
		printQueue(queue);
		System.out.println("Done!");
	}

	public static void printQueue(Queue<String> Q) {
		Object[] QArray = Q.toArray();
		for (int i = 0; i < QArray.length; i++)
			System.out.println((String) QArray[i]);
	}
}