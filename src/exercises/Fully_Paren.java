package exercises;

import java.util.Scanner;

import ciic4020.stack.ArrayStack;
import ciic4020.stack.Stack;

public class Fully_Paren {

	public static Integer[] theArray = new Integer[26];

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		System.out.println("please enter an expression and its corresponding values: ");

		while (true) {
			String line = in.nextLine();
			if (line.length() == 0) {
				break;
			}
			if (Character.isAlphabetic(line.charAt(0)) && line.charAt(1) == '=') {
				String[] valuesArray = line.split("=");
				int ints = (int) valuesArray[0].charAt(0) - 65;
				theArray[ints] = Integer.parseInt(valuesArray[1]);
			}
			fullyParenthesizedExpression(line);
		}
		System.out.println("The final symbol table is: ");
		System.out.println("");
		System.out.println("Variable" + "\t" + "Value");
		for (int i = 0; i < theArray.length; i++) {
			if (theArray[i] != null) {
				Character letter = (char) (i + 65);
				System.out.println(letter + "\t" + "\t" + theArray[i]);
			}
		}

	}

	public static boolean isOperator(char c) {
		return ((c == '/') || (c == '*') || (c == '+') || (c == '-'));
	}

	public static Integer[] fullyParenthesizedExpression(String infix) {
		Stack<Character> operatorStack = new ArrayStack<Character>(1);
		Stack<Integer> operandStack = new ArrayStack<Integer>(1);
		Stack<Character> parenthesisStack = new ArrayStack<Character>(1);
		Stack<Integer> resultStack = new ArrayStack<Integer>(1);

		for (int i = 0; i < infix.length(); i++) {
			if ((infix.charAt(i) != '[' && infix.charAt(i) != '{' && infix.charAt(i) != '(')
					|| (infix.length() - 1 != ']' && infix.length() - 1 != '}')) {
				System.out.println(infix + " is invalid");
				break;
			}
			if (infix.charAt(i) == '(' || infix.charAt(i) == '{' || infix.charAt(i) == '[') {
				parenthesisStack.push(infix.charAt(i));
			}
			if ((infix.charAt(i) >= 'A' && (infix.charAt(i) <= 'Z'))) {
				int ints = (int) infix.charAt(0) - 65;
				int target = theArray[ints];
				operandStack.push(target);
			}
			if (isOperator(infix.charAt(i))) {
				operatorStack.push(infix.charAt(i));
			} else {
				int ints = 0;
				int target = 0;
				if (operatorStack.isEmpty() || operandStack.size() < 2) {
					if (parenthesisStack.top() != infix.charAt(i)) {
						System.out.println(infix + " is invalid");
						break;
					}
				}
				if (operandStack.size() >= 2 || !operatorStack.isEmpty()) {
					if (infix.charAt(i) == ')' || infix.charAt(i) == ']' || infix.charAt(i) == '}') {
						int op1 = operandStack.pop();
						int op2 = operandStack.pop();
						char character = operatorStack.pop();

						switch (character) {
						case '+':
							operandStack.push((op1 + op2));
							resultStack.push((op1 + op2));
							parenthesisStack.pop();
							ints = (int) infix.charAt(0) - 65;
							target = theArray[ints];
							break;

						case '-':
							operandStack.push(Math.abs(op2 - op1));
							resultStack.push((op1 + op2));
							parenthesisStack.pop();
							ints = (int) infix.charAt(0) - 65;
							target = theArray[ints];
							break;

						case '/':
							operandStack.push(op2 / op1);
							resultStack.push((op1 / op2));
							parenthesisStack.pop();
							ints = (int) infix.charAt(0) - 65;
							target = theArray[ints];
							break;
						case '*':
							operandStack.push(op2 * op1);
							resultStack.push((op1 * op2));
							parenthesisStack.pop();
							ints = (int) infix.charAt(0) - 65;
							target = theArray[ints];
							break;
						}
					}
				}
				if (i == infix.length() - 1 && parenthesisStack.size() != 0) {
					System.out.println(infix + " is invalid");
					break;
				}
			}
		}
		return theArray;
	}
}
