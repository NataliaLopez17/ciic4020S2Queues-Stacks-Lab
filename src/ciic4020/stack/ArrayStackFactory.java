package ciic4020.stack;

public class ArrayStackFactory<E> implements StackFactory<E> {

	private final int DEFAULT_SIZE = 3;

	@Override
	public Stack<E> newInstance() {
		return new ArrayStack<E>(DEFAULT_SIZE);
	}

}