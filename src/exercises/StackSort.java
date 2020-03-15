package exercises;

import java.util.Random;

import ciic4020.stack.LinkedListStack;
import ciic4020.stack.Stack;

public class StackSort {

	// public static void main(String[] args) {

	// Scanner scanObj = new Scanner(System.in); // Create a Scanner object
	// System.out.print("Please enter numbers, press enter to finish: ");

	// while (true) {
	// String line = scanObj.nextLine(); // Read user input
	/// if (line.equalsIgnoreCase("")) {
	// break;
	// } else {
	// sortingStacks(n);
	// }
	// }
	// scanObj.close();
	// }

	public static void main(String[] args) {

		Stack<Integer> firstStack = new LinkedListStack<Integer>();
		Stack<Integer> secondStack = new LinkedListStack<Integer>();
		boolean flag = true;

		Random rand = new Random();
		int n = rand.nextInt(50);

		firstStack.push(n);
		if (n > firstStack.top()) {
			firstStack.push(n);
			System.out.println("First Stack: " + firstStack.top());
		}
		if (n < firstStack.top()) {
			while (flag) {
				secondStack.push(firstStack.pop());
				System.out.println("Second Stack : " + secondStack.top());
				if (firstStack.isEmpty()) {
					firstStack.push(n);
					flag = false;
					System.out.println("First Stack: " + firstStack.top());
					break;
				} else {
					continue;
				}
			}
		}
		for (int i = 0; i < secondStack.size(); i++) {
			for (int j = 0; j < firstStack.size(); j++) {
				System.out.println(firstStack.pop());
			}
			System.out.println(secondStack.pop());
		}

	}

}
