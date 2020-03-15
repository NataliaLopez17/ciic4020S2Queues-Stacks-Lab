package exercises;

import java.util.Scanner;

import ciic4020.stack.LinkedListStack;
import ciic4020.stack.Stack;

public class StackSort {

	public static void main(String[] args) {

		Scanner scanObj = new Scanner(System.in); // Create a Scanner object
		System.out.print("Please enter numbers, press enter to finish: ");

		while (true) {
			String line = scanObj.nextLine(); // Read user input
			if (line.equalsIgnoreCase("")) {
				break;
			} else {
				sortingStacks(line);
			}
		}
		scanObj.close();
	}

	public static void sortingStacks(String line) {

		Stack<Integer> firstStack = new LinkedListStack<Integer>();
		Stack<Integer> secondStack = new LinkedListStack<Integer>();
		boolean flag = true;

		firstStack.push(Integer.parseInt(line));
		if (Integer.parseInt(line) > firstStack.top()) {
			firstStack.push(Integer.parseInt(line));
			System.out.println("First Stack: " + firstStack.top());
		}
		if (Integer.parseInt(line) < firstStack.top()) {
			while (flag) {
				secondStack.push(firstStack.pop());
				System.out.println("Second Stack : " + secondStack.top());
				if (firstStack.isEmpty()) {
					firstStack.push(Integer.parseInt(line));
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
