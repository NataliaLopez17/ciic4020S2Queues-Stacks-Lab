package exercises;

import java.util.ArrayList;
import java.util.Scanner;

import ciic4020.stack.ArrayStack;
import ciic4020.stack.Stack;

public class StackSort {

	public static void main(String[] args) {

		Scanner scanObj = new Scanner(System.in);
		System.out.println("please enter some numbers, press enter to end: ");
		ArrayList<String> ints = new ArrayList<String>();
		String line = null;
		while ((line = scanObj.nextLine()).length() > 0) {
			ints.add(line);
		}
		int theArray[] = new int[ints.size()];
		int counter = 0;
		for (String string : ints) {
			theArray[counter] = Integer.parseInt(string);
			counter++;
		}
		sortingStacks(theArray, theArray.length);

	}

	public static void sortingStacks(int theArray[], int num) {
		Stack<Integer> leftStack = new ArrayStack<Integer>(1);
		Stack<Integer> rightStack = new ArrayStack<Integer>(1);

		for (int i = 0; i < num; i++) {
			leftStack.push(theArray[i]);
		}

		for (int i = 0; i < num; i++) {
			if (i % 2 == 0) {
				while (!leftStack.isEmpty()) {
					int temp = leftStack.pop();
					if (rightStack.isEmpty()) {
						rightStack.push(temp);
					} else {
						if (rightStack.top() > temp) {
							int temp2 = rightStack.pop();
							rightStack.push(temp2);
							rightStack.push(temp2);
						} else {
							rightStack.push(temp);
						}
					}
				}
				theArray[num - 1 - i] = rightStack.pop();
			} else {
				while (!rightStack.isEmpty()) {
					int temp = rightStack.pop();
					if (leftStack.isEmpty()) {
						leftStack.push(temp);
					} else {
						if (leftStack.top() > temp) {
							int temp2 = leftStack.pop();
							leftStack.push(temp2);
							leftStack.push(temp2);
						} else {
							leftStack.push(temp);
						}
					}
				}
				theArray[num - 1 - i] = leftStack.pop();
			}
		}

		for (int i : theArray) {
			System.out.println(i);
		}
	}
}
