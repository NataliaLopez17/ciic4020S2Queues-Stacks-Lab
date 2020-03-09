package ciic4020.stack;

public interface StackFactory<E> {

	public Stack<E> newInstance();

}