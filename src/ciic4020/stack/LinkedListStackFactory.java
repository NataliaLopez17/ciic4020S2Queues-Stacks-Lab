package ciic4020.stack;

public class LinkedListStackFactory<E> implements StackFactory<E> {

	@Override
	public Stack<E> newInstance() {
		return new LinkedListStack<E>();
	}

}