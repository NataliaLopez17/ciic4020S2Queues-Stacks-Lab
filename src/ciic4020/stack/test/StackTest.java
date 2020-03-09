package ciic4020.stack.test;

import ciic4020.stack.Stack;
import ciic4020.stack.StackFactory;
import ciic4020.stack.ArrayStackFactory;
//import ciic4020.stack.LinkedListStackFactory;

public class StackTest {

	public static void main(String[] args) {
		//StackFactory<String> factory = new LinkedListStackFactory<String>();
		StackFactory<String> factory = new ArrayStackFactory<String>();
		Stack<String> stack = factory.newInstance();
		
		stack.push("Jil");
		stack.push("Ron");
		stack.push("Amy");
		stack.push("Ned"); // Should trigger reAllocate if using ArrayStack
		printStack(stack);
		System.out.println("Top of the stack: " + stack.top());
		System.out.println("Size of the stack: " + stack.size());
		
		System.out.println("Popped " + stack.pop());
		printStack(stack);
		System.out.println("Top of the stack: " + stack.top());
		System.out.println("Size of the stack: " + stack.size());
		
		stack.push("Xi");
		stack.push("Li");
		System.out.println("After pushing Xi, Li");
		printStack(stack);
		System.out.println("Top of the stack: " + stack.top());
		System.out.println("Size of the stack: " + stack.size());
		System.out.println("Popped " + stack.pop());
		printStack(stack);
		System.out.println("Top of the stack: " + stack.top());
		System.out.println("Size of the stack: " + stack.size());
		
		System.out.println("Is the stack empty? " + stack.isEmpty());
		System.out.println("Clearing the stack...");
		stack.clear();
		System.out.println("Is the stack empty now? " + stack.isEmpty());
		printStack(stack); // Just in case...
		System.out.println("Done!");
	}

	public static void printStack(Stack<String> S) {
		Object[] asArray = S.toArray();
		for (int i = asArray.length - 1; i >= 0; i--)
			System.out.println((String) asArray[i]);
	}
}
