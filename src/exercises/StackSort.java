package exercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ciic4020.stack.ArrayStack;

public class StackSort {
	// Main Method
	public static void main(String[] args) {
		System.out.print("please write some numbers, press enter to exit: ");
		Scanner scanObj = new Scanner(System.in);
		List<String> ints = new ArrayList<String>();
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
		stackSort(theArray, theArray.length);
		scanObj.close();
	}

	public static void stackSort(int theArray[], int num) {
		ArrayStack<Integer> leftStack = new ArrayStack<Integer>(20);
		ArrayStack<Integer> rightStack = new ArrayStack<Integer>(20);

		for (int i = 0; i < num; i++)
			leftStack.push(theArray[i]);

		for (int i = 0; i < num; i++) {
			if (i % 2 == 0) {
				while (!leftStack.isEmpty()) {
					int temp = leftStack.pop();
					if (rightStack.isEmpty())
						rightStack.push(temp);
					else {
						if (rightStack.top() > temp) {
							int temp2 = rightStack.pop();
							rightStack.push(temp);
							rightStack.push(temp2);
						} else
							rightStack.push(temp);
					}
				}
				theArray[num - 1 - i] = rightStack.pop();
			} else {
				while (!rightStack.isEmpty()) {
					int temp = rightStack.pop();
					if (leftStack.isEmpty())
						leftStack.push(temp);
					else {
						if (leftStack.top() > temp) {
							int temp2 = leftStack.pop();
							leftStack.push(temp);
							leftStack.push(temp2);
						} else
							leftStack.push(temp);
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